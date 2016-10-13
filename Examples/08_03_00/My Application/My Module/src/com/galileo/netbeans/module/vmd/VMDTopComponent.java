package com.galileo.netbeans.module.vmd;

import java.io.Serializable;
import java.util.logging.Logger;
import org.netbeans.api.visual.vmd.VMDGraphScene;
import org.netbeans.api.visual.vmd.VMDNodeWidget;
import org.netbeans.api.visual.vmd.VMDPinWidget;
import org.openide.util.NbBundle;
import org.openide.util.lookup.Lookups;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

final class VMDTopComponent extends TopComponent {

   private static VMDTopComponent instance;

   private static final String PREFERRED_ID = "VMDTopComponent";
   
   private VMDGraphScene scene = new VMDGraphScene();

   private VMDTopComponent() {
      initComponents();
      setName(NbBundle.getMessage(VMDTopComponent.class, "CTL_VMDTopComponent"));
      setToolTipText(NbBundle.getMessage(VMDTopComponent.class, "HINT_VMDTopComponent"));

      scenePane.setViewportView(scene.createView());

      VMDNodeWidget node1 = (VMDNodeWidget)scene.addNode("Node 1");
      node1.setNodeName("Node 1");

      VMDNodeWidget node2 = (VMDNodeWidget)scene.addNode("Node 2");
      node2.setNodeName("Node 2");

      VMDNodeWidget node3 = (VMDNodeWidget)scene.addNode("Node 3");
      node3.setNodeName("Node 3");

      VMDPinWidget pin1 = (VMDPinWidget)scene.addPin("Node 1", "Pin 1");
      pin1.setPinName("Pin 1");

      VMDPinWidget pin2 = (VMDPinWidget)scene.addPin("Node 2", "Pin 2");
      pin2.setPinName("Pin 2");

      VMDPinWidget pin3 = (VMDPinWidget)scene.addPin("Node 2", "Pin 3");
      pin3.setPinName("Pin 3");

      VMDPinWidget pin4 = (VMDPinWidget)scene.addPin("Node 3", "Pin 4");
      pin4.setPinName("Pin 4");

      scene.addEdge("Edge 1");
      scene.setEdgeSource("Edge 1", "Pin 1");
      scene.setEdgeTarget("Edge 1", "Pin 2");

      scene.addEdge("Edge 2");
      scene.setEdgeSource("Edge 2", "Pin 3");
      scene.setEdgeTarget("Edge 2", "Pin 4");
      
      associateLookup(Lookups.singleton(scene.createSatelliteView()));
   }

   /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
   // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
   private void initComponents() {

      scenePane = new javax.swing.JScrollPane();
      doLayout = new javax.swing.JButton();

      org.openide.awt.Mnemonics.setLocalizedText(doLayout, "Layout");
      doLayout.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            doLayoutActionPerformed(evt);
         }
      });

      org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
               .add(org.jdesktop.layout.GroupLayout.LEADING, scenePane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
               .add(doLayout))
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .add(scenePane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
            .add(doLayout)
            .addContainerGap())
      );
   }// </editor-fold>//GEN-END:initComponents

private void doLayoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doLayoutActionPerformed
   scene.layoutScene();
   scene.validate();
}//GEN-LAST:event_doLayoutActionPerformed
    
    
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton doLayout;
   private javax.swing.JScrollPane scenePane;
   // End of variables declaration//GEN-END:variables
    
    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link findInstance}.
     */
    public static synchronized VMDTopComponent getDefault() {
       if (instance == null) {
          instance = new VMDTopComponent();
       }
       return instance;
    }
    
    /**
     * Obtain the VMDTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized VMDTopComponent findInstance() {
       TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
       if (win == null) {
          Logger.getLogger(VMDTopComponent.class.getName()).warning(
                  "Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");
          return getDefault();
       }
       if (win instanceof VMDTopComponent) {
          return (VMDTopComponent)win;
       }
       Logger.getLogger(VMDTopComponent.class.getName()).warning(
               "There seem to be multiple components with the '" + PREFERRED_ID +
               "' ID. That is a potential source of errors and unexpected behavior.");
       return getDefault();
    }
    
   @Override
    public int getPersistenceType() {
       return TopComponent.PERSISTENCE_ALWAYS;
    }
    
    /** replaces this in object stream */
   @Override
    public Object writeReplace() {
       return new ResolvableHelper();
    }
    
   @Override
    protected String preferredID() {
       return PREFERRED_ID;
    }
    
    final static class ResolvableHelper implements Serializable {
       private static final long serialVersionUID = 1L;
       public Object readResolve() {
          return VMDTopComponent.getDefault();
       }
    }
}
