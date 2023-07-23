package com.ekRoni;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;

public class ReceptionistRegistration {
    JFrame frame;
    ImageIcon img;
    ResultSet rez;
    File f;
    String filename;
    public static void main(String[] args) {
        ReceptionistRegistration ob= new ReceptionistRegistration();
        ob.createPanel();
    }
    public void createPanel()
    {
        img= new ImageIcon("C:\\Users\\ekRoni\\IdeaProjects\\Payra\\src\\com\\Sakib\\logoPayra.png");
        frame = new JFrame();
        frame.setLayout(null);
        frame.setTitle("Receptionist Registration");
        frame.setSize(1300,700);
        frame.setIconImage(img.getImage());
        frame.setLocationRelativeTo(null);
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        loadPanel();
        frame.setVisible(true);
    }
    public void loadPanel()
    {
        SwingModel sw= new SwingModel();
        sw.CreatePanel(0,0,1300,700);
        sw.panel.setBackground(Color.ORANGE);
        sw.CreateLabel(430,80,1000,50,"New Receptionist Registration","Algerian",25);
        sw.CreateTextfield(580,155,240,30,"");

        SwingModel sw0=new SwingModel();
        sw0.CreateLabel(515,155,80,30,"Name :","Algerian",17);

        SwingModel sw1= new SwingModel();
        sw1.CreateTextfield(580,310,240,30,"");
        sw1.CreateLabel(468,190,170,30,"User Name :","Algerian",17);

        SwingModel sw2= new SwingModel();
        sw2.CreateTextfield(580,350,240,30,"");
        sw2.CreateLabel(472,230,110,30,"Password :","Algerian",17);

        SwingModel sw5= new SwingModel();
        sw5.CreateTextfield(580,390,240,30,"");
        sw5.CreateLabel(445,270,150,30,"Blood Group :","Algerian",17);

        SwingModel sw3= new SwingModel();
        sw3.CreateTextfield(580,430,240,30,"");
        sw3.CreateLabel(520,310,50,30,"Age :","Algerian",17);

        SwingModel sw4= new SwingModel();
        sw4.CreateTextfield(580,470,240,30,"");
        sw4.CreateLabel(505,350,100,30,"Email :","Algerian",17);

        SwingModel sw7= new SwingModel();
        sw7.CreateTextfield(580,510,240,30,"");
        sw7.CreateLabel(505,390,100,30,"Phone :","Algerian",17);

        SwingModel sw8=new SwingModel();
        sw8.CreateTextfield(580,270,240,30,"");
        sw8.CreateLabel(493,430,100,30,"Gender :","Algerian",17);

        SwingModel sw9=new SwingModel();
        sw9.CreateTextfield(580,230,240,30,"");
        sw9.CreateLabel(485,470,150,30,"Address :","Algerian",17);

        SwingModel sw10=new SwingModel();
        sw10.CreateTextfield(580,190,240,30,"");
        sw10.CreateLabel(488,510,200,30,"Position :","Algerian",17);

        sw10.CreateButton(900,550,100,30,"Image");
        sw10.button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                JFileChooser img_chooser = new JFileChooser();
                int response = img_chooser.showOpenDialog(null);

                if(response == img_chooser.APPROVE_OPTION){
                    f = img_chooser.getSelectedFile();
                    filename = f.getAbsolutePath();


                    sw10.CreateResizeImage(870,390,150,150,filename);
                    sw10.image_label.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.GRAY));
                    sw.panel.add(sw10.image_label);
                    sw.panel.repaint();

                }

            }
        });
        sw.CreateButton(580,550,240,30,"Register");
        sw.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sw_Name=sw.textField.getText();
                String sw10_UserName=sw10.textField.getText();
                String sw9_Password=sw9.textField.getText();
                String sw8_BloodGroup=sw8.textField.getText();
                String sw1_Age=sw1.textField.getText();
                String sw2_Email=sw2.textField.getText();
                String sw5_Phone=sw5.textField.getText();
                String sw3_Gender=sw3.textField.getText();
                String sw4_Address=sw4.textField.getText();
                String sw7_Position=sw7.textField.getText();
                String Command="INSERT INTO receptionist (Name,User_name,Password,Blood_group,Age,Email,Phone,Sex,Address,Position) VALUES('"+sw_Name+"','"+sw10_UserName+"','"+sw9_Password+"','"+sw8_BloodGroup+"','"+sw1_Age+"','"+sw2_Email+"','"+sw5_Phone+"','"+sw3_Gender+"','"+sw4_Address+"','"+sw7_Position+"')";

                if((sw.textField.getText().isEmpty()|| sw10.textField.getText().isEmpty()|| sw9.textField.getText().isEmpty()||sw8.textField.getText().isEmpty()||sw1.textField.getText().isEmpty()|| sw2.textField.getText().isEmpty()|| sw5.textField.getText().isEmpty()|| sw3.textField.getText().isEmpty()|| sw4.textField.getText().isEmpty()|| sw7.textField.getText().isEmpty())){
                    JOptionPane.showMessageDialog(null,"Some TextField is empty");
                }
                else {
//                    sw.SendData(Command);
                    JOptionPane.showMessageDialog(null,"Data Insert Successfully");
                    sw.textField.setText("");
                    sw10.textField.setText("");
                    sw9.textField.setText("");
                    sw8.textField.setText("");
                    sw1.textField.setText("");
                    sw2.textField.setText("");
                    sw5.textField.setText("");
                    sw3.textField.setText("");
                    sw4.textField.setText("");
                    sw7.textField.setText("");
                }

            }
        });


        frame.add(sw.panel);
        sw.panel.add(sw.label);
        sw.panel.add(sw0.label);
        sw.panel.add(sw.textField);
        sw.panel.add(sw1.textField);
        sw.panel.add(sw1.label);
        sw.panel.add(sw2.textField);
        sw.panel.add(sw2.label);
        sw.panel.add(sw3.textField);
        sw.panel.add(sw3.label);
        sw.panel.add(sw4.textField);
        sw.panel.add(sw4.label);
        sw.panel.add(sw5.textField);
        sw.panel.add(sw5.label);
        sw.panel.add(sw7.textField);
        sw.panel.add(sw7.label);
        sw.panel.add(sw8.textField);
        sw.panel.add(sw8.label);
        sw.panel.add(sw9.textField);
        sw.panel.add(sw9.label);
        sw.panel.add(sw10.textField);
        sw.panel.add(sw10.label);
        sw.panel.add(sw.button);
        sw.panel.add(sw10.button);

    }
}
