package com.galileo.netbeans.myentities;

public class Genre {
   
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

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }
   
   public String getGenre() {
      return genre;
   }
   
   public void setGenre(String genre) {
      this.genre = genre;
   }

   @Override
   public String toString() {
      return genre;
   }

   @Override
   public boolean equals(Object obj) {
      if(obj instanceof Genre) {
         if(((Genre)obj).getGenre().equals(genre)) {
            return true;
         }
      }
      return false;
   }

   @Override
   public int hashCode() {
      int hash = 3;
      hash = 37 * hash + this.genre != null ? this.genre.hashCode() : 0;
      return hash;
   }
}
