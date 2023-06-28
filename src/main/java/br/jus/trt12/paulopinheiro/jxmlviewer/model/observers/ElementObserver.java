package br.jus.trt12.paulopinheiro.jxmlviewer.model.observers;

import br.jus.trt12.paulopinheiro.jxmlviewer.model.jtable.XMLElementTableModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JLabel;
import javax.swing.JTable;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class ElementObserver implements PropertyChangeListener {
    private JLabel jlabel;
    private JTable jtable;

    public ElementObserver(JLabel jlabel, JTable jtable) {
        this.jlabel = jlabel;
        this.jtable = jtable;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Element element  = (Element) evt.getNewValue();
        updateComponents(element);
    }

    private void updateComponents(Element element) {
        this.jlabel.setText(getElementName(element));
        this.jtable.setModel(new XMLElementTableModel(element));
    }

    private static String getElementName(Element element) {
       String name;
        if (element==null) name = "No element selected";
        else {
            Attr nameAttr = element.getAttributeNode("name");
            if (nameAttr!=null) {
                name = nameAttr.getValue() + " (" + element.getNodeName() + ")";
            } else {
                name = element.getNodeName();
            }
            if (element.hasChildNodes()) {
                Node lastChild = element.getLastChild();
                if (lastChild.getNodeType()==Node.TEXT_NODE && !lastChild.getNodeValue().trim().isEmpty()) {
                    name = name + ": " + element.getLastChild().getNodeValue();
                }
            }
        }
        return name;
    }
}
