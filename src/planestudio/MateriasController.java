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
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import planestudio.Materia;

/**
 * FXML Controller class
 *
 * @author obaquerog
 */
public class MateriasController implements Initializable {

    @FXML
    TextField txtCodigo;

    @FXML
    TextField txtNombre;

    @FXML
    TextField txtSemestre;

    @FXML
    TableView twMaterias;

    @FXML
    TableColumn tcCodigo;
    @FXML
    TableColumn tcNombre;
    @FXML
    TableColumn tcSemestre;

    @FXML
    Button btnConsultar;

    @FXML
    Button btnActualizar;

    ObservableList<Materia> materias;
    String codigo, nombre, semestre;
    int posicionMateriaEnTabla, idMateria;

    ConectarBase conectar = new ConectarBase();
    Connection con = conectar.conexion();
    PreparedStatement pst;
    ResultSet rs;
    String sql;

    private final ListChangeListener<Materia> selectorTablaMaterias
            = new ListChangeListener<Materia>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends Materia> c) {
            ponerMateriaSeleccionada();
        }
    };

    public Materia getTablaMateriaSeleccionada() {
        if (twMaterias != null) {
            List<Materia> tabla = twMaterias.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Materia materiaSeleccionada = tabla.get(0);
                return materiaSeleccionada;
            }
        }
        return null;
    }

    private void ponerMateriaSeleccionada() {
        final Materia materia = getTablaMateriaSeleccionada();
        posicionMateriaEnTabla = materias.indexOf(materia);

        if (materia != null) {
            idMateria = materia.getId();
            txtCodigo.setText(materia.getCodigo());
            txtNombre.setText(materia.getNombre());
            txtSemestre.setText(materia.getSemestre());
            this.EditableTextField(false);
        }
    }

    private void inicializarTablaMaterias() {
        tcCodigo.setCellValueFactory(new PropertyValueFactory<Materia, String>("codigo"));
        tcNombre.setCellValueFactory(new PropertyValueFactory<Materia, String>("nombre"));
        tcSemestre.setCellValueFactory(new PropertyValueFactory<Materia, String>("semestre"));
        materias = FXCollections.observableArrayList();
        twMaterias.setItems(materias);
    }

    public void EditableTextField(boolean valor) {

        txtSemestre.setEditable(valor);
    }

    public void limpiarTextField() {
        txtNombre.setText("");
        txtSemestre.setText("");
        txtCodigo.setText("");
    }

    public void cargarDatosTableView(String sql) {

        this.inicializarTablaMaterias();
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Materia obtenerMateria = new Materia();
                obtenerMateria.id.set(rs.getInt(1));
                obtenerMateria.codigo.set(rs.getString(2));
                obtenerMateria.nombre.set(rs.getString(3));
                obtenerMateria.semestre.set(rs.getString(4));
                materias.add(obtenerMateria);
            }
            System.out.println("Materia consultada correctamente !!");

        } catch (SQLException ex) {
            Logger.getLogger(MateriasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargarTodasMaterias() {
        sql = "SELECT id,codigo,nombre,semestre FROM materias ";
        this.cargarDatosTableView(sql);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.EditableTextField(false);

        final ObservableList<Materia> tablaMateriaSel = twMaterias.getSelectionModel().getSelectedItems();
        tablaMateriaSel.addListener(selectorTablaMaterias);
        this.cargarTodasMaterias();
    }

    @FXML
    public void accionActualizar(ActionEvent event) {
        if (!this.validarTextField()) {
            return;
        }
        sql = "UPDATE materias SET nombre = ? WHERE id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nombre);
            pst.setInt(2, idMateria);
            pst.executeUpdate();
            if (pst.getUpdateCount() > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Plan de Estudio - EIS");
                alert.setHeaderText(null);
                alert.setContentText("La materia ha sido actualizada correctamente !!");
                alert.showAndWait();
                this.limpiarTextField();
                this.cargarTodasMaterias();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Plan de Estudio - EIS");
                alert.setHeaderText(null);
                alert.setContentText("La materia no ha sido actualizada.");
                alert.showAndWait();
            }

        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Plan de Estudio - EIS");
            alert.setHeaderText(null);
            alert.setContentText("La materia no ha sido actualizada.");
            alert.showAndWait();
        }
    }

    public boolean validarTextField() {
        nombre = txtNombre.getText();
        if (nombre.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Plan de Estudio - EIS");
            alert.setHeaderText(null);
            alert.setContentText("El campo nombres esta vacio.");
            alert.showAndWait();
            return false;
        }
        return true;
    }

    @FXML
    public void accionConsultar(ActionEvent event) {
        sql = "SELECT id,codigo,nombre,semestre FROM materias WHERE codigo LIKE'%" + txtCodigo.getText() + "%'";
        this.cargarDatosTableView(sql);
        this.limpiarTextField();
    }

}
