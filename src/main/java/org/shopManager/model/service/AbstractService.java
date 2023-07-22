package org.shopManager.model.service;

import org.shopManager.model.utils.DatabaseUtils;

import java.sql.SQLException;

public abstract class AbstractService {

    protected DatabaseUtils databaseUtils;

    public AbstractService() throws SQLException {
        this.databaseUtils = new DatabaseUtils();
    }

}
