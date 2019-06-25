# 基于内存的单元测试代码


## 基于内存数据库H2和embedded-redis的单元测试的例子，
  当进行单元测试时，很多开发小伙伴都会想到mock数据，或者链接远程数据仓库。mock假的数据进行测试不太容易测出底层代码问题；链接远程数据仓库，
  如果不是你一个人在用，很可能别人会破坏你的测试数据。
  可以利用内存数据库来解决单元测试问题，H2是一个不错的选择；embedded-redis可以替换线上redis，也是java语言实现https://github.com/kstyrc/embedded-redis；
  
  ## 引入
    <dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>com.github.kstyrc</groupId>
			<artifactId>embedded-redis</artifactId>
			<version>0.6</version>
			<scope>test</scope>
		</dependency>
