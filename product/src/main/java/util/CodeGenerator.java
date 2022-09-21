package util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://119.3.231.229:3306/dcr?serverTimezone=UTC", "root", "Dcr+123456")
                .globalConfig(builder -> {
                    builder.author("baomidou") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
//                            .fileOverride()
                            .outputDir("D:\\IdeaProjects\\POC\\marketing\\product\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.szsm.product") // 设置父包名
                            .moduleName(null) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\IdeaProjects\\POC\\marketing\\product\\src\\main\\resources\\mappers")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.entityBuilder().enableLombok();//使用lombok
                    builder.controllerBuilder().enableHyphenStyle()
                            .enableRestStyle();//开启RestController
                    builder.addInclude("product_info"); // 设置需要生成的表名
                })
                .templateEngine(new FreemarkerTemplateEngine()).templateConfig(builder -> builder.controller("")) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}