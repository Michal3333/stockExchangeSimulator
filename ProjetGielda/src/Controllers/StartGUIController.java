package Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Inicjuj;
import org.w3c.dom.css.RGBColor;


import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static model.Inicjuj.odczytaj;

public class StartGUIController  implements EventHandler<ActionEvent> {
    public TextField LiczbaGield;
    public TextField LiczbaSpolek;
    public TextField LiczbaWalut;
    public TextField LiczbaRynkowWAlut;
    public TextField LiczbaSurowcow;
    public TextField LiczbaRynkowSurowcow;

    public static Stage stage;
    public Label liczbaGield;
    public GridPane tabela;


    private Scene createAssetsScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/GlowneMenu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        return scene;
    }
    public static Scene createMainScene(){
        FXMLLoader loader = new FXMLLoader(StartGUIController.class.getResource("/gui/StartGUI.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        return scene;
    }

    public void Button1Handler(ActionEvent actionEvent) {
        try {
            int gieldy = Integer.parseInt(LiczbaGield.getText());
            int liczbaspolek = Integer.parseInt(LiczbaSpolek.getText());
            int waluty = Integer.parseInt(LiczbaWalut.getText());
            int liczbarynkowwalut =Integer.parseInt(LiczbaRynkowWAlut.getText());
            int liczbasur = Integer.parseInt(LiczbaSurowcow.getText());
            int liczbarynkowsur = Integer.parseInt(LiczbaSurowcow.getText());


            Inicjuj.Inicjujwszystko(gieldy,liczbaspolek,waluty,liczbarynkowwalut,liczbasur,liczbarynkowsur);


            stage.setScene(createAssetsScene());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }











    public void wczytaj(ActionEvent actionEvent) {
        odczytaj();
        try {
            stage.setScene(createAssetsScene());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void handle(ActionEvent event) {

    }
}
