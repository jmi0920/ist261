/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ist_261_project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.util.Iterator;
import javax.swing.JComboBox;
import javax.swing.JDialog;

/**
 *
 * @author Josh
 */
public class PlanTable {
    
    public LinkedList phoneList;
    public DefaultTableModel tableModel;
    
    JTable planTable;
    JButton newButton, detailsButton, doneButton, searchButton;
    JPanel buttonPanel;
    DecimalFormat currency = new DecimalFormat("#.00"); 
    JLabel searchText;
    JTextField searchField;
    
    public PlanTable (LinkedList<Phone> list, LinkedList<Carrier> carrierList, LinkedHashSet<Plan> planList){

        LinkedList<Phone> phoneList = new LinkedList<Phone>(list);
        LinkedList<Carrier> carriers = new LinkedList<Carrier>(carrierList);
        
        JFrame tableFrame = new JFrame();
        tableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Object columnNames[] = {"Name", "Phone", "Manufacture", "Carrier", "Price"};
        Object rowData [][] = {};
        
        tableModel = new DefaultTableModel(rowData, columnNames);
        planTable = new JTable(tableModel);
        
        Iterator<Plan> iter = planList.iterator();
        
        for(int i = 0; i < planList.size(); i++){
            Plan tempPlan = null;
            while(iter.hasNext()){
                tempPlan = iter.next();
                String name = tempPlan.getName();
                String phone = tempPlan.getPhone().getModel();
                String manufacturer = tempPlan.getPhone().getManufacturer();
                String carrier = tempPlan.getCarrier().getName();
                double price = tempPlan.getPrice();
            
            tableModel.insertRow(planTable.getRowCount(), new Object[]{name, phone, manufacturer, carrier, "$" + String.valueOf(price)});
            }
        }
        
        newButton = new JButton("Create Plan");
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog(tableFrame, "Create a Plan", true);
                dialog.setLayout(new FlowLayout());
                
                JLabel selectPhoneLabel, selectCarrierLabel, estimatedPlanPrice,
                        nameLabel;
                JTextField price, nameField;
                JButton create;
                

                ArrayList<String> modelStrings = new ArrayList<String>();
                ArrayList<String> carrierStrings = new ArrayList<>();
                
                for(int i = 0; i < phoneList.size(); i++){
                    Phone tempPhone = phoneList.get(i);
                    modelStrings.add(tempPhone.getModel());
                }
                
                for(int i = 0; i < carrierList.size(); i++){
                    Carrier tempCarrier = carrierList.get(i);
                    carrierStrings.add(tempCarrier.getName());
                }
                String[] modelArray = new String[modelStrings.size()];
                modelArray = modelStrings.toArray(modelArray);
                
                String[] carrierArray = new String[carrierStrings.size()];
                carrierArray = carrierStrings.toArray(carrierArray);
                
                JComboBox modelList = new JComboBox(modelArray);
                JComboBox carrierList = new JComboBox(carrierArray);
                
                selectPhoneLabel = new JLabel("Select Phone Model");
                selectCarrierLabel = new JLabel("Select Carrier");
                estimatedPlanPrice = new JLabel("Estimated Plan Price:");
                
                //TODO look into java method to fix layout, this is ugly.
                nameLabel = new JLabel("                      Enter Plan Name");
                
                modelList.insertItemAt("", 0);
                modelList.setSelectedIndex(0);
                
                carrierList.insertItemAt("", 0);
                carrierList.setSelectedIndex(0);
                
                price = new JTextField(10);
                nameField = new JTextField(20);
                
                modelList.addActionListener (new ActionListener () {
                    public void actionPerformed(ActionEvent e) {
                        String searchString = modelList.getSelectedItem().toString();
                        double markUp;
                        
                        String selectedCarrier = carrierList.getSelectedItem().toString();
                        
                        switch (selectedCarrier) {
                            case "Verizon": markUp = .15;
                                            break;
                                            
                            case "Sprint": markUp = .09;
                                            break;
                            
                            case "T-Mobile": markUp = .12;
                                            break;                
                            
                            default: markUp = .05;
                                break;
                        }
                        
                        for(int i =0; i < phoneList.size(); i++){
                            Phone PhoneTemp = phoneList.get(i);
                            
                            if(PhoneTemp.getModel().equals(searchString)){
                                price.setText(String.valueOf(PhoneTemp.getPrice() + (PhoneTemp.getPrice() * markUp)));
                            }
                            else if(searchString == "" || selectedCarrier == ""){
                                price.setText("");
                            }
                        }
                    }
                });
                
                carrierList.addActionListener (new ActionListener () {
                    public void actionPerformed(ActionEvent e) {
                        String searchString = modelList.getSelectedItem().toString();
                        double markUp;
                        
                        String selectedCarrier = carrierList.getSelectedItem().toString();
                        
                        switch (selectedCarrier) {
                            case "Verizon": markUp = .15;
                                            break;
                                            
                            case "Sprint": markUp = .09;
                                            break;
                            
                            case "T-Mobile": markUp = .12;
                                            break;                
                            
                            default: markUp = .05;
                                break;
                        }
                        
                        for(int i =0; i < phoneList.size(); i++){
                            Phone PhoneTemp = phoneList.get(i);
                            
                            if(PhoneTemp.getModel().equals(searchString)){
                                price.setText(String.valueOf(PhoneTemp.getPrice() + (PhoneTemp.getPrice() * markUp)));
                            }
                            else if(searchString == "" || selectedCarrier == ""){
                                price.setText("");
                            }
                        }
                    }
                });
                
                create = new JButton("Create");
                LinkedList<Phone> planPhone = new LinkedList<Phone>();
                LinkedList<Carrier> planCarrier = new LinkedList<Carrier>();
                
                create.addActionListener (new ActionListener () {
                    public void actionPerformed(ActionEvent e) {
                        for(int i =0; i < phoneList.size(); i++){
                            Phone PhoneTemp = phoneList.get(i);
                            
                            if(PhoneTemp.getModel().equals(modelList.getSelectedItem().toString())){
                                Phone selectedPhone = new Phone(PhoneTemp.getModel(), PhoneTemp.getManufacturer(), PhoneTemp.getPrice());
                                planPhone.add(selectedPhone);
                            }
                        }
                        
                        for(int i = 0; i < carriers.size(); i++){
                            Carrier carrierTemp = carriers.get(i);
                            
                            if(carrierTemp.getName().equals(carrierList.getSelectedItem().toString())){
                                Carrier selectedCarrier = new Carrier(carrierTemp.getName());
                                planCarrier.add(selectedCarrier);
                            }
                        }
                        
                        //Plan(String newName, Phone newPhone, Carrier newCarrier, double newPrice)
                        planList.add(new Plan(nameField.getText(), planPhone.get(0), planCarrier.get(0), Double.parseDouble(price.getText())));
                        tableFrame.setVisible(false);
                        PlanTable refresh = new PlanTable(phoneList, carriers, planList);
                        dialog.dispose();
                    }
                });
                        
                dialog.add(selectPhoneLabel);
                dialog.add(modelList);
                
                dialog.add(selectCarrierLabel);
                dialog.add(carrierList);
                
                dialog.add(estimatedPlanPrice);
                dialog.add(price);
                
                dialog.add(create);
                
                dialog.add(nameLabel);
                dialog.add(nameField);
                
                dialog.setSize(500, 150);
                dialog.setVisible(true);
            }
        });
     
        detailsButton = new JButton("Show Details");
        detailsButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selctedPhone = planTable.getSelectedRow();
                if(selctedPhone == -1){
                    JOptionPane.showMessageDialog(tableFrame,
                            "An entry must be selected.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                else{
                PhoneController details = new PhoneController();
                details.getPhoneDetails(phoneList, selctedPhone, 0, carrierList, planList);
                tableFrame.setVisible(false);
                }
            }
        });
        
        doneButton = new JButton("Done");
        doneButton.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                
                ApplicationHome phoneHome = new ApplicationHome(phoneList, carrierList, planList);
                tableFrame.setVisible(false);
            }
        });
        
        buttonPanel = new JPanel(new GridLayout(1,4));
        buttonPanel.add(newButton);
        buttonPanel.add(detailsButton);
        buttonPanel.add(doneButton);
        
        tableFrame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        
        JScrollPane scrollPane = new JScrollPane(planTable);
        tableFrame.add(scrollPane, BorderLayout.CENTER);
        tableFrame.setSize(500, 300);
        tableFrame.setLocationRelativeTo(null); 
        tableFrame.setVisible(true);
    }
}