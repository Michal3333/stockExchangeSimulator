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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Inicjuj;
import model.Spolka;
import model.Surowiec;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class WidokSpolkiController implements Initializable {
    public ListView <Spolka> listaspolek;
    public Label nazwa;
    public Label data;
    public Label kurs;
    public Label zysk;
    public Label przychod;
    public Label wlasny;
    public Label zakladowy;
    public TextField cenawylupu;
    private ObservableList<Spolka> spolkaObservableList = FXCollections.observableArrayList();

    public void back(ActionEvent actionEvent) {
        try {
            StartGUIController.stage.setScene(goback());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void wyswietlspolke(MouseEvent mouseEvent) {
        DecimalFormat format = new DecimalFormat("#0.00");
        Spolka spolka = listaspolek.getSelectionModel().getSelectedItem();
        nazwa.setText(spolka.getNazwa());
        data.setText(spolka.getDataPierwszejWyceny());
        kurs.setText(format.format(spolka.getKursOtwarcia()));
        zysk.setText(format.format(spolka.getZysk()));
        przychod.setText(format.format(spolka.getPrzychod()));
        wlasny.setText(format.format(spolka.getKapitalWlasny()));
        zakladowy.setText(format.format(spolka.getKapitalZakladowy()));
    }

    public void dodajspolke(ActionEvent actionEvent) {
        Inicjuj.dodajspolke();
        spolkaObservableList.setAll(Inicjuj.getSpolki());
        listaspolek.setItems(spolkaObservableList);

    }

    public void usunspolke(ActionEvent actionEvent) {
        Spolka spolka = listaspolek.getSelectionModel().getSelectedItem();
        Inicjuj.usunspolke(spolka);
        spolkaObservableList.setAll(Inicjuj.getSpolki());
        listaspolek.setItems(spolkaObservableList);
        nazwa.setText(null);
        data.setText(null);
        kurs.setText(null);
        zysk.setText(null);
        przychod.setText(null);
        wlasny.setText(null);
        zakladowy.setText(null);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        spolkaObservableList.setAll(Inicjuj.getSpolki());
        listaspolek.setItems(spolkaObservableList);

    }
    private Scene goback() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/GlowneMenu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        return scene;
    }

    public void wykup(ActionEvent actionEvent) {
        Spolka spolka = listaspolek.getSelectionModel().getSelectedItem();
        double ilosc =Double.valueOf( cenawylupu.getText());
        spolka.wykupakcje(ilosc);
    }
}
