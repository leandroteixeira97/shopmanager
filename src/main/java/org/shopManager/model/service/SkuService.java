package org.shopManager.model.service;

import org.shopManager.model.entity.Sku;
import org.shopManager.model.enumeration.Color;
import org.shopManager.model.enumeration.Size;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SkuService extends AbstractService {

    public SkuService() throws SQLException {
        super();
    }

    public Sku findSkuById(int skuId) throws SQLException {
        String sql = "SELECT * FROM sku WHERE id = " + skuId;
        ResultSet resultSet = databaseUtils.executeQuery(sql);

        if (resultSet.next()) {
            return convertResultSetIntoSku(resultSet);
        }

        throw new SQLException("No SKU was found to the given ID");
    }

    public List<Sku> findAllSkusByProductId(Long productId) throws SQLException {
        List<Sku> skuList = new ArrayList<>();
        String sql = "SELECT * FROM sku WHERE product_id = " + productId;
        ResultSet resultSet = databaseUtils.executeQuery(sql);

        while (resultSet.next()) {
            skuList.add(convertResultSetIntoSku(resultSet));
        }

        if (!skuList.isEmpty()) return skuList;

        throw new SQLException("No SKUs was found based on the given Product ID!");

    }

    private Sku convertResultSetIntoSku(ResultSet resultSet) throws SQLException {
        Sku sku = new Sku();

        sku.setId(resultSet.getInt("id"));
        sku.setCode(resultSet.getString("code"));
        sku.setColor(Color.valueOf(resultSet.getString("color")));
        sku.setSize(Size.valueOf(resultSet.getString("size")));
        sku.setPrice(resultSet.getFloat("price"));
        sku.setProductId(resultSet.getLong("product_id"));

        return sku;
    }

    public void insertNewSku(Sku sku) throws SQLException {
        String sql = "INSERT INTO sku (code, color, size, product_id, price, amount) VALUES ('" +
                sku.getCode() + "', '" + sku.getColor().toString() + "', '" + sku.getSize().toString() + "', " + sku.getProductId() + ", " + sku.getPrice() + ", " + sku.getAmount() + ");";
        databaseUtils.insert(sql, "sku");
    }
}
