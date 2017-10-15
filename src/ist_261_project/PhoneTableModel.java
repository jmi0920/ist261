/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ist_261_project;

import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Josh
 */
public class PhoneTableModel extends AbstractTableModel{
    
    private String[] columnNames = {"Model", "Manufacturer", "Price"};
    private LinkedList<Phone> phoneList;
    
    public PhoneTableModel(LinkedList<Phone> newPhoneList){
        phoneList = newPhoneList;
    }

    @Override
    public int getRowCount() {
        return phoneList.size();
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return (Object) phoneList.get(rowIndex).getModel();
            case 1: return (Object) phoneList.get(rowIndex).getManufacturer();
            case 2: return (Object) phoneList.get(rowIndex).getPrice();
            default: return null;
        }
    }
}
