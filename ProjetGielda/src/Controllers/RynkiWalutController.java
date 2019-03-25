package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import model.Inicjuj;
import model.Rynek;
import model.RynekWalut;
import model.Spolka;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class RynkiWalutController implements Initializable{
    public ListView <Rynek> listarynkow;
    public Label nazwa;
    public Label waluta;
    public Label marza;
    public Label kraj;
    public Label miasto;
    public Label adres;
    private ObservableList<Rynek> rynekWalutsObservableList = FXCollections.observableArrayList();

    public void dodaj(ActionEvent actionEvent) {
        Inicjuj.dodajrynekwalut();
        rynekWalutsObservableList.setAll(Inicjuj.getRynkiWalut());
        rynekWalutsObservableList.addAll(Inicjuj.getRynkiSurowcow());
        listarynkow.setItems(rynekWalutsObservableList);
    }

    public void wybierzrynek(MouseEvent mouseEvent) {
        DecimalFormat format = new DecimalFormat("#0.00");
        Rynek rynekWalut = listarynkow.getSelectionModel().getSelectedItem();
        nazwa.setText(rynekWalut.getNazwa());
        waluta.setText(rynekWalut.getWaluta());
        marza.setText(format.format(rynekWalut.getMarza()));
        kraj.setText(rynekWalut.getKraj());
        miasto.setText(rynekWalut.getMisato());
        adres.setText(rynekWalut.getAdres());
    }

    public void cofnij(ActionEvent actionEvent) {
        try {
            StartGUIController.stage.setScene(goback());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private Scene goback() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/RynkiMenu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        return scene;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rynekWalutsObservableList.setAll(Inicjuj.getRynkiWalut());
        rynekWalutsObservableList.addAll(Inicjuj.getRynkiSurowcow());
        listarynkow.setItems(rynekWalutsObservableList);

    }

    public void dodajsur(ActionEvent actionEvent) {
        Inicjuj.dodajryneksur();
        rynekWalutsObservableList.setAll(Inicjuj.getRynkiWalut());
        rynekWalutsObservableList.addAll(Inicjuj.getRynkiSurowcow());
        listarynkow.setItems(rynekWalutsObservableList);
    }
}
