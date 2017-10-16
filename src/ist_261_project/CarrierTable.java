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
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Josh
 */
public class CarrierTable {
    
    public LinkedList carrierList;
    public CarrierList list;
    public DefaultTableModel tableModel;
    
    JTable carrierTable;
    JButton newButton, detailsButton, doneButton;
    JPanel buttonPanel;
    
    public CarrierTable(LinkedList<Phone> phoneList, LinkedList<Carrier> list){
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
        detailsButton = new JButton("Show Details");
        
        doneButton = new JButton("Done");
        doneButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ApplicationHome home = new ApplicationHome(phoneList, carrierList);
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
