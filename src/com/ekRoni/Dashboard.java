package com.ekRoni;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Dashboard {
    JFrame frame;
    JPanel panel;
    ImageIcon img;
    JLabel statusLabel;
    String pass,age,job;

    public Dashboard(String uname,String str,String position) {
        pass=uname;
        age=str;
        job=position;
    }
    Dashboard(){

    }
    public static void main(String[] args) {
        Dashboard ob=new Dashboard();
        ob.CreatePanel();
    }
    public void CreatePanel(){
        img= new ImageIcon("C:\\Users\\ekRoni\\IdeaProjects\\Payra\\src\\com\\Sakib\\logoPayra.png");
        frame = new JFrame();
        frame.setLayout(null);
        frame.setTitle("All Blood Details");
        frame.setSize(1650,1080);
        frame.setIconImage(img.getImage());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setLocationRelativeTo(null);

        loadPanel();

        frame.setVisible(true);
    }
    public void loadPanel(){
        SwingModel All_sw=new SwingModel();
        All_sw.CreatePanel(0,0,1650,1080);
        All_sw.panel.setBackground(Color.ORANGE);

        SwingModel All_sw1=new SwingModel();
        All_sw1.CreatePanel(0,0,280,1080);
        All_sw1.panel.setBackground(Color.BLACK);
        All_sw1.CreateLabel(20,180,300,50,"Receptionist Details","Algerian",20);
        All_sw1.label.setForeground(Color.white);
        All_sw1.CreateResizeImage(65,250,150,150,"C:\\Users\\ekRoni\\IdeaProjects\\BloodDonationSystem\\src\\com\\ekRoni\\ekRoni (2).png");

        SwingModel All_sw2=new SwingModel();
        All_sw2.CreatePanel(65,250,150,150);
        All_sw2.panel.setBackground(Color.ORANGE);
        All_sw2.CreateLabel(62,420,160,50,"Name:"+pass,"Algerian",20);
        All_sw2.label.setForeground(Color.white);
        All_sw2.CreateButton(60,570,150,30,"LogOut");
        All_sw2.button.setFocusable(false);
        All_sw2.button.setBackground(Color.ORANGE);

        SwingModel All_sw3=new SwingModel();
        All_sw3.CreateLabel(7,467,300,50,"Position:"+job,"Algerian",17);
        All_sw3.label.setForeground(Color.white);
        All_sw3.CreatePanel(280,0,1370,100);
        All_sw3.panel.setBackground(Color.BLACK);

        SwingModel All_sw4=new SwingModel();
        All_sw4.CreateLabel(102,442,90,50,"Age:"+age,"Algerian",17);
        All_sw4.label.setForeground(Color.WHITE);

        SwingModel All_sw5=new SwingModel();
        All_sw5.CreateLabel(280,33,500,50,"Blood Donation System Dashboard","Algerian",25);
        All_sw5.label.setForeground(Color.white);

        SwingModel All_sw6=new SwingModel();
        All_sw6.CreateHoverPanel(450,200,200,200);
        All_sw6.CreateResizeImage(3,7,195,160,"");
        All_sw6.CreateLabel(13,165,190,40,"DownerRegistration","Algerian",15);
        All_sw6.label.setForeground(Color.BLACK);
        All_sw6.hoverpanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Downerpanal ob=new Downerpanal();
                ob.CreateFrame();
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

        SwingModel All_sw7=new SwingModel();
        All_sw7.CreateHoverPanel(700,200,200,200);
        All_sw7.CreateResizeImage(3,7,195,160,"");
        All_sw7.CreateLabel(13,165,250,40,"Search Blood Downer","Algerian",15);
        All_sw7.label.setForeground(Color.BLACK);
        All_sw7.hoverpanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SearchBloodPanal ob=new SearchBloodPanal();
                ob.CreateFrame();
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

        SwingModel All_sw8=new SwingModel();
        All_sw8.CreateHoverPanel(950,200,200,200);
        All_sw8.CreateResizeImage(3,7,195,160,"");
        All_sw8.CreateLabel(75,165,90,40,"Stock","Algerian",15);
        All_sw8.label.setForeground(Color.BLACK);
        All_sw8.hoverpanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                StockPanal ob=new StockPanal();
                ob.CreateFrame();
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

        SwingModel All_sw9=new SwingModel();
        All_sw9.CreateHoverPanel(575,430,200,200);
        All_sw9.CreateResizeImage(3,7,180,160,"");
        All_sw9.CreateLabel(40,165,140,40,"Delete Downer","Algerian",15);
        All_sw9.label.setForeground(Color.BLACK);
        All_sw9.hoverpanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DeleteDowner ob=new DeleteDowner();
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

        SwingModel All_sw10=new SwingModel();
        All_sw10.CreateHoverPanel(815,430,200,200);
        All_sw10.CreateResizeImage(3,7,195,160,"");
        All_sw10.CreateLabel(83,165,90,40,"Exit","Algerian",15);
        All_sw10.label.setForeground(Color.BLACK);
        All_sw10.hoverpanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int output = JOptionPane.showConfirmDialog(frame,"Are You Want To Exit","Message",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);

                if(output == JOptionPane.YES_OPTION){
                    System.exit(0);
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

        frame.add(All_sw.panel);
        All_sw.panel.add(All_sw1.panel);
        All_sw.panel.add(All_sw3.panel);
        All_sw.panel.add(All_sw6.hoverpanel);
        All_sw.panel.add(All_sw7.hoverpanel);
        All_sw.panel.add(All_sw8.hoverpanel);
        All_sw.panel.add(All_sw9.hoverpanel);
        All_sw.panel.add(All_sw10.hoverpanel);

        All_sw1.panel.add(All_sw1.label);
        All_sw1.panel.add(All_sw2.button);
//        All_sw1.panel.add(All_sw2.panel);
        All_sw1.panel.add(All_sw2.label);
        All_sw1.panel.add(All_sw4.label);
        All_sw3.panel.add(All_sw5.label);
        All_sw1.panel.add(All_sw3.label);

        All_sw1.panel.add(All_sw1.image_label);

        All_sw6.hoverpanel.add(All_sw6.image_label);
        All_sw6.hoverpanel.add(All_sw6.label);

        All_sw7.hoverpanel.add(All_sw7.image_label);
        All_sw7.hoverpanel.add(All_sw7.label);

        All_sw8.hoverpanel.add(All_sw8.image_label);
        All_sw8.hoverpanel.add(All_sw8.label);

        All_sw9.hoverpanel.add(All_sw9.image_label);
        All_sw9.hoverpanel.add(All_sw9.label);

        All_sw10.hoverpanel.add(All_sw10.image_label);
        All_sw10.hoverpanel.add(All_sw10.label);


    }
}
