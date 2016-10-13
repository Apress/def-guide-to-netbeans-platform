package com.galileo.netbeans.module;

import javax.swing.JPanel;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;

public class AlbumEditDialog extends JPanel {
   
   private AlbumEditDialog() {
      initComponents();
      for(Genre g : DataModel.getGenres()) {
         genre.addItem(g);
      }
   }

   public static Album editAlbum(Album album) {
      AlbumEditDialog dialog = new AlbumEditDialog();
      dialog.title.setText(album.getTitle());
      dialog.tracks.setText(album.getTracks());
      dialog.cds.setText(album.getCDs());
      dialog.year.setText(album.getYear());
      dialog.genre.getModel().setSelectedItem(album.getGenre());

      DialogDescriptor desc = new DialogDescriptor(dialog, "Edit...");
      if(DialogDisplayer.getDefault().notify(desc) == DialogDescriptor.OK_OPTION) {
         album.setTitle(dialog.title.getText());
         album.setTracks(dialog.tracks.getText());
         album.setCDs(dialog.cds.getText());
         album.setYear(dialog.year.getText());
         album.setGenre((Genre)dialog.genre.getModel().getSelectedItem());
         return album;
      } else {
         return null;
      }
   }
   
   public static Album newAlbum() {
      AlbumEditDialog dialog = new AlbumEditDialog();
      DialogDescriptor desc = new DialogDescriptor(dialog, "New...");
      if(DialogDisplayer.getDefault().notify(desc) == DialogDescriptor.OK_OPTION) {
         Album album = new Album(0, dialog.title.getText(), dialog.tracks.getText(), dialog.cds.getText(), dialog.year.getText(), (Genre)dialog.genre.getModel().getSelectedItem());
         return album;
      } else {
         return null;
      }
   }
   
   /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
   // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
   private void initComponents() {

      jPanel1 = new javax.swing.JPanel();
      jLabel1 = new javax.swing.JLabel();
      jLabel2 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      jLabel4 = new javax.swing.JLabel();
      title = new javax.swing.JTextField();
      tracks = new javax.swing.JTextField();
      cds = new javax.swing.JTextField();
      year = new javax.swing.JTextField();
      jLabel5 = new javax.swing.JLabel();
      genre = new javax.swing.JComboBox();

      jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(AlbumEditDialog.class, "NewJPanel.jPanel1.border.title"))); // NOI18N

      jLabel1.setText(org.openide.util.NbBundle.getMessage(AlbumEditDialog.class, "NewJPanel.jLabel1.text")); // NOI18N

      jLabel2.setText(org.openide.util.NbBundle.getMessage(AlbumEditDialog.class, "NewJPanel.jLabel2.text")); // NOI18N

      jLabel3.setText(org.openide.util.NbBundle.getMessage(AlbumEditDialog.class, "NewJPanel.jLabel3.text")); // NOI18N

      jLabel4.setText(org.openide.util.NbBundle.getMessage(AlbumEditDialog.class, "NewJPanel.jLabel4.text")); // NOI18N

      title.setText(org.openide.util.NbBundle.getMessage(AlbumEditDialog.class, "NewJPanel.title.text")); // NOI18N

      tracks.setText(org.openide.util.NbBundle.getMessage(AlbumEditDialog.class, "NewJPanel.tracks.text")); // NOI18N

      cds.setText(org.openide.util.NbBundle.getMessage(AlbumEditDialog.class, "NewJPanel.cds.text")); // NOI18N

      year.setText(org.openide.util.NbBundle.getMessage(AlbumEditDialog.class, "NewJPanel.year.text")); // NOI18N

      jLabel5.setText(org.openide.util.NbBundle.getMessage(AlbumEditDialog.class, "NewJPanel.jLabel5.text")); // NOI18N

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(jLabel2)
               .addComponent(jLabel5)
               .addComponent(jLabel1))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
               .addComponent(genre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(tracks, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jLabel3)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(cds, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jLabel4)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(year)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel1))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel4)
               .addComponent(cds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel3)
               .addComponent(tracks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel2))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(genre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel5))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
      );
   }// </editor-fold>//GEN-END:initComponents
   
   
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JTextField cds;
   private javax.swing.JComboBox genre;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JTextField title;
   private javax.swing.JTextField tracks;
   private javax.swing.JTextField year;
   // End of variables declaration//GEN-END:variables
   
}
