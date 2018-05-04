/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planestudio;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author obaquerog
 */
public class Estudiante {
    public SimpleIntegerProperty id = new SimpleIntegerProperty();
    public SimpleStringProperty codigo = new SimpleStringProperty();
    public SimpleStringProperty nombres = new SimpleStringProperty();
    public SimpleStringProperty apellidos = new SimpleStringProperty();
    public SimpleStringProperty telefono = new SimpleStringProperty();
    public SimpleStringProperty correo = new SimpleStringProperty();

    public String getCodigo() {
        return codigo.get();
    }

    public String getNombres() {
        return nombres.get();
    }

    public String getApellidos() {
        return apellidos.get();
    }

    public String getTelefono() {
        return telefono.get();
    }

    public String getCorreo() {
        return correo.get();
    }

    public Integer getId() {
        return id.get();
    }
    
    
}
