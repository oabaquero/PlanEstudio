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
public class NotasEstudiante {

    public SimpleIntegerProperty id = new SimpleIntegerProperty();
    public SimpleIntegerProperty estudiantes_id = new SimpleIntegerProperty();
    public SimpleIntegerProperty materias_id = new SimpleIntegerProperty();
    public SimpleStringProperty codigo = new SimpleStringProperty();
    public SimpleStringProperty nombre = new SimpleStringProperty();
    public SimpleStringProperty periodo = new SimpleStringProperty();
    public SimpleStringProperty ano = new SimpleStringProperty();
    public SimpleStringProperty nota = new SimpleStringProperty();

    public Integer getId() {
        return id.get();
    }
    
    public Integer getMateriasId() {
        return materias_id.get();
    }
    
    public Integer getEstudiantesId() {
        return materias_id.get();
    }

    public String getCodigo() {
        return codigo.get();
    }

    public String getNombre() {
        return nombre.get();
    }

    public String getPeriodo() {
        return periodo.get();
    }

    public String getAno() {
        return ano.get();
    }
    
    public String getNota() {
        return nota.get();
    }
}