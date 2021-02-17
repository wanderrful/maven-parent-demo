package com.wanderrful.service

import com.wanderrful.core.Customer
import com.wanderrful.core.Wallet
import com.wanderrful.dto.GetCustomerResponse
import com.wanderrful.repository.CustomerRepository
import com.wanderrful.repository.WalletRepository

/**
 * Business logic for assembling fictional customer data via external services
 */
class CustomerService(
        private val walletRepository: WalletRepository,
        private val customerRepository: CustomerRepository) {

    /**
     * Safely retrieve nullable customer data from external services
     */
    fun getCustomerById(id: String): GetCustomerResponse {
        // If null, then it's null
        val customer: Customer? = customerRepository.getCustomerById(id)

        // If the list of wallets is null, then return an empty list
        // Also, if the list only contains nulls, then return an empty list
        val wallets: List<Wallet?> = walletRepository.getWalletsByCustomerId(id)?.filterNotNull() ?: listOf()

        return GetCustomerResponse(customer = customer, wallets = wallets)
    }

}
