package com.example.todolist;

import com.example.todolist.datamodel.TodoData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 500);
        stage.setTitle("Todo List!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    @Override
    public void stop() throws Exception {
        try {
            TodoData.getInstance().storeTodoItems();
        }catch (NullPointerException e){
            System.out.println("No data to save");
        }
    }
    @Override
    public void init() {
        try {
            TodoData.getInstance().loadTodoItems();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}