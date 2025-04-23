module edu.nu.testfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens edu.nu.testfx to javafx.fxml;
    exports edu.nu.testfx;
}