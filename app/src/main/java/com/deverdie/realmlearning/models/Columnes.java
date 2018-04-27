package com.deverdie.realmlearning.models;

public class Columnes {
    String dbColName;
    String dbColKey;
    int colIndex;

    public Columnes(String dbColName, String dbColKey, int colIndex) {
        this.dbColName = dbColName;
        this.dbColKey = dbColKey;
        this.colIndex = colIndex;
    }

    public String getDbName() {
        return dbColName;
    }

    public void setDbName(String dbName) {
        this.dbColName = dbName;
    }

    public String getDbColKey() {
        return dbColKey;
    }

    public void setDbColKey(String dbColKey) {
        this.dbColKey = dbColKey;
    }

    public int getColIndex() {
        return colIndex;
    }

    public void setColIndex(int colIndex) {
        this.colIndex = colIndex;
    }
}
