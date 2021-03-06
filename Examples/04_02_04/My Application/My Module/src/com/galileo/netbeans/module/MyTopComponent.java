package com.galileo.netbeans.module;

import java.io.Serializable;
import java.util.logging.Logger;
import org.openide.util.NbBundle;
import org.openide.util.lookup.Lookups;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

final class MyTopComponent extends TopComponent implements MyInterface {

   private static MyTopComponent instance;
   private static final String PREFERRED_ID = "MyTopComponent";

   private MyTopComponent() {
      initComponents();
      setName(NbBundle.getMessage(MyTopComponent.class, "CTL_MyTopComponent"));
      setToolTipText(NbBundle.getMessage(MyTopComponent.class, "HINT_MyTopComponent"));
      associateLookup(Lookups.fixed(getActionMap(), this));
   }

   public void doSomething() {
      System.out.println("do something");
   }

   /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
                    "Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");
            return getDefault();
        }
        if (win instanceof MyTopComponent) {
            return (MyTopComponent)win;
        }
        Logger.getLogger(MyTopComponent.class.getName()).warning(
                "There seem to be multiple components with the '" + PREFERRED_ID +
                "' ID. That is a potential source of errors and unexpected behavior.");
        return getDefault();
    }

    public @Override int getPersistenceType() {
        return TopComponent.PERSISTENCE_ALWAYS;
    }

    /** replaces this in object stream */
    public @Override Object writeReplace() {
        return new ResolvableHelper();
    }

    protected @Override String preferredID() {
        return PREFERRED_ID;
    }

    final static class ResolvableHelper implements Serializable {
        private static final long serialVersionUID = 1L;
        public Object readResolve() {
            return MyTopComponent.getDefault();
        }
    }
}
