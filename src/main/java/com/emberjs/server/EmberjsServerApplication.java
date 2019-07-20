package com.emberjs.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import io.katharsis.spring.boot.v3.KatharsisConfigV3;

/**
 * 一定要禁用掉默认加载数据源类，否则项目无法启动
 * 报错：
 * Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.
 * com.mongodb.MongoSocketOpenException: Exception opening socket
 * @author ubuntuvim
 *
 */
@EnableMongoAuditing
//@Slf4j
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@Import({KatharsisConfigV3.class})
public class EmberjsServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmberjsServerApplication.class, args);
	}

}
