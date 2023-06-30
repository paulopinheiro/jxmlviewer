package br.jus.trt12.paulopinheiro.jxmlviewer.model.observables;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import org.w3c.dom.Document;

public class ObservableDocument {
    private Document document;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addObserver(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener("document", listener);
    }

    public void setDocument(Document newDocument) {
        Document oldDocument = this.document;
        this.document = newDocument;
        pcs.firePropertyChange("document", oldDocument, newDocument);
    }
}
