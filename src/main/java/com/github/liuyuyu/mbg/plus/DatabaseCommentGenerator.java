package com.github.liuyuyu.mbg.plus;

import lombok.Getter;
import lombok.Setter;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.internal.DefaultCommentGenerator;

/*
 * @author liuyuyu
 */
public class DatabaseCommentGenerator extends DefaultCommentGenerator {
    @Getter
    @Setter
    private boolean enable = true;

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if(!this.enable){
            return;
        }
        field.addJavaDocLine("/**");
        String remarks = introspectedColumn.getRemarks();
        field.addJavaDocLine(" *");
        field.addJavaDocLine(" * "+remarks);
        field.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
    }
}
