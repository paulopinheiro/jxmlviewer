package br.jus.trt12.paulopinheiro.jxmlviewer.model.jtree;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XMLTreeNode {
    private Element element;

    public XMLTreeNode(Element element) {
        this.element = element;
    }

    public Element getElement() {
        return element;
    }

    @Override
    public String toString() {
        return getElementName(element);
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
