package org.shopManager.model.service;

import org.shopManager.model.entity.Product;
import org.shopManager.model.enumeration.CategoryType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductService extends AbstractService {

    private SkuService skuService;

    public ProductService() throws SQLException {
        super();
        this.skuService = new SkuService();
    }

    public Product findProductById(int id) throws SQLException {
        String sql = "SELECT * FROM product WHERE id = " + id;
        ResultSet resultSet = databaseUtils.executeQuery(sql);

        if (resultSet.next()) {
            Product product = new Product();

            product.setId(resultSet.getLong("id"));
            product.setName(resultSet.getString("name"));
            product.setCategory(CategoryType.valueOf(resultSet.getString("category")));
            product.setSkus(skuService.findAllSkusByProductId(product.getId()));

            return product;
        }

        throw new SQLException("No product was found based on the given ID");
    }

    public Long createNewProduct(Product product) throws SQLException {
        String sql = "INSERT INTO product (name, category) VALUES ('" + product.getName() + "', '" + product.getCategory().toString() + "');";
        ResultSet resultSet = databaseUtils.executeQuery(sql);
        return resultSet.getLong("id");
    }

}
