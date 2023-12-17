package atm.commands

import atm.UserCommandsRouter
import atm.commands.Command.Result
import atm.data.Database
import atm.data.Database.Account
import atm.io.Outputter
import java.util.Optional
import javax.inject.Inject
import kotlin.jvm.optionals.getOrNull


class LoginCommand @Inject constructor(
    private val database: Database,
    private val outputter: Outputter,
    private val userCommandsRouterFactory: UserCommandsRouter.Factory,
    account: Optional<Account>
) : SingleArgCommand() {
    private val account = account.getOrNull()

    init {
        println("Creating a new $this")
    }

    public override fun handleArg(arg: String): Result = account?.let { Result.handled() } ?: run {
        val username = arg
        val account = database.getAccount(username)
        outputter.output(
            "$username is logged in with balance: ${account.balance()}"
        )
        Result.enterNestedCommandSet(userCommandsRouterFactory.create(account).router())
    }
}