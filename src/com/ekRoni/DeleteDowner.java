package com.ekRoni;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteDowner {
    JFrame frame;
    ImageIcon img;
    JTextArea TextArea;
    public static void main(String[] args) {
       DeleteDowner ob=new DeleteDowner();
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
    public void loadPanel()
    {
        SwingModel sw= new SwingModel();
        sw.CreatePanel(0,0,900,500);
        sw.panel.setBackground(Color.orange);
        sw.CreateLabel(345,30,1000,50,"Delete Downer","Algerian",25);

        SwingModel sw1=new SwingModel();
        sw1.CreateLabel(300,80,100,50,"Donor ID:","Algerian",17);
        sw1.CreateTextfield(395,94,60,20,"");
        sw1.CreateButton(475,94,100,20,"Search");
//        sw1.CreateLabel(40,90,150,50,"New DownerRegistration ID","Algerian",17);
//
//
//        SwingModel sw2=new SwingModel();
//        sw2.CreateLabel(300,86,80,50,"1","Algerian",17);


        SwingModel sw3=new SwingModel();
        sw3.CreateLabel(40,130,100,50,"Full Name:","Algerian",17);
        sw3.CreateTextfield(230,145,220,20,"");

        SwingModel sw4=new SwingModel();
        sw4.CreateLabel(40,170,150,50,"Father's Name:","Algerian",17);
        sw4.CreateTextfield(230,180,220,20,"");

        SwingModel sw5=new SwingModel();
        sw5.CreateLabel(40,205,250,50,"Mother's Name:","Algerian",17);
        sw5.CreateTextfield(230,217,220,20,"");

        SwingModel sw6=new SwingModel();
        sw6.CreateLabel(40,280,150,50,"Date Of Birth:","Algerian",17);
        sw6.CreateTextfield(230,290,220,20,"");
        String[] Date={"Date","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        String[] Month={"Month","1","2","3","4","5","6","7","8","9","10","11","12"};
        String[] Year={"Year","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022"};
        String[] Gender={"Gender","Male","Female","Others"};
        String[] BloodGroup={"Blood Group","A+","B+","O+","AB+","A-","O-"};
//        sw6.CreateCombo(230,290,60,30,Date);
//
//        SwingModel sw7=new SwingModel();
//        sw7.CreateCombo(300,290,75,30,Month);
//
//        SwingModel sw9=new SwingModel();
//        sw9.CreateCombo(380,290,70,30,Year);

        SwingModel sw10=new SwingModel();
        sw10.CreateLabel(40,320,150,50,"Gender:","Algerian",17);
//        sw10.CreateCombo(230,330,220,30,Gender);
        sw10.CreateTextfield(230,330,220,20,"");

        SwingModel sw11=new SwingModel();
        sw11.CreateLabel(490,130,180,50,"Email:","Algerian",17);
        sw11.CreateTextfield(625,143,220,20,"");

        SwingModel sw12=new SwingModel();
        sw12.CreateLabel(490,165,180,50,"Blood Groups:","Algerian",17);
//        sw11.CreateCombo(625,175,220,20,BloodGroup);
        sw12.CreateTextfield(625,175,220,20,"");

        SwingModel sw13=new SwingModel();
        sw13.CreateLabel(490,195,180,50,"City:","Algerian",17);
        sw13.CreateTextfield(625,210,220,20,"");

        SwingModel sw19=new SwingModel();
        sw19.CreateLabel(490,235,70,50,"Age:","Algerian",17);
        sw19.CreateTextfield(625,250,220,20,"");

        SwingModel sw14=new SwingModel();
        sw14.CreateLabel(490,280,180,50,"Complete Address:","Algerian",17);
        TextArea=new JTextArea();
        TextArea.setBounds(668,295,180,73);

        SwingModel sw18=new SwingModel();
        sw18.CreateLabel(40,240,150,50,"Mobile Number:","Algerian",17);
        sw18.CreateTextfield(230,255,220,20,"");

        sw1.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Search_textField=sw1.textField.getText();
                ResultSet rs=sw1.GetData("Select *from downer where Downer_ID='"+Search_textField+"'");
                try {
                    if(rs.next()){
                        sw3.textField.setText(rs.getString(2));
                        sw4.textField.setText(rs.getString(3));
                        sw5.textField.setText(rs.getString(4));
                        sw6.textField.setText(rs.getString(6));
                        sw10.textField.setText(rs.getString(7));
                        sw11.textField.setText(rs.getString(8));
                        sw12.textField.setText(rs.getString(9));
                        sw13.textField.setText(rs.getString(10));
                        sw18.textField.setText(rs.getString(5));
                        sw19.textField.setText(rs.getString(11));
                        TextArea.setText(rs.getString(12));
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Downer Id Doesn't Exit");
                        sw1.textField.setText("");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });

        SwingModel sw15=new SwingModel();
        sw15.CreateButton(230,400,90,20,"Delete");
        sw15.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Search_textField=sw1.textField.getText();
                String FName=sw3.textField.getText();
                String FatherName=sw4.textField.getText();
                String MotherName=sw5.textField.getText();
                String DOB=sw6.textField.getText();
                String Gender=sw10.textField.getText();
                String Blood_group=sw12.textField.getText();
//                String Day=(String) sw6.box.getSelectedItem();
//                String Month= (String) sw7.box.getSelectedItem();
//                String Year=(String)sw9.box.getSelectedItem();
//                String Gender=(String)sw10.box.getSelectedItem();
                String Email=sw11.textField.getText();
//                String BloodGroup=(String)sw11.box.getSelectedItem();
                String City=sw13.textField.getText();
                String Mobile=sw18.textField.getText();
                String Age=sw19.textField.getText();
                String TextAria=TextArea.getText();
                String Command=("Delete from downer where Downer_ID='"+Search_textField+"'");
                sw.Delete(Command);
                try {
                    sw1.Update(Command);
                    JOptionPane.showMessageDialog(null,"Successfully Deleted");
                    sw1.textField.setText("");
                    sw3.textField.setText("");
                    sw4.textField.setText("");
                    sw5.textField.setText("");
                    sw6.textField.setText("");
                    sw10.textField.setText("");
                    sw12.textField.setText("");
//                    sw6.box.setSelectedIndex(0);
//                    sw7.box.setSelectedIndex(0);
//                    sw9.box.setSelectedIndex(0);
//                    sw10.box.setSelectedIndex(0);
//                    sw11.box.setSelectedIndex(0);
                    sw11.textField.setText("");
                    sw13.textField.setText("");
                    sw18.textField.setText("");
                    sw19.textField.setText("");
                    TextArea.setText("");
                }
                catch (Exception k) {
                    JOptionPane.showMessageDialog(null, "Connection Error");
                }
            }
        });

        SwingModel sw16=new SwingModel();
        sw16.CreateButton(450,400,90,20,"Reset");
        sw16.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sw1.textField.setText("");
                sw3.textField.setText("");
                sw4.textField.setText("");
                sw5.textField.setText("");
                sw6.textField.setText("");
                sw10.textField.setText("");
                sw12.textField.setText("");
//                sw6.box.setSelectedIndex(0);
//                sw7.box.setSelectedIndex(0);
//                sw9.box.setSelectedIndex(0);
//                sw10.box.setSelectedIndex(0);
//                sw11.box.setSelectedIndex(0);
                sw11.textField.setText("");
                sw13.textField.setText("");
                sw18.textField.setText("");
                sw19.textField.setText("");
                TextArea.setText("");
            }
        });

        SwingModel sw17=new SwingModel();
        sw17.CreateButton(670,400,90,20,"Close");
        sw17.button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setVisible(false);
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

        frame.add(sw.panel);
        sw.panel.add(sw.label);
        sw.panel.add(sw1.label);
        sw.panel.add(sw1.textField);
        sw.panel.add(sw1.button);
        sw.panel.add(sw3.label);
        sw.panel.add(sw3.textField);
        sw.panel.add(sw4.label);
        sw.panel.add(sw4.textField);
        sw.panel.add(sw5.label);
        sw.panel.add(sw5.textField);
        sw.panel.add(sw6.textField);
        sw.panel.add(sw6.label);
//        sw.panel.add(sw6.box);
//        sw.panel.add(sw7.box);
//        sw.panel.add(sw9.box);
        sw.panel.add(sw10.label);
//        sw.panel.add(sw10.box);
        sw.panel.add(sw10.textField);
        sw.panel.add(sw11.label);
        sw.panel.add(sw11.textField);
        sw.panel.add(sw12.label);
//        sw.panel.add(sw11.box);
        sw.panel.add(sw12.textField);
        sw.panel.add(sw13.label);
        sw.panel.add(sw13.textField);
        sw.panel.add(sw14.label);
        sw.panel.add(TextArea);
        sw.panel.add(sw15.button);
        sw.panel.add(sw16.button);
        sw.panel.add(sw17.button);
        sw.panel.add(sw18.label);
        sw.panel.add(sw18.textField);
        sw.panel.add(sw19.label);
        sw.panel.add(sw19.textField);

    }
}
