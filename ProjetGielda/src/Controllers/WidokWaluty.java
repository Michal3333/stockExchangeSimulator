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
import model.Waluta;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class WidokWaluty implements Initializable{
    public ListView<Waluta> listawalut;
    public LineChart wykres;
    public Label aktualna;
    public Label minimalna;
    public Label maksymalna;
    public ListView<String> listapanstw;
    private ObservableList<Waluta> waltaObservableList = FXCollections.observableArrayList();
    private ObservableList<String> panstwaObservableList = FXCollections.observableArrayList();
    private Scene createmenuscene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Menu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        return scene;
    }
    public void initialize(URL location, ResourceBundle resources) {
        //spolkaObservableList.addAll(Inicjuj.getSpolki());
        waltaObservableList.setAll(Inicjuj.getWaluty());
        listawalut.setItems(waltaObservableList);
    }
    public void back(ActionEvent actionEvent) {
        try {
            StartGUIController.stage.setScene(createmenuscene());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void wyswietlWaluty(MouseEvent mouseEvent) {
        Waluta waluta=listawalut.getSelectionModel().getSelectedItem();
        XYChart.Series<String,Double> wykreswaluta = new XYChart.Series<>();
        wykreswaluta.setName("cena");
        for (int i = 0; i < waluta.getHistoria().size(); i++)
        {
            wykreswaluta.getData().add(new XYChart.Data<>(String.valueOf(i),waluta.getHistoria().get(i)));
        }
        DecimalFormat format = new DecimalFormat("#0.00");
        wykres.setData(FXCollections.observableArrayList(wykreswaluta));
        aktualna.setText(format.format(waluta.getAktualnaWartosc()));
        minimalna.setText(format.format(waluta.getMinimalnaWartosc()));
        maksymalna.setText(format.format(waluta.getMaksymalnaWartos()));
        panstwaObservableList.setAll(waluta.getListaPanstw());

        listapanstw.setItems(panstwaObservableList);



    }


    public void dodajwalute(ActionEvent actionEvent) {
        Inicjuj.dodajwalute();
        waltaObservableList.setAll(Inicjuj.getWaluty());
        listawalut.setItems(waltaObservableList);

    }

    public void usunwalute(ActionEvent actionEvent) {
        Waluta waluta = listawalut.getSelectionModel().getSelectedItem();
        Inicjuj.usunwalute(waluta);
        waltaObservableList.setAll(Inicjuj.getWaluty());
        listawalut.setItems(waltaObservableList);

    }
}

