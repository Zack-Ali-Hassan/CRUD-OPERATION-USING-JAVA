module com.example.crudoperation {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.crudoperation to javafx.fxml;
    exports com.example.crudoperation;
}