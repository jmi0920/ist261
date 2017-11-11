/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ist_261_project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Joshua Irwin
 */
public class CarrierDetailView{
    
    JTextField nameField;
    JButton editButton, deleteButton, doneButton;
    String nameString;
    JLabel nameLabel, headingLabel, exitMessage;
    JPanel buttonPanel;
    int index = 0;
    
    public CarrierDetailView(LinkedList<Phone> list, int selectedPhone, int addPhoneDialog,
            LinkedList<Carrier> carrierList){
        
        LinkedList<Carrier> carrier_list = new LinkedList<>(carrierList);
        index = selectedPhone;
        
        String nameString = carrier_list.get(index).getName();
        
        JFrame frame = new JFrame("Carrier List");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        exitMessage = new JLabel("Please click \"View Table\" to close this page to prevent data loss");
        exitMessage.setBounds(10, 320, 400, 30);
        frame.add(exitMessage);
        
        headingLabel = new JLabel("Carrier: " + (index+1) + "/" + carrier_list.size());
        headingLabel.setBounds(150, 50, 200, 30);
        
        nameField = new JTextField(nameString);
        nameLabel = new JLabel("Carrier Name");
        nameField.setBounds(90, 150, 200,30);  
        nameLabel.setBounds(10, 150, 90, 30);
        
        // Handles Edit Button
        // TODO stop have three seperate popups and merge into one.
        editButton = new JButton("Edit");
        editButton.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String name = JOptionPane.showInputDialog(frame, "Change Carrier Name"
                        + "\nLeave Blank To Keep Old Data");
               
                if(name == null){
                    JOptionPane.showMessageDialog(frame, "Canceled",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    if (!name.isEmpty()){
                        carrier_list.get(index).setName(name);
                        nameField.setText(name);
                    }
                }
                 headingLabel.setText("Carrier: " + (index+1) + "/" + carrier_list.size());
            }
        });
        
        doneButton = new JButton("View Table");
        doneButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarrierTable carrierTable = new CarrierTable(list, carrier_list);
                frame.setVisible(false);
            }
        });

        if (addPhoneDialog == 1){
                String name = JOptionPane.showInputDialog(frame, "New Carrier Name");
                
                if(name == null){
                    JOptionPane.showMessageDialog(frame, "Canceled",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                else if(!name.isEmpty()){
                    Carrier tempCarrier = new Carrier(name);
                    carrier_list.add(tempCarrier);
                    nameField.setText(name);
                    index = carrier_list.size() - 1;
                    
                    //Saves the new phone to the data collection upon creation.
                    FileOutputStream fileOutput = null;
                    ObjectOutputStream objectOut = null;
        
                    try{
                       fileOutput = new FileOutputStream("CarrierList.ser");
                       objectOut = new ObjectOutputStream(fileOutput);
                       objectOut.writeObject(carrier_list);
                       objectOut.close();
                    }
        
                    catch(IOException ex){
                        ex.printStackTrace();
                    }
                }
                
                else{
                    StringBuilder errorString = new StringBuilder();
                    if(name.isEmpty()){
                        errorString.append(" Name");
                    }
                    
                    JOptionPane.showMessageDialog(frame,
                            "Fields Left Blank:" + errorString,
                            "Error",
                            JOptionPane.WARNING_MESSAGE);
                }
                 headingLabel.setText("Carrier: " + (index+1) + "/" + carrier_list.size());
            }
        
        // Handles delete button
        deleteButton = new JButton("Delete");
        deleteButton.setBackground(Color.RED);
        deleteButton.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                //Yes == 0, No == 1
                int choice = JOptionPane.showConfirmDialog(frame,
                        "Are you sure you want to delete this phone?",
                        "Confirm Delete", JOptionPane.YES_NO_OPTION );
                if (choice == 0){
                    carrier_list.remove(index);
                    returnList(carrier_list);
                    
                    //Rewrites PhoneList.ser if a phone is removed.
                    FileOutputStream fileOutput = null;
                    ObjectOutputStream objectOut = null;
        
                    try{
                       fileOutput = new FileOutputStream("CarrierList.ser");
                       objectOut = new ObjectOutputStream(fileOutput);
                       objectOut.writeObject(carrier_list);
                       objectOut.close();
                    }
        
                    catch(IOException ex){
                        ex.printStackTrace();
                    }
        
                    if (carrier_list.size() == 0 && choice == 0){
                        index--;
                        nameField.setText("null");
                        deleteButton.setEnabled(false);
                    }
                    
                    else if (index >= 1){
                        index--;
                        String nameString = carrier_list.get(index).getName();
                        nameField.setText(nameString);
                    }
                    
                    else{
                        String nameString = carrier_list.get(index).getName();
                        nameField.setText(nameString);
                    }
                     headingLabel.setText("Carrier: " + (index+1) + "/" + carrier_list.size());
                }
            }
        });

        frame.add(headingLabel);

        frame.add(editButton);
        editButton.setBounds(10, 350, 110, 30);
        
        frame.add(deleteButton);
        deleteButton.setBounds(140, 350, 110, 30);
        
        frame.add(doneButton);
        doneButton.setBounds(265, 350, 110, 30);

        
        // Disables input so only method of changing values is through
        // edit button.
        nameField.setEditable(false);

        frame.add(nameField);
        
        frame.add(nameLabel);
      
        frame.setLayout(null);
        frame.setSize(400, 425);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }
    
    public LinkedList<Carrier> returnList(LinkedList<Carrier> list){
        return list;
    }
}
