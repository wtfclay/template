package com.example.demo.util;

import lombok.Data;

@Data
public class Column {
    //user_id
    private String columnName;
    //userId
    private String javaColumn;
    //VARCHAR
    private String typeName;
    //String
    private String javaType;
    //备注
    private String remarks;
    //主键
    private boolean pk = false;

}
