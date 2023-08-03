package org.shopManager.controller.scenes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.shopManager.controller.SceneHandler;
import org.shopManager.model.entity.Sku;
import org.shopManager.model.enumeration.Color;
import org.shopManager.model.enumeration.SceneType;
import org.shopManager.model.enumeration.Size;
import org.shopManager.model.utils.ControllerUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterSKUController implements Initializable {

    public Button cleanFieldsButton;
    public Button registerSKUButton;

    @FXML
    private TextField skuCodeInput;
    @FXML
    private ComboBox<String> skuColorSelect;
    @FXML
    private ComboBox<String> skuSizeSelect;
    @FXML
    private TextField skuPriceInput;
    @FXML
    private TextField skuAmountInput;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ControllerUtils.setSelectItems(skuColorSelect, Color.values());
        ControllerUtils.setSelectItems(skuSizeSelect, Size.values());
    }

    public void cleanAllFields() {
        skuColorSelect.setValue(null);
        skuSizeSelect.setValue(null);
        skuPriceInput.clear();
        skuAmountInput.clear();
    }

    public void registerSKU() throws IOException {
        if (skuCodeInput.getText() != null &&
                skuColorSelect.getValue() != null &&
                skuSizeSelect.getValue() != null &&
                skuPriceInput.getText() != null &&
                skuAmountInput.getText() != null) {

            Sku sku = new Sku();

            sku.setCode(skuCodeInput.getText());
            sku.setPrice(Float.parseFloat(skuPriceInput.getText()));
            sku.setColor(Color.valueOf(skuColorSelect.getValue()));
            sku.setSize(Size.valueOf(skuSizeSelect.getValue()));
            sku.setAmount(Integer.parseInt(skuAmountInput.getText()));

            RegisterProductController.product.addSku(sku);

            cleanAllFields();
            SceneHandler.handleScenes(SceneType.REGISTER_PRODUCT);
        }
    }

    public void cancelSKURegister(ActionEvent actionEvent) throws IOException {
        SceneHandler.handleScenes(SceneType.REGISTER_PRODUCT);
    }

    @FXML
    private void updateCodeInput() {
        String codeInputText = ControllerUtils.reverseString(skuCodeInput.getText().toUpperCase());
        skuCodeInput.setText(codeInputText);
    }

    @FXML
    private void updatePriceInput() {
        String priceInputText = ControllerUtils.reverseString(skuPriceInput.getText());
        if (ControllerUtils.isNumber(priceInputText)) {
            skuPriceInput.setText(priceInputText);
        } else {
            skuPriceInput.setText(priceInputText.substring(0, priceInputText.length() - 1));
        }
    }

    @FXML
    private void updateAmountInput() {
        String priceInputText = ControllerUtils.reverseString(skuAmountInput.getText());
        if (ControllerUtils.isNumber(priceInputText)) {
            skuAmountInput.setText(priceInputText);
        } else {
            skuAmountInput.setText(priceInputText.substring(0, priceInputText.length() - 1));
        }
    }
}
