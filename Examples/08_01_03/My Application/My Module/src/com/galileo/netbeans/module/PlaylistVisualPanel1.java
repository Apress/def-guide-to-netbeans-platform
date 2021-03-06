package com.galileo.netbeans.module;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.openide.util.NbBundle;

public final class PlaylistVisualPanel1 extends JPanel implements DocumentListener {
   
   public static final String PROP_PLAYLIST_NAME = "playlistName";
   public static final String PROP_GENRE         = "genre";
   public static final String PROP_DESCRIPTION   = "description";
   public static final String PROP_IMAGE_PATH    = "imagePath";

   public PlaylistVisualPanel1() {
      initComponents();
      playlistName.getDocument().addDocumentListener(this);
      imagePath.getDocument().addDocumentListener(this);
   }

   @Override
   public String getName() {
      return NbBundle.getBundle(PlaylistWizardPanel1.class).getString("Panel1.Name");
   }
   
   public String getPlaylistName() {
      return playlistName.getText();
   }
   
   public String getGenre() {
      return (String)genre.getSelectedItem();
   }
   
   public String getDescription() {
      return description.getText();
   }

   public String getImagePath() {
      return imagePath.getText();
   }

   public void changedUpdate( DocumentEvent e ) {
      if (playlistName.getDocument() == e.getDocument()) {
         firePropertyChange(PROP_PLAYLIST_NAME, 0, 1);
      } else if(imagePath.getDocument() == e.getDocument()) {
         firePropertyChange(PROP_IMAGE_PATH, 0, 1);
      }
   }
   
   public void insertUpdate( DocumentEvent e ) {
      if (playlistName.getDocument() == e.getDocument()) {
         firePropertyChange(PROP_PLAYLIST_NAME, 0, 1);
      } else if(imagePath.getDocument() == e.getDocument()) {
         firePropertyChange(PROP_IMAGE_PATH, 0, 1);
      }
   }
   
   public void removeUpdate( DocumentEvent e ) {
      if (playlistName.getDocument() == e.getDocument()) {
         firePropertyChange(PROP_PLAYLIST_NAME, 0, 1);
      } else if(imagePath.getDocument() == e.getDocument()) {
         firePropertyChange(PROP_IMAGE_PATH, 0, 1);
      }
   }
    
  /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        genre = new javax.swing.JComboBox();
        playlistName = new javax.swing.JTextField();
        imagePath = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        preview = new javax.swing.JLabel();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, "Name:");

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, "Genre:");

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, "Description:");

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, "Image:");

        description.setColumns(20);
        description.setRows(5);
        jScrollPane1.setViewportView(description);

        genre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Trance", "House", "Pop", "Rock" }));

        org.openide.awt.Mnemonics.setLocalizedText(search, "Browse...");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, "max. 128 x 128 pixel");

        preview.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel3)
                    .add(jLabel2)
                    .add(jLabel1)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(preview, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 130, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5)
                    .add(genre, 0, 293, Short.MAX_VALUE)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                    .add(playlistName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(imagePath, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(search)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(playlistName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(genre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel4)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(imagePath, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(search)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel5)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(preview, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 130, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
    JFileChooser chooser = new JFileChooser(imagePath.getText());
    chooser.setFileFilter(new FileNameExtensionFilter("JPG, GIF, PNG Images", "jpg", "gif", "png"));

    if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
       preview.setIcon(new ImageIcon(chooser.getSelectedFile().getAbsolutePath()));
       imagePath.setText(chooser.getSelectedFile().getAbsolutePath());
   }
}//GEN-LAST:event_searchActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea description;
    private javax.swing.JComboBox genre;
    private javax.swing.JTextField imagePath;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField playlistName;
    private javax.swing.JLabel preview;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
 
}
