package com.ekRoni;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

public class SearchBloodDownerLocation {
    JFrame frame;
    ImageIcon img;
    public static void main(String[] args) {
        SearchBloodDownerLocation ob=new SearchBloodDownerLocation();
        ob.createPanel();
    }
    public void createPanel()
    {
        img= new ImageIcon("C:\\Users\\ekRoni\\IdeaProjects\\Payra\\src\\com\\Sakib\\logoPayra.png");
        frame = new JFrame();
        frame.setLayout(null);
        frame.setTitle("Receptionist Registration");
        frame.setSize(900,500);
        frame.setIconImage(img.getImage());
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        loadPanel();

        frame.setVisible(true);
    }
    public void loadPanel(){
        SwingModel sw= new SwingModel();
        sw.CreatePanel(0,0,900,500);
        sw.panel.setBackground(Color.orange);
        sw.CreateLabel(240,30,1000,50,"Search Blood Downer(Location)","Algerian",25);

        SwingModel sw1=new SwingModel();
        sw1.CreateLabel(340,70,100,50,"Location:","Algerian",17);
        sw1.CreateTextfield(435,85,130,20,"");
        String Command="Select *from downer";
        ResultSet rez=sw1.GetData(Command);
        sw1.CreateTable(145,115,600,280,rez);

        SwingModel sw2=new SwingModel();
        sw1.textField.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {

            }

            public void keyReleased(KeyEvent e) {
                String location=sw1.textField.getText();
                String cmd;
                cmd="Select * from downer where City like '%"+location+"%' or Address like '%"+location+"%'";
                ResultSet rz1= sw1.GetData(cmd);
                sw1.scrollPane.setVisible(false);
                sw2.CreateTable(145,115,600,280,rz1);
                sw.panel.add(sw2.scrollPane);
            }
            public void keyTyped(KeyEvent e) {

            }
        });
        sw1.CreateButton(675,400,70,30,"Close");
        sw1.button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setVisible(false);
//               System.exit(0);

            }
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

        frame.add(sw.panel);
        sw.panel.add(sw.label);
        sw.panel.add(sw1.label);
        sw.panel.add(sw1.scrollPane);
        sw.panel.add(sw1.button);
        sw.panel.add(sw1.textField);
    }
}
