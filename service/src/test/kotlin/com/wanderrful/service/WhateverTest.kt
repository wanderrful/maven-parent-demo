package com.wanderrful.service

import com.wanderrful.core.Customer
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class WhateverTest {

    @Test
    fun testSimpleNullity() {
        // When
        var blah: String? = "hello"

        // Then
        println("blah=${blah}")  // blah=hello

        // And

        // When
        blah = null

        // Then
        println("blah=${blah}")  // blah=null
    }

    /**
     * When we use ?. to access a property, it auto-checks nullity and just returns null if it encounters that
     */
    @Test
    fun testKotlinNullMethods() {
        // When
        var customer: Customer? = Customer(id = "hello", walletIds = listOf("world"))

        // Then
        println("customer.id=${customer?.id}")  // customer.id=null

        // And

        // When
        customer = null

        // Then
        println("customer.id=${customer?.id}")  // customer.id=null

        // And

        // When
        customer = Customer(id = null, walletIds = null)

        // Then
        println("customer.id=${customer.id}")  // customer.id=null

        // And

        // When
        customer = Customer(id = null, walletIds = null)

        // Then
        println("customer.walletIds[0]=${customer.walletIds?.first()}")  // customer.walletIds[0]=null
    }

}
