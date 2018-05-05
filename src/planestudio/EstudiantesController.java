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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import planestudio.Estudiante;

/**
 * FXML Controller class
 *
 * @author obaquerog
 */
public class EstudiantesController implements Initializable {

    @FXML
    TextField txtCodigo;

    @FXML
    TextField txtNombres;

    @FXML
    TextField txtApellidos;

    @FXML
    TextField txtTelefono;

    @FXML
    TextField txtCorreo;

    @FXML
    Button btnConsultar;
    @FXML
    Button btnNuevo;
    @FXML
    Button btnActualizar;
    @FXML
    Button btnGuardar;
    @FXML
    Button btnEditar;

    @FXML
    TableView<Estudiante> twEstudiantes;
    @FXML
    TableColumn tcCodigo;
    @FXML
    TableColumn tcNombres;
    @FXML
    TableColumn tcApellidos;
    @FXML
    TableColumn tcTelefono;
    @FXML
    TableColumn tcCorreo;

    ObservableList<Estudiante> estudiantes;
    String codigo, nombres, apellidos, telefono, correo;
    int posicionEstudianteEnTabla, idEstudiante;

    ConectarBase conectar = new ConectarBase();
    Connection con = conectar.conexion();
    PreparedStatement pst;
    ResultSet rs;
    String sql;

