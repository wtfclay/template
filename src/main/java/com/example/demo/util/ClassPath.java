package com.example.demo.util;

/**
 * 根据文件路径获取类路径
 */
public class ClassPath {
    public static String getPath(String path) {
        String index = "src.main.java";
        String p = path.replaceAll("/", ".");
        p = p.substring(p.indexOf(index) + index.length() + 1, p.length() - 1);
        return p;
    }
}
