package org.shopManager.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import org.shopManager.Main;
import org.shopManager.model.enumeration.SceneType;

import java.io.IOException;
import java.util.Objects;

public class SceneHandler {

    public SceneHandler() {
    }

    public static void handleScenes(SceneType scene) throws IOException {
        switch (scene) {
            case MAIN_MENU -> {
                Main.setScene(getScene("fxmls/MainMenu.fxml"));
            }
            case LOGIN_FORM -> {
                Main.setScene(getScene("fxmls/AuthenticationForm.fxml"));
            }
            case REGISTER_PRODUCT -> {
                Main.setScene(getScene("fxmls/RegisterProduct.fxml"));
            }
            case REGISTER_SKU -> {
                Main.setScene(getScene("fxmls/RegisterSKU.fxml"));
            }
            default -> {
                Main.setScene(null);
            }
        }
    }

    private static AnchorPane getScreen(String fxmlName) throws IOException {
        return FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("/" + fxmlName)));
    }

    private static Scene getScene(String fxmlName) throws IOException {
        return new Scene(getScreen(fxmlName));
    }

}
