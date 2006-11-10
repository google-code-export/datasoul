/*
 * PreviewPanel.java
 *
 * Created on 26 de Dezembro de 2005, 23:21
 */

package datasoul.datashow;

import datasoul.ObjectManager;
import datasoul.render.ContentManager;
import datasoul.song.Song;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author  Administrador
 */
public class PreviewPanel extends javax.swing.JPanel implements ListSelectionListener {

    /**
     * Creates new form PreviewPanel
     */
    public PreviewPanel() {
        initComponents();
        serviceItemTable1.addTableListener(this);
    }

    public void previewItem(ServiceItem serviceItem){
        ContentManager cm = ContentManager.getInstance();
        cm.setTemplatePreview(serviceItem.getTemplate());
        cm.setTitlePreview(serviceItem.getTitle());
        serviceItemTable1.setServiceItem(serviceItem);
        cm.setSlidePreview( serviceItemTable1.getSlideText() );
        cm.setNextSlidePreview( serviceItemTable1.getNextSlideText() );
        if(serviceItem instanceof Song)
            cm.setSongAuthorPreview( ((Song)serviceItem).getSongAuthor() );
        cm.updatePreview();
         
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        serviceItemTable1 = new datasoul.datashow.ServiceItemTable();
        jToolBar1 = new javax.swing.JToolBar();
        labelLive = new javax.swing.JLabel();
        btnGoLive = new javax.swing.JButton();

        setDoubleBuffered(false);

        jToolBar1.setFloatable(false);
        labelLive.setText("Preview");
        jToolBar1.add(labelLive);

        btnGoLive.setText(java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("GO_LIVE"));
        btnGoLive.setToolTipText("Send slides to live");
        btnGoLive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoLiveActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(jToolBar1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnGoLive))
            .add(serviceItemTable1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jToolBar1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .add(btnGoLive, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(serviceItemTable1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoLiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoLiveActionPerformed

        try{
            ObjectManager.getInstance().setBusyCursor();
            ServiceItem previewItem = ObjectManager.getInstance().getPreviewPanel().serviceItemTable1.getServiceItem();
            ObjectManager.getInstance().getLivePanel().showItem(previewItem);
        }finally{
            ObjectManager.getInstance().setDefaultCursor();
        }
        
    }//GEN-LAST:event_btnGoLiveActionPerformed

    public void valueChanged(ListSelectionEvent e) {
        ContentManager cm = ContentManager.getInstance();
        cm.setSlidePreview( serviceItemTable1.getSlideText() );
        cm.setNextSlidePreview( serviceItemTable1.getNextSlideText() );
        cm.updatePreview();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoLive;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel labelLive;
    private datasoul.datashow.ServiceItemTable serviceItemTable1;
    // End of variables declaration//GEN-END:variables
    
}
