package br.jus.trt12.paulopinheiro.jxmlviewer.model.observables;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Observable;
import org.w3c.dom.Element;

public class ObservableElement extends Observable {
    private Element element;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addObserver(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener("element", listener);
    }

    public void setElement(Element newElement) {
        Element oldElement = this.element;
        this.element = newElement;
        pcs.firePropertyChange("element", oldElement, newElement);
    }

}