    private final ListChangeListener<Estudiante> selectorTablaEstudiantes
            = new ListChangeListener<Estudiante>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends Estudiante> c) {
            ponerEstudianteSeleccionado();
        }
    };

    /**
     * PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaPersonas"
     */
    public Estudiante getTablaEstudianteSeleccionado() {
        if (twEstudiantes != null) {
            List<Estudiante> tabla = twEstudiantes.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Estudiante competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    /**
     * Método para poner en los textFields la tupla que selccionemos
     */
    private void ponerEstudianteSeleccionado() {
        final Estudiante estudiante = getTablaEstudianteSeleccionado();
        posicionEstudianteEnTabla = estudiantes.indexOf(estudiante);

        if (estudiante != null) {

            // Pongo los textFields con los datos correspondientes
            idEstudiante = estudiante.getId();
            txtCodigo.setText(estudiante.getCodigo());
            txtNombres.setText(estudiante.getNombres());
            txtApellidos.setText(estudiante.getApellidos());
            txtTelefono.setText(estudiante.getTelefono());
            txtCorreo.setText(estudiante.getCorreo());
            // Pongo los botones en su estado correspondiente
            btnEditar.setDisable(false);
            btnGuardar.setDisable(true);
            btnActualizar.setDisable(true);
            this.EdiableTextField(false);

        }
    }

    /**
     * Método para inicializar la tabla
     */
    private void inicializarTablaEstudiantes() {
        tcCodigo.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("codigo"));
        tcNombres.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("nombres"));
        tcApellidos.setCellValueFactory(new PropertyValueFactory<Estudiante, Integer>("apellidos"));
        tcTelefono.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("telefono"));
        tcCorreo.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("correo"));

        estudiantes = FXCollections.observableArrayList();
        twEstudiantes.setItems(estudiantes);
    }

    public void EdiableTextField(boolean valor) {
        txtNombres.setEditable(valor);
        txtApellidos.setEditable(valor);
        txtTelefono.setEditable(valor);
        txtCorreo.setEditable(valor);
    }

    public void limpiarTextField() {
        txtNombres.setText("");
        txtApellidos.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
    }

    public void cargarDatosTableView(String sql) {
        btnActualizar.setDisable(true);
        btnGuardar.setDisable(true);
        btnEditar.setDisable(true);
        this.inicializarTablaEstudiantes();
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Estudiante obtenerEstudiante = new Estudiante();
                obtenerEstudiante.id.set(rs.getInt(1));
                obtenerEstudiante.codigo.set(rs.getString(2));
                obtenerEstudiante.nombres.set(rs.getString(3));
                obtenerEstudiante.apellidos.set(rs.getString(4));
                obtenerEstudiante.telefono.set(rs.getString(5));
                obtenerEstudiante.correo.set(rs.getString(6));
                estudiantes.add(obtenerEstudiante);
            }
            System.out.println("Estudiante Consultado correctamente");

        } catch (SQLException ex) {
            Logger.getLogger(EstudiantesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargarTodosEstudiantes() {
        sql = "SELECT id,codigo,nombres,apellidos,telefono,correo FROM estudiantes ";
        this.cargarDatosTableView(sql);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        this.EdiableTextField(false);
        // Inicializamos la tabla

        // Seleccionar las tuplas de la tabla de las personas
        final ObservableList<Estudiante> tablaPersonaSel = twEstudiantes.getSelectionModel().getSelectedItems();
        tablaPersonaSel.addListener(selectorTablaEstudiantes);
        this.cargarTodosEstudiantes();

    }

    @FXML
    public void accionConsultar(ActionEvent event) {
        sql = "SELECT id,codigo,nombres,apellidos,telefono,correo FROM estudiantes WHERE codigo LIKE'%" + txtCodigo.getText() + "%'";
        this.cargarDatosTableView(sql);
        this.limpiarTextField();
    }

    @FXML
    public void accionNuevo(ActionEvent event) {
        this.limpiarTextField();
        txtCodigo.setText("");
        this.EdiableTextField(true);
        // Pongo los botones en su estado correspondiente
        btnActualizar.setDisable(true);
        btnEditar.setDisable(true);
        btnGuardar.setDisable(false);
    }

    @FXML
    public void accionEditar(ActionEvent event) {
        this.EdiableTextField(true);
        // Pongo los botones en su estado correspondiente
        btnActualizar.setDisable(false);
        btnEditar.setDisable(true);
        btnGuardar.setDisable(true);
    }

    @FXML
    public void accionActualizar(ActionEvent event) {
        if (!this.validarTextField()) {
            return;
        }
        sql = "UPDATE estudiantes SET codigo = ?,nombres = ?, apellidos = ?, telefono = ?, correo = ? WHERE id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, codigo);
            pst.setString(2, nombres);
            pst.setString(3, apellidos);
            pst.setString(4, telefono);
            pst.setString(5, correo);
            pst.setInt(6, idEstudiante);
            pst.executeUpdate();
            if (pst.getUpdateCount() > 0) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Plan de Estudio - EIS");
                alert.setHeaderText(null);
                alert.setContentText("El estudiante ha sido actualizado correctamente.");
                alert.showAndWait();
                this.limpiarTextField();
                this.cargarTodosEstudiantes();
            } else {
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

    public boolean validarTextField() {
        codigo = txtCodigo.getText();
        nombres = txtNombres.getText();
        apellidos = txtApellidos.getText();
        telefono = txtTelefono.getText();
        correo = txtCorreo.getText();
        if (codigo.isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Plan de Estudio - EIS");
            alert.setHeaderText(null);
            alert.setContentText("El campo código esta vacio.");
            alert.showAndWait();
            return false;
        }
        if (nombres.isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Plan de Estudio - EIS");
            alert.setHeaderText(null);
            alert.setContentText("El campo nombres esta vacio.");
            alert.showAndWait();
            return false;
        }
        if (apellidos.isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Plan de Estudio - EIS");
            alert.setHeaderText(null);
            alert.setContentText("El campo apellidos esta vacio.");
            alert.showAndWait();
            return false;
        }
        if (telefono.isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Plan de Estudio - EIS");
            alert.setHeaderText(null);
            alert.setContentText("El campo teléfono esta vacio.");
            alert.showAndWait();
            return false;
        }
        if (correo.isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Plan de Estudio - EIS");
            alert.setHeaderText(null);
            alert.setContentText("El campo correo esta vacio.");
            alert.showAndWait();
            return false;
        }
        return true;
    }

    @FXML
    public void accionGuardar(ActionEvent event) {
        if (!this.validarTextField()) {
            return;
        }
        sql = "INSERT INTO estudiantes (codigo,nombres,apellidos,telefono,correo)" + "VALUES(?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, codigo);
            pst.setString(2, nombres);
            pst.setString(3, apellidos);
            pst.setString(4, telefono);
            pst.setString(5, correo);
            pst.executeUpdate();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Plan de Estudio - EIS");
            alert.setHeaderText(null);
            alert.setContentText("El estudiante ha sido registrado correctamente.");
            alert.showAndWait();
            txtCodigo.setText("");
            this.limpiarTextField();
            this.cargarTodosEstudiantes();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Plan de Estudio - EIS");
            alert.setHeaderText(null);
            alert.setContentText("El estudiante no ha sido registrado.");
            alert.showAndWait();
        }
    }
}
