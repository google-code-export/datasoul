/* 
 * Copyright 2005-2008 Samuel Mello & Eduardo Schnell
 *
 *   This program is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation; version 2 of the License.
 * 
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 * 
 */

/*
 * DisplayControlPanel.java
 *
 * Created on 24 May 2006, 23:14
 */

package datasoul.datashow;

import datasoul.config.ConfigObj;
import datasoul.config.DisplayControlConfig;
import datasoul.render.ContentManager;
import datasoul.templates.DisplayTemplate;
import datasoul.templates.TemplateComboBox;
import java.util.Hashtable;
import javax.swing.JLabel;
  
/**
 *
 * @author  samuelm
 */
public class DisplayControlPanel extends javax.swing.JPanel {
    
    private boolean isMainOnBlack = false;
    
    /**
     * Creates new form DisplayControlPanel
     */
    public DisplayControlPanel() {
        initComponents();
        
        String x = DisplayControlConfig.getInstance().getTemplateMonitor();
        templateMonitor.setSelectedItem(x);
        if (x != null){
            ContentManager.getInstance().setTemplateMonitorLive( x );
            ContentManager.getInstance().slideChange(-1);
        }

        
        jSliderShowHideSpeed.setValue( DisplayControlConfig.getInstance().getSlideShowHideTime() / 100 );
        jSliderSlideChangeSpeed.setValue( DisplayControlConfig.getInstance().getSlideTransitionTime() / 100 );
        cbMonitorFollowMain.setSelected( DisplayControlConfig.getInstance().getMonitorFollowMainControls() );
        updateMonitorControls();
 
        templateMonitor.setTargetContent(DisplayTemplate.TARGET_CONTENT_STAGE);
        
        pnlSpeed.setVisible( jSpeedCb.isSelected() );
        pnlMonitor.setVisible( jMonitorCb.isSelected() );
        
        if (!ConfigObj.getActiveInstance().getMonitorOutput()){
            pnlMonitor.setVisible(false);
            jMonitorCb.setVisible(false);
        }
        
    }

    
    public void mainDisplayBlack(){
        
        if( !isMainOnBlack ){
            ContentManager.getInstance().setMainBlack( true );
            isMainOnBlack = true;
            btnMainBlack.setSelected(true);
        }else{
            ContentManager.getInstance().setMainBlack( false );
            isMainOnBlack = false;
            btnMainBlack.setSelected(false);
        }

        if (DisplayControlConfig.getInstance().getMonitorFollowMainControls()){
            btnMonitorBlack.setSelected( btnMainBlack.isSelected() );
            btnMonitorBlackActionPerformed(null);
        }
    }
    
    public void mainDisplayShow(){

        int time = DisplayControlConfig.getInstance().getSlideShowHideTime();

        ContentManager.getInstance().slideShowMain( time );
        
        btnShow.setSelected(true);
        btnHide.setSelected(false);
        
        if (DisplayControlConfig.getInstance().getMonitorFollowMainControls()){
            monitorDisplayShow();
        }
    }
    
    public void mainDisplayHide(){
        
        int time = DisplayControlConfig.getInstance().getSlideShowHideTime();
        
        ContentManager.getInstance().slideHideMain( time );

        btnShow.setSelected(false);
        btnHide.setSelected(true);
        
        if (DisplayControlConfig.getInstance().getMonitorFollowMainControls()){
            monitorDisplayHide();
        }
    }
    
    public void monitorDisplayShow(){
        
        int time = DisplayControlConfig.getInstance().getSlideShowHideTime();
        
        btnMonitorShow.setSelected(true);
        btnMonitorHide.setSelected(false);
        
        ContentManager.getInstance().slideShowMonitor( time );
    }
    
