# Mybatis-Generator-plus

Mybatis-Generator 的插件集合

### 已有功能
- [x] 数据库comment支持
- [x] 实体上增加lombok注解（Getter/Setter移除）
- [x] 清空ResultMap

### 开始使用

暂时没有上传到仓库，需要先安装到本地
```
mvn clean install -Dmaven.test.skip=true
```

pom.xml
```xml
    <plugin>
        <groupId>org.mybatis.generator</groupId>
        <artifactId>mybatis-generator-maven-plugin</artifactId>
        <version>1.3.2</version>
        <configuration>
            <configurationFile>${basedir}/src/main/resources/generatorConfig.xml</configurationFile>
            <overwrite>true</overwrite>
            <verbose>true</verbose>
        </configuration>
        <dependencies>
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>${mysql.version}</version>
            </dependency>
            <dependency>
                <groupId>tk.mybatis</groupId>
                <artifactId>mapper</artifactId>
                <version>${mapper.version}</version>
            </dependency>
            <dependency>
                <groupId>com.github.liuyuyu</groupId>
                <artifactId>mbg-plus</artifactId>
                <version>${mbg.version}</version>
            </dependency>
        </dependencies>
    </plugin>
```
generatorConfig.xml
```xml
    <plugin type="com.github.liuyuyu.mbg.plus.ClearResultMapPlugin" />
    <plugin type="com.github.liuyuyu.mbg.plus.LombokPlugin" />

    <commentGenerator type="com.github.liuyuyu.mbg.plus.DatabaseCommentGenerator" />
```

最后，运行
```bash
mvn mybatis-generator:generate
```
