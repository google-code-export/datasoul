/*
 * SongFormatFrame.java
 *
 * Created on 29 de Janeiro de 2006, 21:35
 */

package datasoul.song;

import datasoul.templates.TextTemplateItem;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 *
 * @author  Administrador
 */
public class SongFormatFrame extends javax.swing.JFrame {
    
    private SongViewer svp;
    private SongTemplate songTemplate;
    
    private String view;
    
    /** Creates new form SongFormatFrame */
    public SongFormatFrame(SongViewer svp, SongTemplate songTemplate) {
        initComponents();
        
        this.songTemplate = songTemplate;
        
        this.svp = svp;
        this.tableProperties.setModel(this.songTemplate);
        ///this.tableProperties.setModel(new TextTemplateItem("Testando",10,10));
        
        tableProperties.setDefaultEditor(Object.class, songTemplate.getTableCellEditor() );
        tableProperties.setModel(this.songTemplate);
        this.center();
    }
    
    public void center(){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle frame = getBounds();
        setLocation((screen.width - frame.width)/2, (screen.height - frame.height)/2);
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProperties = new javax.swing.JTable();
        btnApply = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("datasoul/internationalize"); // NOI18N
        setTitle(bundle.getString("Song_Format")); // NOI18N
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableProperties.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableProperties);

        btnApply.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/apply.png")));
        btnApply.setText(bundle.getString("Apply")); // NOI18N
        btnApply.setToolTipText(bundle.getString("Apply_the_changes_to_song_view")); // NOI18N
        btnApply.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnApplyMouseClicked(evt);
            }
        });

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/button_cancel.png")));
        btnClose.setText(bundle.getString("Cancel")); // NOI18N
        btnClose.setToolTipText(bundle.getString("Close_window")); // NOI18N
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .add(btnApply)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnClose)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnApply)
                    .add(btnClose))
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnApplyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnApplyMouseClicked
        svp.refresh();
        try {
            String filepath = System.getProperty("datasoul.stgloc") + System.getProperty("file.separator") 
            + "config"+ System.getProperty("file.separator") + "datasoul.song"+view+"template";

            this.songTemplate.save(filepath);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        dispose();
    }//GEN-LAST:event_btnApplyMouseClicked

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCloseMouseClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApply;
    private javax.swing.JButton btnClose;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableProperties;
    // End of variables declaration//GEN-END:variables
    
}
