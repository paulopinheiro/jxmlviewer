package br.jus.trt12.paulopinheiro.jxmlviewer.model.jtree;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlTreeModel implements TreeModel {
    protected Document document;
    List<TreeModelListener> listeners = new ArrayList<>();

    public XmlTreeModel (Document document) {
        this.setDocument(document);
    }

    @Override
    public Object getRoot() {
        if (document==null) return null;

        List<Element> elements = getChildElements(document);
        if (!elements.isEmpty()) {
            return new XMLTreeNode(elements.get(0));
        }
        return null;
    }

    @Override
    public Object getChild(Object parent, int index) {
        if (parent instanceof XMLTreeNode) {
            List<Element> elements = getChildElements(((XMLTreeNode)parent).getElement());
            return new XMLTreeNode(elements.get(index));
        } else {
            return null;
        }
    }

    @Override
    public int getChildCount(Object parent) {
        if (parent instanceof XMLTreeNode) {
            List<Element> elements = getChildElements(((XMLTreeNode)parent).getElement());
            return elements.size();
        }
        return 0;
    }

    @Override
    public boolean isLeaf(Object node) {
        if (node instanceof XMLTreeNode) {
            Element element = ((XMLTreeNode)node).getElement();
            List<Element> elements = getChildElements(element);
            return elements.isEmpty();
        } else {
            return true;
        }
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        if (parent instanceof XMLTreeNode && child instanceof XMLTreeNode) {
            Element pElement = ((XMLTreeNode)parent).getElement();
            Element cElement = ((XMLTreeNode)child).getElement();
            if (cElement.getParentNode()!=pElement) {
                return -1;
            }

            List<Element> elements = getChildElements(pElement);
            return elements.indexOf(cElement);
        }
        return -1;
    }

    @Override
    public void addTreeModelListener(TreeModelListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    @Override
    public void removeTreeModelListener(TreeModelListener listener) {
        listeners.remove(listener);
    }

    public Document getDocument() {
        return document;
    }

    private void setDocument(Document document) {
        this.document = document;
        TreeModelEvent evt = new TreeModelEvent(this,new TreePath(getRoot()));
        for (TreeModelListener listener: listeners) {
            listener.treeStructureChanged(evt);
        }
    }

    private List<Element> getChildElements(Node node) {
        List<Element> elements = new ArrayList<>();

        NodeList list = node.getChildNodes();
        for (int i=0; i<list.getLength();i++) {
            if (list.item(i).getNodeType()==Node.ELEMENT_NODE) {
                elements.add((Element)list.item(i));
            }
        }
        return elements;
    }
}
