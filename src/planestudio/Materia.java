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
public class Materia {

    public SimpleIntegerProperty id = new SimpleIntegerProperty();
    public SimpleStringProperty codigo = new SimpleStringProperty();
    public SimpleStringProperty nombre = new SimpleStringProperty();
    public SimpleStringProperty semestre = new SimpleStringProperty();

    public String getCodigo() {
        return codigo.get();
    }

    public String getNombre() {
        return nombre.get();
    }

    public String getSemestre() {
        return semestre.get();
    }

    public Integer getId() {
        return id.get();
    }
    
    @Override
    public String toString(){
     return nombre.get();
    }
}
