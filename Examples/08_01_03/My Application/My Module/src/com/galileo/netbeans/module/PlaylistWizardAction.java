/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.galileo.netbeans.module;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import org.openide.DialogDisplayer;
import org.openide.WizardDescriptor;

public final class PlaylistWizardAction implements ActionListener {

    public void actionPerformed(ActionEvent e) {
      PlaylistWizardDescriptor descriptor = new PlaylistWizardDescriptor();
      Dialog dialog = DialogDisplayer.getDefault().createDialog(descriptor);
      dialog.setVisible(true);
      dialog.toFront();

      if (descriptor.getValue() == WizardDescriptor.FINISH_OPTION) {
         Map<String, Object> props = descriptor.getProperties();
         //Create the playlist with the data stored in props
      }
    }
}
