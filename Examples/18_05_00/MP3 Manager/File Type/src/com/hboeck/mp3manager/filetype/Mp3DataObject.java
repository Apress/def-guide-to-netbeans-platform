package com.hboeck.mp3manager.filetype;

import com.hboeck.mp3manager.id3.v1.ID3v1Tag;
import com.hboeck.mp3manager.id3.v2.ID3v2Tag;
import java.io.IOException;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataNode;
import org.openide.loaders.DataObjectExistsException;
import org.openide.loaders.MultiDataObject;
import org.openide.loaders.MultiFileLoader;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.Lookup;


public class Mp3DataObject extends MultiDataObject {

   private ID3v1Tag id3v1 = null;
   private ID3v2Tag id3v2 = null;

   public Mp3DataObject(FileObject pf, MultiFileLoader loader)
           throws DataObjectExistsException, IOException {
      super(pf, loader);
   }

   @Override
   protected Node createNodeDelegate() {
      return new Mp3DataNode(this, getLookup());
   }

   @Override
   public Lookup getLookup() {
      return getCookieSet().getLookup();
   }

   public ID3v1Tag getID3v1Tag() {
      if(id3v1 == null) {
         id3v1 = new ID3v1Tag(FileUtil.toFile(getPrimaryFile()));
      }
      return(id3v1);
   }

   public ID3v2Tag getID3v2Tag() {
      if(id3v2 == null) {
         id3v2 = new ID3v2Tag(FileUtil.toFile(getPrimaryFile()));
      }
      return(id3v2);
   }
}
