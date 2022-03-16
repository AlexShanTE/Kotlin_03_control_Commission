import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calculateComission_DefaultValues() {
        val expectedComission = 0
        val actualComission = calculateComission(currentTransaction = 1000)
        assertEquals(expectedComission,actualComission)
    }
    @Test
    fun calculateComission_MasterCard_Maestro_lowLastTransaction() {
        val cardName: String = MASTERCARD
        val lastTransaction = 10_000
        val currentTransaction = 100_000
        val expectedComission = -1
        val actualComission = calculateComission(cardName,lastTransaction,currentTransaction)
        assertEquals(expectedComission,actualComission)
    }
    @Test
    fun calculateComission_MasterCard_Maestro_HighLastTransaction() {
        val cardName = MAESTRO
        val lastTransaction = 100_000
        val currentTransaction = 100_000
        val expectedComission = 620
        val actualComission = calculateComission(cardName,lastTransaction,currentTransaction)
        assertEquals(expectedComission,actualComission)
    }
    @Test
    fun calculateComission_Visa_MIR_CurrentLessThanMinimalCommission() {
        val cardName = VISA
        val currentTransaction = 100
        val expectedComission = 3500
        val actualComission = calculateComission(
            cardName = cardName,
            currentTransaction = currentTransaction
        )
        assertEquals(expectedComission,actualComission)
    }
    @Test
    fun calculateComission_Visa_MIR_CurrentMoreThanMinimalCommission() {
        val cardName = MIR
        val currentTransaction = 1_000_000
        val expectedComission = 7500
        val actualComission = calculateComission(
            cardName = cardName,
            currentTransaction = currentTransaction
        )
        assertEquals(expectedComission,actualComission)
    }
    @Test
    fun calculateComission_VK_PAY() {
        val cardName = VK_PAY
        val lastTransaction = 10_000
        val currentTransaction = 1_000_000
        val expectedComission = 0
        val actualComission = calculateComission(cardName,lastTransaction,currentTransaction)
        assertEquals(expectedComission,actualComission)
    }
    @Test
    fun calculateComission_UnknownCard() {
        val cardName = "UnknownCard"
        val lastTransaction = 1_000
        val currentTransaction = 1_000_000
        val expectedComission = -1
        val actualComission = calculateComission(cardName,lastTransaction,currentTransaction)
        assertEquals(expectedComission,actualComission)
    }


}