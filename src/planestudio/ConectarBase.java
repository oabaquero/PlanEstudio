/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planestudio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author obaquerog
 */
public class ConectarBase extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        
    }
    Connection con=null;
    public Connection conexion() {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost/ProgramaEIS", "root","");
        }
        catch(Exception ex){
            Logger.getLogger(ConectarBase.class.getName()).log(Level.SEVERE,null,ex);
        }
        return con;
    }

    public  void cerrar() throws SQLException {
        if (con != null) {
            con.close();
        }
    }
    
}
