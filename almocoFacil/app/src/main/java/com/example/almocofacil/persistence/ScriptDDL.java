package com.example.almocofacil.persistence;

public class ScriptDDL {

    public static String getCreateTableAutorizacao() {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE IF NOT EXISTS AUTORIZACAO ( ");
        sql.append("ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, ");
        sql.append("ALUNONOME VARCHAR(200) UNIQUE NOT NULL DEFAULT (''), ");
        sql.append("ALUNOMATRICULA VARCHAR(200) UNIQUE NOT NULL DEFAULT (''), ");
        sql.append("DATA VARCHAR (20) NOT NULL DEFAULT (''), ");
        sql.append("REFEICAONOME VARCHAR (20) NOT NULL DEFAULT ('') ");
        sql.append("STATUSAUTORIZACAO VARCHAR (50) NOT NULL DEFAULT ('') ");
        sql.append("REQUISICAOID VARCHAR (20) NOT NULL DEFAULT ('') ");
        sql.append("REFEICAOID VARCHAR (20) NOT NULL DEFAULT ('') ");
        sql.append(") ");
        return sql.toString();
    }
}
