package br.jus.trt12.paulopinheiro.jxmlviewer.model.observables;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ObservableObject {
    private Object object;
    private final String objectName;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public ObservableObject(String objectName) {
        this.objectName = objectName;
    }

    public void addObserver(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(objectName, listener);
    }

    public void setObject(Object newObject) {
        Object oldObject = this.object;
        this.object = newObject;
        pcs.firePropertyChange(objectName, oldObject, newObject);
    }
}
