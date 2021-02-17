package com.wanderrful

import kotlin.jvm.JvmStatic

import org.slf4j.LoggerFactory

import com.wanderrful.helpers.AppHelper

/**
 * Hello world!
 */
object App {
    @JvmStatic
    fun main(args: Array<String>) {
        val appHelper = AppHelper()

        val logger = LoggerFactory.getLogger(App::class.java)
        logger.info(appHelper.retrieveBaseMessage())
    }
}