package com.yrj.spring_boot_demo.auto;


import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @类描述@：
 * @Author: 余仁杰
 * @Date: 2020/7/18 14:36
 */
@SpringBootTest
public class AutoTableBean {

    @Test
    public void test(){

        AutoGenerator ag = new AutoGenerator();

        //全局配置
        GlobalConfig config = new GlobalConfig();
        config //是否支持AR模式
                .setAuthor("yurenjie") //作者
                .setOutputDir("E:\\test")
                //生成路径
                .setFileOverride(true)//文件覆盖
                .setServiceName("%sService") //设置生成的service接口名首字母是否为I
                .setIdType(IdType.AUTO) //主键策略
                .setBaseResultMap(true)
                .setBaseColumnList(true);
        ag.setGlobalConfig(config);

        //数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)
                .setUrl("jdbc:mysql://localhost:3306/mysql2?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2B8")
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUsername("root")
                .setPassword("yrj961129");
        ag.setDataSource(dsConfig);

        //策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig
                .setCapitalMode(true) // 全局大写命名
                .setDbColumnUnderline(true) //表名 字段名 是否使用下滑线命名
                .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
                .setInclude("rioa_user") //生成的表
                .setTablePrefix("rioa_") // 表前缀
                .setSuperServiceClass(null)
                .setSuperServiceImplClass(null)
                .setSuperMapperClass(null);
        ag.setStrategy(stConfig);

        //包名策略
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.yrj")
                .setController("controller")
                .setEntity("beans")
                .setService("service")
                .setMapper("mapper")
                .setXml("mapper")
                .setServiceImpl("service.impl");
        ag.setPackageInfo(pkConfig);

        //执行
        ag.execute();
    }

}
