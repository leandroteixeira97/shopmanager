package org.shopManager.model.utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class ControllerUtils {

    public static void setSelectItems(ComboBox<String> comboBox, Object[] items) {
        ObservableList<String> objects = FXCollections.observableArrayList();

        for (Object item : items) {
            objects.add(item.toString());
        }

        comboBox.setItems(objects);
    }

    public static boolean isNumber(String stringedNumber) {
        try {
            Double.parseDouble(stringedNumber);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String reverseString(String string) {
        if (string.length() > 1) {
            return string.charAt(string.length() - 1) + reverseString(string.substring(0, string.length() - 1));
        }

        return string;
    }

}
