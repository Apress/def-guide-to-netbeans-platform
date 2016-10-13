package com.hboeck.mp3manager.services.player;

import com.hboeck.mp3manager.filetype.Mp3DataObject;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;
import org.openide.util.Lookup;

public abstract class Mp3Player {

   public static Mp3Player getDefault() {
      Mp3Player player = Lookup.getDefault().lookup(Mp3Player.class);
      if (player == null) {
         player = new DefaultMp3Player();
      }

      return player;
   }
   private final Set<Mp3PlayerEventListener> listeners = new HashSet<Mp3PlayerEventListener>(1);

   public void addEventListener(Mp3PlayerEventListener l) {
      synchronized (listeners) {
         listeners.add(l);
      }
   }

   public void removeEventListener(Mp3PlayerEventListener l) {
      synchronized (listeners) {
         listeners.remove(l);
      }
   }

   protected final void firePlayEvent(Mp3DataObject mp3) {
      Iterator<Mp3PlayerEventListener> it;
      synchronized (listeners) {
         it = new HashSet<Mp3PlayerEventListener>(listeners).iterator();
      }

      while (it.hasNext()) {
         it.next().playing(mp3);
      }
   }

   protected final void fireStopEvent() {
      Iterator<Mp3PlayerEventListener> it;
      synchronized (listeners) {
         it = new HashSet<Mp3PlayerEventListener>(listeners).iterator();
      }

      while (it.hasNext()) {
         it.next().stopped();
      }
   }

   private static final class DefaultMp3Player extends Mp3Player {

      public void play(Mp3DataObject mp3) {
         throw new UnsupportedOperationException("Not supported yet.");
      }

      public void pause() {
         throw new UnsupportedOperationException("Not supported yet.");
      }

      public void stop() {
         throw new UnsupportedOperationException("Not supported yet.");
      }

      public void setMute(boolean mute) {
         throw new UnsupportedOperationException("Not supported yet.");
      }

      public void setVolume(int volume) {
         throw new UnsupportedOperationException("Not supported yet.");
      }

      public int getDuration() {
         throw new UnsupportedOperationException("Not supported yet.");
      }

      public int getMediaTime() {
         throw new UnsupportedOperationException("Not supported yet.");
      }

      public void setMediaTime(int seconds) {
         throw new UnsupportedOperationException("Not supported yet.");
      }

      public void play(ListIterator<Mp3DataObject> mp3s) {
         throw new UnsupportedOperationException("Not supported yet.");
      }

      public void previous() {
         throw new UnsupportedOperationException("Not supported yet.");
      }

      public void next() {
         throw new UnsupportedOperationException("Not supported yet.");
      }
   }

   public abstract void play(Mp3DataObject mp3);

   public abstract void play(ListIterator<Mp3DataObject> mp3s);

   public abstract void pause();

   public abstract void stop();

   public abstract void previous();

   public abstract void next();

   public abstract void setMute(boolean mute);

   public abstract void setVolume(int volume);

   public abstract int getDuration();

   public abstract int getMediaTime();

   public abstract void setMediaTime(int seconds);
}
