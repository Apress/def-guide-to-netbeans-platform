package com.galileo.netbeans.module;

import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import org.openide.modules.ModuleInstall;

public class Installer extends ModuleInstall {

   private static final Logger logger = Logger.getLogger(Installer.class.getName());

   @Override
   public void restored() {
      
      Logger globalLogger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

      logger.log(Level.FINE, "This is a fine message"); // or easier
      logger.fine("This is a fine message");

// Show dialog with the exception
//      logger.log(Level.SEVERE, null, new Exception("SEVERE"));
//      logger.log(Level.WARNING, null, new Exception("WARNING"));

      LogManager manager = LogManager.getLogManager();
      for(String s : Collections.list(manager.getLoggerNames())) {
         System.out.println(s);
      }
   }
}
