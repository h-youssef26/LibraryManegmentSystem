module edu.nu.testfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.persistence;
    requires java.naming;
    requires org.hibernate.orm.core;
    opens edu.nu.testfx to javafx.fxml;
    exports edu.nu.testfx;
}