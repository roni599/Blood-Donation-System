package com.ekRoni;

import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceptionistLogIn {
    JFrame frame;
    ImageIcon img;
    public static void main(String[] args) throws SQLException {
        ReceptionistLogIn ob=new ReceptionistLogIn();
        ob.CreatePanel();
    }
    public void CreatePanel() throws SQLException {
        img= new ImageIcon("C:\\Users\\ekRoni\\IdeaProjects\\Payra\\src\\com\\Sakib\\logoPayra.png");
        frame = new JFrame();
        frame.setLayout(null);
        frame.setTitle("ReceptionistLogin");
        frame.setSize(1300,700);
        frame.setIconImage(img.getImage());
        frame.setLocationRelativeTo(null);

        loadPanel();

        frame.setVisible(true);
    }
    public void loadPanel() throws SQLException {
        SwingModel sw= new SwingModel();
        sw.CreatePanel(0,0,1300,700);

        SwingModel sw1=new SwingModel();
        sw1.CreatePanel(400,230,600,300);
        sw1.panel.setBackground(Color.ORANGE);

        sw1.CreateLabel(140,95,100,50,"UserName:","",15);
        sw1.CreateTextfield(230,110,200,25,"UserName");

        SwingModel sw2=new SwingModel();
        sw2.CreateLabel(140,140,100,50,"Password:","",15);
        sw2.CreateTextfield(230,155,200,25,"Password");

        sw1.CreateButton(230,195,70,20,"LogIn");
        sw1.button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String U_name1=sw1.textField.getText();
                String P_Word2=sw2.textField.getText();
                ResultSet re=sw.GetData("Select * from receptionist");
                try {
                    while (re.next()){
                        String uname=re.getNString("Name");
                        String username=re.getNString("User_name");
                        String Password=re.getNString("Password");
                        int Age=re.getInt("Age");
                        String str = String.valueOf(Age);
                        String Position=re.getNString("Position");

                        if(U_name1.equals(username)&& P_Word2.equals(Password)){
                            Dashboard ob=new Dashboard(uname,str,Position);
                            ob.CreatePanel();
                        }

                    }
                }
                catch (SQLException ex) {
                    ex.printStackTrace();
                }
            };

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        sw2.CreateButton(360,195,70,20,"Close");
        sw2.button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int output = JOptionPane.showConfirmDialog(frame,"Are You Want To Exit","Message",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);

                if(output == JOptionPane.YES_OPTION){
//                    System.exit(0);
                    frame.setVisible(false);
                }
                else if(output == JOptionPane.NO_OPTION){
                    frame.setVisible(true);
                }
            };

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        SwingModel sw3=new SwingModel();
        sw3.CreateLabel(250,50,200,50,"LogIn Here","Algerian",25);


        frame.add(sw.panel);
        sw.panel.add(sw1.panel);
        sw1.panel.add(sw1.label);
        sw1.panel.add((sw1.textField));
        sw1.panel.add(sw1.button);

        sw1.panel.add(sw2.label);
        sw1.panel.add((sw2.textField));
        sw1.panel.add(sw2.button);

        sw1.panel.add(sw3.label);
    }

}



