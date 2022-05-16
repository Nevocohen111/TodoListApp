package com.example.todolist.datamodel;

import javafx.collections.FXCollections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TodoData {
    private static TodoData instance = new TodoData();
    private static String fileName = "TodoListItems.txt";

    private List<TodoItem> todoItems;
    private DateTimeFormatter formatter;


    public static TodoData getInstance() {
        return instance;
    }

    private TodoData() {
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public List<TodoItem> getTodoItems() {
        return todoItems;
    }
    public void addTodoItem(TodoItem item) {
        todoItems.add(item);
    }

 /*   public void setTodoItems(List<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }*/

    public void loadTodoItems() throws IOException {
        todoItems = FXCollections.observableArrayList();
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String input;
            while ((input = reader.readLine()) != null) {
                //split by tab
                String[] itemPieces = input.split("\\t");
                String shortDescription = itemPieces[0];
                String details = itemPieces[1];
                String dateString = itemPieces[2];
                LocalDate localDate = LocalDate.parse(dateString, formatter);
                TodoItem todoItem = new TodoItem(shortDescription, details, localDate);
                todoItems.add(todoItem);
            }
        }
    }

    public void storeTodoItems() throws IOException {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            Iterator<TodoItem> iterator = todoItems.iterator();
            while(iterator.hasNext()) {
                TodoItem item = iterator.next();
                writer.write(String.format("%s\t%s\t%s", item.getShortDescription(), item.getDetails(), item.getDeadline().format(formatter)));
                writer.newLine();
            }
        }
    }

    public void deleteTodoItem(TodoItem item) {
    	todoItems.remove(item);
    }

}
