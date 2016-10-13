package com.galileo.netbeans.module;

public class PlaySupport implements PlayCookie {
   
   private Mp3DataObject mp3 = null;

   public PlaySupport(Mp3DataObject mp3) {
      this.mp3 = mp3;
   }
   
    public void play() {
        //Mp3Player.getDefault().play(mp3);
       System.out.println("play");
       mp3.playing(true);
    }
}
