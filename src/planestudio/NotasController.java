/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planestudio;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    ComboBox cmbPeriodo;

    @FXML
    ComboBox cmbMateria;

    @FXML
    Text tCodigo;

    @FXML
    Text tNombres;

    @FXML
    Text tApellidos;

    @FXML
    TableView<NotasEstudiante> twMateriaNota;
    @FXML
    TableColumn tcCodigo;
    @FXML
    TableColumn tcNombre;
    @FXML
    TableColumn tcPeriodo;
    @FXML
    TableColumn tcAno;
    @FXML
    TableColumn tcNota;
    ObservableList<NotasEstudiante> notas;
    ObservableList<Materia> listaMaterias;
    ObservableList<Materia> listaPeriodo;

    int posicionNotaEnTabla, idNota;
    ConectarBase conectar = new ConectarBase();
    Connection con = conectar.conexion();
    PreparedStatement pst;
    ResultSet rs;
    String sql;

    private final ListChangeListener<NotasEstudiante> selectorTablaNotasEstudiantes
            = new ListChangeListener<NotasEstudiante>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends NotasEstudiante> c) {            
            ponerNotaSeleccionada();
        }
    };

    private void ponerNotaSeleccionada() {
        final NotasEstudiante nota = getTablaNotasEstudianteSeleccionado();
        posicionNotaEnTabla = notas.indexOf(nota);
        
        if (nota != null) {
            idNota = nota.getId();
            cmbMateria.setValue(nota.getNombre());
            cmbPeriodo.setValue(nota.getPeriodo());
            txtNota.setText(nota.getNota());
        }
        btnRegistrar.setDisable(true);
    }

    public NotasEstudiante getTablaNotasEstudianteSeleccionado() {
        if (twMateriaNota != null) {
            List<NotasEstudiante> tabla = twMateriaNota.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final NotasEstudiante obj = tabla.get(0);
                return obj;
            }
        }
        return null;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        final ObservableList<NotasEstudiante> tablaPersonaSel = twMateriaNota.getSelectionModel().getSelectedItems();
        tablaPersonaSel.addListener(selectorTablaNotasEstudiantes);
        
        this.llenarComboMaterias();
        this.llenarComboPeriodos();
    }

    @FXML
    public void accionConsultar(ActionEvent event) {
        if ("".equals(txtCodigo.getText())) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Falta información por diligenciar");
            alert.setContentText("No ha ingresado un codigo de estudiante!");
            alert.showAndWait();

        } else 
            cargarTodasNotasEstudiante(txtCodigo.getText()); 
    }

    public void cargarTodasNotasEstudiante(String codigo){
     tcCodigo.setCellValueFactory(new PropertyValueFactory<NotasEstudiante, String>("codigo"));
            tcNombre.setCellValueFactory(new PropertyValueFactory<NotasEstudiante, String>("nombre"));
            tcPeriodo.setCellValueFactory(new PropertyValueFactory<NotasEstudiante, Integer>("periodo"));
            tcAno.setCellValueFactory(new PropertyValueFactory<NotasEstudiante, String>("ano"));
            tcNota.setCellValueFactory(new PropertyValueFactory<NotasEstudiante, String>("nota"));
            notas = FXCollections.observableArrayList();
            twMateriaNota.setItems(notas);
            try {
                sql = "select notas.id, materias.codigo, materias.nombre, notas.periodo, notas.ano, notas.nota, "
                        +"notas.estudiantes_id, notas.materias_id "
                        + "from notas inner join estudiantes on notas.estudiantes_id = estudiantes.id "
                        + "inner join materias on materias.id = notas.materias_id "
                        + "where estudiantes.codigo = '" + codigo+"'"
                        + " order by notas.ano asc ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    NotasEstudiante objNotas = new NotasEstudiante();
                    objNotas.id.set(rs.getInt(1));
                    objNotas.codigo.set(rs.getString(2));
                    objNotas.nombre.set(rs.getString(3));
                    objNotas.periodo.set(rs.getString(4));
                    objNotas.ano.set(rs.getString(5));
                    objNotas.nota.set(rs.getString(6));
                    objNotas.estudiantes_id.set(rs.getInt(7));
                    objNotas.materias_id.set(rs.getInt(8));
                    notas.add(objNotas);
                }

                System.out.println("Notas de estudiante consultadas correctamente");

            } catch (SQLException ex) {
                Logger.getLogger(EstudiantesController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @FXML
    public void accionNuevo(ActionEvent event) {
        this.limpiarFormulario();
        btnRegistrar.setDisable(false);
    }
    
    public void limpiarFormulario(){
        cmbPeriodo.setValue(null);
        cmbMateria.setValue(null);
        txtNota.setText("");
    };

    @FXML
    public void accionActualizar(ActionEvent event) {
        sql = "UPDATE notas SET nota = ? WHERE id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, txtNota.getText());
            pst.setInt(2, idNota);
            pst.executeUpdate();
            if(pst.getUpdateCount()>0){
                Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Notas de Estudiante");
            alert.setHeaderText(null);
            alert.setContentText("La nota ha sido actualizada correctamente.");
            alert.showAndWait();
            
            this.cargarTodasNotasEstudiante(txtCodigo.getText());
            }
            else{
                Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Plan de Estudio - EIS");
            alert.setHeaderText(null);
            alert.setContentText("El estudiante no ha sido actualizado.");
            alert.showAndWait();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Plan de Estudio - EIS");
            alert.setHeaderText(null);
            alert.setContentText("El estudiante no ha sido actualizado.");
            alert.showAndWait();
        }
    }

    @FXML
    public void accionRegistrar(ActionEvent event) {        
        String mat = cmbMateria.getSelectionModel().getSelectedItem().toString();
        sql = "INSERT INTO notas (estudiantes_id,materias_id,periodo,ano,nota)" 
            + "VALUES((select id from estudiantes where codigo ='"+txtCodigo.getText()+"'),(select id from materias where nombre ='"+mat+"'),?,(Select Year(CURDATE())),?)";                
        try {
            
            pst = con.prepareStatement(sql);
            //pst.setString(1, cmbMateria.getSelectionModel().getSelectedItem().toString());
            pst.setString(1, cmbPeriodo.getSelectionModel().getSelectedItem().toString());       
            pst.setDouble(2, Double.parseDouble(txtNota.getText()));
         
            pst.executeUpdate();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Plan de Estudio - EIS");
            alert.setHeaderText(null);
            alert.setContentText("La nota ha sido registrada correctamente.");
            alert.showAndWait();            
            this.limpiarFormulario();
            this.cargarTodasNotasEstudiante(txtCodigo.getText());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Plan de Estudio - EIS");
            alert.setHeaderText(null);
            alert.setContentText("La nota no ha sido registrada.");
            alert.showAndWait();
        }
    }

    private void llenarComboMaterias() {
        listaMaterias = FXCollections.observableArrayList();
        cmbMateria.setItems(listaMaterias);

        try {
            sql = "select id, nombre from materias ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Materia obj = new Materia();
                obj.id.set(rs.getInt(1));
                obj.nombre.set(rs.getString(2));
                listaMaterias.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void llenarComboPeriodos() {
        listaPeriodo = FXCollections.observableArrayList();
        cmbPeriodo.setItems(listaPeriodo);

        try {
            sql = "SELECT DISTINCT notas.periodo from notas group by notas.periodo ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Materia obj = new Materia();
                obj.nombre.set(rs.getString(1));
                listaPeriodo.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
