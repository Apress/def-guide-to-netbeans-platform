package com.galileo.netbeans.module;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import org.openide.filesystems.FileObject;

public final class GetResourceAction implements ActionListener {

   public void actionPerformed(ActionEvent evt) {
      FileObject res = Installer.getDefault().getModuleResource(
                                "resources/myprops.properties");
      Properties props = new Properties();
      try {
         props.load(res.getInputStream());
      } catch(Exception e) {}
      
      System.out.println(props.getProperty("key"));
   }
}