package com.ekRoni;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SearchBloodPanal {
    JFrame frame;
    public static void main(String[] args) {
        SearchBloodPanal ob=new SearchBloodPanal();
        ob.CreateFrame();

    }
    public void CreateFrame()
    {
        frame= new JFrame();
        frame.setSize(1650,1080);
        frame.setLayout(null);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LoadMainPanel();
        frame.setVisible(true);
    }
    public void LoadMainPanel()
    {
        SwingModel ob1= new SwingModel();
        ob1.CreatePanel(0,0,1650,1080);
        ob1.panel.setBackground(new Color(1,185,211));

        ob1.CreateLabel(330,150,800,70,"Search Blood Downer With Location & Blood Group","Algerian",25);

        SwingModel ob4= new SwingModel();
        ob4.CreateHoverPanel(410,250,250,250);
        ob4.CreateLabel(12,213,300,50,"Search Blood With Location","Algerian",15);
        ob4.hoverpanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SearchBloodDownerLocation ob=new SearchBloodDownerLocation();
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
        ob5.CreateHoverPanel(700,250,250,250);
        ob5.CreateLabel(23,213,300,50,"Search Blood With Group","Algerian",15);
        ob5.hoverpanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SearchBloodDownerBloodGroup ob=new SearchBloodDownerBloodGroup();
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
        ob4.CreateResizeImage(10,35,220,220,"C:\\Users\\ekRoni\\IdeaProjects\\ContactManagementSystem\\src\\com\\Me\\team.png");
        ob5.CreateResizeImage(10,35,220,220,"C:\\Users\\ekRoni\\IdeaProjects\\ContactManagementSystem\\src\\com\\Me\\team.png");



        ob1.panel.add(ob1.label);

        ob1.panel.add(ob4.hoverpanel);
        ob4.hoverpanel.add(ob4.label);
        ob4.hoverpanel.add(ob4.image_label);

        ob1.panel.add(ob5.hoverpanel);
        ob5.hoverpanel.add(ob5.label);
        ob5.hoverpanel.add(ob5.image_label);
        frame.add(ob1.panel);
    }
}
