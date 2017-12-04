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
import javax.swing.ImageIcon;
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
    
    public ApplicationHome(LinkedList<Phone> phoneList, LinkedList<Carrier> carrierList, LinkedHashSet<Plan> planList){
        
        homeFrame = new JFrame("Home");
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        applicationName = new JLabel("Phone Comparer", SwingConstants.CENTER);
        
        viewPhones = new JButton("View Phones");
        viewCarriers = new JButton("View Carriers");
        viewPlans = new JButton("Plans");

        viewPhones.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                PhoneController phonecntl = new PhoneController();
                phonecntl.getPhoneTable(phoneList, carrierList, planList);
                homeFrame.setVisible(false);
            }
        });
        
        viewCarriers.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarrierController carrierCntl = new CarrierController();
                carrierCntl.getCarrierTable(phoneList, carrierList, planList);
                homeFrame.setVisible(false);
            }
        });
        
        viewPlans.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlanController planCntl = new PlanController();
                planCntl.getPlanTable(phoneList, carrierList, planList);
                homeFrame.setVisible(false);
            }
        });
        
        ImageIcon icon = createImageIcon("background_image.jpg","");
        JLabel background = new JLabel("", icon, JLabel.CENTER);
        
        buttonPanel = new JPanel(new GridLayout(1,4));
        buttonPanel.add(viewCarriers);
        buttonPanel.add(viewPhones);
        buttonPanel.add(viewPlans);
        
        homeFrame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        homeFrame.getContentPane().add(applicationName, BorderLayout.NORTH);
        homeFrame.add(background);
        
        homeFrame.setSize(986, 700);
        homeFrame.setLocationRelativeTo(null); 
        homeFrame.setVisible(true);
    }
    
    // Returns an ImageIcon, or null if the path was invalid
    public ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}


