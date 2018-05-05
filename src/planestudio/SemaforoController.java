/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planestudio;

import static java.awt.Color.green;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author obaquerog
 */
public class SemaforoController implements Initializable {

    //region Declarar objetos
    @FXML
    TextField txtCodigo;
    @FXML
    Button btnConsultar;
    @FXML
    Text tCodigo;
    @FXML
    Text tNombres;
    @FXML
    Text tApellidos;
    @FXML
    Pane pane1S1, pane1S2, pane1S3, pane1S4, pane1S5, pane1S6, pane1S7, pane1S8, pane1S9, pane1S10, pane2S1, pane2S2, pane2S3, pane2S4,
            pane2S5, pane2S6, pane2S7, pane2S8, pane2S9, pane2S10, pane3S1, pane3S2, pane3S3, pane3S4, pane3S5, pane3S6, pane3S7, pane3S8, pane3S9,
            pane3S10, pane4S1, pane4S2, pane4S3, pane4S4, pane4S5, pane4S6, pane4S7, pane4S8, pane4S9, pane4S10, pane5S1, pane5S2, pane5S3, pane5S4,
            pane5S5, pane5S6, pane5S7, pane5S8, pane5S9, pane5S10, pane6S1, pane6S2, pane6S3, pane6S4, pane6S5, pane6S6, pane6S7, pane6S8, pane6S9,
            pane6S10;

    @FXML
    Label lCodigo1S1, lCodigo1S2, lCodigo1S3, lCodigo1S4, lCodigo1S5, lCodigo1S6, lCodigo1S7, lCodigo1S8, lCodigo1S9, lCodigo1S10, lCodigo2S1,
            lCodigo2S2, lCodigo2S3, lCodigo2S4, lCodigo2S5, lCodigo2S6, lCodigo2S7, lCodigo2S8, lCodigo2S9, lCodigo2S10, lCodigo3S1, lCodigo3S2, lCodigo3S3,
            lCodigo3S4, lCodigo3S5, lCodigo3S6, lCodigo3S7, lCodigo3S8, lCodigo3S9, lCodigo3S10, lCodigo4S1, lCodigo4S2, lCodigo4S3, lCodigo4S4, lCodigo4S5,
            lCodigo4S6, lCodigo4S7, lCodigo4S8, lCodigo4S9, lCodigo4S10, lCodigo5S1, lCodigo5S2, lCodigo5S3, lCodigo5S4, lCodigo5S5, lCodigo5S6, lCodigo5S7,
            lCodigo5S8, lCodigo5S9, lCodigo5S10, lCodigo6S1, lCodigo6S2, lCodigo6S3, lCodigo6S4, lCodigo6S5, lCodigo6S6, lCodigo6S7, lCodigo6S8, lCodigo6S9,
            lCodigo6S10;

    @FXML
    Label lNombre1S1, lNombre1S2, lNombre1S3, lNombre1S4, lNombre1S5, lNombre1S6, lNombre1S7, lNombre1S8, lNombre1S9, lNombre1S10, lNombre2S1, lNombre2S2,
            lNombre2S3, lNombre2S4, lNombre2S5, lNombre2S6, lNombre2S7, lNombre2S8, lNombre2S9, lNombre2S10, lNombre3S1, lNombre3S2, lNombre3S3, lNombre3S4,
            lNombre3S5, lNombre3S6, lNombre3S7, lNombre3S8, lNombre3S9, lNombre3S10, lNombre4S1, lNombre4S2, lNombre4S3, lNombre4S4, lNombre4S5, lNombre4S6,
            lNombre4S7, lNombre4S8, lNombre4S9, lNombre4S10, lNombre5S1, lNombre5S2, lNombre5S3, lNombre5S4, lNombre5S5, lNombre5S6, lNombre5S7, lNombre5S8,
            lNombre5S9, lNombre5S10, lNombre6S1, lNombre6S2, lNombre6S3, lNombre6S4, lNombre6S5, lNombre6S6, lNombre6S7, lNombre6S8, lNombre6S9,
            lNombre6S10;

