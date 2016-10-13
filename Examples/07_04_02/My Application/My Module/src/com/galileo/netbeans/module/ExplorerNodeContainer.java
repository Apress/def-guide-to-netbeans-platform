package com.galileo.netbeans.module;

import java.util.ArrayList;
import javax.swing.Action;
import org.openide.cookies.InstanceCookie;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataFolder;
import org.openide.loaders.DataObject;
import org.openide.loaders.FolderLookup;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.NbCollections;


public class ExplorerNodeContainer extends Children.Keys<FileObject> {
   
   private FileObject folder = null;

   public ExplorerNodeContainer(FileObject folder) {
      this.folder = folder;
   }

   @Override
   protected void addNotify() {
      setKeys(new FileObject[] {folder});
   }
   
   protected Node[] createNodes(FileObject folder) {
      ArrayList<Node> list = new ArrayList<Node>();
      
      for(FileObject f : NbCollections.iterable(folder.getFolders(false))) {
         list.add(new ExplorerFolderNode(f));
      }

      FolderLookup lkp = new NonRecursiveActionLookup(DataFolder.findFolder(folder));

      for(Action action : lkp.getLookup().lookupAll(Action.class)) {
         list.add(new ExplorerLeafNode(action));
      }
      
      return list.toArray(new Node[list.size()]);
   }

   private static final class NonRecursiveActionLookup extends FolderLookup {
      public NonRecursiveActionLookup(DataFolder df) {
         super(df);
      }
      
      @Override
      protected InstanceCookie acceptContainer(DataObject.Container con) {
         return null;
      }

      @Override
      protected InstanceCookie acceptFolder(DataFolder df) {
         return null;
      }
   }
}
