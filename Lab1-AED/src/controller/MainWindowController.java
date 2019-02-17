package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Newton;
import model.Polynomial;
import tokenizer.TokenizerException;

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
	private Button secantMethodButton;
	@FXML
	private TextField rootsTextField;
	private Polynomial poly;
	private ArrayList<TextField> textFields;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		textFields = new ArrayList<TextField>();
		textFields.add(c0TextField);
		textFields.add(c1TextField);
		textFields.add(c2TextField);
		textFields.add(c3TextField);
		textFields.add(c4TextField);
		textFields.add(c5TextField);
		textFields.add(c6TextField);
		textFields.add(c7TextField);
		textFields.add(c8TextField);
		textFields.add(c9TextField);
		textFields.add(c10TextField);
	}

	@FXML
	void newtonMethod(ActionEvent event) {

		String f = "";
		boolean hasNext = true;
		for (int i = 10; i >= 0 && hasNext; i--) {
			String text = textFields.get(i).getText();
			if (!text.isEmpty()) {
				f += text + "x^" + i;
				if (i != 0) {
					f += " +";
				}
			} else {
				f += 0 + "x^" + i;
				if (i != 0) {
					f += " +";
				}
			}
		}
		System.out.println(f);

	}

	@FXML
	void randomPolynomial(ActionEvent event) {

	}

	@FXML
	void secantMethod(ActionEvent event) {

	}

}
