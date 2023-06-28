package br.jus.trt12.paulopinheiro.jxmlviewer.model.jtable;

import java.beans.PropertyChangeSupport;
import javax.swing.table.AbstractTableModel;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

public class XMLElementTableModel extends AbstractTableModel {
    private final Element element;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public XMLElementTableModel(Element element) {
        this.element = element;
    }

    @Override
    public int getRowCount() {
        if ((element==null)||(!element.hasAttributes())) return 0;
        return element.getAttributes().getLength();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0: return "Attribute";
            case 1: return "Value";
            default: return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        NamedNodeMap attrMap = this.element.getAttributes();
        Attr attr = (Attr) attrMap.item(rowIndex);
        switch(columnIndex) {
            case 0: return attr.getName();
            case 1: return attr.getValue();
            default: return "";
        }
    }
}
