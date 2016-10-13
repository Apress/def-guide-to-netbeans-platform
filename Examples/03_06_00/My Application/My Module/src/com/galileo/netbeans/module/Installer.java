/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.galileo.netbeans.module;

import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.modules.ModuleInstall;

/**
 * Manages a module's lifecycle. Remember that an installer is optional and
 * often not needed at all.
 */
public class Installer extends ModuleInstall {

   @Override
   public boolean closing() {
      NotifyDescriptor d = new NotifyDescriptor.Confirmation(
         "Do you really want to exit the application?",
         "Exit",
         NotifyDescriptor.YES_NO_OPTION);
      if (DialogDisplayer.getDefault().notify(d) == NotifyDescriptor.YES_OPTION) {
         return true;
      } else {
         return false;
      }
   }
}
