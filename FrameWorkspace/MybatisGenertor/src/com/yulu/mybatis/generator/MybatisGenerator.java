package com.yulu.mybatis.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MybatisGenerator {
	public static void main(String[] args) {
		try {
			// 警告信息集合
			List<String> warnings = new ArrayList<String>();
			// 每次生成代码前需要将以前生成的先删除
		    boolean overwrite = true;
		    File configFile = new File("config/generatorConfig.xml");
		    ConfigurationParser cp = new ConfigurationParser(warnings);
		    Configuration config = cp.parseConfiguration(configFile);
		    DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		    MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		    myBatisGenerator.generate(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
