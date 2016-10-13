package com.galileo.netbeans.module;

import org.openide.LifecycleManager;
import org.openide.util.Lookup;

public class MyLifecycleManager extends LifecycleManager{
   
   public void saveAll() {
      for(LifecycleManager manager : Lookup.getDefault().lookupAll(LifecycleManager.class)) {
         if(manager != this) {
            manager.saveAll();
         }
      }
   }
   
   public void exit() {
      for(LifecycleManager manager : Lookup.getDefault().lookupAll(LifecycleManager.class)) {
         if(manager != this) {
            manager.exit();
         }
      }
   }
}
