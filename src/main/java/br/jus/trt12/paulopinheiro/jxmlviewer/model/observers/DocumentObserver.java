package br.jus.trt12.paulopinheiro.jxmlviewer.model.observers;

import br.jus.trt12.paulopinheiro.jxmlviewer.model.jtree.XmlTreeModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.w3c.dom.Document;

public class DocumentObserver implements PropertyChangeListener {
    private JTree jTree;

    public DocumentObserver(JTree jTree) {
        this.jTree = jTree;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Document document = (Document) evt.getNewValue();
        if (document==null) this.jTree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("no XML file selected")));
        else this.jTree.setModel(new XmlTreeModel(document));
    }
    
}
