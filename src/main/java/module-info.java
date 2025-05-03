module edu.nu.testfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires jakarta.persistence;
    requires java.naming;
    requires org.hibernate.orm.core;
    requires static lombok;
    opens edu.nu.testfx to javafx.fxml;
    opens models to javafx.fxml, org.hibernate.orm.core;
    exports models;
    exports edu.nu.testfx;
}