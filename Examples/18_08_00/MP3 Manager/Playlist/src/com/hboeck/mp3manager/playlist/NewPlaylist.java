package com.hboeck.mp3manager.playlist;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.windows.TopComponent;

public final class NewPlaylist implements ActionListener {
   
   public void actionPerformed(ActionEvent evt) {
      TopComponent tc = new Playlist();
      tc.open();
      tc.requestActive();
   }
}
