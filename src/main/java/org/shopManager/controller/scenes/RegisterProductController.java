package org.shopManager.controller.scenes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.shopManager.model.entity.Product;
import org.shopManager.model.entity.Sku;
import org.shopManager.model.enumeration.CategoryType;
import org.shopManager.model.enumeration.Color;
import org.shopManager.model.enumeration.Size;
import org.shopManager.model.service.ProductService;
import org.shopManager.model.service.SkuService;

import java.net.URL;
import java.sql.SQLException;
import java.util.*;

public class RegisterProductController implements Initializable {

    @FXML
    private TextField productNameInput;
    @FXML
    private TextField productBrandInput;
    @FXML
    private ComboBox<String> productCategorySelect;
    @FXML
    private Button newSkuButton;
    @FXML
    private ComboBox<String> skuColorSelect;
    @FXML
    private ComboBox<String> skuSizeSelect;
    @FXML
    private TextField skuPriceInput;
    @FXML
    private TextField skuAmountInput;
    @FXML
    private Label registerProductFeedbackLabel;
    private ProductService productService;
    private SkuService skuService;

    public void registerProduct() throws SQLException {
        String productName = productNameInput.getText();
        String productBrand = productBrandInput.getText();
        CategoryType productCategory = CategoryType.valueOf(productCategorySelect.getValue());
        Color skuColor = Color.valueOf(skuColorSelect.getValue());
        Size skuSize = Size.valueOf(skuSizeSelect.getValue());
        float skuPrice = Float.parseFloat(skuPriceInput.getText());
        int skuAmount = Integer.parseInt(skuAmountInput.getText());

        if (productName != null && productBrand != null && skuPrice != 0 && skuAmount != 0) {
            Product product = new Product(productName, productCategory, productBrand);
            Long productId = productService.insertNewProduct(product);

            if (productId != 0) {
                Sku sku = new Sku();

                sku.setColor(skuColor);
                sku.setSize(skuSize);
                sku.setPrice(skuPrice);
                sku.setAmount(skuAmount);
                sku.setProductId(productId);

                skuService.insertNewSku(sku);

                clearInputs();
                registerProductFeedbackLabel.setText("Produto cadastrado com sucesso!");
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clearInputs();
        try {
            this.productService = new ProductService();
            this.skuService = new SkuService();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        setSelectItems(productCategorySelect, CategoryType.values());
        setSelectItems(skuColorSelect, Color.values());
        setSelectItems(skuSizeSelect, Size.values());
    }

    private void setSelectItems(ComboBox<String> comboBox, Object[] items) {
        ObservableList<String> objects = FXCollections.observableArrayList();

        for (Object item : items) {
            objects.add(item.toString());
        }

        comboBox.setItems(objects);
    }

    private void clearInputs() {
        productNameInput.clear();
        productBrandInput.clear();
        productCategorySelect.setValue(null);
        skuColorSelect.setValue(null);
        skuSizeSelect.setValue(null);
        skuPriceInput.clear();
        skuAmountInput.clear();
    }
}
