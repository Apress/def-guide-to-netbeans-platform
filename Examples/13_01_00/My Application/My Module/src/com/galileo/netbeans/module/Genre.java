package com.galileo.netbeans.module;

public class Genre {
   
   private int    id    = 0;
   private String genre = new String();

   public Genre(int id, String genre) {
      this.id    = id;
      this.genre = genre;
   }
   
   public int getId() {
      return id;
   }
   
   public String getGenre() {
      return genre;
   }
   
   @Override
   public String toString() {
      return genre;
   }
   
   @Override
   public boolean equals(Object obj) {
      if(obj instanceof Genre) {
         if(((Genre)obj).getId() == id) {
            return true;
         }
      }
      return false;
   }

   @Override
   public int hashCode() {
      int hash = 7;
      hash = 97 * hash + this.id;
      return hash;
   }
}
