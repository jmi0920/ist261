/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ist_261_project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Josh
 */
public class PhoneTable {
    
    public LinkedList phoneList;
    public DefaultTableModel tableModel;
    
    JTable phoneTable;
    JButton newButton, detailsButton, doneButton, searchButton;
    JPanel buttonPanel;
    DecimalFormat currency = new DecimalFormat("#.00"); 
    JLabel searchText;
    JTextField searchField;
    
    public PhoneTable (LinkedList<Phone> list, LinkedList<Carrier> carrierList, LinkedHashSet<Plan> planList){

        LinkedList<Phone> phoneList = new LinkedList<Phone>(list);
        
        JFrame tableFrame = new JFrame();
        tableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Object columnNames[] = {"Model", "Manufacture", "Price"};
        Object rowData [][] = {};
        
        tableModel = new DefaultTableModel(rowData, columnNames);
        phoneTable = new JTable(tableModel);
        
        for(int i = 0; i < phoneList.size(); i++){
            Phone test2 = phoneList.get(i);
            String model = test2.getModel();
            String manuf = test2.getManufacturer();
            double price = test2.getPrice();
            
            tableModel.insertRow(phoneTable.getRowCount(), new Object[]{model, manuf, "$" + String.valueOf(price)});
        }
        
        searchField = new JTextField("Search Phones");
        searchField.setBounds(0, 200, 250, 30);
        tableFrame.add(searchField);
        
        searchButton = new JButton("Find Phone");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO Rename variables
                int phoneIndex = -1;
                String searchString = searchField.getText();
                for(int i =0; i < phoneList.size(); i++){
                    Phone PhoneTemp = phoneList.get(i);
                    //System.out.println(searchString);
                    //System.out.println(PhoneTemp.getModel());
                    if(PhoneTemp.getModel().equals(searchString) || PhoneTemp.getManufacturer().equals(searchString)){
                        //System.out.println("In Success");
                        phoneIndex = i;
                        PhoneController newPhone = new PhoneController();
                        newPhone.getPhoneDetails(phoneList, phoneIndex, 0, carrierList, planList);
                        tableFrame.setVisible(false);
                        System.out.println(phoneList.get(i).getModel());
                    }
                }
                
                if(phoneIndex == -1){
                    JOptionPane.showMessageDialog(tableFrame,
                            "No phone matched search","Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        searchButton.setBounds(260, 200, 100, 30);
        tableFrame.add(searchButton);
        
        
        
        newButton = new JButton("New Phone");
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO Rename variables
                PhoneController newPhone = new PhoneController();
                newPhone.getPhoneDetails(phoneList, 0, 1, carrierList, planList);
                tableFrame.setVisible(false);
            }
        });
     
        detailsButton = new JButton("Show Details");
        detailsButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selctedPhone = phoneTable.getSelectedRow();
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
        
        JScrollPane scrollPane = new JScrollPane(phoneTable);
        tableFrame.add(scrollPane, BorderLayout.CENTER);
        tableFrame.setSize(500, 300);
        tableFrame.setLocationRelativeTo(null); 
        tableFrame.setVisible(true);
    }
}
