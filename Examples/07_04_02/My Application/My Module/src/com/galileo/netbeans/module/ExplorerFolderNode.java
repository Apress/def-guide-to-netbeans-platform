package com.galileo.netbeans.module;

import org.openide.filesystems.FileObject;
import org.openide.nodes.AbstractNode;

public class ExplorerFolderNode extends AbstractNode{
   
   public ExplorerFolderNode(FileObject node) {
      super(new ExplorerNodeContainer(node));
      setDisplayName(node.getName());
      
      String iconBase = (String) node.getAttribute("icon");
      if(iconBase != null) {
         setIconBaseWithExtension(iconBase);
      }
   }
}
