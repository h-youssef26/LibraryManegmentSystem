package edu.nu.testfx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

public class FXMLDocumentController implements Initializable {

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
    private AnchorPane signup_form;

    @FXML
    private Button signup_loginAccount;

    @FXML
    private TextField signup_username;

    @FXML
    private TextField signup_email;

/*
    @FXML
    private TextField Signup_cpassword;*/

    @FXML
    private PasswordField Signup_cpassword;

    @FXML
    private PasswordField signup_Password;


    public void register() {
        alertMessage alert = new alertMessage();

        // CHECK IF WE HAVE EMPTY FIELDS
        if (signup_email.getText().isEmpty() || signup_username.getText().isEmpty()
                || signup_Password.getText().isEmpty() || Signup_cpassword.getText().isEmpty()) {
            alert.errorMessage("All fields are necessary to be filled");
            return;
        }

        // FIXED: Use equals() instead of == for String comparison
        else if (!signup_Password.getText().equals(Signup_cpassword.getText())) {
            alert.errorMessage("Password does not match");
            return;
        } else if (signup_Password.getText().length() < 8) {
            alert.errorMessage("Invalid Password, at least 8 characters needed");
            return;
        }


        try {
            Session session;
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();

            // CHECK IF THE USERNAME OR EMAIL IS ALREADY TAKEN (more secure than raw SQL)
            boolean userExists = session.createQuery(
                            "SELECT count(u) > 0 FROM User u WHERE u.username = :username OR u.email = :email",
                            Boolean.class)
                    .setParameter("username", signup_username.getText())
                    .setParameter("email", signup_email.getText())
                    .getSingleResult();

            if (userExists) {
                alert.errorMessage(signup_username.getText() + " is already taken");
                return;
            }

            // Begin transaction
            Transaction transaction = session.beginTransaction();

            try {
                // Create new user entity
                User newUser = new User();
                newUser.setEmail(signup_email.getText());
                newUser.setUsername(signup_username.getText());
                newUser.setPassword(signup_Password.getText()); // Note: Should hash this in production
                //newUser.setDate(new Date());

                // Save the user
                session.save(newUser);
                transaction.commit();

                alert.successMessage("Registered Successfully!");

                //registerClearFields();

                signup_form.setVisible(false);
                Login_form.setVisible(true);

                session.getTransaction().commit();

                session.close();


            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
                alert.errorMessage("Registration failed: " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
            alert.errorMessage("Database connection error");
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
       /* questions();
        forgotListQuestion();*/
    }
}
