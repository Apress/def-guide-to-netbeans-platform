package com.galileo.netbeans.module;

import java.awt.Image;
import java.io.Serializable;
import org.netbeans.core.spi.multiview.MultiViewDescription;
import org.netbeans.core.spi.multiview.MultiViewElement;
import org.openide.util.HelpCtx;
import org.openide.windows.TopComponent;

public class MultiViewPanel1Description implements MultiViewDescription, Serializable{

   public int getPersistenceType() {
      return TopComponent.PERSISTENCE_NEVER;
   }
   
   public String getDisplayName() {
      return "View 1";
   }
   
   public Image getIcon() {
      return null;
   }
   
   public HelpCtx getHelpCtx() {
      return HelpCtx.DEFAULT_HELP;
   }
   
   public String preferredID() {
      return "PANEL_1";
   }
   
   public MultiViewElement createElement() {
      return new MultiViewPanel1();
   }
}
