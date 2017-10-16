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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/*
 * @author Josh
 */
public class ApplicationHome {
    
    JFrame homeFrame;
    JButton viewPhones, viewPlans, viewCarriers;
    JPanel buttonPanel;
    JLabel applicationName;
    public LinkedList<Phone> phoneList;
    public PhoneList list;
    
    public ApplicationHome(LinkedList<Phone> phoneList, LinkedList<Carrier> carrierList){
        
        homeFrame = new JFrame("Home");
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        applicationName = new JLabel("Application Name", SwingConstants.CENTER);
        
        viewPhones = new JButton("View Phones");
        viewCarriers = new JButton("View Carriers");
        viewPlans = new JButton("Not Yet Implemented");

        viewPhones.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                PhoneController phonecntl = new PhoneController();
                phonecntl.getPhoneTable(phoneList, carrierList);
                homeFrame.setVisible(false);
            }
        });
        
        viewCarriers.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarrierController carrierCntl = new CarrierController();
                carrierCntl.getCarrierTable(phoneList, carrierList);
                homeFrame.setVisible(false);
            }
        });
        
        buttonPanel = new JPanel(new GridLayout(1,4));
        buttonPanel.add(viewCarriers);
        buttonPanel.add(viewPhones);
        buttonPanel.add(viewPlans);
        
        homeFrame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        
        homeFrame.getContentPane().add(applicationName, BorderLayout.CENTER);
        
        homeFrame.setSize(400, 425);
        homeFrame.setLocationRelativeTo(null); 
        homeFrame.setVisible(true);
    }
}
