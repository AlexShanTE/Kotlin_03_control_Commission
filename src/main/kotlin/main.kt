const val MASTERCARD = "Mastercard"
const val MAESTRO = "Maestro"

const val VISA = "Visa"
const val MIR = "Мир"

const val VK_PAY = "VK Pay"


fun main() {
    println(calculateComission(currentTransaction = 10000))
    println(calculateComission(cardName = MIR,currentTransaction = 1000000))
    println(calculateComission(cardName = MAESTRO,lastTransaction = 600000,currentTransaction = 1000))
    println(calculateComission(cardName = VISA,currentTransaction = 10000))
}

fun calculateComission(
    cardName: String = VK_PAY,
    lastTransaction: Int = 0,
    currentTransaction: Int
):Int  {
    return when (cardName) {
        MASTERCARD, MAESTRO -> {
            when {
                lastTransaction < 75000 -> 0
                else -> (currentTransaction * 0.006 + 20).toInt()
            }
        }
        VISA, MIR -> {
            when {
                currentTransaction * 0.0075 < 3500 -> 3500
                else -> (currentTransaction * 0.0075).toInt()
            }
        }
        VK_PAY -> 0
        else -> -1
    }
}