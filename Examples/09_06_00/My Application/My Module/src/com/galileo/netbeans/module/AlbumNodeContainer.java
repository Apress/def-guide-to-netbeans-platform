package com.galileo.netbeans.module;

import org.openide.nodes.Children;
import org.openide.nodes.Node;

public class AlbumNodeContainer extends Children.Keys<String>{
   
   private String genre = new String();
   
   public AlbumNodeContainer(String genre) {
      this.genre = genre;
   }
   
   protected Node[] createNodes(String genre) {
      return(new Node[] {new AlbumNode(new Album("Tunnel Trance Force 39", "42", "2", "2007", "com/galileo/netbeans/module/resources/cover1_small.jpg", "com/galileo/netbeans/module/resources/cover1_big.jpg")),
                         new AlbumNode(new Album("Dream Dance 43", "39", "3", "2007", "com/galileo/netbeans/module/resources/cover2_small.jpg", "com/galileo/netbeans/module/resources/cover2_big.jpg")),
                         new AlbumNode(new Album("DJ Networx 31", "45", "2", "2006", "com/galileo/netbeans/module/resources/cover3_small.jpg", "com/galileo/netbeans/module/resources/cover3_big.jpg"))});
   }

   @Override
   protected void addNotify() {
      setKeys(new String[] {genre});
   }
}
