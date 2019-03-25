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
import model.Inwestor;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class WidokInwestorzyController implements Initializable{
    public Label imie;
    public Label nazwisko;
    public Label pesel;
    public Label budzet;
    public ListView <Inwestor> listainwestorow;
    public LineChart wykres;
    private ObservableList<Inwestor> inwestorObservableList = FXCollections.observableArrayList();

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

    public void wyswietlinwestorow(MouseEvent mouseEvent) {
        Inwestor inwestor = listainwestorow.getSelectionModel().getSelectedItem();
        XYChart.Series<String,Double> wykresbudzet = new XYChart.Series<>();
        wykresbudzet.setName("posiadanie");
        for (int i = 0; i < inwestor.getHistoria().size(); i++)
        {
            wykresbudzet.getData().add(new XYChart.Data<>(String.valueOf(i),inwestor.getHistoria().get(i)));
        }

        wykres.setData(FXCollections.observableArrayList(wykresbudzet));
        DecimalFormat format = new DecimalFormat("#0.00");
        imie.setText((inwestor.getImie()));
        nazwisko.setText((inwestor.getNazwisko()));
        budzet.setText(format.format(inwestor.getBudzet()));
        pesel.setText(Integer.toString(inwestor.getPesel()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inwestorObservableList.addAll(Inicjuj.getInwestorzy());
        listainwestorow.setItems(inwestorObservableList);
    }

    public void usuninwestor(ActionEvent actionEvent) {
        Inwestor inwestor = listainwestorow.getSelectionModel().getSelectedItem();
        Inicjuj.usuninwestora(inwestor);
        inwestor.setWatek(false);
        inwestorObservableList.setAll(Inicjuj.getInwestorzy());
        listainwestorow.setItems(inwestorObservableList);
        wykres.setData(null);
        imie.setText(null);
        nazwisko.setText(null);
        pesel.setText(null);
        budzet.setText(null);
    }
}
