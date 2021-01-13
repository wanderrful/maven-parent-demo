package com.wanderrful

import kotlin.jvm.JvmStatic

import org.slf4j.LoggerFactory

import com.wanderrful.service.MyService

/**
 * Hello world!
 *
 */
object App {
    @JvmStatic
    fun main(args: Array<String>) {
        val myService = MyService()
        val logger = LoggerFactory.getLogger(App::class.java)
        logger.info(myService.message)
    }
}