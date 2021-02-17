package com.wanderrful.service

import com.wanderrful.core.CurrencyCode
import com.wanderrful.core.Customer
import com.wanderrful.core.Money
import com.wanderrful.core.Wallet
import com.wanderrful.dto.GetCustomerResponse
import com.wanderrful.repository.CustomerRepository
import com.wanderrful.repository.WalletRepository
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CustomerServiceTest {

    @InjectMocks
    lateinit var customerService: CustomerService

    @Mock
    lateinit var customerRepository: CustomerRepository

    @Mock
    lateinit var walletRepository: WalletRepository

    /**
     * Should retrieve customer data and wallet data appropriately.
     */
    @Test
    fun testGetCustomerByIdHappyPath() {
        // Given
        val customerId = "myCustomerId"
        val fakeCustomer: Customer = createFakeCustomer(customerId = customerId)
        val fakeWallet: List<Wallet> = createFakeWallet(customerId = customerId)

        Mockito.`when`(customerRepository.getCustomerById(Mockito.anyString()))
                .thenReturn(fakeCustomer)
        Mockito.`when`(walletRepository.getWalletsByCustomerId(Mockito.anyString()))
                .thenReturn(fakeWallet)

        // When
        val outcome: GetCustomerResponse = customerService.getCustomerById(customerId)

        // Then
        Assert.assertNotNull("Outcome should be valid", outcome)
        Assert.assertEquals("CustomerId should match expectation", customerId, outcome.customer?.id)
        Assert.assertEquals("Wallet customerId should match expectation",
                fakeWallet.first().customerId,
                outcome.customer?.id)
        Assert.assertEquals("Wallet amount should match expectation",
                fakeWallet.first().balance.amount,
                outcome.wallets?.first()?.balance?.amount)
        Assert.assertEquals("Wallet currencyCode should match expectation",
                fakeWallet.first().balance.currencyCode,
                outcome.wallets?.first()?.balance?.currencyCode)
    }

    /**
     * Should handle null customer response gracefully.
     *  (e.g. if customer-service fails somehow)
     */
    @Test
    fun testGetCustomerByIdWithNullCustomerResponse() {
        // Given
        val customerId = "myCustomerId"
        val fakeWallet: List<Wallet> = createFakeWallet(customerId = customerId)

        Mockito.`when`(customerRepository.getCustomerById(Mockito.anyString()))
                .thenReturn(null)
        Mockito.`when`(walletRepository.getWalletsByCustomerId(Mockito.anyString()))
                .thenReturn(fakeWallet)

        // When
        val outcome: GetCustomerResponse = customerService.getCustomerById(customerId)

        // Then
        Assert.assertNotNull("Outcome should be valid", outcome)
        Assert.assertNull("Customer should be null", outcome.customer)
        Assert.assertEquals("Wallet amount should match expectation",
                fakeWallet.first().balance.amount,
                outcome.wallets?.first()?.balance?.amount)
        Assert.assertEquals("Wallet currencyCode should match expectation",
                fakeWallet.first().balance.currencyCode,
                outcome.wallets?.first()?.balance?.currencyCode)
    }

    /**
     * Should handle both null customer and wallet responses gracefully.
     *  (e.g. if both customer-service and wallet-service are down)
     */
    @Test
    fun testGetCustomerByIdWithNullCustomerAndWalletResponses() {
        // Given
        val customerId = "myCustomerId"
        val fakeWallet: List<Wallet> = createFakeWallet(customerId = customerId)

        Mockito.`when`(customerRepository.getCustomerById(Mockito.anyString()))
                .thenReturn(null)
        Mockito.`when`(walletRepository.getWalletsByCustomerId(Mockito.anyString()))
                .thenReturn(null)

        // When
        val outcome: GetCustomerResponse = customerService.getCustomerById(customerId)

        // Then
        Assert.assertNotNull("Outcome should be valid", outcome)
        Assert.assertNull("Customer should be null", outcome.customer)
        Assert.assertEquals("Wallet should be an empty list", emptyList<Wallet>(), outcome.wallets)
    }

    /**
     * Should throw NullPointerException when we try to force not-null with the !! operator
     */
    @Test(expected = NullPointerException::class)
    fun testGetCustomerByIdThrowsWhenForcingNPE() {
        // Given
        val customerId = "myCustomerId"
        val fakeWallet: List<Wallet> = createFakeWallet(customerId = customerId)

        Mockito.`when`(customerRepository.getCustomerById(Mockito.anyString()))
                .thenReturn(null)
        Mockito.`when`(walletRepository.getWalletsByCustomerId(Mockito.anyString()))
                .thenReturn(null)

        // When
        val outcome: GetCustomerResponse = customerService.getCustomerById(customerId)

        // Then
        Assert.assertNotNull("Outcome should be valid", outcome)
        Assert.assertNotNull("Customer should be null", outcome.customer!!.id)  // Throws NPE
    }

    private fun createFakeCustomer(customerId: String): Customer = Customer(id = customerId, walletIds = listOf("myWalletId"))

    private fun createFakeWallet(customerId: String): List<Wallet> = listOf(Wallet(
            customerId = customerId,
            balance = Money(currencyCode = CurrencyCode.EUR, amount = 100L)))

}