    public void monitorDisplayHide(){

        int time = DisplayControlConfig.getInstance().getSlideShowHideTime();

        btnMonitorShow.setSelected(false);
        btnMonitorHide.setSelected(true);

        ContentManager.getInstance().slideHideMonitor( time );
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        pnlSpeed = new javax.swing.JPanel();
        jSliderSlideChangeSpeed = new javax.swing.JSlider();
        jLabel16 = new javax.swing.JLabel();
        jSliderShowHideSpeed = new javax.swing.JSlider();
        jLabel15 = new javax.swing.JLabel();
        pnlMonitor = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        templateMonitor = new datasoul.templates.TemplateComboBox();
        jPanel1 = new javax.swing.JPanel();
        btnMonitorBlack = new javax.swing.JToggleButton();
        btnMonitorHide = new javax.swing.JToggleButton();
        btnMonitorShow = new javax.swing.JToggleButton();
        cbMonitorFollowMain = new javax.swing.JCheckBox();
        jMonitorCb = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        btnMainBlack = new javax.swing.JToggleButton();
        btnHide = new javax.swing.JToggleButton();
        btnShow = new javax.swing.JToggleButton();
        jSpeedCb = new javax.swing.JCheckBox();

        setAutoscrolls(true);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("datasoul/internationalize"); // NOI18N
        jLabel10.setText(bundle.getString("MAIN OUTPUT")); // NOI18N

        jSliderSlideChangeSpeed.setMajorTickSpacing(5);
        jSliderSlideChangeSpeed.setMaximum(30);
        jSliderSlideChangeSpeed.setMinorTickSpacing(1);
        jSliderSlideChangeSpeed.setPaintTicks(true);
        jSliderSlideChangeSpeed.setValue(2);
        jSliderSlideChangeSpeed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderSlideChangeSpeedStateChanged(evt);
            }
        });

        jLabel16.setText(bundle.getString("SLIDE CHANGE TRANSITION SPEED")); // NOI18N

        jSliderShowHideSpeed.setMajorTickSpacing(5);
        jSliderShowHideSpeed.setMaximum(30);
        jSliderShowHideSpeed.setMinorTickSpacing(1);
        jSliderShowHideSpeed.setPaintTicks(true);
        jSliderShowHideSpeed.setValue(10);
        jSliderShowHideSpeed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderShowHideSpeedStateChanged(evt);
            }
        });

        jLabel15.setText(bundle.getString("SHOW/HIDE SPEED")); // NOI18N

        javax.swing.GroupLayout pnlSpeedLayout = new javax.swing.GroupLayout(pnlSpeed);
        pnlSpeed.setLayout(pnlSpeedLayout);
        pnlSpeedLayout.setHorizontalGroup(
            pnlSpeedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSpeedLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addContainerGap(143, Short.MAX_VALUE))
            .addGroup(pnlSpeedLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addContainerGap(60, Short.MAX_VALUE))
            .addComponent(jSliderSlideChangeSpeed, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
            .addComponent(jSliderShowHideSpeed, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
        );
        pnlSpeedLayout.setVerticalGroup(
            pnlSpeedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSpeedLayout.createSequentialGroup()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSliderShowHideSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSliderSlideChangeSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setText(bundle.getString("TEMPLATE")); // NOI18N

        templateMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                templateMonitorActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 3, 0));

        btnMonitorBlack.setText(bundle.getString("BLACK")); // NOI18N
        btnMonitorBlack.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnMonitorBlack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonitorBlackActionPerformed(evt);
            }
        });
        jPanel1.add(btnMonitorBlack);

        btnMonitorHide.setSelected(true);
        btnMonitorHide.setText(bundle.getString("HIDE")); // NOI18N
        btnMonitorHide.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnMonitorHide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonitorHideActionPerformed(evt);
            }
        });
        jPanel1.add(btnMonitorHide);

        btnMonitorShow.setText(bundle.getString("SHOW")); // NOI18N
        btnMonitorShow.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnMonitorShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonitorShowActionPerformed(evt);
            }
        });
        jPanel1.add(btnMonitorShow);

        cbMonitorFollowMain.setText(bundle.getString("STAGE FOLLOWS MAIN OUTPUT CONTROLS")); // NOI18N
        cbMonitorFollowMain.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        cbMonitorFollowMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMonitorFollowMainActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMonitorLayout = new javax.swing.GroupLayout(pnlMonitor);
        pnlMonitor.setLayout(pnlMonitorLayout);
        pnlMonitorLayout.setHorizontalGroup(
            pnlMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMonitorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(templateMonitor, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
            .addGroup(pnlMonitorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbMonitorFollowMain)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMonitorLayout.setVerticalGroup(
            pnlMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMonitorLayout.createSequentialGroup()
                .addComponent(cbMonitorFollowMain)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(templateMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMonitorCb.setText(bundle.getString("SHOW STAGE CONTROLS")); // NOI18N
        jMonitorCb.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jMonitorCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMonitorCbActionPerformed(evt);
            }
        });

        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 3, 0));

        btnMainBlack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/video-display-black.png"))); // NOI18N
        btnMainBlack.setText(bundle.getString("BLACK")); // NOI18N
        btnMainBlack.setToolTipText(bundle.getString("MAKES THE MAIN OUTPUT BLACK (F12)")); // NOI18N
        btnMainBlack.setFocusPainted(false);
        btnMainBlack.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnMainBlack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainBlackActionPerformed(evt);
            }
        });
        jPanel2.add(btnMainBlack);

        btnHide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/stock_3d-light-off.png"))); // NOI18N
        btnHide.setSelected(true);
        btnHide.setText(bundle.getString("HIDE")); // NOI18N
        btnHide.setToolTipText(bundle.getString("HIDE THE MAIN OUTPUT CONTENT (F9)")); // NOI18N
        btnHide.setFocusPainted(false);
        btnHide.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnHide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHideActionPerformed(evt);
            }
        });
        jPanel2.add(btnHide);

        btnShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/stock_3d-light-on.png"))); // NOI18N
        btnShow.setText(bundle.getString("SHOW")); // NOI18N
        btnShow.setToolTipText(bundle.getString("SHOW THE MAIN OUTPUT CONTENT (F10)")); // NOI18N
        btnShow.setFocusPainted(false);
        btnShow.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });
        jPanel2.add(btnShow);

        jSpeedCb.setText(bundle.getString("SHOW SPEED CONTROLS")); // NOI18N
        jSpeedCb.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jSpeedCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSpeedCbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jMonitorCb)
                    .addComponent(jSpeedCb)
                    .addComponent(pnlSpeed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMonitor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jMonitorCb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpeedCb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jSpeedCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSpeedCbActionPerformed
        pnlSpeed.setVisible( jSpeedCb.isSelected() );
    }//GEN-LAST:event_jSpeedCbActionPerformed

    private void jMonitorCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMonitorCbActionPerformed
        pnlMonitor.setVisible( jMonitorCb.isSelected() );
    }//GEN-LAST:event_jMonitorCbActionPerformed

    private void btnMonitorShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonitorShowActionPerformed
        if (btnMonitorShow.isSelected()){
            this.monitorDisplayShow();
        }else{
            btnMonitorShow.setSelected(true);
        }
    }//GEN-LAST:event_btnMonitorShowActionPerformed

    private void btnMonitorHideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonitorHideActionPerformed
        if (btnMonitorHide.isSelected()){
            this.monitorDisplayHide();
        }else{
            btnMonitorHide.setSelected(true);
        }
    }//GEN-LAST:event_btnMonitorHideActionPerformed

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        if (btnShow.isSelected()){
            this.mainDisplayShow();
        }else{
            btnShow.setSelected(true);
        }
    }//GEN-LAST:event_btnShowActionPerformed

    public void shortcutShowMain(){
        if (!btnShow.isSelected()){
            this.mainDisplayShow();
        }
    }

    public void shortcutHideMain(){
        if (!btnHide.isSelected()){
            this.mainDisplayHide();
        }
    }

    
    private void btnHideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHideActionPerformed
        if (btnHide.isSelected()){
            this.mainDisplayHide();
        }else{
            btnHide.setSelected(true);
        }
        
    }//GEN-LAST:event_btnHideActionPerformed

    private void cbMonitorFollowMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMonitorFollowMainActionPerformed

        DisplayControlConfig.getInstance().setMonitorFollowMainControls( cbMonitorFollowMain.isSelected() );
        updateMonitorControls();
        
    }//GEN-LAST:event_cbMonitorFollowMainActionPerformed

    private void updateMonitorControls(){
        
        boolean b = ! DisplayControlConfig.getInstance().getMonitorFollowMainControls();
        btnMonitorBlack.setEnabled(b);
        //btnMonitorClear.setEnabled(b);
        btnMonitorHide.setEnabled(b);
        btnMonitorShow.setEnabled(b);
        
    }
    
    private void jSliderSlideChangeSpeedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderSlideChangeSpeedStateChanged

        DisplayControlConfig.getInstance().setSlideTransitionTime( jSliderSlideChangeSpeed.getValue() * 100 );
        
    }//GEN-LAST:event_jSliderSlideChangeSpeedStateChanged

    private void jSliderShowHideSpeedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderShowHideSpeedStateChanged
        
        DisplayControlConfig.getInstance().setSlideShowHideTime( jSliderShowHideSpeed.getValue() * 100 );
        
    }//GEN-LAST:event_jSliderShowHideSpeedStateChanged

    private void btnMonitorBlackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonitorBlackActionPerformed
        if ( ConfigObj.getActiveInstance().getMonitorOutput() ){
            if( btnMonitorBlack.isSelected() ){
                ContentManager.getInstance().setMonitorBlack( true );
            }else{
                ContentManager.getInstance().setMonitorBlack( false );
            }
        }
        
    }//GEN-LAST:event_btnMonitorBlackActionPerformed

    private void templateMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_templateMonitorActionPerformed

        if (templateMonitor.getSelectedItem() != null && !templateMonitor.isUpdating()){
            ContentManager.getInstance().setTemplateMonitorLive( templateMonitor.getSelectedItem().toString() );
            ContentManager.getInstance().slideChange(-1);
            DisplayControlConfig.getInstance().setTemplateMonitor( templateMonitor.getSelectedItem().toString() );                    
        }
        
    }//GEN-LAST:event_templateMonitorActionPerformed

    private void btnMainBlackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainBlackActionPerformed

        this.mainDisplayBlack();
    }//GEN-LAST:event_btnMainBlackActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnHide;
    private javax.swing.JToggleButton btnMainBlack;
    private javax.swing.JToggleButton btnMonitorBlack;
    private javax.swing.JToggleButton btnMonitorHide;
    private javax.swing.JToggleButton btnMonitorShow;
    private javax.swing.JToggleButton btnShow;
    private javax.swing.JCheckBox cbMonitorFollowMain;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JCheckBox jMonitorCb;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSlider jSliderShowHideSpeed;
    private javax.swing.JSlider jSliderSlideChangeSpeed;
    private javax.swing.JCheckBox jSpeedCb;
    private javax.swing.JPanel pnlMonitor;
    private javax.swing.JPanel pnlSpeed;
    private datasoul.templates.TemplateComboBox templateMonitor;
    // End of variables declaration//GEN-END:variables
    
}

