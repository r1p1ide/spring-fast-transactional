package com.example.springfasttransactional.util.strings;

public class SqlStrings {

    public static final String GET_ALL_ACCOUNTS_SQL = "SELECT * FROM Account ORDER BY id";
    public static final String CREATE_ACCOUNT_SQL = "INSERT INTO Account VALUES (DEFAULT, ?, ?)";
    public static final String GET_MONEY_BY_ID_SQL = "SELECT balance FROM Account WHERE id=?";
    public static final String UPDATE_MONEY_SQL = "UPDATE Account SET balance=? WHERE id=?";

    // option with a transaction on the DB side
//    public static final String UPDATE_MONEY_SQL =
//            "UPDATE account SET balance=\n" +
//            "CASE\n" +
//            "WHEN id=? THEN ?\n" +
//            "WHEN id=? THEN ?\n" +
//            "ELSE balance\n" +
//            "END";
//
//    public static final String TRANSFER_MONEY_SQL =
//            "WITH constants (idFrom, idTo, moneyDiff) as (values (?, ?, ?))\n" +
//            "UPDATE account SET balance=\n" +
//            "\tCASE\n" +
//            "\t\tWHEN id=(SELECT idFrom FROM constants) THEN \n" +
//            "\t\t\t((SELECT balance FROM Account, constants WHERE id=idFrom) \n" +
//            "\t\t\t - (SELECT moneyDiff FROM constants))\n" +
//            "\t\tWHEN id=(SELECT idTo FROM constants) THEN \n" +
//            "\t\t\t((SELECT balance FROM Account, constants WHERE id=idTo) \n" +
//            "\t\t\t + (SELECT moneyDiff FROM constants))\n" +
//            "\tELSE balance\n" +
//            "END";
}
