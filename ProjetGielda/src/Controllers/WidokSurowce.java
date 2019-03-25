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
import model.Inicjuj;
import model.Surowiec;
import model.Waluta;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class WidokSurowce implements Initializable{
    public Label jednostka;
    public ListView <Surowiec> listasurowcuw;
    public LineChart wykres;
    public Label aktualna;
    public Label minimalna;
    public Label maksymalna;
    private ObservableList<Surowiec> surowiecObservableList = FXCollections.observableArrayList();

    private Scene createmenuscene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Menu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        return scene;
    }
    public void back(ActionEvent actionEvent) {
        try {
            StartGUIController.stage.setScene(createmenuscene());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void initialize(URL location, ResourceBundle resources) {
        //spolkaObservableList.addAll(Inicjuj.getSpolki());
        surowiecObservableList.setAll(Inicjuj.getSurowce());
        listasurowcuw.setItems(surowiecObservableList);
    }


    public void wyswietlSurowce(MouseEvent mouseEvent) {
        Surowiec surowiec=listasurowcuw.getSelectionModel().getSelectedItem();
        XYChart.Series<String,Double> wykressurowiec = new XYChart.Series<>();
        wykressurowiec.setName("Cena");
        for (int i = 0; i < surowiec.getHistoria().size(); i++)
        {
            wykressurowiec.getData().add(new XYChart.Data<>(String.valueOf(i),surowiec.getHistoria().get(i)));
        }
        DecimalFormat format = new DecimalFormat("#0.00");
        wykres.setData(FXCollections.observableArrayList(wykressurowiec));
        aktualna.setText(format.format(surowiec.getAktualnaWartosc()));
        minimalna.setText(format.format(surowiec.getMinimalnaWartosc()));
        maksymalna.setText(format.format(surowiec.getMaksymalnaWartos()));
        jednostka.setText(surowiec.getJednostka());

    }

    public void dodajSurowiec(ActionEvent actionEvent) {
        Inicjuj.dodajsurowiec();
        surowiecObservableList.setAll(Inicjuj.getSurowce());
        listasurowcuw.setItems(surowiecObservableList);
    }

    public void usunsurowiec(ActionEvent actionEvent) {
        Surowiec surowiec = listasurowcuw.getSelectionModel().getSelectedItem();
        Inicjuj.usunsurowiec(surowiec);
        surowiecObservableList.setAll(Inicjuj.getSurowce());
        listasurowcuw.setItems(surowiecObservableList);
        wykres.setData(null);
        minimalna.setText(null);
        maksymalna.setText(null);
        aktualna.setText(null);
        jednostka.setText(null);

    }
}
