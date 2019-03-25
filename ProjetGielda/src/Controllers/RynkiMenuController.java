package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class RynkiMenuController {
    private Scene utwurzstronegield() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/GieldaWidok.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        return scene;
    }

    private Scene utwurzstronewalut() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/RynkiWalutWidok.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        return scene;
    }
    private Scene cofnij() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/GlowneMenu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        return scene;
    }
    public void przjdzdowalut(ActionEvent actionEvent) {
        try {
            StartGUIController.stage.setScene(utwurzstronewalut());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void przejdzdogield(ActionEvent actionEvent) {
        try {
            StartGUIController.stage.setScene(utwurzstronegield());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cofnijdoGlownemenu(ActionEvent actionEvent) {
        try {
            StartGUIController.stage.setScene(cofnij());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
