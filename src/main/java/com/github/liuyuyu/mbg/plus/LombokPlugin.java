package com.github.liuyuyu.mbg.plus;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

/*
 * 增加lombok支持
 * @author liuyuyu
 */
@Slf4j
@Data
public class LombokPlugin extends PluginAdapter {
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        this.addLombokAnnotation(topLevelClass,introspectedTable);
        return true;
    }

    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        this.addLombokAnnotation(topLevelClass,introspectedTable);
        return true;
    }

    @Override
    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        this.addLombokAnnotation(topLevelClass,introspectedTable);
        return true;
    }

    @Override
    public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        this.addLombokAnnotation(topLevelClass,introspectedTable);
        return true;
    }


    private void addLombokAnnotation(TopLevelClass topLevelClass, IntrospectedTable introspectedTable){
        topLevelClass.addImportedType("lombok.*");
        topLevelClass.addAnnotation("@Data");
    }

    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return false;
    }

    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return false;
    }
}
