package com.galileo.netbeans.module;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.openide.util.NbBundle;


public final class FirstTrayAction extends AbstractAction {

    public FirstTrayAction()
    {
        super (NbBundle.getMessage(FirstTrayAction.class, "CTL_FirstTrayAction"));
    }

    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
    }
}
