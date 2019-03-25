package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import model.Inicjuj;

import java.io.IOException;

import static model.Inicjuj.zapisz;

public class GlowneMenuController {
    private Scene utwurzstroneaktyw() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Menu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        return scene;
    }
    private Scene utwurzstronelaczonych() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/LaczonyWykres.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        return scene;
    }
    private Scene utwurzstoneklientow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/KlienciMenu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        return scene;
    }
    private Scene utwurzstonerynkow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/RynkiMenu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        return scene;
    }
    private Scene utwurzstonespolek() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/WidokSpolki.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        return scene;
    }

    public void przejdzdoaktyw(ActionEvent actionEvent) {
        try {
            StartGUIController.stage.setScene(utwurzstroneaktyw());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void przejdzdoklientow(ActionEvent actionEvent) {
        try {
            StartGUIController.stage.setScene(utwurzstoneklientow());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void przejdzdorynkow(ActionEvent actionEvent) {
        try {
            StartGUIController.stage.setScene(utwurzstonerynkow());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void zapiszwszystko(ActionEvent actionEvent) {
        Inicjuj.zapisz();
    }

    public void przejdzdospolek(ActionEvent actionEvent) {
        try {
            StartGUIController.stage.setScene(utwurzstonespolek());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void przejdzdolaczonychwykresow(ActionEvent actionEvent) {
        try {
            StartGUIController.stage.setScene(utwurzstronelaczonych());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
