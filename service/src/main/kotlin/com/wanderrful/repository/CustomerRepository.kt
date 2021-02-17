package com.wanderrful.repository

import com.wanderrful.core.Customer

/**
 * Represents calls to a fictional "customer-service"
 */
interface CustomerRepository {

    /**
     * Simple getById
     */
    fun getCustomerById(customerId: String): Customer?

}
