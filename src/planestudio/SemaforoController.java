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
    Pane pane1S1;
    @FXML
    Pane pane1S2;
    @FXML
    Pane pane1S3;
    @FXML
    Pane pane1S4;
    @FXML
    Pane pane1S5;
    @FXML
    Pane pane1S6;
    @FXML
    Pane pane1S7;
    @FXML
    Pane pane1S8;
    @FXML
    Pane pane1S9;
    @FXML
    Pane pane1S10;
    @FXML
    Pane pane2S1;
    @FXML
    Pane pane2S2;
    @FXML
    Pane pane2S3;
    @FXML
    Pane pane2S4;
    @FXML
    Pane pane2S5;
    @FXML
    Pane pane2S6;
    @FXML
    Pane pane2S7;
    @FXML
    Pane pane2S8;
    @FXML
    Pane pane2S9;
    @FXML
    Pane pane2S10;
    @FXML
    Pane pane3S1;
    @FXML
    Pane pane3S2;
    @FXML
    Pane pane3S3;
    @FXML
    Pane pane3S4;
    @FXML
    Pane pane3S5;
    @FXML
    Pane pane3S6;
    @FXML
    Pane pane3S7;
    @FXML
    Pane pane3S8;
    @FXML
    Pane pane3S9;
    @FXML
    Pane pane3S10;
    @FXML
    Pane pane4S1;
    @FXML
    Pane pane4S2;
    @FXML
    Pane pane4S3;
    @FXML
    Pane pane4S4;
    @FXML
    Pane pane4S5;
    @FXML
    Pane pane4S6;
    @FXML
    Pane pane4S7;
    @FXML
    Pane pane4S8;
    @FXML
    Pane pane4S9;
    @FXML
    Pane pane4S10;
    @FXML
    Pane pane5S1;
    @FXML
    Pane pane5S2;
    @FXML
    Pane pane5S3;
    @FXML
    Pane pane5S4;
    @FXML
    Pane pane5S5;
    @FXML
    Pane pane5S6;
    @FXML
    Pane pane5S7;
    @FXML
    Pane pane5S8;
    @FXML
    Pane pane5S9;
    @FXML
    Pane pane5S10;
    @FXML
    Pane pane6S1;
    @FXML
    Pane pane6S2;
    @FXML
    Pane pane6S3;
    @FXML
    Pane pane6S4;
    @FXML
    Pane pane6S5;
    @FXML
    Pane pane6S6;
    @FXML
    Pane pane6S7;
    @FXML
    Pane pane6S8;
    @FXML
    Pane pane6S9;
    @FXML
    Pane pane6S10;

    @FXML
    Label lCodigo1S1;
    @FXML
    Label lCodigo1S2;
    @FXML
    Label lCodigo1S3;
    @FXML
    Label lCodigo1S4;
    @FXML
    Label lCodigo1S5;
    @FXML
    Label lCodigo1S6;
    @FXML
    Label lCodigo1S7;
    @FXML
    Label lCodigo1S8;
    @FXML
    Label lCodigo1S9;
    @FXML
    Label lCodigo1S10;
    @FXML
    Label lCodigo2S1;
    @FXML
    Label lCodigo2S2;
    @FXML
    Label lCodigo2S3;
    @FXML
    Label lCodigo2S4;
    @FXML
    Label lCodigo2S5;
    @FXML
    Label lCodigo2S6;
    @FXML
    Label lCodigo2S7;
    @FXML
    Label lCodigo2S8;
    @FXML
    Label lCodigo2S9;
    @FXML
    Label lCodigo2S10;
    @FXML
    Label lCodigo3S1;
    @FXML
    Label lCodigo3S2;
    @FXML
    Label lCodigo3S3;
    @FXML
    Label lCodigo3S4;
    @FXML
    Label lCodigo3S5;
    @FXML
    Label lCodigo3S6;
    @FXML
    Label lCodigo3S7;
    @FXML
    Label lCodigo3S8;
    @FXML
    Label lCodigo3S9;
    @FXML
    Label lCodigo3S10;
    @FXML
    Label lCodigo4S1;
    @FXML
    Label lCodigo4S2;
    @FXML
    Label lCodigo4S3;
    @FXML
    Label lCodigo4S4;
    @FXML
    Label lCodigo4S5;
    @FXML
    Label lCodigo4S6;
    @FXML
    Label lCodigo4S7;
    @FXML
    Label lCodigo4S8;
    @FXML
    Label lCodigo4S9;
    @FXML
    Label lCodigo4S10;
    @FXML
    Label lCodigo5S1;
    @FXML
    Label lCodigo5S2;
    @FXML
    Label lCodigo5S3;
    @FXML
    Label lCodigo5S4;
    @FXML
    Label lCodigo5S5;
    @FXML
    Label lCodigo5S6;
    @FXML
    Label lCodigo5S7;
    @FXML
    Label lCodigo5S8;
    @FXML
    Label lCodigo5S9;
    @FXML
    Label lCodigo5S10;
    @FXML
    Label lCodigo6S1;
    @FXML
    Label lCodigo6S2;
    @FXML
    Label lCodigo6S3;
    @FXML
    Label lCodigo6S4;
    @FXML
    Label lCodigo6S5;
    @FXML
    Label lCodigo6S6;
    @FXML
    Label lCodigo6S7;
    @FXML
    Label lCodigo6S8;
    @FXML
    Label lCodigo6S9;
    @FXML
    Label lCodigo6S10;

    @FXML
    Label lNombre1S1;
    @FXML
    Label lNombre1S2;
    @FXML
    Label lNombre1S3;
    @FXML
    Label lNombre1S4;
    @FXML
    Label lNombre1S5;
    @FXML
    Label lNombre1S6;
    @FXML
    Label lNombre1S7;
    @FXML
    Label lNombre1S8;
    @FXML
    Label lNombre1S9;
    @FXML
    Label lNombre1S10;
    @FXML
    Label lNombre2S1;
    @FXML
    Label lNombre2S2;
    @FXML
    Label lNombre2S3;
    @FXML
    Label lNombre2S4;
    @FXML
    Label lNombre2S5;
    @FXML
    Label lNombre2S6;
    @FXML
    Label lNombre2S7;
    @FXML
    Label lNombre2S8;
    @FXML
    Label lNombre2S9;
    @FXML
    Label lNombre2S10;
    @FXML
    Label lNombre3S1;
    @FXML
    Label lNombre3S2;
    @FXML
    Label lNombre3S3;
    @FXML
    Label lNombre3S4;
    @FXML
    Label lNombre3S5;
    @FXML
    Label lNombre3S6;
    @FXML
    Label lNombre3S7;
    @FXML
    Label lNombre3S8;
    @FXML
    Label lNombre3S9;
    @FXML
    Label lNombre3S10;
    @FXML
    Label lNombre4S1;
    @FXML
    Label lNombre4S2;
    @FXML
    Label lNombre4S3;
    @FXML
    Label lNombre4S4;
    @FXML
    Label lNombre4S5;
    @FXML
    Label lNombre4S6;
    @FXML
    Label lNombre4S7;
    @FXML
    Label lNombre4S8;
    @FXML
    Label lNombre4S9;
    @FXML
    Label lNombre4S10;
    @FXML
    Label lNombre5S1;
    @FXML
    Label lNombre5S2;
    @FXML
    Label lNombre5S3;
    @FXML
    Label lNombre5S4;
    @FXML
    Label lNombre5S5;
    @FXML
    Label lNombre5S6;
    @FXML
    Label lNombre5S7;
    @FXML
    Label lNombre5S8;
    @FXML
    Label lNombre5S9;
    @FXML
    Label lNombre5S10;
    @FXML
    Label lNombre6S1;
    @FXML
    Label lNombre6S2;
    @FXML
    Label lNombre6S3;
    @FXML
    Label lNombre6S4;
    @FXML
    Label lNombre6S5;
    @FXML
    Label lNombre6S6;
    @FXML
    Label lNombre6S7;
    @FXML
    Label lNombre6S8;
    @FXML
    Label lNombre6S9;
    @FXML
    Label lNombre6S10;

    @FXML
    Label lNota1S1;
    @FXML
    Label lNota1S2;
    @FXML
    Label lNota1S3;
    @FXML
    Label lNota1S4;
    @FXML
    Label lNota1S5;
    @FXML
    Label lNota1S6;
    @FXML
    Label lNota1S7;
    @FXML
    Label lNota1S8;
    @FXML
    Label lNota1S9;
    @FXML
    Label lNota1S10;
    @FXML
    Label lNota2S1;
    @FXML
    Label lNota2S2;
    @FXML
    Label lNota2S3;
    @FXML
    Label lNota2S4;
    @FXML
    Label lNota2S5;
    @FXML
    Label lNota2S6;
    @FXML
    Label lNota2S7;
    @FXML
    Label lNota2S8;
    @FXML
    Label lNota2S9;
    @FXML
    Label lNota2S10;
    @FXML
    Label lNota3S1;
    @FXML
    Label lNota3S2;
    @FXML
    Label lNota3S3;
    @FXML
    Label lNota3S4;
    @FXML
    Label lNota3S5;
    @FXML
    Label lNota3S6;
    @FXML
    Label lNota3S7;
    @FXML
    Label lNota3S8;
    @FXML
    Label lNota3S9;
    @FXML
    Label lNota3S10;
    @FXML
    Label lNota4S1;
    @FXML
    Label lNota4S2;
    @FXML
    Label lNota4S3;
    @FXML
    Label lNota4S4;
    @FXML
    Label lNota4S5;
    @FXML
    Label lNota4S6;
    @FXML
    Label lNota4S7;
    @FXML
    Label lNota4S8;
    @FXML
    Label lNota4S9;
    @FXML
    Label lNota4S10;
    @FXML
    Label lNota5S1;
    @FXML
    Label lNota5S2;
    @FXML
    Label lNota5S3;
    @FXML
    Label lNota5S4;
    @FXML
    Label lNota5S5;
    @FXML
    Label lNota5S6;
    @FXML
    Label lNota5S7;
    @FXML
    Label lNota5S8;
    @FXML
    Label lNota5S9;
    @FXML
    Label lNota5S10;
    @FXML
    Label lNota6S1;
    @FXML
    Label lNota6S2;
    @FXML
    Label lNota6S3;
    @FXML
    Label lNota6S4;
    @FXML
    Label lNota6S5;
    @FXML
    Label lNota6S6;
    @FXML
    Label lNota6S7;
    @FXML
    Label lNota6S8;
    @FXML
    Label lNota6S9;
    @FXML
    Label lNota6S10;
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
             pst=con.prepareStatement(sql);
             rs=pst.executeQuery();
             while(rs.next()){
                 dato=rs.getString(1);
                 tCodigo.setText(rs.getString(2));
                 tNombres.setText(rs.getString(3));
                 tApellidos.setText(rs.getString(4));
             }
          if(dato!=null){   
        sql = "select m.id,m.codigo,m.nombre,n.periodo,n.ano,n.nota,m.linea,m.semestre,n.estudiantes_id,(SELECT COUNT(nc.materias_id) from notas nc where nc.materias_id=n.materias_id and nc.estudiantes_id=n.estudiantes_id) as cantidad from materias m\n" +
"left join (select max(n2.id) as id,max(n2.ano) as ano,max(n2.nota) as nota,n2.materias_id,n2.estudiantes_id,max(n2.periodo) as periodo\n" +
"from notas n2\n" +
"where n2.estudiantes_id='"+dato+"' \n" +
"group by n2.estudiantes_id,n2.materias_id\n" +
") n on n.materias_id=m.id" ;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                switch (rs.getString(8)) {
                    case "1":
                        switch (rs.getString(7)) {
                            case "1":
                                if(rs.getInt(10)==1){
                                   pane1S1.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane1S1.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane1S1.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane1S1.setOpacity(1);
                                lCodigo1S1.setText(rs.getString(2));
                                lNombre1S1.setText(rs.getString(3));
                                lNota1S1.setText(rs.getString(6));
                                break;
                            case "2":
                                if(rs.getInt(10)==1){
                                   pane2S1.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane2S1.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane2S1.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane2S1.setOpacity(1);
                                lCodigo2S1.setText(rs.getString(2));
                                lNombre2S1.setText(rs.getString(3));
                                lNota2S1.setText(rs.getString(6));
                                break;
                            case "3":
                                if(rs.getInt(10)==1){
                                   pane3S1.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane3S1.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane3S1.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane3S1.setOpacity(1);
                                lCodigo3S1.setText(rs.getString(2));
                                lNombre3S1.setText(rs.getString(3));
                                lNota3S1.setText(rs.getString(6));
                                break;
                            case "4":
                                if(rs.getInt(10)==1){
                                   pane4S1.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane4S1.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane4S1.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane4S1.setOpacity(1);
                                lCodigo4S1.setText(rs.getString(2));
                                lNombre4S1.setText(rs.getString(3));
                                lNota4S1.setText(rs.getString(6));
                                break;
                            case "5":
                                if(rs.getInt(10)==1){
                                   pane5S1.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane5S1.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane5S1.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane5S1.setOpacity(1);
                                lCodigo5S1.setText(rs.getString(2));
                                lNombre5S1.setText(rs.getString(3));
                                lNota5S1.setText(rs.getString(6));
                                break;
                            case "6":
                                if(rs.getInt(10)==1){
                                   pane6S1.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane6S1.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
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
                                if(rs.getInt(10)==1){
                                   pane1S2.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane1S2.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane1S2.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane1S2.setOpacity(1);
                                lCodigo1S2.setText(rs.getString(2));
                                lNombre1S2.setText(rs.getString(3));
                                lNota1S2.setText(rs.getString(6));
                                break;
                            case "2":
                                if(rs.getInt(10)==1){
                                   pane2S2.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane2S2.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane2S2.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane2S2.setOpacity(1);
                                lCodigo2S2.setText(rs.getString(2));
                                lNombre2S2.setText(rs.getString(3));
                                lNota2S2.setText(rs.getString(6));
                                break;
                            case "3":
                                if(rs.getInt(10)==1){
                                   pane3S2.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane3S2.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane3S2.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane3S2.setOpacity(1);
                                lCodigo3S2.setText(rs.getString(2));
                                lNombre3S2.setText(rs.getString(3));
                                lNota3S2.setText(rs.getString(6));
                                break;
                            case "4":
                                if(rs.getInt(10)==1){
                                   pane4S2.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane4S2.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane4S2.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane4S2.setOpacity(1);
                                lCodigo4S2.setText(rs.getString(2));
                                lNombre4S2.setText(rs.getString(3));
                                lNota4S2.setText(rs.getString(6));
                                break;
                            case "5":
                                if(rs.getInt(10)==1){
                                   pane5S2.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane5S2.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane5S2.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane5S2.setOpacity(1);
                                lCodigo5S2.setText(rs.getString(2));
                                lNombre5S2.setText(rs.getString(3));
                                lNota5S2.setText(rs.getString(6));
                                break;
                            case "6":
                                if(rs.getInt(10)==1){
                                   pane6S2.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane6S2.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
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
                                if(rs.getInt(10)==1){
                                   pane1S3.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane1S3.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane1S3.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane1S3.setOpacity(1);
                                lCodigo1S3.setText(rs.getString(2));
                                lNombre1S3.setText(rs.getString(3));
                                lNota1S3.setText(rs.getString(6));
                                break;
                            case "2":
                                if(rs.getInt(10)==1){
                                   pane2S3.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane2S3.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane2S3.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane2S3.setOpacity(1);
                                lCodigo2S3.setText(rs.getString(2));
                                lNombre2S3.setText(rs.getString(3));
                                lNota2S3.setText(rs.getString(6));
                                break;
                            case "3":
                                if(rs.getInt(10)==1){
                                   pane3S3.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane3S3.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane3S3.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane3S3.setOpacity(1);
                                lCodigo3S3.setText(rs.getString(2));
                                lNombre3S3.setText(rs.getString(3));
                                lNota3S3.setText(rs.getString(6));
                                break;
                            case "4":
                                if(rs.getInt(10)==1){
                                   pane4S3.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane4S3.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane4S3.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane4S3.setOpacity(1);
                                lCodigo4S3.setText(rs.getString(2));
                                lNombre4S3.setText(rs.getString(3));
                                lNota4S3.setText(rs.getString(6));
                                break;
                            case "5":
                                if(rs.getInt(10)==1){
                                   pane5S3.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane5S3.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane5S3.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane5S3.setOpacity(1);
                                lCodigo5S3.setText(rs.getString(2));
                                lNombre5S3.setText(rs.getString(3));
                                lNota5S3.setText(rs.getString(6));
                                break;
                            case "6":
                                if(rs.getInt(10)==1){
                                   pane6S3.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane6S3.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
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
                                if(rs.getInt(10)==1){
                                   pane1S4.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane1S4.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane1S4.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane1S4.setOpacity(1);
                                lCodigo1S4.setText(rs.getString(2));
                                lNombre1S4.setText(rs.getString(3));
                                lNota1S4.setText(rs.getString(6));
                                break;
                            case "2":
                                if(rs.getInt(10)==1){
                                   pane2S4.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane2S4.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane2S4.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane2S4.setOpacity(1);
                                lCodigo2S4.setText(rs.getString(2));
                                lNombre2S4.setText(rs.getString(3));
                                lNota2S4.setText(rs.getString(6));
                                break;
                            case "3":
                                if(rs.getInt(10)==1){
                                   pane3S4.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane3S4.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane3S4.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane3S4.setOpacity(1);
                                lCodigo3S4.setText(rs.getString(2));
                                lNombre3S4.setText(rs.getString(3));
                                lNota3S4.setText(rs.getString(6));
                                break;
                            case "4":
                                if(rs.getInt(10)==1){
                                   pane4S4.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane4S4.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane4S4.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane4S4.setOpacity(1);
                                lCodigo4S4.setText(rs.getString(2));
                                lNombre4S4.setText(rs.getString(3));
                                lNota4S4.setText(rs.getString(6));
                                break;
                            case "5":
                                if(rs.getInt(10)==1){
                                   pane5S4.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane5S4.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane5S4.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane5S4.setOpacity(1);
                                lCodigo5S4.setText(rs.getString(2));
                                lNombre5S4.setText(rs.getString(3));
                                lNota5S4.setText(rs.getString(6));
                                break;
                            case "6":
                                if(rs.getInt(10)==1){
                                   pane6S4.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane6S4.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
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
                                if(rs.getInt(10)==1){
                                   pane1S5.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane1S5.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane1S5.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane1S5.setOpacity(1);
                                lCodigo1S5.setText(rs.getString(2));
                                lNombre1S5.setText(rs.getString(3));
                                lNota1S5.setText(rs.getString(6));
                                break;
                            case "2":
                                if(rs.getInt(10)==1){
                                   pane2S5.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane2S5.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane2S5.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane2S5.setOpacity(1);
                                lCodigo2S5.setText(rs.getString(2));
                                lNombre2S5.setText(rs.getString(3));
                                lNota2S5.setText(rs.getString(6));
                                break;
                            case "3":
                                if(rs.getInt(10)==1){
                                   pane3S5.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane3S5.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane3S5.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane3S5.setOpacity(1);
                                lCodigo3S5.setText(rs.getString(2));
                                lNombre3S5.setText(rs.getString(3));
                                lNota3S5.setText(rs.getString(6));
                                break;
                            case "4":
                                if(rs.getInt(10)==1){
                                   pane4S5.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane4S5.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane4S5.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane4S5.setOpacity(1);
                                lCodigo4S5.setText(rs.getString(2));
                                lNombre4S5.setText(rs.getString(3));
                                lNota4S5.setText(rs.getString(6));
                                break;
                            case "5":
                                if(rs.getInt(10)==1){
                                   pane5S5.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane5S5.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane5S5.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane5S5.setOpacity(1);
                                lCodigo5S5.setText(rs.getString(2));
                                lNombre5S5.setText(rs.getString(3));
                                lNota5S5.setText(rs.getString(6));
                                break;
                            case "6":
                                if(rs.getInt(10)==1){
                                   pane6S5.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane6S5.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
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
                                if(rs.getInt(10)==1){
                                   pane1S6.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane1S6.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane1S6.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane1S6.setOpacity(1);
                                lCodigo1S6.setText(rs.getString(2));
                                lNombre1S6.setText(rs.getString(3));
                                lNota1S6.setText(rs.getString(6));
                                break;
                            case "2":
                                if(rs.getInt(10)==1){
                                   pane2S6.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane2S6.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane2S6.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane2S6.setOpacity(1);
                                lCodigo2S6.setText(rs.getString(2));
                                lNombre2S6.setText(rs.getString(3));
                                lNota2S6.setText(rs.getString(6));
                                break;
                            case "3":
                                if(rs.getInt(10)==1){
                                   pane3S6.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane3S6.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane3S6.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane3S6.setOpacity(1);
                                lCodigo3S6.setText(rs.getString(2));
                                lNombre3S6.setText(rs.getString(3));
                                lNota3S6.setText(rs.getString(6));
                                break;
                            case "4":
                                if(rs.getInt(10)==1){
                                   pane4S6.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane4S6.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane4S6.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane4S6.setOpacity(1);
                                lCodigo4S6.setText(rs.getString(2));
                                lNombre4S6.setText(rs.getString(3));
                                lNota4S6.setText(rs.getString(6));
                                break;
                            case "5":
                                if(rs.getInt(10)==1){
                                   pane5S6.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane5S6.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane5S6.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane5S6.setOpacity(1);
                                lCodigo5S6.setText(rs.getString(2));
                                lNombre5S6.setText(rs.getString(3));
                                lNota5S6.setText(rs.getString(6));
                                break;
                            case "6":
                                if(rs.getInt(10)==1){
                                   pane6S6.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane6S6.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
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
                                if(rs.getInt(10)==1){
                                   pane1S7.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane1S7.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane1S7.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane1S7.setOpacity(1);
                                lCodigo1S7.setText(rs.getString(2));
                                lNombre1S7.setText(rs.getString(3));
                                lNota1S7.setText(rs.getString(6));
                                break;
                            case "2":
                                if(rs.getInt(10)==1){
                                   pane2S7.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane2S7.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane2S7.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane2S7.setOpacity(1);
                                lCodigo2S7.setText(rs.getString(2));
                                lNombre2S7.setText(rs.getString(3));
                                lNota2S7.setText(rs.getString(6));
                                break;
                            case "3":
                                if(rs.getInt(10)==1){
                                   pane3S7.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane3S7.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane3S7.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane3S7.setOpacity(1);
                                lCodigo3S7.setText(rs.getString(2));
                                lNombre3S7.setText(rs.getString(3));
                                lNota3S7.setText(rs.getString(6));
                                break;
                            case "4":
                                if(rs.getInt(10)==1){
                                   pane4S7.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane4S7.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane4S7.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane4S7.setOpacity(1);
                                lCodigo4S7.setText(rs.getString(2));
                                lNombre4S7.setText(rs.getString(3));
                                lNota4S7.setText(rs.getString(6));
                                break;
                            case "5":
                                if(rs.getInt(10)==1){
                                   pane5S7.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane5S7.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane5S7.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane5S7.setOpacity(1);
                                lCodigo5S7.setText(rs.getString(2));
                                lNombre5S7.setText(rs.getString(3));
                                lNota5S7.setText(rs.getString(6));
                                break;
                            case "6":
                                if(rs.getInt(10)==1){
                                   pane6S7.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane6S7.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
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
                                if(rs.getInt(10)==1){
                                   pane1S8.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane1S8.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane1S8.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane1S8.setOpacity(1);
                                lCodigo1S8.setText(rs.getString(2));
                                lNombre1S8.setText(rs.getString(3));
                                lNota1S8.setText(rs.getString(6));
                                break;
                            case "2":
                                if(rs.getInt(10)==1){
                                   pane2S8.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane2S8.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane2S8.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane2S8.setOpacity(1);
                                lCodigo2S8.setText(rs.getString(2));
                                lNombre2S8.setText(rs.getString(3));
                                lNota2S8.setText(rs.getString(6));
                                break;
                            case "3":
                                if(rs.getInt(10)==1){
                                   pane3S8.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane3S8.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane3S8.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane3S8.setOpacity(1);
                                lCodigo3S8.setText(rs.getString(2));
                                lNombre3S8.setText(rs.getString(3));
                                lNota3S8.setText(rs.getString(6));
                                break;
                            case "4":
                                if(rs.getInt(10)==1){
                                   pane4S8.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane4S8.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane4S8.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane4S8.setOpacity(1);
                                lCodigo4S8.setText(rs.getString(2));
                                lNombre4S8.setText(rs.getString(3));
                                lNota4S8.setText(rs.getString(6));
                                break;
                            case "5":
                                if(rs.getInt(10)==1){
                                   pane5S8.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane5S8.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane5S8.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane5S8.setOpacity(1);
                                lCodigo5S8.setText(rs.getString(2));
                                lNombre5S8.setText(rs.getString(3));
                                lNota5S8.setText(rs.getString(6));
                                break;
                            case "6":
                                if(rs.getInt(10)==1){
                                   pane6S8.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane6S8.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
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
                                if(rs.getInt(10)==1){
                                   pane1S9.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane1S9.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane1S9.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane1S9.setOpacity(1);
                                lCodigo1S9.setText(rs.getString(2));
                                lNombre1S9.setText(rs.getString(3));
                                lNota1S9.setText(rs.getString(6));
                                break;
                            case "2":
                                if(rs.getInt(10)==1){
                                   pane2S9.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane2S9.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane2S9.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane2S9.setOpacity(1);
                                lCodigo2S9.setText(rs.getString(2));
                                lNombre2S9.setText(rs.getString(3));
                                lNota2S9.setText(rs.getString(6));
                                break;
                            case "3":
                                if(rs.getInt(10)==1){
                                   pane3S9.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane3S9.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane3S9.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane3S9.setOpacity(1);
                                lCodigo3S9.setText(rs.getString(2));
                                lNombre3S9.setText(rs.getString(3));
                                lNota3S9.setText(rs.getString(6));
                                break;
                            case "4":
                                if(rs.getInt(10)==1){
                                   pane4S9.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane4S9.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane4S9.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane4S9.setOpacity(1);
                                lCodigo4S9.setText(rs.getString(2));
                                lNombre4S9.setText(rs.getString(3));
                                lNota4S9.setText(rs.getString(6));
                                break;
                            case "5":
                                if(rs.getInt(10)==1){
                                   pane5S9.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane5S9.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane5S9.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane5S9.setOpacity(1);
                                lCodigo5S9.setText(rs.getString(2));
                                lNombre5S9.setText(rs.getString(3));
                                lNota5S9.setText(rs.getString(6));
                                break;
                            case "6":
                                if(rs.getInt(10)==1){
                                   pane6S9.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane6S9.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
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
                                if(rs.getInt(10)==1){
                                   pane1S10.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane1S10.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane1S10.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane1S10.setOpacity(1);
                                lCodigo1S10.setText(rs.getString(2));
                                lNombre1S10.setText(rs.getString(3));
                                lNota1S10.setText(rs.getString(6));
                                break;
                            case "2":
                                if(rs.getInt(10)==1){
                                   pane2S10.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane2S10.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane2S10.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane2S10.setOpacity(1);
                                lCodigo2S10.setText(rs.getString(2));
                                lNombre2S10.setText(rs.getString(3));
                                lNota2S10.setText(rs.getString(6));
                                break;
                            case "3":
                                if(rs.getInt(10)==1){
                                   pane3S10.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane3S10.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane3S10.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane3S10.setOpacity(1);
                                lCodigo3S10.setText(rs.getString(2));
                                lNombre3S10.setText(rs.getString(3));
                                lNota3S10.setText(rs.getString(6));
                                break;
                            case "4":
                                if(rs.getInt(10)==1){
                                   pane4S10.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane4S10.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane4S10.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane4S10.setOpacity(1);
                                lCodigo4S10.setText(rs.getString(2));
                                lNombre4S10.setText(rs.getString(3));
                                lNota4S10.setText(rs.getString(6));
                                break;
                            case "5":
                                if(rs.getInt(10)==1){
                                   pane5S10.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane5S10.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
                                    pane5S10.setStyle("-fx-background-color: #A4A4A4");
                                }
                                pane5S10.setOpacity(1);
                                lCodigo5S10.setText(rs.getString(2));
                                lNombre5S10.setText(rs.getString(3));
                                lNota5S10.setText(rs.getString(6));
                                break;
                            case "6":
                                if(rs.getInt(10)==1){
                                   pane6S10.setStyle("-fx-background-color: #2EFE2E");
                                }
                                else if(rs.getInt(10)>1){
                                    pane6S10.setStyle("-fx-background-color: #F3F781");
                                }
                                else if(rs.getInt(10)==0){
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
         }
          else{
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
