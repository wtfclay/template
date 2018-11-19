package com.example.demo.util;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tool {

    public static final String TEMPLATE_PATH = "src/main/resources/templates";
    public static final String CLASS_PATH_MODEL = "/Users/clay/IdeaProjects/demo/src/main/java/com/example/demo/model/";
    public static final String CLASS_PATH_MAPPER = "/Users/clay/IdeaProjects/demo/src/main/java/com/example/demo/mapper/";
    public static final String CLASS_PATH_MAPPING = "/Users/clay/IdeaProjects/demo/src/main/resources/mapping/";
    public static final String TABLE_NAME = "user_info";


    public void model(List<Column> columnList) {
        // step1 创建freeMarker配置实例
        Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        Writer out = null;
        try {

            // step2 获取模版路径
            configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
            // step3 创建数据模型
            Map<String, Object> dataMap = new HashMap<String, Object>();
            dataMap.put("classPathModel", ClassPath.getPath(CLASS_PATH_MODEL));
            dataMap.put("className", HumpLine.lineToHump2(TABLE_NAME));

            dataMap.put("columnList", columnList);
            // step4 加载模版文件
            Template template = configuration.getTemplate("model.ftl");
            // step5 生成数据
            File docFile = new File(CLASS_PATH_MODEL + "" + dataMap.get("className") + ".java");
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
            // step6 输出文件
            template.process(dataMap, out);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^model.java 文件创建成功 !");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void mapper() {
        // step1 创建freeMarker配置实例
        Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        Writer out = null;
        try {

            // step2 获取模版路径
            configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
            // step3 创建数据模型
            Map<String, Object> dataMap = new HashMap<String, Object>();
            dataMap.put("classPathModel", ClassPath.getPath(CLASS_PATH_MODEL));
            dataMap.put("classPathMapper", ClassPath.getPath(CLASS_PATH_MAPPER));
            dataMap.put("className", HumpLine.lineToHump2(TABLE_NAME));
            dataMap.put("tableName", TABLE_NAME);
            // step4 加载模版文件
            Template template = configuration.getTemplate("mapper.ftl");
            // step5 生成数据
            File docFile = new File(CLASS_PATH_MAPPER + "" + dataMap.get("className") + "Mapper.java");
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
            // step6 输出文件
            template.process(dataMap, out);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^Mapper.java 文件创建成功 !");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void mapping(List<Column> columnList) {
        // step1 创建freeMarker配置实例
        Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        Writer out = null;
        try {

            // step2 获取模版路径
            configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
            // step3 创建数据模型
            Map<String, Object> dataMap = new HashMap<String, Object>();
            dataMap.put("classPathModel", ClassPath.getPath(CLASS_PATH_MODEL));
            dataMap.put("classPathMapper", ClassPath.getPath(CLASS_PATH_MAPPER));
            dataMap.put("className", HumpLine.lineToHump2(TABLE_NAME));
            dataMap.put("tableName", TABLE_NAME);

            dataMap.put("columnList", columnList);

            // step4 加载模版文件
            Template template = configuration.getTemplate("mapping.ftl");
            // step5 生成数据
            File docFile = new File(CLASS_PATH_MAPPING + "" + dataMap.get("className") + "Mapper.xml");
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
            // step6 输出文件
            template.process(dataMap, out);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^mapping.xml 文件创建成功 !");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
