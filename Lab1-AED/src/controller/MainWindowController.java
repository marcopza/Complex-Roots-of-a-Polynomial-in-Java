package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainWindowController implements Initializable {

    @FXML private TextField c10TextField;
    @FXML private TextField c9TextField;
    @FXML private TextField c8TextField;
    @FXML private TextField c7TextField;
    @FXML private TextField c6TextField;
    @FXML private TextField c5TextField;
    @FXML private TextField c4TextField;
    @FXML private TextField c3TextField;
    @FXML private TextField c2TextField;
    @FXML private TextField c1TextField;
    @FXML private TextField c0TextField;
    @FXML private Button randomPolMethod;
    @FXML private Button newtonMethodButton;
    @FXML private Button secantMethodButton;
    @FXML private TextField rootsTextField;

    @Override
	public void initialize(URL location, ResourceBundle resources) {		
		
	}

	@FXML
    void newtonMethod(ActionEvent event) {

    }

    @FXML
    void randomPolynomial(ActionEvent event) {

    }

    @FXML
    void secantMethod(ActionEvent event) {

    }

}
