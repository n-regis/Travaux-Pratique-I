/*
 * travaux pratique système de gestion des fleuristes
 * @author Nganha Regis Eric
 * date: 2015/02/28
 * version: 2.00
 */
package Utilitaires;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

/** classe qui permet la connection à la basse de données
 *
 * 
 */
public class ConfigDB {
    
  private ConfigDB() {
    }
    
  
  /** cette methode permet de se connecter à la base de données
   * @param nomfichierProp qui contient les coordonnées de la basse de données
  
  */
   public static Connection getConnection(String nomFichierProp)
      throws IOException, ClassNotFoundException, SQLException {
    Properties props = new Properties();
    URL urlFichierProp = ConfigDB.class.getResource(nomFichierProp);
    BufferedInputStream bis = null;
    try {
    	//lecture du fichier de propriétés
      bis = new BufferedInputStream(urlFichierProp.openStream());
      props.load(bis);
      String driver = props.getProperty("driver");
      String url = props.getProperty("url");
      String identifiant = props.getProperty("identifiant");
      String motdepasse = props.getProperty("motdepasse");
     
      Class.forName(driver);
      //retourner le driver approprié
      return DriverManager.getConnection(url, identifiant, motdepasse);
    }
    finally {
      if (bis != null) {
        bis.close();
      }
    }}
    
}
