package com.example.demo.util;

/**
 * mysql类型 jdbcType javaType 转换
 */
public class Type {


    public static String getJavaType(String mysqlType) {
        String javaType = mysqlType;

        if ("BIGINT".equals(mysqlType)) {
            javaType = "Long";
        } else if ("TINYINT".equals(mysqlType)) {
            javaType = "Byte";
        } else if ("SMALLINT".equals(mysqlType)) {
            javaType = "Short";
        } else if ("MEDIUMINT".equals(mysqlType)) {
            javaType = "Integer";
        } else if ("INTEGER".equals(mysqlType)) {
            javaType = "Integer";
        } else if ("INT".equals(mysqlType)) {
            javaType = "Integer";
        } else if ("FLOAT".equals(mysqlType)) {
            javaType = "Float";
        } else if ("DOUBLE".equals(mysqlType)) {
            javaType = "Double";
        } else if ("DECIMAL".equals(mysqlType)) {
            javaType = "BigDecimal";
        } else if ("NUMERIC".equals(mysqlType)) {
            javaType = "BigDecimal";
        } else if ("CHAR".equals(mysqlType)) {
            javaType = "String";
        } else if ("VARCHAR".equals(mysqlType)) {
            javaType = "String";
        } else if ("TINYBLOB".equals(mysqlType)) {
            javaType = "byte[]";
        } else if ("TINYTEXT".equals(mysqlType)) {
            javaType = "String";
        } else if ("BLOB".equals(mysqlType)) {
            javaType = "byte[]";
        } else if ("TEXT".equals(mysqlType)) {
            javaType = "String";
        } else if ("MEDIUMBLOB".equals(mysqlType)) {
            javaType = "byte[]";
        } else if ("MEDIUMTEXT".equals(mysqlType)) {
            javaType = "String";
        } else if ("LONGBLOB".equals(mysqlType)) {
            javaType = "byte[]";
        } else if ("LONGTEXT".equals(mysqlType)) {
            javaType = "String";
        } else if ("DATE".equals(mysqlType)) {
            javaType = "Date";
        } else if ("TIME".equals(mysqlType)) {
            javaType = "Date";
        } else if ("YEAR".equals(mysqlType)) {
            javaType = "Date";
        } else if ("DATETIME".equals(mysqlType)) {
            javaType = "Date";
        } else if ("TIMESTAMP".equals(mysqlType)) {
            javaType = "Date";
        }
        return javaType;
    }

    public static String getJdbcType(String mysqlType) {
        String jdbcType = mysqlType;

        if ("BIGINT".equals(mysqlType)) {
        } else if ("TINYINT".equals(mysqlType)) {
        } else if ("SMALLINT".equals(mysqlType)) {
        } else if ("MEDIUMINT".equals(mysqlType)) {
            jdbcType = "INTEGER";
        } else if ("INTEGER".equals(mysqlType)) {
        } else if ("INT".equals(mysqlType)) {
            jdbcType = "INTEGER";
        } else if ("FLOAT".equals(mysqlType)) {
            jdbcType = "REAL";
        } else if ("DOUBLE".equals(mysqlType)) {
        } else if ("DECIMAL".equals(mysqlType)) {
        } else if ("NUMERIC".equals(mysqlType)) {
            jdbcType = "DECIMAL";
        } else if ("CHAR".equals(mysqlType)) {
        } else if ("VARCHAR".equals(mysqlType)) {
        } else if ("TINYBLOB".equals(mysqlType)) {
            jdbcType = "BINARY";
        } else if ("TINYTEXT".equals(mysqlType)) {
            jdbcType = "VARCHAR";
        } else if ("BLOB".equals(mysqlType)) {
            jdbcType = "BINARY";
        } else if ("TEXT".equals(mysqlType)) {
            jdbcType = "LONGVARCHAR";
        } else if ("MEDIUMBLOB".equals(mysqlType)) {
            jdbcType = "LONGVARBINARY";
        } else if ("MEDIUMTEXT".equals(mysqlType)) {
            jdbcType = "LONGVARCHAR";
        } else if ("LONGBLOB".equals(mysqlType)) {
            jdbcType = "LONGVARBINARY";
        } else if ("LONGTEXT".equals(mysqlType)) {
            jdbcType = "LONGVARCHAR";
        } else if ("DATE".equals(mysqlType)) {
        } else if ("TIME".equals(mysqlType)) {
        } else if ("YEAR".equals(mysqlType)) {
            jdbcType = "DATE";
        } else if ("DATETIME".equals(mysqlType)) {
            jdbcType = "TIMESTAMP";
        } else if ("TIMESTAMP".equals(mysqlType)) {
            jdbcType = "TIMESTAMP";
        }
        return jdbcType;
    }
}
