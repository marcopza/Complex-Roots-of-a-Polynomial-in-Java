package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

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
	private Button aberthMethodButton;
	@FXML
	private Button durandkernerMethodButton;
	@FXML
	private ListView<Text> rootsListView;
	@FXML
	private ComboBox<Integer> degreeComboBox;
	private ComplexPolynomial poly;
	private ArrayList<TextField> textFields;
	private double[] coefficients;
	private Random random;
	private boolean randomly;

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
		ObservableList<Integer> items = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		degreeComboBox.setItems(items);
		random = new Random();
	}

	private void initializeCoefficinetsArray() {
		rootsListView.getItems().clear();
		coefficients = new double[degreeComboBox.getSelectionModel().getSelectedItem() + 1];
	}

	private void setCoefficients() {
		int i = 0;
		for (TextField t : textFields) {
			if (!t.getText().equals("")) {
				coefficients[i] = Double.parseDouble(t.getText());
				i++;
			}
		}
		poly = new ComplexPolynomial(coefficients);
	}

	@FXML
	void randomPolynomial(ActionEvent event) {

		if (!degreeComboBox.getSelectionModel().isEmpty()) {
			randomly = true;
			initializeCoefficinetsArray();
			for (TextField t : textFields) {
				t.setText("");
			}
			int j = textFields.size() - 1;
			for (int i = 0; i < coefficients.length; i++) {
				coefficients[i] = random.nextInt(100) + 1;
				textFields.get(j).setText(String.valueOf(coefficients[i]));
				j--;
			}
			poly = new ComplexPolynomial(coefficients);
		} else {
			JOptionPane.showMessageDialog(null, "You must first indicate the order of the polynomial", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private Complex[] durandKernerPressed() {
		Complex[] results = poly.durandKerner();
		return results;
	}

	private Complex[] aberthMethodPressed() {
		Complex[] results = poly.aberth();
		return results;
	}

	@FXML
	void solve(ActionEvent event) {
		if (!degreeComboBox.getSelectionModel().isEmpty()) {
			initializeCoefficinetsArray();
			Complex[] results;
			if (!randomly)
				try {
					setCoefficients();
				} catch (ArrayIndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(null,
							"The degree of the polynomial must match the number of text fields that contain coefficients",
							"Error", JOptionPane.ERROR_MESSAGE);
				}

			if (event.getSource().equals(durandkernerMethodButton)) {
				results = durandKernerPressed();
				durandkernerMethodButton.setDisable(true);
				aberthMethodButton.setDisable(false);
			} else {
				results = aberthMethodPressed();
				aberthMethodButton.setDisable(true);
				durandkernerMethodButton.setDisable(false);
			}
			for (int j = 0; j < results.length; j++) {
				rootsListView.getItems().add(results[j].toText());
			}
			randomly = false;
		} else {
			JOptionPane.showMessageDialog(null, "You must first indicate the order of the polynomial", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	void getPolynomial() {

	}

}
