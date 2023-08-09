package br.jus.trt12.paulopinheiro.jxmlviewer;

import br.jus.trt12.paulopinheiro.jxmlviewer.model.jtree.XMLTreeNode;
import br.jus.trt12.paulopinheiro.jxmlviewer.model.observers.DocumentObserver;
import br.jus.trt12.paulopinheiro.jxmlviewer.model.observers.ElementObserver;
import br.jus.trt12.paulopinheiro.jxmlviewer.model.observables.ObservableObject;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class JXMLViewer extends javax.swing.JFrame {
    private ObservableObject obDocument;
    private ObservableObject obElement;
    private DocumentObserver docObserver;
    private ElementObserver eleObserver;

    public JXMLViewer() {
        initComponents();
        otherInitTasks();
    }

    //Testa se path informado é de um arquivo válido
    private void processaArquivo(String absolutePath) {
        try {
            File arquivo = new File(absolutePath);
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(arquivo);
            setDocument(document);
        } catch (IOException ex ){
            JOptionPane.showMessageDialog(rootPane, ex.getLocalizedMessage(), "Há um problema com o arquivo selecionado", JOptionPane.ERROR_MESSAGE);
        } catch (SAXParseException ex ){
            JOptionPane.showMessageDialog(rootPane, ex.getLocalizedMessage(), "Há um problema com a sintaxe do arquivo XML", JOptionPane.ERROR_MESSAGE);
        } catch (SAXException ex ){
            JOptionPane.showMessageDialog(rootPane, ex.getLocalizedMessage(), "Há um problema com o conteúdo do arquivo XML", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(JXMLViewer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getLocalizedMessage(), "Ocorreu um erro de sistema", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(JXMLViewer.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }

    private void setDocument(Document document) {
        this.obDocument.setObject(document);
        setElement(null);
    }

    private void setElement(Element element) {
        this.obElement.setObject(element);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jfcXMLChooseDialog = new javax.swing.JFileChooser();
        jbtXMLFile = new javax.swing.JButton();
        jtfXMLPath = new javax.swing.JTextField();
        jbtXMLRead = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtrArvore = new javax.swing.JTree();
        jpnElement = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbElement = new javax.swing.JTable();
        jlbElement = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JXMLViewer");

        jbtXMLFile.setText("File:");
        jbtXMLFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtXMLFileActionPerformed(evt);
            }
        });

        jbtXMLRead.setText("Read");
        jbtXMLRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtXMLReadActionPerformed(evt);
            }
        });

        jtrArvore.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jtrArvoreValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jtrArvore);

        jpnElement.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtbElement.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Attribute", "Value"
            }
        ));
        jScrollPane2.setViewportView(jtbElement);

        jlbElement.setFont(jlbElement.getFont().deriveFont(jlbElement.getFont().getStyle() | java.awt.Font.BOLD, jlbElement.getFont().getSize()+2));
        jlbElement.setText("No element selected");

        javax.swing.GroupLayout jpnElementLayout = new javax.swing.GroupLayout(jpnElement);
        jpnElement.setLayout(jpnElementLayout);
        jpnElementLayout.setHorizontalGroup(
            jpnElementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnElementLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnElementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnElementLayout.createSequentialGroup()
                        .addComponent(jlbElement)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpnElementLayout.setVerticalGroup(
            jpnElementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnElementLayout.createSequentialGroup()
                .addComponent(jlbElement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtXMLFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfXMLPath, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtXMLRead))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addComponent(jpnElement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtXMLFile)
                    .addComponent(jtfXMLPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtXMLRead))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jpnElement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtXMLFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtXMLFileActionPerformed
        int i = jfcXMLChooseDialog.showOpenDialog(null);
        if (i==1) jtfXMLPath.setText("");
        else jtfXMLPath.setText(jfcXMLChooseDialog.getSelectedFile().getAbsolutePath());
    }//GEN-LAST:event_jbtXMLFileActionPerformed

    private void jbtXMLReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtXMLReadActionPerformed
        processaArquivo(jtfXMLPath.getText());
    }//GEN-LAST:event_jbtXMLReadActionPerformed

    private void jtrArvoreValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jtrArvoreValueChanged
        XMLTreeNode node = (XMLTreeNode) this.jtrArvore.getLastSelectedPathComponent();
        if (node!=null) setElement(node.getElement());
    }//GEN-LAST:event_jtrArvoreValueChanged

    private void otherInitTasks() {
        this.initObsComponents();
        setDocument(null);
        setElement(null);
    }

    private void initObsComponents() {
        this.obDocument = new ObservableObject("document");
        this.docObserver = new DocumentObserver(this.jtrArvore);
        this.obDocument.addObserver(this.docObserver);

        this.obElement = new ObservableObject("element");
        this.eleObserver = new ElementObserver(this.jlbElement, this.jtbElement);
        this.obElement.addObserver(eleObserver);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JXMLViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JXMLViewer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtXMLFile;
    private javax.swing.JButton jbtXMLRead;
    private javax.swing.JFileChooser jfcXMLChooseDialog;
    private javax.swing.JLabel jlbElement;
    private javax.swing.JPanel jpnElement;
    private javax.swing.JTable jtbElement;
    private javax.swing.JTextField jtfXMLPath;
    private javax.swing.JTree jtrArvore;
    // End of variables declaration//GEN-END:variables
}
