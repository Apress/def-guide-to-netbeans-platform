package com.galileo.netbeans.module;

import java.io.Serializable;
import java.util.logging.Logger;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

final class MyTopComponent extends TopComponent {
   
   private static MyTopComponent instance;
   
   private static final String PREFERRED_ID = "MyTopComponent"; //NOI18N
   
   private MyTopComponent() {
      initComponents();
      setName(NbBundle.getMessage(MyTopComponent.class, "CTL_MyTopComponent"));
      setToolTipText(NbBundle.getMessage(MyTopComponent.class, "HINT_MyTopComponent"));
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
      jLabel3 = new javax.swing.JLabel();

      org.openide.awt.Mnemonics.setLocalizedText(jLabel1, "Label 1");

      org.openide.awt.Mnemonics.setLocalizedText(jLabel2, "Label 2");

      org.openide.awt.Mnemonics.setLocalizedText(jLabel3, "Label 3");

      org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(layout.createSequentialGroup()
            .addContainerGap()
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
               .add(jLabel1)
               .add(jLabel2)
               .add(jLabel3))
            .addContainerGap(356, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(layout.createSequentialGroup()
            .addContainerGap()
            .add(jLabel1)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(jLabel2)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(jLabel3)
            .addContainerGap(235, Short.MAX_VALUE))
      );
   }// </editor-fold>//GEN-END:initComponents
    
    
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   // End of variables declaration//GEN-END:variables
    
    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link findInstance}.
     */
    public static synchronized MyTopComponent getDefault() {
       if (instance == null) {
          instance = new MyTopComponent();
       }
       return instance;
    }
    
    /**
     * Obtain the MyTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized MyTopComponent findInstance() {
       TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
       if (win == null) {
          Logger.getLogger(MyTopComponent.class.getName()).warning(
                  "Cannot find MyWindow component. It will not be located properly in the window system."); //NOI18N
          return getDefault();
       }
       if (win instanceof MyTopComponent) {
          return (MyTopComponent)win;
       }
       Logger.getLogger(MyTopComponent.class.getName()).warning(
               "There seem to be multiple components with the '" + PREFERRED_ID +
               "' ID. That is a potential source of errors and unexpected behavior."); //NOI18N
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
          return MyTopComponent.getDefault();
       }
    }
}
