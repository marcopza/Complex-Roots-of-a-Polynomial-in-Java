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
		String d = "";
		for (int i = 10; i >= 0; i--) {
			String text = textFields.get(i).getText();
			if (!text.isEmpty()) {

				if (i != 0) {
					f += text + "*" + "x^" + i;
					d += (Integer.parseInt(text) * i) + "*" + (i == 1 ? "" : "x^" + (i - 1));
					f += "+";
					d += "+";
				} else {
					f += text;
					d += 0;
				}
			}
		}
		System.out.println(f);
		System.out.println(d);
		poly = new Polynomial(f, d);
		Newton newton = new Newton();
		System.out.println(newton.findRoot(poly, 1, 1e-6, 200));

	}

	@FXML
	void randomPolynomial(ActionEvent event) {

	}

	@FXML
	void secantMethod(ActionEvent event) {

	}

}
