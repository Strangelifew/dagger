package atm.commands

import atm.data.Database.Account
import atm.io.Outputter
import atm.WithdrawalLimiter
import java.math.BigDecimal
import javax.inject.Inject


class DepositCommand @Inject constructor(
    private val account: Account,
    private val outputter: Outputter,
    private val withdrawalLimiter: WithdrawalLimiter
) :
    BigDecimalCommand(outputter) {
    init {
        println("Creating a new $this")
    }

    protected override fun handleAmount(amount: BigDecimal) {
        account.deposit(amount)
        withdrawalLimiter.recordDeposit(amount)
        outputter.output("${account.username()} now has: ${account.balance()}")
    }

}