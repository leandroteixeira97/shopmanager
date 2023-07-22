package org.shopManager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class Main extends Application {

    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        Main.stage = stage;
        stage.setResizable(false);
        AnchorPane authenticationForm = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxmls/AuthenticationForm.fxml")));
        Scene scene = new Scene(authenticationForm);
        stage.setScene(scene);
        stage.show();
    }

    public static void setScene(Scene scene) {
        Main.stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}