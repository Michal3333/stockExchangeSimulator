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
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LaczonyWykresController implements Initializable{
    public ListView<Aktywa> listaaktyw;
    public LineChart wykres;
    public ListView wybrane;
    private ObservableList<Aktywa> aktywaObservableList= FXCollections.observableArrayList();

    private ObservableList<Aktywa> pom = FXCollections.observableArrayList();

    public void back(ActionEvent actionEvent) {
        try {
            StartGUIController.stage.setScene(goback());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void wyswietlwykresy(MouseEvent mouseEvent) {
        Waluta waluta =null;
        Surowiec surowiec=null;
        Akcja akcja =null;
        JednostkaUczestnictwa jednostkaUczestnictwa=null;
        Aktywa aktywa =listaaktyw.getSelectionModel().getSelectedItem();
        pom.add(aktywa);
        wybrane.setItems(pom);


    }

    public void generujwykres(ActionEvent actionEvent) {
        wykres.getData().clear();

        for (Aktywa aktywa : pom) {
            XYChart.Series<String,Double> wykresakcje = new XYChart.Series<>();
            wykresakcje.setName(aktywa.getNazwa());
            for(int i=0;i<aktywa.getHistoria().size();i++){
                wykresakcje.getData().add(new XYChart.Data<>(String.valueOf(i),aktywa.getHistoria().get(i)/aktywa.getStartowaCena()));
            }
            wykres.getData().add(wykresakcje);


        }

    }

    public void wyczyscwykres(ActionEvent actionEvent) {
        pom.clear();
        wykres.getData().clear();
        wybrane.getItems().clear();
    }
    private Scene goback() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/GlowneMenu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        return scene;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (Spolka spolka : Inicjuj.getSpolki()) {
            aktywaObservableList.add(spolka.getAkcja());
        }
        for(FunduszInwestycyjny funduszInwestycyjny : Inicjuj.getFundusze()){
            aktywaObservableList.add(funduszInwestycyjny.getJednostkaUczestnictwa());
        }
        aktywaObservableList.addAll(Inicjuj.getSurowce());
        aktywaObservableList.addAll(Inicjuj.getWaluty());

        listaaktyw.setItems(aktywaObservableList);

    }
}
