package com.wanderrful.repository

import com.wanderrful.core.Wallet

/**
 * Represents external calls to a fictional "wallet-service"
 */
interface WalletRepository {

    /**
     * Ask an external service for a list of wallets associated with the given customerId
     */
    fun getWalletsByCustomerId(customerId: String): List<Wallet?>?

}
