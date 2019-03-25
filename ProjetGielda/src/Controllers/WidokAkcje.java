package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import model.Akcja;
import model.Inicjuj;
import model.Spolka;
import model.Surowiec;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class WidokAkcje implements Initializable{
    public ListView<Akcja> listaakcji;
    public LineChart wykres;
    public Label aktualna;
    public Label minimalna;
    public Label maksymalna;
    private ObservableList<Akcja> akcjaObservableList = FXCollections.observableArrayList();
    // private ObservableList<Spolka> spolkaObservableList = FXCollections.observableArrayList();
    public void wyswietlAkcje(MouseEvent mouseEvent) {
        Akcja akcja=listaakcji.getSelectionModel().getSelectedItem();
        XYChart.Series<String,Double> wykresakcje = new XYChart.Series<>();
        wykresakcje.setName("Cena");
        for (int i = 0; i < akcja.getHistoria().size(); i++)
            {
            wykresakcje.getData().add(new XYChart.Data<>(String.valueOf(i),akcja.getHistoria().get(i)));
        }
        DecimalFormat format = new DecimalFormat("#0.00");
        wykres.setData(FXCollections.observableArrayList(wykresakcje));
        aktualna.setText(format.format(akcja.getAktualnaWartosc()));
        minimalna.setText(format.format(akcja.getMinimalnaWartosc()));
        maksymalna.setText(format.format(akcja.getMaksymalnaWartos()));

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //spolkaObservableList.addAll(Inicjuj.getSpolki());
        for (Spolka spolka : Inicjuj.getSpolki()) {
            akcjaObservableList.add(spolka.getAkcja());

        }
        listaakcji.setItems(akcjaObservableList);
    }

    private Scene createmenuscene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Menu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        return scene;
    }

    public void cofnij(ActionEvent actionEvent) {
        try {
            StartGUIController.stage.setScene(createmenuscene());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void usunakcje(ActionEvent actionEvent) {
        Akcja akcja = listaakcji.getSelectionModel().getSelectedItem();
        Spolka usuwnaspolka =null;
        for (Spolka spolka : Inicjuj.getSpolki()) {
            if(spolka.getAkcja()==akcja){usuwnaspolka=spolka;}
        }

        Inicjuj.usunspolke(usuwnaspolka);
        akcjaObservableList.clear();

        for (Spolka spolka : Inicjuj.getSpolki()) {
            akcjaObservableList.add(spolka.getAkcja());

        }
        listaakcji.setItems(akcjaObservableList);
        wykres.setData(null);
        minimalna.setText(null);
        maksymalna.setText(null);
        aktualna.setText(null);
    }

    public void dodajakcje(ActionEvent actionEvent) {
        Inicjuj.dodajspolke();
        akcjaObservableList.clear();
        for (Spolka spolka : Inicjuj.getSpolki()) {
            akcjaObservableList.add(spolka.getAkcja());

        }
        listaakcji.setItems(akcjaObservableList);

    }
}
