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
import java.util.LinkedHashSet;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Josh
 */
public class CarrierTable {
    
    public LinkedList carrierList;
    public DefaultTableModel tableModel;
    
    JTable carrierTable;
    JButton newButton, detailsButton, doneButton;
    JPanel buttonPanel;
    
    public CarrierTable(LinkedList<Phone> phoneList, LinkedList<Carrier> list, LinkedHashSet<Plan> planList){
        
        LinkedList<Carrier> carrierList = new LinkedList<Carrier>(list);
        JFrame tableFrame = new JFrame();
        tableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Object columnNames[] = {"Carrier Name"};
        Object rowData [][] = {};
        
        tableModel = new DefaultTableModel(rowData, columnNames);
        carrierTable = new JTable(tableModel);
        
        for(int i = 0; i < carrierList.size(); i++){
            Carrier tempCarrier = carrierList.get(i);
            String name = tempCarrier.getName();
            tableModel.insertRow(carrierTable.getRowCount(), new Object[]{name});
        }
        
        newButton = new JButton("New Carrier");
            newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO Rename variables
                CarrierController newCarrier = new CarrierController();
                newCarrier.getCarrierDetails(phoneList, 0, 1, carrierList, planList);
                tableFrame.setVisible(false);
            }
        });
        
        detailsButton = new JButton("Show Details");
        detailsButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedCarrier = carrierTable.getSelectedRow();
                if(selectedCarrier == -1){
                    JOptionPane.showMessageDialog(tableFrame,
                            "An entry must be selected.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                else{
                CarrierController details = new CarrierController();
                details.getCarrierDetails(phoneList, selectedCarrier, 0, carrierList, planList);
                tableFrame.setVisible(false);
                }
            }
        });
        
        doneButton = new JButton("Done");
        doneButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ApplicationHome home = new ApplicationHome(phoneList, carrierList, planList);
                tableFrame.setVisible(false);
            }
        });
        
        buttonPanel = new JPanel(new GridLayout(1,4));
        buttonPanel.add(newButton);
        buttonPanel.add(detailsButton);
        buttonPanel.add(doneButton);
        
        tableFrame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
         
        JScrollPane scrollPane = new JScrollPane(carrierTable);
       
        tableFrame.add(scrollPane, BorderLayout.CENTER);
        tableFrame.setSize(500, 300);
        tableFrame.setLocationRelativeTo(null); 
        tableFrame.setVisible(true);
    }

}
