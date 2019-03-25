package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static model.Inicjuj.zapisz;

public class MenuController {
    private Scene createAssetsScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/WidokAkcje.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        return scene;
    }
    private Scene createSurowceScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/WidokSurowce.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        return scene;
    }
    private Scene createWalutaScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/WidokWaluty.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        return scene;
    }
    private Scene goback() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/GlowneMenu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        return scene;
    }
    private Scene createjednostkasecene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/WidokJednostki.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        return scene;
    }

    public void przejdzdoakcji(ActionEvent actionEvent) {
        try {
        StartGUIController.stage.setScene(createAssetsScene());
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    public void pzrejdzdosurowcow(ActionEvent actionEvent) {
        try {
            StartGUIController.stage.setScene(createSurowceScene());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void przejdzdowalut(ActionEvent actionEvent) {
        try {
            StartGUIController.stage.setScene(createWalutaScene());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void cofnij(ActionEvent actionEvent) {
        try {
            StartGUIController.stage.setScene(goback());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void przejdzdojednostek(ActionEvent actionEvent) {
        try {
            StartGUIController.stage.setScene(createjednostkasecene());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
