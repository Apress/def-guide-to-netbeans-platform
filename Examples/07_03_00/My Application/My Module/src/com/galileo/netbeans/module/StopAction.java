package com.galileo.netbeans.module;

import org.openide.nodes.Node;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;
import org.openide.util.actions.CookieAction;

public final class StopAction extends CookieAction {
   
   protected void performAction(Node[] activatedNodes) {
      StopCookie stopCookie = activatedNodes[0].getLookup().lookup(StopCookie.class);
      stopCookie.stop();
   }
   
   protected int mode() {
      return CookieAction.MODE_EXACTLY_ONE;
   }
   
   public String getName() {
      return NbBundle.getMessage(StopAction.class, "CTL_StopAction");
   }
   
   protected Class[] cookieClasses() {
      return new Class[] {
         StopCookie.class
      };
   }
   
   @Override
   protected String iconResource() {
      return "com/galileo/netbeans/module/stop.png";
   }
   
   public HelpCtx getHelpCtx() {
      return HelpCtx.DEFAULT_HELP;
   }
   
   @Override
   protected boolean asynchronous() {
      return false;
   }
   
}

