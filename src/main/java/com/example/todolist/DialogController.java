package com.example.todolist;

import com.example.todolist.datamodel.TodoData;
import com.example.todolist.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogController {
    @FXML
    private TextField shortDescriptionField;
    @FXML
    private TextArea detailsArea;
    @FXML
    private DatePicker datelinePicker;



    public TodoItem processResult() {
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate datelineValue = datelinePicker.getValue();
        TodoItem newItem = new TodoItem(shortDescription, details, datelineValue);
        TodoData.getInstance().addTodoItem(newItem);
        return newItem;
    }

}
