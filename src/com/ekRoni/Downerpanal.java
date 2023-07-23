package com.ekRoni;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

public class Downerpanal extends Picture {
    JFrame frame;
    public static void main(String[] args) {
        Downerpanal ob= new Downerpanal();
        ob.CreateFrame();

    }
    public void CreateFrame()
    {
        frame= new JFrame();
        frame.setSize(1650,1080);
        frame.setLayout(null);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setUndecorated(true);
        LoadMainPanel();
        frame.setVisible(true);
    }
    public void LoadMainPanel()
    {
        SwingModel ob1= new SwingModel();
        ob1.CreatePanel(0,0,1650,1080);
        ob1.panel.setBackground(new Color(1,185,211));

        ob1.CreateLabel(450,150,800,70,"Welcome To BLOOD DONATION SYSTEM","Algerian",25);

        SwingModel ob2= new SwingModel();
        ob2.CreateHoverPanel(275,250,250,250);
        ob2.CreateLabel(40,210,300,50,"Donner Registration","Algerian",15);
        ob2.hoverpanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DownerRegistration ob=new DownerRegistration();
                try {
                    ob.createPanel();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
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

//        SwingModel ob3= new SwingModel();
//        ob3.CreateHoverPanel(440,250,250,250);
//        ob3.CreateLabel(30,210,300,50,"Patient Registration","Algerian",15);
//        ob3.hoverpanel.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//            }
//        });

        SwingModel ob4= new SwingModel();
        ob4.CreateHoverPanel(565,250,250,250);
        ob4.CreateLabel(30,210,200,50,"Update Downer Details","Algerian",15);
        ob4.hoverpanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                UpdateDownerDetails ob=new UpdateDownerDetails();
                ob.createPanel();
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
        SwingModel ob5= new SwingModel();
        ob5.CreateHoverPanel(850,250,250,250);
        ob5.CreateLabel(45,210,300,50,"All Downer Details","Algerian",15);
        ob5.hoverpanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AllDownerDetails ob=new AllDownerDetails();
                ob.createPanel();
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
//        ob3.CreateResizeImage(10,5,220,220,"C:\\Users\\ekRoni\\IdeaProjects\\ContactManagementSystem\\src\\teamwork.png");
        ob2.CreateResizeImage(10,5,220,220,"C:\\Users\\ekRoni\\IdeaProjects\\ContactManagementSystem\\src\\manager.png");
        ob4.CreateResizeImage(10,35,220,220,"C:\\Users\\ekRoni\\IdeaProjects\\ContactManagementSystem\\src\\com\\Me\\team.png");
        ob5.CreateResizeImage(10,35,220,220,"C:\\Users\\ekRoni\\IdeaProjects\\ContactManagementSystem\\src\\com\\Me\\team.png");


        frame.add(ob1.panel);
        ob1.panel.add(ob1.label);
        ob1.panel.add(ob2.hoverpanel);

        ob2.hoverpanel.add(ob2.label);
        ob2.hoverpanel.add(ob2.image_label);

//        ob1.panel.add(ob3.hoverpanel);
//        ob3.hoverpanel.add(ob3.label);
//        ob3.hoverpanel.add(ob3.image_label);

        ob1.panel.add(ob4.hoverpanel);
        ob4.hoverpanel.add(ob4.label);
        ob4.hoverpanel.add(ob4.image_label);

        ob1.panel.add(ob5.hoverpanel);
        ob5.hoverpanel.add(ob5.label);
        ob5.hoverpanel.add(ob5.image_label);

    }
}
