module com.example.todolist {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.todolist to javafx.fxml;
    exports com.example.todolist;
    exports com.example.todolist.datamodel;
    opens com.example.todolist.datamodel to javafx.fxml;
}