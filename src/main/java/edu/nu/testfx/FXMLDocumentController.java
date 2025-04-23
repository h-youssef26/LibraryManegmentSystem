package edu.nu.testfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

public class FXMLDocumentController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       /* questions();
        forgotListQuestion();*/
    }
    @FXML
    private PasswordField Login_Password;

    @FXML
    private TextField Login_Username;

    @FXML
    private Button Login_btn;

    @FXML
    private Hyperlink Login_forgotPassword;

    @FXML
    private AnchorPane Login_form;

    @FXML
    private CheckBox Login_selectShowPassword;

    @FXML
    private TextField Login_showPassword;

    @FXML
    private TextField Siignup_email;

    @FXML
    private Button changePass_backBtn;

    @FXML
    private TextField changePass_cPassword;

    @FXML
    private AnchorPane changePass_form;

    @FXML
    private PasswordField changePass_password;

    @FXML
    private Button changePass_proceedBtn;

    @FXML
    private TextField forgot_answer;

    @FXML
    private Button forgot_backBtn;

    @FXML
    private AnchorPane forgot_form;

    @FXML
    private Button forgot_proceedBtn;

    @FXML
    private ComboBox<?> forgot_selectQuestion;

    @FXML
    private TextField forgot_userrname;

    @FXML
    private Button login_createAccount;

    @FXML
    private Button signup_btn;

    @FXML
    private TextField signup_cPassword;

    @FXML
    private AnchorPane signup_form;

    @FXML
    private Button signup_loginAccount;

    @FXML
    private TextField signup_password;

    @FXML
    private TextField signup_username;
}