    @FXML
    Label lNota1S1, lNota1S2, lNota1S3, lNota1S4, lNota1S5, lNota1S6, lNota1S7, lNota1S8, lNota1S9, lNota1S10, lNota2S1, lNota2S2,
            lNota2S3, lNota2S4, lNota2S5, lNota2S6, lNota2S7, lNota2S8, lNota2S9, lNota2S10, lNota3S1, lNota3S2, lNota3S3, lNota3S4,
            lNota3S5, lNota3S6, lNota3S7, lNota3S8, lNota3S9, lNota3S10, lNota4S1, lNota4S2, lNota4S3, lNota4S4, lNota4S5, lNota4S6,
            lNota4S7, lNota4S8, lNota4S9, lNota4S10, lNota5S1, lNota5S2, lNota5S3, lNota5S4, lNota5S5, lNota5S6, lNota5S7, lNota5S8,
            lNota5S9, lNota5S10, lNota6S1, lNota6S2, lNota6S3, lNota6S4, lNota6S5, lNota6S6, lNota6S7, lNota6S8, lNota6S9,
            lNota6S10;
    //endregion

    ConectarBase conectar = new ConectarBase();
    Connection con = conectar.conexion();
    PreparedStatement pst;
    ResultSet rs;
    String sql;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.deshabilitarHbox();
    }

    public void deshabilitarHbox() {
        pane1S1.setOpacity(0);
        pane1S2.setOpacity(0);
        pane1S3.setOpacity(0);
        pane1S4.setOpacity(0);
        pane1S5.setOpacity(0);
        pane1S6.setOpacity(0);
        pane1S7.setOpacity(0);
        pane1S8.setOpacity(0);
        pane1S9.setOpacity(0);
        pane1S10.setOpacity(0);
        pane2S1.setOpacity(0);
        pane2S2.setOpacity(0);
        pane2S3.setOpacity(0);
        pane2S4.setOpacity(0);
        pane2S5.setOpacity(0);
        pane2S6.setOpacity(0);
        pane2S7.setOpacity(0);
        pane2S8.setOpacity(0);
        pane2S9.setOpacity(0);
        pane2S10.setOpacity(0);
        pane3S1.setOpacity(0);
        pane3S2.setOpacity(0);
        pane3S3.setOpacity(0);
        pane3S4.setOpacity(0);
        pane3S5.setOpacity(0);
        pane3S6.setOpacity(0);
        pane3S7.setOpacity(0);
        pane3S8.setOpacity(0);
        pane3S9.setOpacity(0);
        pane3S10.setOpacity(0);
        pane4S1.setOpacity(0);
        pane4S2.setOpacity(0);
        pane4S3.setOpacity(0);
        pane4S4.setOpacity(0);
        pane4S5.setOpacity(0);
        pane4S6.setOpacity(0);
        pane4S7.setOpacity(0);
        pane4S8.setOpacity(0);
        pane4S9.setOpacity(0);
        pane4S10.setOpacity(0);
        pane5S1.setOpacity(0);
        pane5S2.setOpacity(0);
        pane5S3.setOpacity(0);
        pane5S4.setOpacity(0);
        pane5S5.setOpacity(0);
        pane5S6.setOpacity(0);
        pane5S7.setOpacity(0);
        pane5S8.setOpacity(0);
        pane5S9.setOpacity(0);
        pane5S10.setOpacity(0);
        pane6S1.setOpacity(0);
        pane6S2.setOpacity(0);
        pane6S3.setOpacity(0);
        pane6S4.setOpacity(0);
        pane6S5.setOpacity(0);
        pane6S6.setOpacity(0);
        pane6S7.setOpacity(0);
        pane6S8.setOpacity(0);
        pane6S9.setOpacity(0);
        pane6S10.setOpacity(0);
    }

    @FXML
    public void accionConsultar(ActionEvent event) {
        String dato = null;
        sql = "SELECT id,codigo,nombres,apellidos FROM estudiantes WHERE codigo ='" + txtCodigo.getText() + "'";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                dato = rs.getString(1);
                tCodigo.setText(rs.getString(2));
                tNombres.setText(rs.getString(3));
                tApellidos.setText(rs.getString(4));
            }
            if (dato != null) {
                sql = "select m.id,m.codigo,m.nombre,n.periodo,n.ano,n.nota,m.linea,m.semestre,n.estudiantes_id,(SELECT COUNT(nc.materias_id) from notas nc where nc.materias_id=n.materias_id and nc.estudiantes_id=n.estudiantes_id) as cantidad from materias m\n"
                        + "left join (select max(n2.id) as id,max(n2.ano) as ano,max(n2.nota) as nota,n2.materias_id,n2.estudiantes_id,max(n2.periodo) as periodo\n"
                        + "from notas n2\n"
                        + "where n2.estudiantes_id='" + dato + "' \n"
                        + "group by n2.estudiantes_id,n2.materias_id\n"
                        + ") n on n.materias_id=m.id";
                try {
                    pst = con.prepareStatement(sql);
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        switch (rs.getString(8)) {
                            case "1":
                                switch (rs.getString(7)) {
                                    case "1":
                                        if (rs.getInt(10) == 1) {
                                            pane1S1.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane1S1.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane1S1.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane1S1.setOpacity(1);
                                        lCodigo1S1.setText(rs.getString(2));
                                        lNombre1S1.setText(rs.getString(3));
                                        lNota1S1.setText(rs.getString(6));
                                        break;
                                    case "2":
                                        if (rs.getInt(10) == 1) {
                                            pane2S1.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane2S1.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane2S1.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane2S1.setOpacity(1);
                                        lCodigo2S1.setText(rs.getString(2));
                                        lNombre2S1.setText(rs.getString(3));
                                        lNota2S1.setText(rs.getString(6));
                                        break;
                                    case "3":
                                        if (rs.getInt(10) == 1) {
                                            pane3S1.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane3S1.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane3S1.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane3S1.setOpacity(1);
                                        lCodigo3S1.setText(rs.getString(2));
                                        lNombre3S1.setText(rs.getString(3));
                                        lNota3S1.setText(rs.getString(6));
                                        break;
                                    case "4":
                                        if (rs.getInt(10) == 1) {
                                            pane4S1.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane4S1.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane4S1.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane4S1.setOpacity(1);
                                        lCodigo4S1.setText(rs.getString(2));
                                        lNombre4S1.setText(rs.getString(3));
                                        lNota4S1.setText(rs.getString(6));
                                        break;
                                    case "5":
                                        if (rs.getInt(10) == 1) {
                                            pane5S1.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane5S1.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane5S1.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane5S1.setOpacity(1);
                                        lCodigo5S1.setText(rs.getString(2));
                                        lNombre5S1.setText(rs.getString(3));
                                        lNota5S1.setText(rs.getString(6));
                                        break;
                                    case "6":
                                        if (rs.getInt(10) == 1) {
                                            pane6S1.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane6S1.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane6S1.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane6S1.setOpacity(1);
                                        lCodigo6S1.setText(rs.getString(2));
                                        lNombre6S1.setText(rs.getString(3));
                                        lNota6S1.setText(rs.getString(6));
                                        break;
                                }
                                break;
                            case "2":
                                switch (rs.getString(7)) {
                                    case "1":
                                        if (rs.getInt(10) == 1) {
                                            pane1S2.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane1S2.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane1S2.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane1S2.setOpacity(1);
                                        lCodigo1S2.setText(rs.getString(2));
                                        lNombre1S2.setText(rs.getString(3));
                                        lNota1S2.setText(rs.getString(6));
                                        break;
                                    case "2":
                                        if (rs.getInt(10) == 1) {
                                            pane2S2.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane2S2.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane2S2.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane2S2.setOpacity(1);
                                        lCodigo2S2.setText(rs.getString(2));
                                        lNombre2S2.setText(rs.getString(3));
                                        lNota2S2.setText(rs.getString(6));
                                        break;
                                    case "3":
                                        if (rs.getInt(10) == 1) {
                                            pane3S2.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane3S2.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane3S2.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane3S2.setOpacity(1);
                                        lCodigo3S2.setText(rs.getString(2));
                                        lNombre3S2.setText(rs.getString(3));
                                        lNota3S2.setText(rs.getString(6));
                                        break;
                                    case "4":
                                        if (rs.getInt(10) == 1) {
                                            pane4S2.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane4S2.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane4S2.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane4S2.setOpacity(1);
                                        lCodigo4S2.setText(rs.getString(2));
                                        lNombre4S2.setText(rs.getString(3));
                                        lNota4S2.setText(rs.getString(6));
                                        break;
                                    case "5":
                                        if (rs.getInt(10) == 1) {
                                            pane5S2.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane5S2.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane5S2.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane5S2.setOpacity(1);
                                        lCodigo5S2.setText(rs.getString(2));
                                        lNombre5S2.setText(rs.getString(3));
                                        lNota5S2.setText(rs.getString(6));
                                        break;
                                    case "6":
                                        if (rs.getInt(10) == 1) {
                                            pane6S2.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane6S2.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane6S2.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane6S2.setOpacity(1);
                                        lCodigo6S2.setText(rs.getString(2));
                                        lNombre6S2.setText(rs.getString(3));
                                        lNota6S2.setText(rs.getString(6));
                                        break;
                                }
                                break;
                            case "3":
                                switch (rs.getString(7)) {
                                    case "1":
                                        if (rs.getInt(10) == 1) {
                                            pane1S3.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane1S3.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane1S3.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane1S3.setOpacity(1);
                                        lCodigo1S3.setText(rs.getString(2));
                                        lNombre1S3.setText(rs.getString(3));
                                        lNota1S3.setText(rs.getString(6));
                                        break;
                                    case "2":
                                        if (rs.getInt(10) == 1) {
                                            pane2S3.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane2S3.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane2S3.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane2S3.setOpacity(1);
                                        lCodigo2S3.setText(rs.getString(2));
                                        lNombre2S3.setText(rs.getString(3));
                                        lNota2S3.setText(rs.getString(6));
                                        break;
                                    case "3":
                                        if (rs.getInt(10) == 1) {
                                            pane3S3.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane3S3.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane3S3.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane3S3.setOpacity(1);
                                        lCodigo3S3.setText(rs.getString(2));
                                        lNombre3S3.setText(rs.getString(3));
                                        lNota3S3.setText(rs.getString(6));
                                        break;
                                    case "4":
                                        if (rs.getInt(10) == 1) {
                                            pane4S3.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane4S3.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane4S3.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane4S3.setOpacity(1);
                                        lCodigo4S3.setText(rs.getString(2));
                                        lNombre4S3.setText(rs.getString(3));
                                        lNota4S3.setText(rs.getString(6));
                                        break;
                                    case "5":
                                        if (rs.getInt(10) == 1) {
                                            pane5S3.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane5S3.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane5S3.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane5S3.setOpacity(1);
                                        lCodigo5S3.setText(rs.getString(2));
                                        lNombre5S3.setText(rs.getString(3));
                                        lNota5S3.setText(rs.getString(6));
                                        break;
                                    case "6":
                                        if (rs.getInt(10) == 1) {
                                            pane6S3.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane6S3.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane6S3.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane6S3.setOpacity(1);
                                        lCodigo6S3.setText(rs.getString(2));
                                        lNombre6S3.setText(rs.getString(3));
                                        lNota6S3.setText(rs.getString(6));
                                        break;
                                }
                                break;
                            case "4":
                                switch (rs.getString(7)) {
                                    case "1":
                                        if (rs.getInt(10) == 1) {
                                            pane1S4.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane1S4.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane1S4.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane1S4.setOpacity(1);
                                        lCodigo1S4.setText(rs.getString(2));
                                        lNombre1S4.setText(rs.getString(3));
                                        lNota1S4.setText(rs.getString(6));
                                        break;
                                    case "2":
                                        if (rs.getInt(10) == 1) {
                                            pane2S4.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane2S4.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane2S4.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane2S4.setOpacity(1);
                                        lCodigo2S4.setText(rs.getString(2));
                                        lNombre2S4.setText(rs.getString(3));
                                        lNota2S4.setText(rs.getString(6));
                                        break;
                                    case "3":
                                        if (rs.getInt(10) == 1) {
                                            pane3S4.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane3S4.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane3S4.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane3S4.setOpacity(1);
                                        lCodigo3S4.setText(rs.getString(2));
                                        lNombre3S4.setText(rs.getString(3));
                                        lNota3S4.setText(rs.getString(6));
                                        break;
                                    case "4":
                                        if (rs.getInt(10) == 1) {
                                            pane4S4.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane4S4.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane4S4.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane4S4.setOpacity(1);
                                        lCodigo4S4.setText(rs.getString(2));
                                        lNombre4S4.setText(rs.getString(3));
                                        lNota4S4.setText(rs.getString(6));
                                        break;
                                    case "5":
                                        if (rs.getInt(10) == 1) {
                                            pane5S4.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane5S4.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane5S4.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane5S4.setOpacity(1);
                                        lCodigo5S4.setText(rs.getString(2));
                                        lNombre5S4.setText(rs.getString(3));
                                        lNota5S4.setText(rs.getString(6));
                                        break;
                                    case "6":
                                        if (rs.getInt(10) == 1) {
                                            pane6S4.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane6S4.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane6S4.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane6S4.setOpacity(1);
                                        lCodigo6S4.setText(rs.getString(2));
                                        lNombre6S4.setText(rs.getString(3));
                                        lNota6S4.setText(rs.getString(6));
                                        break;
                                }
                                break;
                            case "5":
                                switch (rs.getString(7)) {
                                    case "1":
                                        if (rs.getInt(10) == 1) {
                                            pane1S5.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane1S5.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane1S5.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane1S5.setOpacity(1);
                                        lCodigo1S5.setText(rs.getString(2));
                                        lNombre1S5.setText(rs.getString(3));
                                        lNota1S5.setText(rs.getString(6));
                                        break;
                                    case "2":
                                        if (rs.getInt(10) == 1) {
                                            pane2S5.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane2S5.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane2S5.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane2S5.setOpacity(1);
                                        lCodigo2S5.setText(rs.getString(2));
                                        lNombre2S5.setText(rs.getString(3));
                                        lNota2S5.setText(rs.getString(6));
                                        break;
                                    case "3":
                                        if (rs.getInt(10) == 1) {
                                            pane3S5.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane3S5.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane3S5.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane3S5.setOpacity(1);
                                        lCodigo3S5.setText(rs.getString(2));
                                        lNombre3S5.setText(rs.getString(3));
                                        lNota3S5.setText(rs.getString(6));
                                        break;
                                    case "4":
                                        if (rs.getInt(10) == 1) {
                                            pane4S5.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane4S5.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane4S5.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane4S5.setOpacity(1);
                                        lCodigo4S5.setText(rs.getString(2));
                                        lNombre4S5.setText(rs.getString(3));
                                        lNota4S5.setText(rs.getString(6));
                                        break;
                                    case "5":
                                        if (rs.getInt(10) == 1) {
                                            pane5S5.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane5S5.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane5S5.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane5S5.setOpacity(1);
                                        lCodigo5S5.setText(rs.getString(2));
                                        lNombre5S5.setText(rs.getString(3));
                                        lNota5S5.setText(rs.getString(6));
                                        break;
                                    case "6":
                                        if (rs.getInt(10) == 1) {
                                            pane6S5.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane6S5.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane6S5.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane6S5.setOpacity(1);
                                        lCodigo6S5.setText(rs.getString(2));
                                        lNombre6S5.setText(rs.getString(3));
                                        lNota6S5.setText(rs.getString(6));
                                        break;
                                }
                                break;
                            case "6":
                                switch (rs.getString(7)) {
                                    case "1":
                                        if (rs.getInt(10) == 1) {
                                            pane1S6.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane1S6.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane1S6.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane1S6.setOpacity(1);
                                        lCodigo1S6.setText(rs.getString(2));
                                        lNombre1S6.setText(rs.getString(3));
                                        lNota1S6.setText(rs.getString(6));
                                        break;
                                    case "2":
                                        if (rs.getInt(10) == 1) {
                                            pane2S6.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane2S6.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane2S6.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane2S6.setOpacity(1);
                                        lCodigo2S6.setText(rs.getString(2));
                                        lNombre2S6.setText(rs.getString(3));
                                        lNota2S6.setText(rs.getString(6));
                                        break;
                                    case "3":
                                        if (rs.getInt(10) == 1) {
                                            pane3S6.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane3S6.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane3S6.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane3S6.setOpacity(1);
                                        lCodigo3S6.setText(rs.getString(2));
                                        lNombre3S6.setText(rs.getString(3));
                                        lNota3S6.setText(rs.getString(6));
                                        break;
                                    case "4":
                                        if (rs.getInt(10) == 1) {
                                            pane4S6.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane4S6.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane4S6.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane4S6.setOpacity(1);
                                        lCodigo4S6.setText(rs.getString(2));
                                        lNombre4S6.setText(rs.getString(3));
                                        lNota4S6.setText(rs.getString(6));
                                        break;
                                    case "5":
                                        if (rs.getInt(10) == 1) {
                                            pane5S6.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane5S6.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane5S6.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane5S6.setOpacity(1);
                                        lCodigo5S6.setText(rs.getString(2));
                                        lNombre5S6.setText(rs.getString(3));
                                        lNota5S6.setText(rs.getString(6));
                                        break;
                                    case "6":
                                        if (rs.getInt(10) == 1) {
                                            pane6S6.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane6S6.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane6S6.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane6S6.setOpacity(1);
                                        lCodigo6S6.setText(rs.getString(2));
                                        lNombre6S6.setText(rs.getString(3));
                                        lNota6S6.setText(rs.getString(6));
                                        break;
                                }
                                break;
                            case "7":
                                switch (rs.getString(7)) {
                                    case "1":
                                        if (rs.getInt(10) == 1) {
                                            pane1S7.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane1S7.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane1S7.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane1S7.setOpacity(1);
                                        lCodigo1S7.setText(rs.getString(2));
                                        lNombre1S7.setText(rs.getString(3));
                                        lNota1S7.setText(rs.getString(6));
                                        break;
                                    case "2":
                                        if (rs.getInt(10) == 1) {
                                            pane2S7.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane2S7.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane2S7.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane2S7.setOpacity(1);
                                        lCodigo2S7.setText(rs.getString(2));
                                        lNombre2S7.setText(rs.getString(3));
                                        lNota2S7.setText(rs.getString(6));
                                        break;
                                    case "3":
                                        if (rs.getInt(10) == 1) {
                                            pane3S7.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane3S7.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane3S7.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane3S7.setOpacity(1);
                                        lCodigo3S7.setText(rs.getString(2));
                                        lNombre3S7.setText(rs.getString(3));
                                        lNota3S7.setText(rs.getString(6));
                                        break;
                                    case "4":
                                        if (rs.getInt(10) == 1) {
                                            pane4S7.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane4S7.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane4S7.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane4S7.setOpacity(1);
                                        lCodigo4S7.setText(rs.getString(2));
                                        lNombre4S7.setText(rs.getString(3));
                                        lNota4S7.setText(rs.getString(6));
                                        break;
                                    case "5":
                                        if (rs.getInt(10) == 1) {
                                            pane5S7.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane5S7.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane5S7.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane5S7.setOpacity(1);
                                        lCodigo5S7.setText(rs.getString(2));
                                        lNombre5S7.setText(rs.getString(3));
                                        lNota5S7.setText(rs.getString(6));
                                        break;
                                    case "6":
                                        if (rs.getInt(10) == 1) {
                                            pane6S7.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane6S7.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane6S7.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane6S7.setOpacity(1);
                                        lCodigo6S7.setText(rs.getString(2));
                                        lNombre6S7.setText(rs.getString(3));
                                        lNota6S7.setText(rs.getString(6));
                                        break;
                                }
                                break;
                            case "8":
                                switch (rs.getString(7)) {
                                    case "1":
                                        if (rs.getInt(10) == 1) {
                                            pane1S8.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane1S8.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane1S8.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane1S8.setOpacity(1);
                                        lCodigo1S8.setText(rs.getString(2));
                                        lNombre1S8.setText(rs.getString(3));
                                        lNota1S8.setText(rs.getString(6));
                                        break;
                                    case "2":
                                        if (rs.getInt(10) == 1) {
                                            pane2S8.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane2S8.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane2S8.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane2S8.setOpacity(1);
                                        lCodigo2S8.setText(rs.getString(2));
                                        lNombre2S8.setText(rs.getString(3));
                                        lNota2S8.setText(rs.getString(6));
                                        break;
                                    case "3":
                                        if (rs.getInt(10) == 1) {
                                            pane3S8.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane3S8.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane3S8.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane3S8.setOpacity(1);
                                        lCodigo3S8.setText(rs.getString(2));
                                        lNombre3S8.setText(rs.getString(3));
                                        lNota3S8.setText(rs.getString(6));
                                        break;
                                    case "4":
                                        if (rs.getInt(10) == 1) {
                                            pane4S8.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane4S8.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane4S8.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane4S8.setOpacity(1);
                                        lCodigo4S8.setText(rs.getString(2));
                                        lNombre4S8.setText(rs.getString(3));
                                        lNota4S8.setText(rs.getString(6));
                                        break;
                                    case "5":
                                        if (rs.getInt(10) == 1) {
                                            pane5S8.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane5S8.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane5S8.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane5S8.setOpacity(1);
                                        lCodigo5S8.setText(rs.getString(2));
                                        lNombre5S8.setText(rs.getString(3));
                                        lNota5S8.setText(rs.getString(6));
                                        break;
                                    case "6":
                                        if (rs.getInt(10) == 1) {
                                            pane6S8.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane6S8.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane6S8.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane6S8.setOpacity(1);
                                        lCodigo6S8.setText(rs.getString(2));
                                        lNombre6S8.setText(rs.getString(3));
                                        lNota6S8.setText(rs.getString(6));
                                        break;
                                }
                                break;
                            case "9":
                                switch (rs.getString(7)) {
                                    case "1":
                                        if (rs.getInt(10) == 1) {
                                            pane1S9.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane1S9.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane1S9.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane1S9.setOpacity(1);
                                        lCodigo1S9.setText(rs.getString(2));
                                        lNombre1S9.setText(rs.getString(3));
                                        lNota1S9.setText(rs.getString(6));
                                        break;
                                    case "2":
                                        if (rs.getInt(10) == 1) {
                                            pane2S9.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane2S9.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane2S9.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane2S9.setOpacity(1);
                                        lCodigo2S9.setText(rs.getString(2));
                                        lNombre2S9.setText(rs.getString(3));
                                        lNota2S9.setText(rs.getString(6));
                                        break;
                                    case "3":
                                        if (rs.getInt(10) == 1) {
                                            pane3S9.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane3S9.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane3S9.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane3S9.setOpacity(1);
                                        lCodigo3S9.setText(rs.getString(2));
                                        lNombre3S9.setText(rs.getString(3));
                                        lNota3S9.setText(rs.getString(6));
                                        break;
                                    case "4":
                                        if (rs.getInt(10) == 1) {
                                            pane4S9.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane4S9.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane4S9.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane4S9.setOpacity(1);
                                        lCodigo4S9.setText(rs.getString(2));
                                        lNombre4S9.setText(rs.getString(3));
                                        lNota4S9.setText(rs.getString(6));
                                        break;
                                    case "5":
                                        if (rs.getInt(10) == 1) {
                                            pane5S9.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane5S9.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane5S9.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane5S9.setOpacity(1);
                                        lCodigo5S9.setText(rs.getString(2));
                                        lNombre5S9.setText(rs.getString(3));
                                        lNota5S9.setText(rs.getString(6));
                                        break;
                                    case "6":
                                        if (rs.getInt(10) == 1) {
                                            pane6S9.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane6S9.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane6S9.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane6S9.setOpacity(1);
                                        lCodigo6S9.setText(rs.getString(2));
                                        lNombre6S9.setText(rs.getString(3));
                                        lNota6S9.setText(rs.getString(6));
                                        break;
                                }
                                break;
                            case "10":
                                switch (rs.getString(7)) {
                                    case "1":
                                        if (rs.getInt(10) == 1) {
                                            pane1S10.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane1S10.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane1S10.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane1S10.setOpacity(1);
                                        lCodigo1S10.setText(rs.getString(2));
                                        lNombre1S10.setText(rs.getString(3));
                                        lNota1S10.setText(rs.getString(6));
                                        break;
                                    case "2":
                                        if (rs.getInt(10) == 1) {
                                            pane2S10.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane2S10.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane2S10.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane2S10.setOpacity(1);
                                        lCodigo2S10.setText(rs.getString(2));
                                        lNombre2S10.setText(rs.getString(3));
                                        lNota2S10.setText(rs.getString(6));
                                        break;
                                    case "3":
                                        if (rs.getInt(10) == 1) {
                                            pane3S10.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane3S10.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane3S10.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane3S10.setOpacity(1);
                                        lCodigo3S10.setText(rs.getString(2));
                                        lNombre3S10.setText(rs.getString(3));
                                        lNota3S10.setText(rs.getString(6));
                                        break;
                                    case "4":
                                        if (rs.getInt(10) == 1) {
                                            pane4S10.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane4S10.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane4S10.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane4S10.setOpacity(1);
                                        lCodigo4S10.setText(rs.getString(2));
                                        lNombre4S10.setText(rs.getString(3));
                                        lNota4S10.setText(rs.getString(6));
                                        break;
                                    case "5":
                                        if (rs.getInt(10) == 1) {
                                            pane5S10.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane5S10.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane5S10.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane5S10.setOpacity(1);
                                        lCodigo5S10.setText(rs.getString(2));
                                        lNombre5S10.setText(rs.getString(3));
                                        lNota5S10.setText(rs.getString(6));
                                        break;
                                    case "6":
                                        if (rs.getInt(10) == 1) {
                                            pane6S10.setStyle("-fx-background-color: #2EFE2E");
                                        } else if (rs.getInt(10) > 1) {
                                            pane6S10.setStyle("-fx-background-color: #F3F781");
                                        } else if (rs.getInt(10) == 0) {
                                            pane6S10.setStyle("-fx-background-color: #A4A4A4");
                                        }
                                        pane6S10.setOpacity(1);
                                        lCodigo6S10.setText(rs.getString(2));
                                        lNombre6S10.setText(rs.getString(3));
                                        lNota6S10.setText(rs.getString(6));
                                        break;
                                }
                                break;
                        }

                        System.out.println("Estudiante Consultado correctamente");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(SemaforoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                this.deshabilitarHbox();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Plan de Estudio - EIS");
                alert.setHeaderText(null);
                alert.setContentText("El estudiante no existe.");
                alert.showAndWait();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemaforoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
