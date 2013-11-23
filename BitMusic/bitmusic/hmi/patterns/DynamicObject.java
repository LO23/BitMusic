/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmusic.hmi.patterns;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author unkedeuxke
 */
public abstract class DynamicObject<E> extends AbstractTableModel {
    private List<String> columnNames;
    private ArrayList<E> listObjects = new ArrayList<>();

    public DynamicObject(final List<String> columnNames) {
        super();
        this.columnNames = columnNames;
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public int getRowCount() {
        return listObjects.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames.get(col);
    }

    public void addObject(E object) {
        listObjects.add(object);
        fireTableRowsInserted(listObjects.size()-1, listObjects.size()-1);
    }

    public void removeObject(int rowIndex) {
        listObjects.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public void removeAllObjects() {
        for (int i=0; i<this.listObjects.size(); i++) {
            this.removeObject(i);
        }
    }

    public ArrayList<E> getListObjects() {
        return this.listObjects;
    }

    public void setListObjects(ArrayList<E> objects) {
        this.removeAllObjects();
        this.listObjects = objects;
    }
}
