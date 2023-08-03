package org.shopManager.controller.scenes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.shopManager.controller.SceneHandler;
import org.shopManager.model.entity.Product;
import org.shopManager.model.entity.Sku;
import org.shopManager.model.enumeration.CategoryType;
import org.shopManager.model.enumeration.Color;
import org.shopManager.model.enumeration.SceneType;
import org.shopManager.model.enumeration.Size;
import org.shopManager.model.service.ProductService;
import org.shopManager.model.service.SkuService;
import org.shopManager.model.utils.ControllerUtils;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RegisterProductController implements Initializable {

    public TableColumn<Sku, String> skuTableCodeColumn;
    public TableColumn<Sku, Color> skuTableColorColumn;
    public TableColumn<Sku, Size> skuTableSizeColumn;
    public TableColumn<Sku, Float> skuTablePriceColumn;
    public TableColumn<Sku, Integer> skuTableAmountColumn;
    public TableColumn skuTableEditionColumn;
    @FXML
    private TextField productNameInput;
    @FXML
    private TextField productBrandInput;
    @FXML
    private ComboBox<String> productCategorySelect;
    @FXML
    private TableView<Sku> skuList;
    @FXML
    private Label registerProductFeedbackLabel;

    private ProductService productService;
    private SkuService skuService;

    public static Product product = new Product();

    public void registerProduct() {
        CategoryType productCategory = CategoryType.valueOf(productCategorySelect.getValue());
        List<Sku> skus = product.getSkus();

        try {
            if (product.getName() != null && product.getBrand() != null && !skus.isEmpty()) {
                product.setCategory(productCategory);
                Long productId = productService.insertNewProduct(product);

                if (productId != 0) {
                    for (Sku sku : skus) {
                        sku.setProductId(productId);
                        skuService.insertNewSku(sku);
                    }
                }

                clearInputs();
                registerProductFeedbackLabel.setText("Produto cadastrado com sucesso!");
            } else if (product.getName() != null && product.getBrand() != null) {
                registerProductFeedbackLabel.setText("Adicione pelo menos um SKU à lista!");
            } else {
                registerProductFeedbackLabel.setText("Preencha todos os campos necessários!");
            }
        } catch (SQLException e) {
            registerProductFeedbackLabel.setText("Não foi possível registrar o produto. Por favor, contate o suporte.");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.productService = new ProductService();
            this.skuService = new SkuService();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ControllerUtils.setSelectItems(productCategorySelect, CategoryType.values());
        loadProductInfo();
        loadSkuTable();
    }

    private void loadProductInfo() {
        if (product.getName() != null) productNameInput.setText(product.getName());
        if (product.getBrand() != null) productBrandInput.setText(product.getBrand());
    }

    private void initializeColumns() {
        skuTableCodeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        skuTableColorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
        skuTableSizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        skuTablePriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        skuTableAmountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
    }

    @FXML
    private void updateProductName() {
        RegisterProductController.product.setName(productNameInput.getText());
    }

    @FXML
    private void updateProductBrand() {
        RegisterProductController.product.setBrand(productBrandInput.getText());
    }

    private void loadSkuTable() {
        initializeColumns();

        if (product.getSkus() != null && !product.getSkus().isEmpty()) {
            ObservableList<Sku> tableData = FXCollections.observableArrayList(product.getSkus());

            skuList.setItems(tableData);
        } else {
            skuList.setItems(FXCollections.emptyObservableList());
        }
    }

    private void clearInputs() {
        product = new Product();
        productCategorySelect.setValue(null);
        loadSkuTable();
    }

    public void cleanAllFields() {
        this.clearInputs();
    }

    public void openRegisterSKUWindow() throws IOException {
        SceneHandler.handleScenes(SceneType.REGISTER_SKU);
    }
}
