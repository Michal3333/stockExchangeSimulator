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
import model.FunduszInwestycyjny;
import model.Inicjuj;
import model.Inwestor;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class WidokFunduszeController implements Initializable{
    public ListView <FunduszInwestycyjny> listafunduszy;
    public LineChart wykres;
    public  Label imie;
    public Label nazwisko;
    public Label nazwa;
    private ObservableList<FunduszInwestycyjny> funduszObservableList = FXCollections.observableArrayList();

    private Scene goback() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/KlienciMenu.fxml"));
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

    public void wyswietfundusze(MouseEvent mouseEvent) {
        FunduszInwestycyjny fundusz = listafunduszy.getSelectionModel().getSelectedItem();
        XYChart.Series<String,Double> wykresbudzet = new XYChart.Series<>();
        wykresbudzet.setName("posiadanie");
        for (int i = 0; i < fundusz.getHistoria().size(); i++)
        {
            wykresbudzet.getData().add(new XYChart.Data<>(String.valueOf(i),fundusz.getHistoria().get(i)));
        }

        wykres.setData(FXCollections.observableArrayList(wykresbudzet));
        DecimalFormat format = new DecimalFormat("#0.00");
        imie.setText((fundusz.getImie()));
        nazwisko.setText((fundusz.getNazwisko()));

        nazwa.setText(fundusz.getNazwka());
    }
    public void usunfundusz(ActionEvent actionEvent) {
        FunduszInwestycyjny fundusz =  listafunduszy.getSelectionModel().getSelectedItem();
        Inicjuj.usunfundusz(fundusz);
        fundusz.setWatek(false);
        funduszObservableList.setAll(Inicjuj.getFundusze());
        listafunduszy.setItems(funduszObservableList);
        wykres.setData(null);
        imie.setText(null);
        nazwisko.setText(null);
        nazwa.setText(null);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        funduszObservableList.setAll(Inicjuj.getFundusze());
        listafunduszy.setItems(funduszObservableList);
    }
}
