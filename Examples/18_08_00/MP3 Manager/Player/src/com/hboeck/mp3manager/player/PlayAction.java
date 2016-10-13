package com.hboeck.mp3manager.player;

import com.hboeck.mp3manager.filetype.Mp3DataObject;
import com.hboeck.mp3manager.services.player.Mp3Player;
import org.openide.loaders.DataObject;
import org.openide.nodes.Node;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;
import org.openide.util.actions.CookieAction;

public final class PlayAction extends CookieAction {

   protected void performAction(Node[] activatedNodes) {
      Mp3DataObject mp3 = activatedNodes[0].getLookup().lookup(Mp3DataObject.class);
      if (mp3 != null) {
         Mp3Player.getDefault().play(mp3);
      }
   }

   protected int mode() {
      return MODE_EXACTLY_ONE;
   }

   public String getName() {
      return NbBundle.getMessage(PlayAction.class, "CTL_PlayAction");
   }

   protected Class[] cookieClasses() {
      return new Class[]{DataObject.class};
   }

   @Override
   protected String iconResource() {
      return "com/hboeck/mp3manager/player/gui/icons/play16.png";
   }

   public HelpCtx getHelpCtx() {
      return HelpCtx.DEFAULT_HELP;
   }

   @Override
   protected boolean asynchronous() {
      return false;
   }
}
