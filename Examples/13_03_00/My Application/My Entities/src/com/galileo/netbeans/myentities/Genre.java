package com.galileo.netbeans.myentities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Genre {
   
   @Id @GeneratedValue
   private Long id;

   private String genre = new String();
   
   public Genre() {
   }

   public Genre(String genre) {
      this.genre = genre;
   }
   
   public Genre(long id, String genre) {
      this.id    = new Long(id);
      this.genre = genre;
   }

   public String getGenre() {
      return(genre);
   }
   
   public void setGenre(String genre) {
      this.genre = genre;
   }

   @Override
   public String toString() {
      return(genre);
   }

   @Override
   public boolean equals(Object obj) {
      if(obj instanceof Genre) {
         if(((Genre)obj).getGenre().equals(genre)) {
            return(true);
         }
      }
      return(false);
   }

   @Override
   public int hashCode() {
      int hash = 3;
      hash = 37 * hash + this.genre != null ? this.genre.hashCode() : 0;
      return hash;
   }
}
