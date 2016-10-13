package com.galileo.netbeans.module;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.LifecycleManager;
import org.openide.modules.ModuleInstall;

public class Installer extends ModuleInstall implements ActionListener {
   private LoginPanel panel = new LoginPanel();
   private DialogDescriptor d = null;

   @Override
   public void restored() {
      d = new DialogDescriptor(panel, "Login", true, this);
      d.setClosingOptions(new Object[]{});
      d.addPropertyChangeListener(new PropertyChangeListener() {
         public void propertyChange(PropertyChangeEvent event) {
            if(event.getPropertyName().equals(DialogDescriptor.PROP_VALUE)
               && event.getNewValue() == DialogDescriptor.CLOSED_OPTION) {
               LifecycleManager.getDefault().exit();
            }
         }
      });

      DialogDisplayer.getDefault().notifyLater(d);

//      WindowManager.getDefault().invokeWhenUIReady(new Runnable(){
//         public void run() {
//            DialogDisplayer.getDefault().notify(d);
//         }
//      });
   }

   public void actionPerformed(ActionEvent event) {
      if(event.getSource() == DialogDescriptor.CANCEL_OPTION) {
         LifecycleManager.getDefault().exit();
      } else {
         if(!SecurityManager.login(panel.getUsername(), panel.getPassword())) {
            panel.setInfo("Benutzername oder Passwort falsch");
         } else {
            d.setClosingOptions(null);
         }
      }
   }
}
