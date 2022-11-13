package com.example.highload1

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories


@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
@EnableJpaRepositories
class HighLoad1Application

fun main(args: Array<String>) {
	runApplication<HighLoad1Application>(*args)
}
