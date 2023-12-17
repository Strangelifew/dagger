package atm.commands

import atm.io.Outputter
import java.math.BigDecimal


/**
 * Abstract [Command] that expects a single argument that can be converted to [ ].
 */
abstract class BigDecimalCommand protected constructor(private val outputter: Outputter) : SingleArgCommand() {
    override fun handleArg(arg: String): Command.Result {
        val amount = tryParse(arg)
        when {
            amount == null -> outputter.output("$arg is not a valid number")
            amount.signum() <= 0 -> outputter.output("amount must be positive")
            else -> handleAmount(amount)
        }
        return Command.Result.handled()
    }

    /** Handles the given (positive) `amount` of money.  */
    protected abstract fun handleAmount(amount: BigDecimal)

    companion object {
        private fun tryParse(arg: String): BigDecimal? = runCatching { BigDecimal(arg) }.getOrNull()
    }
}