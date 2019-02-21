package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import org.jscience.mathematics.number.Complex;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javolution.text.Text;
import model.ComplexPolynomial;

public class MainWindowController implements Initializable {

	@FXML
	private TextField c10TextField;
	@FXML
	private TextField c9TextField;
	@FXML
	private TextField c8TextField;
	@FXML
	private TextField c7TextField;
	@FXML
	private TextField c6TextField;
	@FXML
	private TextField c5TextField;
	@FXML
	private TextField c4TextField;
	@FXML
	private TextField c3TextField;
	@FXML
	private TextField c2TextField;
	@FXML
	private TextField c1TextField;
	@FXML
	private TextField c0TextField;
	@FXML
	private Button randomPolMethod;
	@FXML
	private Button newtonMethodButton;
	@FXML
	private Button durandKernerMethodButton;
	@FXML
	private ListView<Text> rootsListView;
	@FXML
    private ComboBox<Integer> degreeComboBox;
	private ComplexPolynomial poly;
	private ArrayList<TextField> textFields;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		textFields = new ArrayList<TextField>();
		textFields.add(c10TextField);
		textFields.add(c9TextField);
		textFields.add(c8TextField);
		textFields.add(c7TextField);
		textFields.add(c6TextField);
		textFields.add(c5TextField);
		textFields.add(c4TextField);
		textFields.add(c3TextField);
		textFields.add(c2TextField);
		textFields.add(c1TextField);
		textFields.add(c0TextField);
		ObservableList<Integer> items = 
				FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10);
		degreeComboBox.setItems(items);
	}

	@FXML
	void newtonMethod(ActionEvent event) {
		
		

	}

	@FXML
	void randomPolynomial(ActionEvent event) {

	}

	@FXML
	void durandKernerPressed(ActionEvent event) {
		rootsListView.getItems().clear();
		double[] coefficients = new double[degreeComboBox.getSelectionModel().getSelectedItem() + 1];
		int i = 0;
		for(TextField t : textFields) {
			if(!t.getText().equals("")) {
				coefficients[i] = Double.parseDouble(t.getText());
				i++;
			}
		}
		poly = new ComplexPolynomial(coefficients);
		Complex[] results = poly.durandKerner();
		for(int j = 0; j < results.length; j++) {
			rootsListView.getItems().add(results[j].toText());
		}
	}

	void getPolynomial() {
		
	}
	
}
