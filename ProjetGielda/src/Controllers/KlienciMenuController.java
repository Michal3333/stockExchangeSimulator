package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class KlienciMenuController {
    private Scene goback() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/GlowneMenu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        return scene;
    }
    private Scene przejdzdoinwestorow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/WidokInwestorzy.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        return scene;
    }
    private Scene przejdzdofunduszy() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/FunduszeWidok.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        return scene;
    }

    public void cofnij(ActionEvent actionEvent) {
        try {
            StartGUIController.stage.setScene(goback());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void przejdzdoinwestorow(ActionEvent actionEvent) {
        try {
            StartGUIController.stage.setScene(przejdzdoinwestorow());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void przejdzdofunduszy(ActionEvent actionEvent) {
        try {
            StartGUIController.stage.setScene(przejdzdofunduszy());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
