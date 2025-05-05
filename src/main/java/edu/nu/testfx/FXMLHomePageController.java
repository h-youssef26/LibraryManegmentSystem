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
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javafx.event.ActionEvent;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.sql.Date;
import java.util.Calendar;
import javafx.scene.Scene;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.List;
import javafx.scene.control.ButtonType;
import java.util.Optional;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import models.Book;
import models.User;
import org.hibernate.cfg.Configuration;

public class FXMLHomePageController implements Initializable {

    @FXML
    private TextField AddBook_BookID;

    @FXML
    private TextField AddBook_BookTitle;

    @FXML
    private ComboBox<String> AddBook_Category;

    @FXML
    private AnchorPane AddBook_Form;

    @FXML
    private TextField AddBook_Price;

    @FXML
    private TextField AddBook_Publisher;

    @FXML
    private TextField AddBook_Search;

    @FXML
    private ComboBox<String> AddBook_Year;

    @FXML
    private Button AddBook_addBtn;

    @FXML
    private Button AddBook_clearBtn;

   @FXML
    private TreeTableColumn<Book, String> AddBook_col_Category;

    @FXML
    private TreeTableColumn<Book, Integer> AddBook_col_ID;

    @FXML
    private TreeTableColumn<Book, String> AddBook_col_Price;

    @FXML
    private TreeTableColumn<Book, String> AddBook_col_Publisher;

    @FXML
    private TreeTableColumn<Book, String> AddBook_col_PublisherYear;

    @FXML
    private TreeTableColumn<Book, String> AddBook_col_Title;

    @FXML
    private Button AddBook_deleteBtn;

    @FXML
    private TreeTableView<Book> AddBook_tableView;

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
    private TreeTableColumn<Book, String> BorrowedBook_col_Author;

    @FXML
    private TreeTableColumn<Book, String> BorrowedBook_col_ID;

    @FXML
    private TreeTableColumn<Book, String> BorrowedBook_col_Status;

    @FXML
    private TreeTableColumn<Book, String> BorrowedBook_col_Title;

    @FXML
    private TreeTableColumn<Book, String> BorrowedBook_col_borrowedDate;

    @FXML
    private TreeTableColumn<Book, String> BorrowedBook_col_borrowedPeriod;

    @FXML
    private Button BorrowedBook_confermBtn;

    @FXML
    private TextField BorrowedBook_studentID;

    @FXML
    private TextField BorrowedBook_studentName;

    @FXML
    private TreeTableView<Book> BorrowedBook_tableView;

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

    @FXML
    private Button addBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private Button viewBtn;

    @FXML
    private Button borrowBtn;

    @FXML
    private Button returnBtn;

    @FXML
    private Button logout;



