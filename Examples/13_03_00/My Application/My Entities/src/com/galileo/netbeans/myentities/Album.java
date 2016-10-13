package com.galileo.netbeans.myentities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Album {
   
   @Id @GeneratedValue
   private Long   id;

   private String title  = new String();
   private String tracks = new String();
   private String cds    = new String();

   @Column(name = "years")
   private String year   = new String();

   @ManyToOne
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
   
   public String getTitle() {
      return(title);
   }
   
   public String getTracks() {
      return(tracks);
   }
   
   public String getCds() {
      return(cds);
   }
   
   public String getYear() {
      return(year);
   }
   
   public Genre getGenre() {
      return(genre);
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
