package org.apache.derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.openide.modules.ModuleInstall;

public class Database extends ModuleInstall {
   private static Connection conn = null;

   public void restored() {
      System.setProperty("derby.system.home", 
         System.getProperty("netbeans.user", 
         System.getProperty("user.home")) + "/databases");
      initTables();
   }

   private void initTables() {
      try {
         Statement stmt = getConnection().createStatement();
         stmt.executeQuery("SELECT id FROM playlist");
         stmt.close();
      } catch(SQLException e) {
         try {
            Statement stmt = getConnection().createStatement();
            stmt.execute("CREATE TABLE playlist (" +
               "id VARCHAR(12)," +
               "filename VARCHAR(100))");
            stmt.close();
         } catch(SQLException ex) {
            ex.printStackTrace();
         }
      }
   }

   public static Connection getConnection() throws SQLException{
      if(conn == null || conn.isClosed()) {
         conn = DriverManager.getConnection(
            "jdbc:derby:mp3manager;create=true", 
            "user", "password");
      }
      return(conn);
   }

   public void close() {
      try {
        conn.close();
        DriverManager.getConnection("jdbc:derby:;shutdown=true");
      } catch (SQLException ex) {}
   }

}
