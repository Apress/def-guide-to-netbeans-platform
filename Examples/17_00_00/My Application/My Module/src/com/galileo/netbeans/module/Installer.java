package com.galileo.netbeans.module;

import java.awt.AWTException;
import java.awt.Font;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import org.openide.modules.ModuleInstall;
import org.openide.util.ImageUtilities;
import org.openide.util.lookup.Lookups;

public class Installer extends ModuleInstall {
   
   @Override
   public void restored() {
      if (SystemTray.isSupported()) {
         SystemTray tray = SystemTray.getSystemTray();
         
         PopupMenu popup = new PopupMenu();
         popup.setFont(new Font("Arial", Font.PLAIN, 11));

         for(Action a : Lookups.forPath("TrayMenu").lookupAll(Action.class)) {
            MenuItem item = new MenuItem((String)a.getValue(Action.NAME));
            item.addActionListener(a);
            popup.add(item);
         }
         
         Image image = ImageUtilities.loadImage("com/galileo/netbeans/module/icon.gif");
         TrayIcon trayIcon = new TrayIcon(image, "My Tray Menu", popup);
         
         trayIcon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               System.out.println("double click");
            }
         });
         
         try {
            tray.add(trayIcon);
         } catch (AWTException e) {
            System.err.println(e);
         }
      }
   }
}
