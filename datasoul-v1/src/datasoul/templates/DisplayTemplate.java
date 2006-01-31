/*
 * DisplayTemplate.java
 *
 * Created on December 31, 2005, 12:55 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package datasoul.templates;

import datasoul.util.AttributedObject;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author samuelm
 */
public class DisplayTemplate extends AttributedObject {
    
    ArrayList<TemplateItem> items;
    
    DisplayTemplateTableModel model;
    
    static int defaultItemNameCount = 1;
    
    private String name;
    
    /** Creates a new instance of DisplayTemplate */
    public DisplayTemplate() {
        super();
        items = new ArrayList<TemplateItem>();
        model = new DisplayTemplateTableModel();
    }
    
    @Override
    protected void registerProperties(){
        properties.add("Name");
    }
    
    public DisplayTemplateTableModel getModel(){
        return model;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * items are exported as default access level to
     * allow other classes in this package access it directly.
     * This is needed by the TempalteEditorPanel.
     * But the general rule is that other components shall
     * avoid using it directly.
     */
    ArrayList<TemplateItem> getItems(){
        return items;
    }
    
    public void addItem(TemplateItem t){
        if (t.getName().equals("")){
            t.setName("Item #"+defaultItemNameCount++);
        }
        items.add(t);
        model.fireTableDataChanged();
    }
    
    public void removeItem(TemplateItem t){
        items.remove(t);
        model.fireTableDataChanged();
    }
    
    public void paint (Graphics2D g){
        
        Iterator<TemplateItem> iter = items.iterator();
        while(iter.hasNext()){
            TemplateItem t = iter.next();
            t.draw( g );
        }

    }

    public class DisplayTemplateTableModel extends DefaultTableModel {
        
        public int getRowCount() {
            return items.size();
        }

        public int getColumnCount() {
            return 1;
        }

        public String getColumnName(int columnIndex) {
            return "Item";
        }

        public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            return items.get(rowIndex).getName();
        }

        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        }

        
    }
    

}
