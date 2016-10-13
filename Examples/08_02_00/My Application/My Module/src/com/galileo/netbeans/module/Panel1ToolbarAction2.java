package com.galileo.netbeans.module;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import org.openide.util.ImageUtilities;
import org.openide.util.NbBundle;

public final class Panel1ToolbarAction2 extends AbstractAction {

   public Panel1ToolbarAction2() {
      super(NbBundle.getMessage(Panel1ToolbarAction2.class, "CTL_Panel1ToolbarAction2"),
              new ImageIcon(ImageUtilities.loadImage("com/galileo/netbeans/module/explorer.png")));
   }

    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
    }

}
