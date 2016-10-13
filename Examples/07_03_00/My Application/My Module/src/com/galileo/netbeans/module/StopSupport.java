package com.galileo.netbeans.module;

public class StopSupport implements StopCookie {

   private Mp3DataObject mp3 = null;

   public StopSupport(Mp3DataObject mp3) {
      this.mp3 = mp3;
   }
   
    public void stop() {
        System.out.println("stop");
        mp3.playing(false);
    }

}
