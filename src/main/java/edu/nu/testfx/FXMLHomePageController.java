package edu.nu.testfx;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLHomePageController implements Initializable {
    @FXML
    private TextField AddBook_BookID;

    @FXML
    private TextField AddBook_BookTitle;

    @FXML
    private ComboBox<?> AddBook_Category;

    @FXML
    private AnchorPane AddBook_Form;

    @FXML
    private TextField AddBook_Price;

    @FXML
    private TextField AddBook_Publisher;

    @FXML
    private TextField AddBook_Search;

    @FXML
    private ComboBox<?> AddBook_Year;

    @FXML
    private Button AddBook_addBtn;

    @FXML
    private Button AddBook_clearBtn;

    @FXML
    private TreeTableColumn<?, ?> AddBook_col_Category;

    @FXML
    private TreeTableColumn<?, ?> AddBook_col_ID;

    @FXML
    private TreeTableColumn<?, ?> AddBook_col_Price;

    @FXML
    private TreeTableColumn<?, ?> AddBook_col_Publisher;

    @FXML
    private TreeTableColumn<?, ?> AddBook_col_PublisherYear;

    @FXML
    private TreeTableColumn<?, ?> AddBook_col_Title;

    @FXML
    private Button AddBook_deleteBtn;

    @FXML
    private TreeTableView<?> AddBook_tableView;

    @FXML
    private Button AddBook_updateBtn;

    @FXML
    private TextField BorrowedBook_BookID;

    @FXML
    private AnchorPane BorrowedBook_Form;

    @FXML
    private TextField BorrowedBook_Search;

    @FXML
    private TextField BorrowedBook_borrowedPeriod;

    @FXML
    private Button BorrowedBook_checkBtn;

    @FXML
    private TreeTableColumn<?, ?> BorrowedBook_col_Author;

    @FXML
    private TreeTableColumn<?, ?> BorrowedBook_col_ID;

    @FXML
    private TreeTableColumn<?, ?> BorrowedBook_col_Status;

    @FXML
    private TreeTableColumn<?, ?> BorrowedBook_col_Title;

    @FXML
    private TreeTableColumn<?, ?> BorrowedBook_col_borrowedDate;

    @FXML
    private TreeTableColumn<?, ?> BorrowedBook_col_borrowedPeriod;

    @FXML
    private Button BorrowedBook_confermBtn;

    @FXML
    private TextField BorrowedBook_studentID;

    @FXML
    private TextField BorrowedBook_studentName;

    @FXML
    private TreeTableView<?> BorrowedBook_tableView;

    @FXML
    private LineChart<?, ?> Hime_Capacity;

    @FXML
    private Label Hime_totalCapacity;

    @FXML
    private Label Hime_totalEnrolledStudent;

    @FXML
    private AnchorPane Home_Form;

    @FXML
    private DatePicker Return_BookDate;

    @FXML
    private TextField Return_BookTitle;

    @FXML
    private AnchorPane Return_Form;

    @FXML
    private TextField Return_Search;

    @FXML
    private Button Return_checkBtn;

    @FXML
    private TreeTableColumn<?, ?> Return_col_Author;

    @FXML
    private TextField Return_col_BookID;

    @FXML
    private TreeTableColumn<?, ?> Return_col_ID;

    @FXML
    private TreeTableColumn<?, ?> Return_col_Name;

    @FXML
    private TreeTableColumn<?, ?> Return_col_Status;

    @FXML
    private Button Return_returnBtn;

    @FXML
    private ComboBox<?> Return_studentGender;

    @FXML
    private TextField Return_studentID;

    @FXML
    private TextField Return_studentName;

    @FXML
    private TreeTableView<?> Return_tableView;

    @FXML
    private AnchorPane View_Form;

    @FXML
    private TextField View_Search;

    @FXML
    private TreeTableColumn<?, ?> View_col_Category;

    @FXML
    private TreeTableColumn<?, ?> View_col_ID;

    @FXML
    private TreeTableColumn<?, ?> View_col_NOBC;

    @FXML
    private TreeTableColumn<?, ?> View_col_Status;

    @FXML
    private TreeTableColumn<?, ?> View_col_TNBB;

    @FXML
    private TreeTableColumn<?, ?> View_col_Title;

    @FXML
    private TreeTableColumn<?, ?> View_col_borrowingDate;

    @FXML
    private TreeTableColumn<?, ?> View_col_borrowingPeriod;

    @FXML
    private TreeTableView<?> View_tableView;

    @FXML
    private Button View_viewBtn;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
