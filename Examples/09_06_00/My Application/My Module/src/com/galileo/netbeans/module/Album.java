package com.galileo.netbeans.module;

import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.beans.BeanInfo;
import java.io.IOException;
import org.openide.util.ImageUtilities;

public class Album implements Transferable{
   
   public static final DataFlavor DATA_FLAVOR = new DataFlavor(Album.class, "album");
   
   private String title  = new String();
   private String tracks = new String();
   private String cds    = new String();
   private String year   = new String();
   private String icon16 = new String();
   private String icon32 = new String();

   public Album(String title, String tracks, String cds, String year, String icon16, String icon32) {
      this.title  = title;
      this.tracks = tracks;
      this.cds    = cds;
      this.year   = year;
      this.icon16 = icon16;
      this.icon32 = icon32;
   }
   
   public String getTitle() {
      return title;
   }
   
   public String getTracks() {
      return tracks;
   }
   
   public String getCDs() {
      return cds;
   }
   
   public String getYear() {
      return year;
   }

   public Image getIcon(int type) {
      if(BeanInfo.ICON_COLOR_16x16 == type) {
         return ImageUtilities.loadImage(icon16);
      } else {
         return ImageUtilities.loadImage(icon32);
      }
   }

   public DataFlavor[] getTransferDataFlavors() {
      return new DataFlavor[] {DATA_FLAVOR};
   }

   public boolean isDataFlavorSupported(DataFlavor flavor) {
      return flavor == DATA_FLAVOR;
   }

   public Object getTransferData(DataFlavor flavor)
           throws UnsupportedFlavorException, IOException {
      if(flavor == DATA_FLAVOR) {
         return this;
      } else {
         throw new UnsupportedFlavorException(flavor);
      }
   }
}
