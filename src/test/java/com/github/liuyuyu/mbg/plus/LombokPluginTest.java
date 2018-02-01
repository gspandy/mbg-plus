package com.github.liuyuyu.mbg.plus;

import org.junit.Before;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * @author liuyuyu
 */
public class LombokPluginTest {
    private InputStream resource;

    @Before
    public void before() throws URISyntaxException, IOException {
        //读取mybatis参数
        resource = this.getClass().getClassLoader().getResourceAsStream("generatorConfig.xml");

//        configFile = new File("/Users/zhangsiyuan/Documents/MybatisFun/Mybatis-Chapter9-GeneratorPlugin/src/main/resources/mybatisConfig.xml");
    }

    @Test
    public void modelFieldGenerated() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(resource);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        System.out.println("end.");
    }
}