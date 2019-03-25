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
import model.*;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class WidokJednostkiController implements Initializable{
    public Label aktualna;
    public ListView <JednostkaUczestnictwa> listajednostek;
    public LineChart wykres;
    public Label minimalna;
    public Label maksymalna;
    public Label nazwa;
    private ObservableList<JednostkaUczestnictwa> jednostkaUczestnictwasObservableList = FXCollections.observableArrayList();

    private Scene goback() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Menu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        return scene;
    }

    public void wyswietlJednostke(MouseEvent mouseEvent) {
        JednostkaUczestnictwa jednostkaUczestnictwa=listajednostek.getSelectionModel().getSelectedItem();
        XYChart.Series<String,Double> wykresakcje = new XYChart.Series<>();
        wykresakcje.setName("Cena");
        for (int i = 0; i < jednostkaUczestnictwa.getHistoria().size(); i++)
        {
            wykresakcje.getData().add(new XYChart.Data<>(String.valueOf(i),jednostkaUczestnictwa.getHistoria().get(i)));
        }
        DecimalFormat format = new DecimalFormat("#0.00");
        wykres.setData(FXCollections.observableArrayList(wykresakcje));
        aktualna.setText(format.format(jednostkaUczestnictwa.getAktualnaWartosc()));
        minimalna.setText(format.format(jednostkaUczestnictwa.getMinimalnaWartosc()));
        maksymalna.setText(format.format(jednostkaUczestnictwa.getMaksymalnaWartos()));
        nazwa.setText(jednostkaUczestnictwa.getNazwa());
    }

    public void cofnij(ActionEvent actionEvent) {
        try {
            StartGUIController.stage.setScene(goback());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void usunjednostke(ActionEvent actionEvent) {
        JednostkaUczestnictwa jednostka= listajednostek.getSelectionModel().getSelectedItem();
        FunduszInwestycyjny usuwanyfundusz =null;
        for (FunduszInwestycyjny fundusz : Inicjuj.getFundusze()) {
            if(fundusz.getJednostkaUczestnictwa()==jednostka){usuwanyfundusz=fundusz;}
        }

        Inicjuj.usunfundusz(usuwanyfundusz);
        jednostkaUczestnictwasObservableList.clear();


        for (FunduszInwestycyjny fundusz : Inicjuj.getFundusze()) {
            jednostkaUczestnictwasObservableList.add(fundusz.getJednostkaUczestnictwa());

        }
        listajednostek.setItems(jednostkaUczestnictwasObservableList);
        wykres.setData(null);
        minimalna.setText(null);
        maksymalna.setText(null);
        aktualna.setText(null);
        nazwa.setText(null);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (FunduszInwestycyjny fundusz : Inicjuj.getFundusze()) {
            jednostkaUczestnictwasObservableList.add(fundusz.getJednostkaUczestnictwa());

        }
        listajednostek.setItems(jednostkaUczestnictwasObservableList);
    }
}
