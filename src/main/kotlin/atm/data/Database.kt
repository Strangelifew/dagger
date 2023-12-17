package atm.data

import java.math.BigDecimal
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Database @Inject constructor() {
    init {
        println("Creating a new $this")
    }

    private val accounts = HashMap<String, Account>()
    fun getAccount(username: String): Account = accounts.computeIfAbsent(username, ::Account)

    class Account(private val username: String) {
        private var balance = BigDecimal.ZERO
        fun username(): String = username

        fun balance(): BigDecimal = balance

        fun deposit(amount: BigDecimal) {
            balance += amount
        }

        fun withdraw(amount: BigDecimal) {
            deposit(-amount)
        }
    }
}