    public void switchform(ActionEvent event) {
        if (event.getSource() == homeBtn) {
            Home_Form.setVisible(true);
            AddBook_Form.setVisible(false);
            BorrowedBook_Form.setVisible(false);
            Return_Form.setVisible(false);
            View_Form.setVisible(false);

            Home_Form.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            AddBook_Form.setStyle("-fx-background-color:transparent");
            BorrowedBook_Form.setStyle("-fx-background-color:transparent");
            Return_Form.setStyle("-fx-background-color:transparent");
            View_Form.setStyle("-fx-background-color:transparent");


        } else if (event.getSource() == addBtn) {
            Home_Form.setVisible(false);
            AddBook_Form.setVisible(true);
            BorrowedBook_Form.setVisible(false);
            Return_Form.setVisible(false);
            View_Form.setVisible(false);

            AddBook_Form.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            Home_Form.setStyle("-fx-background-color:transparent");
            BorrowedBook_Form.setStyle("-fx-background-color:transparent");
            Return_Form.setStyle("-fx-background-color:transparent");
            View_Form.setStyle("-fx-background-color:transparent");

            showAddBookTreeTableData();
            addBookYearList();
            addBookClear();
            addBookcategories();


        } else if (event.getSource() == borrowBtn) {
            Home_Form.setVisible(false);
            AddBook_Form.setVisible(false);
            BorrowedBook_Form.setVisible(true);
            Return_Form.setVisible(false);
            View_Form.setVisible(false);

            BorrowedBook_Form.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            Home_Form.setStyle("-fx-background-color:transparent");
            AddBook_Form.setStyle("-fx-background-color:transparent");
            Return_Form.setStyle("-fx-background-color:transparent");
            View_Form.setStyle("-fx-background-color:transparent");

            showBorrowBookTreeTableData();
            clearBorrowFields();


        } else if (event.getSource() == returnBtn) {
            Home_Form.setVisible(false);
            AddBook_Form.setVisible(false);
            BorrowedBook_Form.setVisible(false);
            Return_Form.setVisible(true);
            View_Form.setVisible(false);

            Return_Form.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            Home_Form.setStyle("-fx-background-color:transparent");
            AddBook_Form.setStyle("-fx-background-color:transparent");
            BorrowedBook_Form.setStyle("-fx-background-color:transparent");
            View_Form.setStyle("-fx-background-color:transparent");


        }else if (event.getSource() == viewBtn) {
            Home_Form.setVisible(false);
            AddBook_Form.setVisible(false);
            Return_Form.setVisible(false);
            BorrowedBook_Form.setVisible(false);
            View_Form.setVisible(true);

            View_Form.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            Home_Form.setStyle("-fx-background-color:transparent");
            AddBook_Form.setStyle("-fx-background-color:transparent");
            Return_Form.setStyle("-fx-background-color:transparent");
            BorrowedBook_Form.setStyle("-fx-background-color:transparent");

        }
    }


    private double x = 0;
    private double y = 0;

