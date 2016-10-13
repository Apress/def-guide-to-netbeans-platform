package com.galileo.netbeans.module;

import org.openide.nodes.Node;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;
import org.openide.util.actions.CookieAction;

public final class PlayAction extends CookieAction {
   
   protected void performAction(Node[] activatedNodes) {
      PlayCookie playCookie = activatedNodes[0].getLookup().lookup(PlayCookie.class);
      playCookie.play();
   }
   
   protected int mode() {
      return CookieAction.MODE_EXACTLY_ONE;
   }
   
   public String getName() {
      return NbBundle.getMessage(PlayAction.class, "CTL_PlayAction");
   }
   
   protected Class[] cookieClasses() {
      return new Class[] {
         PlayCookie.class
      };
   }
   
   @Override
   protected String iconResource() {
      return "com/galileo/netbeans/module/play.png";
   }
   
   public HelpCtx getHelpCtx() {
      return HelpCtx.DEFAULT_HELP;
   }
   
   @Override
   protected boolean asynchronous() {
      return false;
   }
   
}

