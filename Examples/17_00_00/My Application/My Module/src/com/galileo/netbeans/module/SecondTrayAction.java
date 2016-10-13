package com.galileo.netbeans.module;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.openide.util.NbBundle;

public final class SecondTrayAction extends AbstractAction {

    public SecondTrayAction () {
        super (NbBundle.getMessage(SecondTrayAction.class, "CTL_SecondTrayAction"));
    }

    public void actionPerformed(ActionEvent e) {
        //TODO implement action body
    }
}
