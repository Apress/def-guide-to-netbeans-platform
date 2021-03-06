package com.galileo.netbeans.module;

import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import org.netbeans.core.spi.multiview.CloseOperationState;
import org.netbeans.core.spi.multiview.MultiViewElement;
import org.netbeans.core.spi.multiview.MultiViewElementCallback;
import org.openide.awt.UndoRedo;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;

public class MultiViewPanel1 extends JPanel implements MultiViewElement {
   
   private JToolBar toolbar = new JToolBar();
   private MultiViewElementCallback callback = null;
   
   public MultiViewPanel1() {
      initComponents();
      toolbar.add(new Panel1ToolbarAction1());
      toolbar.add(new Panel1ToolbarAction2());
   }
   
   /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
   // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
   private void initComponents() {

      jLabel1 = new javax.swing.JLabel();
      jLabel2 = new javax.swing.JLabel();

      jLabel1.setText(org.openide.util.NbBundle.getMessage(MultiViewPanel1.class, "MultiViewPanel1.jLabel1.text")); // NOI18N

      jLabel2.setText(org.openide.util.NbBundle.getMessage(MultiViewPanel1.class, "MultiViewPanel1.jLabel2.text")); // NOI18N

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(70, 70, 70)
                  .addComponent(jLabel1))
               .addGroup(layout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(jLabel2)))
            .addContainerGap(92, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
            .addComponent(jLabel1)
            .addGap(132, 132, 132))
      );
   }// </editor-fold>//GEN-END:initComponents
   
   public JComponent getVisualRepresentation() {
      return this;
   }
   
   public JComponent getToolbarRepresentation() {
      return toolbar;
   }
   
   public Action[] getActions() {
      if(callback != null) {
         return callback.createDefaultActions();
      } else {
         return new Action[]{};
      }
   }

   public Lookup getLookup() {
      return Lookups.singleton(this);
   }
   
   public void componentOpened() {
      componentActivated();
   }
   
   public void componentClosed() {
   }
   
   public void componentShowing() {
   }
   
   public void componentHidden() {
   }
   
   public void componentActivated() {
      callback.updateTitle("View 1");
   }
   
   public void componentDeactivated() {
   }
   
   public UndoRedo getUndoRedo() {
      return UndoRedo.NONE;
   }
   
   public void setMultiViewCallback(MultiViewElementCallback callback) {
      this.callback = callback;
   }
   
   public CloseOperationState canCloseElement() {
      return CloseOperationState.STATE_OK;
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   // End of variables declaration//GEN-END:variables
}
