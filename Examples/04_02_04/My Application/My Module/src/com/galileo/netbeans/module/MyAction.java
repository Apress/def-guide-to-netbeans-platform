package com.galileo.netbeans.module;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;

/**
 * Action which shows My component.
 */
public class MyAction extends AbstractAction {

   public MyAction() {
      super(NbBundle.getMessage(MyAction.class, "CTL_MyAction"));
   }

   public void actionPerformed(ActionEvent evt) {
      TopComponent win = MyTopComponent.findInstance();
      win.open();
      win.requestActive();
   }
}