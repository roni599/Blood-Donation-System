package com.ekRoni;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

public class Decrease {
    JFrame frame;
    ImageIcon img;
    public static void main(String[] args) {
        Decrease ob=new Decrease();
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
        sw.CreateLabel(285,25,1000,50,"Stock Downer(Decrease)","Algerian",25);

        SwingModel sw1=new SwingModel();
//        sw1.CreateLabel(340,70,100,50,"Location:","Algerian",17);
//        sw1.CreateTextfield(435,85,130,20,"");
        ResultSet result=sw.GetData("Select * from Stock");
        sw1.CreateTable(115,115,700,280,result);
        sw1.CreateButton(745,400,70,30,"Close");
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

        String[] BloodGroup={"BloodGroup_Name","A+","A-","B+","B-","O+","O-","AB+","AB-"};
        SwingModel sw2=new SwingModel();
        sw2.CreateLabel(115,72,150,50,"Blood Group :","Algerian",17);
        sw2.CreateCombo(245,85,140,20,BloodGroup);

        SwingModel sw3=new SwingModel();
        sw3.CreateLabel(420,67,150,59,"Units :","Algerian",17);
        sw3.CreateTextfield(492,85,110,20,"");
        sw3.textField.setBackground(Color.LIGHT_GRAY);

        SwingModel sw4=new SwingModel();
        sw3.CreateButton(715,85,100,20,"Update");
        sw3.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if((((String) sw2.box.getSelectedItem()).isEmpty()|| sw3.textField.getText().isEmpty())){
                    JOptionPane.showMessageDialog(null,"Blood Group Field Or Units Text Field is empty");
                }
                else {
                    String Blood_box=(String)sw2.box.getSelectedItem();
                    String units_field=sw3.textField.getText();
                    int units=Integer.parseInt(units_field);
                    String Command="Update stock set  Units=Units-'"+units+"' where BloodGroup_Name='"+Blood_box+"'";
                    sw.Update(Command);
                    JOptionPane.showMessageDialog(null,"Data Updated Successfully");
                    sw1.scrollPane.setVisible(false);
                    ResultSet rez=sw.GetData("Select * from stock");
                    sw4.CreateTable(115,115,700,280,rez);
                    sw.panel.add(sw4.scrollPane);
                    sw2.box.setSelectedIndex(0);
                    sw3.textField.setText("");
                }

            }
        });

        frame.add(sw.panel);
        sw.panel.add(sw.label);
//        sw.panel.add(sw1.label);
        sw.panel.add(sw1.scrollPane);
        sw.panel.add(sw1.button);
//        sw.panel.add(sw1.textField);

        sw.panel.add(sw2.label);
        sw.panel.add(sw2.box);

        sw.panel.add(sw3.label);
        sw.panel.add(sw3.textField);
        sw.panel.add(sw3.button);
    }
}
