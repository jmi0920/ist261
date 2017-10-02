/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ist_261_project;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author Joshua Irwin
 */
public class PhoneView{
    
    JTextField manufacturerField, modelField, priceField;
    JButton nextButton, previousButton, editButton, deleteButton;
    String modelString, manufacturerString;
    JLabel modelLabel, manufacturerLable, priceLabel, headingLabel;
    JMenuBar menuBar;
    JMenu file, view;
    JMenuItem newItem, sortAlphabeticallyModel, sortAlphabeticallyManufacturer; 
    int index = 0;
            
    
    public PhoneView(LinkedList<Phone> list){
        
        LinkedList<Phone> phoneList = new LinkedList<Phone>(list);
        
        
        String modelString = phoneList.get(index).getModel();
        String manufacturerString = phoneList.get(index).getManufacturer();
        
        
        JFrame frame = new JFrame("Phone List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        menuBar = new JMenuBar();
        file = new JMenu("File");
        view = new JMenu("View");
        
        menuBar.add(file);
        menuBar.add(view);
        
        newItem = new JMenuItem("Add New Phone");
        sortAlphabeticallyModel = new JMenuItem("Sort Alphabetically (Model)");
        sortAlphabeticallyManufacturer = new JMenuItem("Sort Alphabetically (Manufacturer)");
        
        file.add(newItem);
        view.add(sortAlphabeticallyModel);
        view.add(sortAlphabeticallyManufacturer);
        
        headingLabel = new JLabel("Phone: " + (index+1) + "/" + phoneList.size());
        headingLabel.setBounds(150, 50, 200, 30);
        
        manufacturerField = new JTextField(manufacturerString);
        manufacturerLable = new JLabel("Manufacturer");
        manufacturerField.setBounds(90, 100, 200,30);  
        manufacturerLable.setBounds(10, 100, 90, 30);

        modelField = new JTextField(modelString);
        modelLabel = new JLabel("Model");
        modelField.setBounds(90, 150, 200,30);
        modelLabel.setBounds(10, 150, 90, 30);
        
        
        priceField = new JTextField("$" + String.valueOf(phoneList.get(index).getPrice()));
        priceLabel = new JLabel("Price");
        priceField.setBounds(90, 200, 200,30); 
        priceLabel.setBounds(10, 200, 90, 30);

        //Handles Next Button
        nextButton = new JButton("Next");
        nextButton.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                index++;
                String modelString = phoneList.get(index).getModel();
                String manufacturerString = phoneList.get(index).getManufacturer();
                modelField.setText(modelString);
                manufacturerField.setText(manufacturerString);
                priceField.setText("$" + String.valueOf(phoneList.get(index).getPrice()));
                
                // Prevents from looking outside of the array
                previousButton.setEnabled(true);
                if (index == phoneList.size() - 1){
                    nextButton.setEnabled(false);
                }
                
                //  --- Debugging ---
                //System.out.println("Next Clicked");
                //System.out.println(index);              
                //System.out.println(modelString);
                
                headingLabel.setText("Phone: " + (index+1) + "/" + phoneList.size());
            }
        });
        
        nextButton.setBounds(300, 320, 70, 30);

        //Handles Back Button
        previousButton = new JButton("Back");
        previousButton.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                index--;
                String modelString = phoneList.get(index).getModel();
                String manufacturerString = phoneList.get(index).getManufacturer();
                modelField.setText(modelString);
                manufacturerField.setText(manufacturerString);
                priceField.setText("$" + String.valueOf(phoneList.get(index).getPrice()));
                nextButton.setEnabled(true);
                if (index == 0){
                    previousButton.setEnabled(false);
                }
                
                //  --- Debugging ---
                //System.out.println("Previous Clicked");
                headingLabel.setText("Phone: " + (index+1) + "/" + phoneList.size());
            }
        });
        
        previousButton.setBounds(10, 320, 70, 30);
        
        // Prevents from looking outside of the array
        if (index == 0){
            previousButton.setEnabled(false);
        }

        // Handles Edit Button
        // TODO stop have three seperate popups and merge into one.
        editButton = new JButton("Edit");
        editButton.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String model = JOptionPane.showInputDialog(frame, "Change Phone Model"
                        + "\nLeave Blank To Keep Old Data");
                String manufacturer = JOptionPane.showInputDialog(frame, "Change Phone Manufacturer"
                        + "\nLeave Blank To Keep Old Data");
                String price = JOptionPane.showInputDialog(frame, "Change Phone Price"
                        + "\nLeave Blank To Keep Old Data");
               
                if(model == null || manufacturer == null || price == null){
                    JOptionPane.showMessageDialog(frame, "Canceled",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    if (!model.isEmpty()){
                        phoneList.get(index).setModel(model);
                        modelField.setText(model);
                    }

                    if (!manufacturer.isEmpty()){
                        phoneList.get(index).setManufacturer(manufacturer);
                        manufacturerField.setText(manufacturer);
                    }

                    if(!price.isEmpty()){

                        phoneList.get(index).setPrice(Double.parseDouble(price));
                        priceField.setText("$" + String.valueOf(price));
                    }
                }
                 headingLabel.setText("Phone: " + (index+1) + "/" + phoneList.size());
            }
        });
        editButton.setBounds(100, 300, 60, 30);

        // Handles Add New Phone in File Menu
        newItem.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String model = JOptionPane.showInputDialog(frame, "New Phone Model");
                String manufacturer = JOptionPane.showInputDialog(frame, "New Phone Manufacturer");
                String price = JOptionPane.showInputDialog(frame, "New Phone Price");
                
                if(model == null || manufacturer == null || price == null){
                    JOptionPane.showMessageDialog(frame, "Canceled",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                else if(!model.isEmpty()&& !manufacturer.isEmpty() && !price.isEmpty()){
                    Phone tempPhone = new Phone(model, manufacturer, Double.parseDouble(price));
                    phoneList.add(tempPhone);
                    modelField.setText(model);
                    manufacturerField.setText(manufacturer);
                    priceField.setText("$" + Double.parseDouble(price));
                    index = phoneList.size() - 1;
                    
                    // Prevents from looking outside of the array
                    if(phoneList.size() == 1){
                        nextButton.setEnabled(false);
                        previousButton.setEnabled(false);
                    }

                    // Prevents from looking outside of the array
                    else{
                    nextButton.setEnabled(false);
                    previousButton.setEnabled(true);
                    }
                }
                
                else{
                    StringBuilder errorString = new StringBuilder();
                    if(model.isEmpty()){
                        errorString.append(" Model");
                    }
                    
                    if(manufacturer.isEmpty()){
                        errorString.append(" Manufacturer");
                    }
                    
                    if(price.isEmpty()){
                        errorString.append(" Price");
                    }
                        
                    
                    JOptionPane.showMessageDialog(frame,
                            "Fields Left Blank:" + errorString,
                            "Error",
                            JOptionPane.WARNING_MESSAGE);
                }
                 headingLabel.setText("Phone: " + (index+1) + "/" + phoneList.size());
            }
        });
        
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
                    phoneList.remove(index);
                    
                    if (phoneList.size() == 0 && choice == 0){
                        index--;
                        modelField.setText("null");
                        manufacturerField.setText("null");
                        priceField.setText("null");
                        deleteButton.setEnabled(false);
                    }
                    
                    else if (index >= 1){
                        index--;
                        String modelString = phoneList.get(index).getModel();
                        String manufacturerString = phoneList.get(index).getManufacturer();
                        modelField.setText(modelString);
                        manufacturerField.setText(manufacturerString);
                        priceField.setText("$" + String.valueOf(phoneList.get(index).getPrice()));
                        
                        // Prevents from looking outside of the array
                        if (index == 0)
                            previousButton.setEnabled(false);
                        
                        if (phoneList.size() == 1){
                            nextButton.setEnabled(false);
                        }
                    }
                    
                    else{
                        String modelString = phoneList.get(index).getModel();
                        String manufacturerString = phoneList.get(index).getManufacturer();
                        modelField.setText(modelString);
                        manufacturerField.setText(manufacturerString);
                        priceField.setText("$" + String.valueOf(phoneList.get(index).getPrice()));
                        
                        // Prevents from looking outside of the array
                        if (phoneList.size() == 1){
                            nextButton.setEnabled(false);
                        }
                    }
                     headingLabel.setText("Phone: " + (index+1) + "/" + phoneList.size());
                }
            }
        });
        
        deleteButton.setBounds(220, 300, 70, 30);

        frame.add(headingLabel);
        
        // Disables input so only method of changing values is through
        // edit button.
        manufacturerField.setEditable(false);
        modelField.setEditable(false);
        priceField.setEditable(false);
        
        frame.add(manufacturerField);
        frame.add(modelField);
        frame.add(priceField);
        
        frame.add(modelLabel);
        frame.add(manufacturerLable);
        frame.add(priceLabel);

        frame.add(nextButton);
        frame.add(previousButton);
        frame.add(editButton);
        frame.add(deleteButton);

        frame.setLayout(null);

        frame.setSize(400, 425);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);

    } 
}
