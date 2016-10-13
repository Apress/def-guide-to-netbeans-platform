package com.galileo.netbeans.module;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import org.openide.util.Exceptions;

public class DataModel {

   public static Vector<Album> getAlbums() {
      Vector<Album> albums = new Vector<Album>();

      try {
         Statement stmt = Installer.getConnection().createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM albums INNER JOIN genres ON albums.genre = genres.id");
         while(rs.next()) {
            albums.add(new Album(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), new Genre(rs.getInt(7), rs.getString(8))));
         }
         rs.close();
         stmt.close();
      } catch(SQLException e) {
         Exceptions.printStackTrace(e);
      }
      
      return albums;
   }
   
   public static Vector<Genre> getGenres() {
      Vector<Genre> genres = new Vector<Genre>();

      try {
         Statement stmt = Installer.getConnection().createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM genres");
         while(rs.next()) {
            genres.add(new Genre(rs.getInt(1), rs.getString(2)));
         }
         rs.close();
         stmt.close();
      } catch(Exception e) {
         e.printStackTrace();
      }
      
      return genres;
   }

   public static void updateAlbum(Album album) throws SQLException {
      PreparedStatement stmt = Installer.getConnection().prepareStatement("UPDATE albums SET title=?, tracks=?, cds=?, years=?, genre=? WHERE id=?");
      stmt.setString(1, album.getTitle());
      stmt.setString(2, album.getTracks());
      stmt.setString(3, album.getCDs());
      stmt.setString(4, album.getYear());
      stmt.setInt(5, album.getGenre().getId());
      stmt.setInt(6, album.getId());
      stmt.execute();
   }
   
   public static void insertAlbum(Album album) throws SQLException {
      PreparedStatement stmt = Installer.getConnection().prepareStatement("INSERT INTO albums (title, tracks, cds, years, genre) VALUES(?, ?, ?, ?, ?)");
      stmt.setString(1, album.getTitle());
      stmt.setString(2, album.getTracks());
      stmt.setString(3, album.getCDs());
      stmt.setString(4, album.getYear());
      stmt.setInt(5, album.getGenre().getId());
      stmt.execute();
   }
   
   public static void deleteAlbum(Album album) throws SQLException {
      PreparedStatement stmt = Installer.getConnection().prepareStatement("DELETE FROM albums WHERE id = ?");
      stmt.setInt(1, album.getId());
      stmt.execute();
   }
}
