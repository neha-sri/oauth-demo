package com.nsri.oauthdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
/**
 * @author neha-sri
 */

@SpringBootApplication
class OauthDemoApplication

fun main(args: Array<String>) {
	runApplication<OauthDemoApplication>(*args)
}
