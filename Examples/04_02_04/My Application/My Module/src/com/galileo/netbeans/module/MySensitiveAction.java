package com.galileo.netbeans.module;

import javax.swing.Action;
import javax.swing.ImageIcon;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;
import org.openide.util.Utilities;

public final class MySensitiveAction extends ContextAction<MyInterface> {

   public MySensitiveAction() {
      this(Utilities.actionsGlobalContext());
   }

   public MySensitiveAction(Lookup context) {
      super(context);
      putValue(NAME, NbBundle.getMessage(MySensitiveAction.class, "CTL_MySensitiveAction"));
      putValue(SMALL_ICON, new ImageIcon(ImageUtilities.loadImage("com/galileo/netbeans/module/icon.gif", true)));
   }

   public Class<MyInterface> contextClass() {
      return MyInterface.class;
   }

   public void performAction(MyInterface context) {
      context.doSomething();
   }

   public Action createContextAwareInstance(Lookup context) {
      return new MySensitiveAction(context);
   }
}