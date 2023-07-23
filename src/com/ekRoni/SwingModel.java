package com.ekRoni;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

public class SwingModel {
    JPanel panel;
    JLabel label;
    JTextField textField;
    JButton button;
    JComboBox box;
    ImageIcon image;
    ImageIcon resized_image;
    JLabel image_label;
    JScrollPane scrollPane;
    JTable table;
    JPanel hoverpanel;

    public void CreatePanel(int x,int y,int wid,int hei){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(x,y,wid,hei);
    }

    public void CreateHoverPanel(int x,int y,int wid,int hei){
        hoverpanel = new JPanel();
        hoverpanel.setLayout(null);
        hoverpanel.setBounds(x,y,wid,hei);
        hoverpanel.setBackground(Color.WHITE);
        hoverpanel.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(199,21,133)));
        hoverpanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                hoverpanel.setBackground(new Color(199,21,133));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hoverpanel.setBackground(Color.WHITE);
            }
        });
    }

    public void CreateTable(int x,int y,int wid,int hei,ResultSet res){

        table = new JTable();
        table.setModel(DbUtils.resultSetToTableModel(res));
        table.setBounds(0,0,wid,hei);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(x,y,wid,hei);
    }

    public void CreateImage(int x,int y,int wid,int hei,String path){
        image = new ImageIcon(path);
        image_label = new JLabel();
        image_label.setIcon(image);
        image_label.setBounds(x,y,wid,hei);
    }

    public void CreateResizeImage(int x,int y,int wid,int hei,String path){
        resized_image = new ImageIcon(path);
        Image rez = resized_image.getImage().getScaledInstance(wid,hei,Image.SCALE_DEFAULT);
        ImageIcon rex = new ImageIcon(rez);
        image_label = new JLabel();
        image_label.setIcon(rex);
        image_label.setBounds(x,y,wid,hei);
    }

    public void CreateCombo(int x,int y,int wid,int hei,String[] options){
        box = new JComboBox(options);
        box.setBounds(x,y,wid,hei);
    }

    public void CreateLabel(int x,int y,int wid,int hei,String text,String fn_name,int size){
        label = new JLabel();
        label.setText(text);
        label.setBounds(x,y,wid,hei);
        label.setFont(new Font(fn_name,Font.BOLD,size));
    }

    public void CreateTextfield(int x,int y,int wid,int hei,String placeholder){
        textField = new JTextField(placeholder);
        textField.setBounds(x,y,wid,hei);
        textField.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.BLACK));
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(textField.getText().equals(placeholder)){
                    textField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(textField.getText().equals("")){
                    textField.setText(placeholder);
                }
            }
        });
    }

    public void CreateButton(int x,int y,int wid,int hei,String btn_name){
        button = new JButton(btn_name);
        button.setFocusable(false);
        button.setBounds(x,y,wid,hei);
    }

    public void SendData(String command){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bds","ekroni","ekroni83");
            Statement st = con.createStatement();
            st.execute(command);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void Update(String command){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bds","ekroni","ekroni83");
            Statement st = con.createStatement();
            st.execute(command);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void Delete(String command){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bds","ekroni","ekroni83");
            Statement st = con.createStatement();
            st.execute(command);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet GetData(String Command){
        ResultSet rz=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bds","ekroni","ekroni83");
            Statement st = con.createStatement();
            rz = st.executeQuery(Command);


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return rz;
    }

}
