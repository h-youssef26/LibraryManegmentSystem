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
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import org.hibernate.query.Query;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;



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

        if (signup_email.getText().isEmpty() || signup_username.getText().isEmpty()
                || signup_Password.getText().isEmpty() || Signup_cpassword.getText().isEmpty()) {
            alert.errorMessage("All fields are required.");
            return;
        }

        if (!signup_Password.getText().equals(Signup_cpassword.getText())) {
            alert.errorMessage("Passwords do not match.");
            return;
        }

        if (signup_Password.getText().length() < 8) {
            alert.errorMessage("Password must be at least 8 characters.");
            return;
        }

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            String hql = "SELECT count(u) FROM User u WHERE u.username = :username OR u.email = :email";
            Long count = (Long) session.createQuery(hql)
                    .setParameter("username", signup_username.getText())
                    .setParameter("email", signup_email.getText())
                    .uniqueResult();

            if (count != null && count > 0) {
                alert.errorMessage(signup_username.getText() + " is already taken.");
                return;
            }

            User newUser = new User();
            newUser.setEmail(signup_email.getText());
            newUser.setUsername(signup_username.getText());
            newUser.setPassword(signup_Password.getText());
            // newUser.setDate(new Date());

            session.save(newUser);
            transaction.commit();

            alert.successMessage("Registered Successfully!");

            registerClearFields();
            signup_form.setVisible(false);
            Login_form.setVisible(true);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/nu/testfx/HomePage.fxml"));
            Parent homePageRoot = loader.load();
            Scene homePageScene = new Scene(homePageRoot);

            Stage stage = (Stage) signup_form.getScene().getWindow();
            stage.setScene(homePageScene);
            stage.show();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            alert.errorMessage("Registration failed: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }


    public void registerClearFields() {
        signup_email.setText("");
        signup_username.setText("");
        signup_Password.setText("");
        Signup_cpassword.setText("");
    }

    public void switchForm(ActionEvent event) {

        if (event.getSource() == signup_loginAccount || event.getSource() == forgot_backBtn) {
            signup_form.setVisible(false);
            Login_form.setVisible(true);
            changePass_form.setVisible(false);
        } else if (event.getSource() == login_createAccount) {
            signup_form.setVisible(true);
            Login_form.setVisible(false);
            changePass_form.setVisible(false);
        } else if (event.getSource() == changePass_backBtn) {
            signup_form.setVisible(false);
            Login_form.setVisible(true);
            changePass_form.setVisible(false);
        } else if (event.getSource() == Login_forgotPassword) {
            signup_form.setVisible(false);
            Login_form.setVisible(false);
            changePass_form.setVisible(true);
        }

    }
    public void login() {
        alertMessage alert = new alertMessage();

        String password = Login_showPassword.isVisible() ? Login_showPassword.getText() : Login_Password.getText();

        if (Login_Username.getText().isEmpty() || password.isEmpty()) {
            alert.errorMessage("Incorrect Username/Password");
            return;
        }

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = null;

        try {
            session = sessionFactory.openSession();

            String hql = "FROM User u WHERE u.username = :username AND u.password = :password";
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("username", Login_Username.getText());
            query.setParameter("password", password);

            User user = query.uniqueResult();

            if (user != null) {
                alert.successMessage("Successfully Logged In!");

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
                    Parent root = loader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                    // Show error to user
                }


                ((Stage) Login_btn.getScene().getWindow()).close();
            } else {
                alert.errorMessage("Incorrect Username/Password");
            }

        } catch (Exception e) {
            e.printStackTrace();
            alert.errorMessage("Database error during login: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }

    public void showPassword() {
        if (Login_selectShowPassword.isSelected()) {
            Login_showPassword.setText(Login_Password.getText());
            Login_showPassword.setVisible(true);
            Login_Password.setVisible(false);
        } else {
            Login_Password.setText(Login_showPassword.getText());
            Login_showPassword.setVisible(false);
            Login_Password.setVisible(true);
        }
    }


    public void changePassword() {
        alertMessage alert = new alertMessage();

        if (changePass_password.getText().isEmpty() || changePass_cPassword.getText().isEmpty()) {
            alert.errorMessage("Please fill all blank fields");
            return;
        }

        if (!changePass_password.getText().equals(changePass_cPassword.getText())) {
            alert.errorMessage("Password does not match");
            return;
        }

        if (changePass_password.getText().length() < 8) {
            alert.errorMessage("Invalid Password, at least 8 characters needed");
            return;
        }

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            String hql = "FROM User u WHERE u.username = :username";
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("username", forgot_userrname.getText());

            User user = query.uniqueResult();

            if (user != null) {
                user.setPassword(changePass_password.getText());

                /*Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                user.setUpdateDate(sqlDate);*/

                session.update(user);
                transaction.commit();

                alert.successMessage("Successfully changed password");

                signup_form.setVisible(false);
                Login_form.setVisible(true);
                changePass_form.setVisible(false);

                Login_Username.setText("");
                Login_Password.setVisible(true);
                Login_Password.setText("");
                Login_showPassword.setVisible(false);
                Login_selectShowPassword.setSelected(false);

                changePass_password.setText("");
                changePass_cPassword.setText("");
            } else {
                alert.errorMessage("User not found");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            alert.errorMessage("An error occurred while changing the password.");
        } finally {
            session.close();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
       /* questions();
        forgotListQuestion();*/
    }
}
