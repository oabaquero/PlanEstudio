/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planestudio;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author obaquerog
 */
public class NotasController implements Initializable {
    
    @FXML
    TextField txtCodigo;
    
    @FXML
    TextField txtNota;
    
    @FXML
    Button btnConsultar;
    
    @FXML
    Button btnNuevo;
    
    @FXML
    Button btnActualizar;
    
    @FXML
    Button btnRegistrar;
    
    @FXML
    ComboBox cmbSemestre;
    
    @FXML
    ComboBox cmbMateria;
    
    @FXML
    Text tCodigo;
    
    @FXML
    Text tNombres;
    
    @FXML
    Text tApellidos;
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        // TODO
    }    
    @FXML
    public void accionConsultar(ActionEvent event){
        
    }
    
    @FXML
    public void accionNuevo(ActionEvent event){
        
    }
    
    @FXML
    public void accionActualizar(ActionEvent event){
        
    }
    
    @FXML
    public void accionRegistrar(ActionEvent event){
        
    }

    
    
}
