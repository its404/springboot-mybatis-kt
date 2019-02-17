package site.tsun.mybatisdemo

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@MapperScan("site.tsun.mybatisdemo.mapper")
class MybatisDemoApplication

fun main(args: Array<String>) {
	runApplication<MybatisDemoApplication>(*args)
}

