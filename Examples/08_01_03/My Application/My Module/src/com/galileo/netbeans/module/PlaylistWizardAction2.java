package com.galileo.netbeans.module;

import java.awt.Dialog;
import java.util.Map;
import org.openide.DialogDisplayer;
import org.openide.WizardDescriptor;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;
import org.openide.util.actions.CallableSystemAction;

public final class PlaylistWizardAction2 extends CallableSystemAction {

   public void performAction() {
      PlaylistWizardDescriptor descriptor = new PlaylistWizardDescriptor();
      Dialog dialog = DialogDisplayer.getDefault().createDialog(descriptor);
      dialog.setVisible(true);
      dialog.toFront();

      if (descriptor.getValue() == WizardDescriptor.FINISH_OPTION) {
         Map<String, Object> props = descriptor.getProperties();
         //Create the playlist with the data stored in props
      }
   }
   
   public String getName() {
      return NbBundle.getMessage(PlaylistWizardAction2.class, "CTL_PlaylistWizardAction");
   }
   
   @Override
   protected String iconResource() {
      return "com/galileo/netbeans/module/wizard.png";
   }
   
   public HelpCtx getHelpCtx() {
      return HelpCtx.DEFAULT_HELP;
   }
   
   @Override
   protected boolean asynchronous() {
      return false;
   }
}
