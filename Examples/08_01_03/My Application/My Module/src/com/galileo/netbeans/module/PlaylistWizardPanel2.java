package com.galileo.netbeans.module;

import javax.swing.event.ChangeListener;
import org.openide.WizardDescriptor;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;

public class PlaylistWizardPanel2 implements WizardDescriptor.Panel<WizardDescriptor> {
   
   private PlaylistVisualPanel2 view = null;

   public PlaylistVisualPanel2 getComponent() {
      if(view == null) {
         view = new PlaylistVisualPanel2();
         view.putClientProperty(WizardDescriptor.PROP_CONTENT_SELECTED_INDEX, new Integer(1));
         view.putClientProperty(WizardDescriptor.PROP_AUTO_WIZARD_STYLE, Boolean.TRUE);
         view.putClientProperty(WizardDescriptor.PROP_CONTENT_DISPLAYED, Boolean.TRUE);
         view.putClientProperty(WizardDescriptor.PROP_CONTENT_NUMBERED, Boolean.TRUE);
      }

      return view;
   }

   public String getName() {
      return NbBundle.getBundle(PlaylistWizardPanel2.class).getString("Panel2.Name");
   }
   
   public HelpCtx getHelp() {
      return HelpCtx.DEFAULT_HELP;
   }
   
   public boolean isValid() {
      return true;
   }

   public final void addChangeListener(ChangeListener l) {}
   public final void removeChangeListener(ChangeListener l) {}

   public void readSettings(WizardDescriptor model) {
   }

   public void storeSettings(WizardDescriptor model) {
      model.putProperty(PlaylistVisualPanel2.PROP_TRACKS, getComponent().getTracks());
   }
}
