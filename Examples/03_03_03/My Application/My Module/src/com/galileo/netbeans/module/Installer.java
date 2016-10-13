package com.galileo.netbeans.module;

import org.openide.cookies.InstanceCookie;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileSystem;
import org.openide.filesystems.Repository;
import org.openide.loaders.DataObject;
import org.openide.modules.ModuleInstall;

public class Installer extends ModuleInstall {

   public static Object getInstance(String name) {
      try {
         FileSystem f = Repository.getDefault().getDefaultFileSystem();
         FileObject o = f.findResource(name);
         DataObject d = DataObject.find(o);
         InstanceCookie c = d.getLookup().lookup(InstanceCookie.class);
         return c.instanceCreate();
      } catch (Exception ex) {
         ex.printStackTrace();
      }
      return null;
   }

   @Override
   public void close() {
      MyClass c = (MyClass)getInstance("MyClass.instance");
      c.test();
   }
}
