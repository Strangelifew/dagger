package atm.commands

import atm.data.Database.Account
import atm.io.Outputter
import atm.WithdrawalLimiter
import java.math.BigDecimal
import javax.inject.Inject


class WithdrawCommand @Inject constructor(
    private val account: Account,
    private val outputter: Outputter,
    private val withdrawalLimiter: WithdrawalLimiter
) : BigDecimalCommand(outputter) {
    init {
        println("Creating a new $this")
    }

    override fun handleAmount(amount: BigDecimal) {
        val remainingWithdrawalLimit: BigDecimal = withdrawalLimiter.remainingWithdrawalLimit
        if (amount > remainingWithdrawalLimit) {
            outputter.output(
                "you may not withdraw $amount; you may withdraw $remainingWithdrawalLimit more in this session"
            )
        } else {
            account.withdraw(amount)
            withdrawalLimiter.recordWithdrawal(amount)
            outputter.output("${account.username()} now has: ${account.balance()}")
        }
    }
}