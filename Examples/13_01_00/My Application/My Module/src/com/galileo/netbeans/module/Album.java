package com.galileo.netbeans.module;

public class Album {
   
   private int    id     = 0;
   private String title  = new String();
   private String tracks = new String();
   private String cds    = new String();
   private String year   = new String();
   private Genre  genre  = null;

   public Album(int id, String title, String tracks, String cds, String year, Genre genre) {
      this.id     = id;
      this.title  = title;
      this.tracks = tracks;
      this.cds    = cds;
      this.year   = year;
      this.genre  = genre;
   }
   
   public int getId() {
      return id;
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
   
   public Genre getGenre() {
      return genre;
   }
   
   public void setTitle(String title) {
      this.title = title;
   }
   
   public void setTracks(String tracks) {
      this.tracks = tracks;
   }
   
   public void setCDs(String cds) {
      this.cds = cds;
   }
   
   public void setYear(String year) {
      this.year = year;
   }
   
   public void setGenre(Genre genre) {
      this.genre = genre;
   }
}
