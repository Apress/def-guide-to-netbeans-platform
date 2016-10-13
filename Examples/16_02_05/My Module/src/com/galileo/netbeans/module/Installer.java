package com.galileo.netbeans.module;

import java.net.URL;
import java.util.Collection;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.URLMapper;
import org.openide.modules.ModuleInfo;
import org.openide.modules.ModuleInstall;
import org.openide.util.Lookup;

/**
 * Manages a module's lifecycle. Remember that an installer is optional and
 * often not needed at all.
 */
public class Installer extends ModuleInstall {

   public static final String MODULE_ID = "com.galileo.netbeans.module";

   private ModuleInfo module = null;

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

   public ModuleInfo getModule() {
      if(module == null) {
         Collection<? extends ModuleInfo> all = 
            Lookup.getDefault().lookupAll(ModuleInfo.class);
         for(ModuleInfo m : all) {
            if(m.getCodeNameBase().equals(MODULE_ID)) {
               module = m; break;
            }
         }
      }

      return module;
   }

   public FileObject getModuleResource(String path) {
      URL url = getClass().getClassLoader().getResource(path);
      FileObject resource = URLMapper.findFileObject(url);
      return resource;
   }

}
