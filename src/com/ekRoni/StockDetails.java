package com.ekRoni;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

public class StockDetails {
    JFrame frame;
    ImageIcon img;
    ResultSet result;
    public static void main(String[] args) {
        StockDetails ob=new StockDetails();
        ob.createPanel();
    }
    public void createPanel()
    {
        img= new ImageIcon("C:\\Users\\ekRoni\\IdeaProjects\\Payra\\src\\com\\Sakib\\logoPayra.png");
        frame = new JFrame();
        frame.setLayout(null);
        frame.setTitle("Stock Details");
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
        sw.CreateLabel(350,20,1000,50,"Stock Details","Algerian",25);

        SwingModel sw1=new SwingModel();
        result=sw.GetData("Select * from Stock");
        sw1.CreateTable(120,70,650,320,result);
        sw1.CreateButton(700,400,70,30,"Close");
        sw1.button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AllDownerDetails ob=new AllDownerDetails();
                frame.setVisible(false);
//                System.exit(0);

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
        sw.panel.add(sw1.scrollPane);
        sw.panel.add(sw1.button);
    }
}
