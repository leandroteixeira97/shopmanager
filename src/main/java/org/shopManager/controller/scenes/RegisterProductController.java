package org.shopManager.controller.scenes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.shopManager.model.enumeration.CategoryType;
import org.shopManager.model.enumeration.Color;
import org.shopManager.model.enumeration.Size;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterProductController implements Initializable {

    @FXML
    private TextField productNameInput;
    @FXML
    private TextField productBrandInput;
    @FXML
    private ComboBox<CategoryType> productCategorySelect;
    @FXML
    private Button newSkuButton;
    @FXML
    private ComboBox<Color> skuColorSelect;
    @FXML
    private ComboBox<Size> skuSizeSelect;
    @FXML
    private TextField skuPriceInput;
    @FXML
    private TextField skuAmountInput;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
