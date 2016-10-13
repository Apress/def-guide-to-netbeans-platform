/*
 * Mp3PlayerEventListener.java
 * 
 * Created on 21.08.2007, 23:03:04
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hboeck.mp3manager.services.player;

import com.hboeck.mp3manager.filetype.Mp3DataObject;
import java.util.EventListener;

/**
 *
 * @author Heiko Böck
 */
public interface Mp3PlayerEventListener extends EventListener{
   public void playing(Mp3DataObject mp3);
   public void stopped();
}
