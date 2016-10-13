package com.galileo.netbeans.myentities;

public class Album {
   
   private Long   id;
   private String title  = new String();
   private String tracks = new String();
   private String cds    = new String();
   private String year   = new String();
   private Genre  genre;
   
   public Album() {
      
   }

   public Album(String title, String tracks, String cds, String year, Genre genre) {
      this.title  = title;
      this.tracks = tracks;
      this.cds    = cds;
      this.year   = year;
      this.genre  = genre;
   }
   
   public Long getId() {
      return id;
   }
   
   public void setId(Long id) {
      this.id = id;
   }
   
   public String getTitle() {
      return title;
   }
   
   public String getTracks() {
      return tracks;
   }
   
   public String getCds() {
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
   
   public void setCds(String cds) {
      this.cds = cds;
   }
   
   public void setYear(String year) {
      this.year = year;
   }
   
   public void setGenre(Genre genre) {
      this.genre = genre;
   }
}
