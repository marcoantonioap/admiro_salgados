module com.mocksolutions {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;

    opens com.mocksolutions to javafx.fxml;
    exports com.mocksolutions;
}
