package org.shopManager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class Main extends Application {

    public Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        stage.setResizable(false);
        AnchorPane authenticationForm = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/AuthenticationForm.fxml")));
        Scene scene = new Scene(authenticationForm);
        stage.setScene(scene);
        stage.show();
    }

    public void handleScenes(String scene) throws IOException {
        switch (scene) {
            case "main" -> {
                AnchorPane fxmlUserChannelConfigScreen = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("/MainMenu.fxml")));
                Scene userChannelConfigScreen = new Scene(fxmlUserChannelConfigScreen);
                stage.setScene(userChannelConfigScreen);
            }
            default -> {
                System.out.printf("teste");
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}