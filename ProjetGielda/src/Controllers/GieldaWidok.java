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
import model.*;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class GieldaWidok implements Initializable{
    public ListView<Gielda> listarynkow;
    public Label nazwa;
    public Label waluta;
    public Label marza;
    public Label kraj;
    public Label miasto;
    public Label adres;
    public ListView<Spolka> indeks;
    private ObservableList<Spolka> indeksObservableList = FXCollections.observableArrayList();
    private ObservableList<Gielda> rynekWalutsObservableList = FXCollections.observableArrayList();

    public void dodaj(ActionEvent actionEvent) {
        Inicjuj.dodajgielde();
        rynekWalutsObservableList.setAll(Inicjuj.getGieldy());

        listarynkow.setItems(rynekWalutsObservableList);
    }

    public void wybierzrynek(MouseEvent mouseEvent) {
        DecimalFormat format = new DecimalFormat("#0.00");
        Gielda gielda = listarynkow.getSelectionModel().getSelectedItem();
        nazwa.setText(gielda.getNazwa());
        waluta.setText(gielda.getWaluta());
        marza.setText(format.format(gielda.getMarza()));
        kraj.setText(gielda.getKraj());
        miasto.setText(gielda.getMisato());
        adres.setText(gielda.getAdres());
        indeksObservableList.setAll(gielda.getIndeks().getListaSpolek());
        indeks.setItems(indeksObservableList);
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
        rynekWalutsObservableList.setAll(Inicjuj.getGieldy());
        listarynkow.setItems(rynekWalutsObservableList);
    }
}
