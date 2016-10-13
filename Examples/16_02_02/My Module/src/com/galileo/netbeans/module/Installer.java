package com.galileo.netbeans.module;

import org.openide.modules.ModuleInstall;

/**
 * Manages a module's lifecycle. Remember that an installer is optional and
 * often not needed at all.
 */
public class Installer extends ModuleInstall {

   @Override
   public void restored() {
      // module started
   }

   @Override
   public void close() {
      // module stopped
   }

   public static Installer getDefault() {
      return findObject(Installer.class, true);
   }
}
