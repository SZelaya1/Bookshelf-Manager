package org.example.bookshelfmanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.io.IOException;

public class StartApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("bookshelf-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), visualBounds.getWidth(), visualBounds.getHeight());
        stage.setTitle("Bookshelf Management App");
        stage.getIcons().add(new Image(StartApplication.class.getResourceAsStream("bookshelf.png")));
        stage.setScene(scene);
        stage.setX(visualBounds.getMinX());
        stage.setY(visualBounds.getMinY());
        stage.setWidth(visualBounds.getWidth());
        stage.setHeight(visualBounds.getHeight());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}