    public void logout() {

        try {

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {

                logout.getScene().getWindow().hide();

                Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();

            } else {
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addBook() {
        alertMessage alert = new alertMessage();

        if ((AddBook_BookID.getText().isEmpty())
                || (AddBook_BookTitle.getText().isEmpty())
                || (AddBook_Price.getText().isEmpty())
                || (AddBook_Year.getSelectionModel().getSelectedItem() == null)
                || (AddBook_Category.getSelectionModel().getSelectedItem() == null)
                || (AddBook_Publisher.getText().isEmpty())){
            alert.errorMessage("All fields are required.");
            return;
        }

        int bookId;
        double price;
        try {
            bookId = Integer.parseInt(AddBook_BookID.getText());
            price = Double.parseDouble(AddBook_Price.getText());
        } catch (NumberFormatException e) {
            alert.errorMessage("Please enter valid numeric values for ID and Price");
            return;
        }

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            String hql = "SELECT count(b) FROM Book b WHERE b.id = :id OR b.name = :name";
            Long count = (Long) session.createQuery(hql)
                    .setParameter("id", bookId)
                    .setParameter("name", AddBook_BookTitle.getText())
                    .uniqueResult();

            if (count != null && count > 0) {
                alert.errorMessage("Book with this ID or Title already exists!");
                return;
            }

            Book newBook = new Book();
            newBook.setId(bookId);
            newBook.setName(AddBook_BookTitle.getText());
            newBook.setAuthor(AddBook_Publisher.getText());
            newBook.setCategories((String) AddBook_Category.getSelectionModel().getSelectedItem());
            newBook.setPrice(price);
            newBook.setYearPublished(AddBook_Year.getSelectionModel().getSelectedItem());

            session.save(newBook);
            transaction.commit();

            alert.successMessage("Book added successfully!");

            addBookClear();


        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            alert.errorMessage("Error adding book: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }

    public void borrowBook() {
        alertMessage alert = new alertMessage();

        if ((BorrowedBook_BookID.getText().isEmpty())
                || (BorrowedBook_borrowedPeriod.getText().isEmpty())
                || (BorrowedBook_studentID.getText().isEmpty())) {
            alert.errorMessage("All fields are required.");
            return;
        }

        int bookId;
        int borrowingPeriod;
        int studentId;
        try {
            bookId = Integer.parseInt(BorrowedBook_BookID.getText());
            borrowingPeriod = Integer.parseInt(BorrowedBook_borrowedPeriod.getText());
            studentId = Integer.parseInt(BorrowedBook_studentID.getText());
        } catch (NumberFormatException e) {
            alert.errorMessage("Please enter valid numeric values for ID and Period");
            return;
        }

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Book book = session.get(Book.class, bookId);
            if (book == null) {
                alert.errorMessage("Book with ID " + bookId + " not found!");
                return;
            }

            if (book.isBorrowedStatus()) {
                if (book.getBorrowingDate() != null && book.getBorrowingPeriod() != null) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(book.getBorrowingDate());
                    cal.add(Calendar.DAY_OF_MONTH, book.getBorrowingPeriod());
                    Date returnDate = new Date(cal.getTimeInMillis());
                    alert.errorMessage("This book is currently borrowed and will be available after: " + returnDate);
                } else {
                    alert.errorMessage("This book is currently borrowed (return date unknown)");
                }
                return;
            }

            User student = session.get(User.class, studentId);
            if (student == null) {
                alert.errorMessage("Student with ID " + studentId + " not found!");
                return;
            }

            book.setBorrowedStatus(true);
            book.setBorrowingPeriod(borrowingPeriod);
            book.setBorrowingDate(new Date(System.currentTimeMillis()));
            book.setBorrowedBy(student);

            student.getBorrowedBooks().add(book);

            session.update(book);
            session.update(student);
            transaction.commit();

            alert.successMessage("Book borrowed successfully!\n" +
                    student.getUsername() + " now has " +
                    student.getBorrowedBooks().size() + " books.");

            clearBorrowFields();

        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            alert.errorMessage("Error borrowing book: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }

    public void clearBorrowFields() {
        BorrowedBook_BookID.clear();
        BorrowedBook_borrowedPeriod.clear();
        BorrowedBook_studentID.clear();
        BorrowedBook_studentName.clear();

        BorrowedBook_BookID.setStyle("");
        BorrowedBook_borrowedPeriod.setStyle("");
        BorrowedBook_studentID.setStyle("");
        BorrowedBook_studentName.setStyle("");
    }

    public boolean isBookBorrowed(int bookId) {
        SessionFactory sessionFactory = null;
        Session session = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();

            String hql = "SELECT b.borrowedStatus FROM Book b WHERE b.id = :bookId";
            Boolean isBorrowed = (Boolean) session.createQuery(hql)
                    .setParameter("bookId", bookId)
                    .uniqueResult();

            return isBorrowed != null && isBorrowed;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) session.close();
            if (sessionFactory != null) sessionFactory.close();
        }
    }

    public Date getBookReturnDate(int bookId) {
        SessionFactory sessionFactory = null;
        Session session = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();

            String hql = "SELECT b.borrowingDate, b.borrowingPeriod FROM Book b WHERE b.id = :bookId AND b.borrowedStatus = true";
            Object[] result = (Object[]) session.createQuery(hql)
                    .setParameter("bookId", bookId)
                    .uniqueResult();

            if (result != null && result[0] != null && result[1] != null) {
                Date borrowingDate = (Date) result[0];
                Integer borrowingPeriod = (Integer) result[1];

                if (borrowingDate != null && borrowingPeriod != null) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(borrowingDate);
                    cal.add(Calendar.DAY_OF_MONTH, borrowingPeriod);
                    return new Date(cal.getTimeInMillis());
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) session.close();
            if (sessionFactory != null) sessionFactory.close();
        }
    }

    public void deleteBookWithCheck() {
        alertMessage alert = new alertMessage();

        if (AddBook_BookID.getText().isEmpty()) {
            alert.errorMessage("Please enter a Book ID");
            return;
        }

        int bookId;
        try {
            bookId = Integer.parseInt(AddBook_BookID.getText());
        } catch (NumberFormatException e) {
            alert.errorMessage("Please enter a valid numeric Book ID");
            return;
        }

        if (isBookBorrowed(bookId)) {
            Date returnDate = getBookReturnDate(bookId);
            if (returnDate != null) {
                alert.errorMessage("This book is currently borrowed and cannot be deleted.\n" +
                        "It will be available for deletion after: " + returnDate);
            } else {
                alert.errorMessage("This book is currently borrowed and cannot be deleted.");
            }
            return;
        }

        Alert confirmation = new Alert(AlertType.CONFIRMATION);
        confirmation.setTitle("Confirmation Message");
        confirmation.setHeaderText(null);
        confirmation.setContentText("Are you sure you want to DELETE Book #" + bookId + "?");

        Optional<ButtonType> option = confirmation.showAndWait();
        if (!option.get().equals(ButtonType.OK)) {
            return;
        }

        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;

        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Book bookToDelete = session.get(Book.class, bookId);
            if (bookToDelete == null) {
                alert.errorMessage("Book with ID " + bookId + " not found!");
                return;
            }

            if (bookToDelete.isBorrowedStatus()) {
                alert.errorMessage("This book was just borrowed and cannot be deleted.");
                return;
            }

            session.delete(bookToDelete);
            transaction.commit();

            alert.successMessage("Book successfully deleted!");
            addBookClear();
            showAddBookTreeTableData();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            alert.errorMessage("Error deleting book: " + e.getMessage());
        } finally {
            if (session != null) session.close();
            if (sessionFactory != null) sessionFactory.close();
        }
    }

    public void addBookUpdate() {
        alertMessage alert = new alertMessage();

        if (AddBook_BookID.getText().isEmpty()
                || AddBook_Year.getSelectionModel().getSelectedItem() == null
                || AddBook_Publisher.getText().isEmpty()
                || AddBook_BookTitle.getText().isEmpty()
                || AddBook_Price.getText().isEmpty()
                || AddBook_Category.getSelectionModel().getSelectedItem() == null
        ){
            alert.errorMessage("Please fill all blank fields");
            return;
        }

        int bookId;
        double price;
        try {
            bookId = Integer.parseInt(AddBook_BookID.getText());
            price = Double.parseDouble(AddBook_Price.getText());
        } catch (NumberFormatException e) {
            alert.errorMessage("Invalid ID or Price format - must be numbers");
            return;
        }

        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Confirmation Message");
        confirmation.setHeaderText(null);
        confirmation.setContentText("Are you sure you want to UPDATE Book #"
                + AddBook_BookTitle.getText() + "?");

        Optional<ButtonType> option = confirmation.showAndWait();
        if (option.get() != ButtonType.OK) {
            return;
        }

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Book bookToUpdate = session.get(Book.class, bookId);
            if (bookToUpdate == null) {
                alert.errorMessage("Book with ID " + bookId + " not found!");
                return;
            }

            bookToUpdate.setName(AddBook_BookTitle.getText());
            bookToUpdate.setAuthor(AddBook_Publisher.getText());
            bookToUpdate.setPrice(price);
            bookToUpdate.setYearPublished(AddBook_Year.getSelectionModel().getSelectedItem());
            bookToUpdate.setCategories(AddBook_Category.getSelectionModel().getSelectedItem());


            session.update(bookToUpdate);
            transaction.commit();

            alert.successMessage("Successfully Updated!");

            showAddBookTreeTableData();
            addBookClear();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            alert.errorMessage("Error updating Book: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }

    public void addBookClear() {
        AddBook_BookTitle.setText("");
        AddBook_Price.setText("");
        AddBook_Publisher.setText("");
        AddBook_BookID.setText("");
        AddBook_Year.getSelectionModel().clearSelection();
        AddBook_Category.getSelectionModel().clearSelection();
    }

    public ObservableList<Book> loadAddBookListData() {
        ObservableList<Book> listBooks = FXCollections.observableArrayList();
        alertMessage alert = new alertMessage();

        SessionFactory sessionFactory = null;
        Session session = null;

        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();

            List<Book> books = session.createQuery(
                    "SELECT DISTINCT b FROM Book b",
                    Book.class
            ).list();
            listBooks.addAll(books);

        } catch (Exception e) {
            e.printStackTrace();
            alert.errorMessage("Error loading books: " + e.getMessage());
        } finally {
            if (session != null) session.close();
            if (sessionFactory != null) sessionFactory.close();
        }

        return listBooks;
    }

    private ObservableList<Book> bookList;

    public void showAddBookTreeTableData() {
        bookList = loadAddBookListData();

        // Create root TreeItem
        TreeItem<Book> root = new TreeItem<>();
        root.setExpanded(true);

        for (Book book : bookList) {
            root.getChildren().add(new TreeItem<>(book));
        }

        AddBook_col_ID.setCellValueFactory(param ->
                new ReadOnlyObjectWrapper<>(param.getValue().getValue().getId()));

        AddBook_col_Title.setCellValueFactory(param ->
                new ReadOnlyStringWrapper(param.getValue().getValue().getName()));

        AddBook_col_Publisher.setCellValueFactory(param ->
                new ReadOnlyStringWrapper(param.getValue().getValue().getAuthor()));

        AddBook_col_Price.setCellValueFactory(param ->
                new ReadOnlyObjectWrapper(param.getValue().getValue().getPrice()));

        AddBook_col_PublisherYear.setCellValueFactory(param ->
                new ReadOnlyStringWrapper(param.getValue().getValue().getYearPublished()));

        AddBook_col_Category.setCellValueFactory(param ->
                new ReadOnlyStringWrapper(param.getValue().getValue().getCategories()));


        AddBook_tableView.setRoot(root);
        AddBook_tableView.setShowRoot(false);
    }

    public ObservableList<Book> loadBorrowBookListData() {
        ObservableList<Book> listBooks = FXCollections.observableArrayList();
        alertMessage alert = new alertMessage();

        SessionFactory sessionFactory = null;
        Session session = null;

        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();

            List<Book> books = session.createQuery(
                    "SELECT DISTINCT b FROM Book b",
                    Book.class
            ).list();
            listBooks.addAll(books);

        } catch (Exception e) {
            e.printStackTrace();
            alert.errorMessage("Error loading books: " + e.getMessage());
        } finally {
            if (session != null) session.close();
            if (sessionFactory != null) sessionFactory.close();
        }

        return listBooks;
    }

    private ObservableList<Book> bookBorrowList;

    public void showBorrowBookTreeTableData() {
        bookBorrowList = loadBorrowBookListData();

        TreeItem<Book> root = new TreeItem<>();
        root.setExpanded(true);

        for (Book book : bookBorrowList) {
            root.getChildren().add(new TreeItem<>(book));
        }

        BorrowedBook_col_ID.setCellValueFactory(param ->
                new ReadOnlyStringWrapper(String.valueOf(param.getValue().getValue().getId())));

        BorrowedBook_col_Title.setCellValueFactory(param ->
                new ReadOnlyStringWrapper(param.getValue().getValue().getName()));

        BorrowedBook_col_Author.setCellValueFactory(param ->
                new ReadOnlyStringWrapper(param.getValue().getValue().getAuthor()));

        BorrowedBook_col_Status.setCellValueFactory(param ->
                new ReadOnlyStringWrapper(param.getValue().getValue().isBorrowedStatus() ? "Borrowed" : "Available"));

        BorrowedBook_col_borrowedDate.setCellValueFactory(param -> {
            Date date = param.getValue().getValue().getBorrowingDate();
            return new ReadOnlyStringWrapper(date != null ? date.toString() : "N/A");
        });

        BorrowedBook_col_borrowedPeriod.setCellValueFactory(param -> {
            Integer period = param.getValue().getValue().getBorrowingPeriod();
            return new ReadOnlyStringWrapper(period != null ? period.toString() + " days" : "N/A");
        });

        BorrowedBook_tableView.setRoot(root);
        BorrowedBook_tableView.setShowRoot(false);
    }

    private String[] yearList = {"First Year", "Second Year", "Third Year", "Fourth Year"};

    public void addBookYearList() {

        List<String> yearL = new ArrayList<>();

        for (String data : yearList) {
            yearL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(yearL);
        AddBook_Year.setItems(ObList);

    }

    private String[] categories = {"Biology", "Maths", "History", "chemistry", "politics"};

    public void addBookcategories() {
        List<String> categoryList = new ArrayList<>();

        for (String data : categories) {
            categoryList.add(data);
        }

        ObservableList<String> obList = FXCollections.observableArrayList(categoryList);
        AddBook_Category.setItems(obList);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        showAddBookTreeTableData();
        addBookYearList();
        addBookcategories();
        showBorrowBookTreeTableData();
    }
}
