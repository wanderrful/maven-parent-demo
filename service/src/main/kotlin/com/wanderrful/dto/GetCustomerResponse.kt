package com.wanderrful.dto

import com.wanderrful.core.Customer
import com.wanderrful.core.Wallet

data class GetCustomerResponse(val customer: Customer?, val wallets: List<Wallet?>?)
