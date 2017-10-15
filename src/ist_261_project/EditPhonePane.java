/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ist_261_project;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Josh
 */
public class EditPhonePane {
    public EditPhonePane(){
        JTextField newModelField = new JTextField();
        JTextField newManufacturerField = new JTextField();
        JTextField newPriceField = new JTextField();
        
        JPanel newPanel = new JPanel();
        newPanel.add(new JLabel("Model:"));
        newPanel.add(newModelField);
        
        newPanel.add(Box.createHorizontalStrut(15));
        
        newPanel.add(new JLabel("Manufacturer:"));
        newPanel.add(newManufacturerField);
        
        newPanel.add(Box.createHorizontalStrut(15));
       
        newPanel.add(new JLabel("Price:"));
        newPanel.add(newPriceField);
        
    }
}
