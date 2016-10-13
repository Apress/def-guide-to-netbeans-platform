package com.galileo.netbeans.module;

import org.openide.nodes.Children;
import org.openide.nodes.Node;

public class GenreNodeContainer extends Children.Keys<String>{
   
   public GenreNodeContainer() {
   }
   
   @Override
   protected void addNotify() {
      setKeys(new String[] {"root"});
   }
   
   protected Node[] createNodes(String root) {
      return(new Node[]{new GenreNode("Techno, Trance and Dance"),
                        new GenreNode("Rock and Pop"),
                        new GenreNode("Country and Classic")});
   }
}
