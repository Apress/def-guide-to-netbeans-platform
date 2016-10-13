package com.galileo.netbeans.module;

import org.openide.nodes.AbstractNode;

public class GenreNode extends AbstractNode{

   public GenreNode(String genre) {
      super(new AlbumNodeContainer(genre));
      this.setDisplayName(genre);
   }
}
