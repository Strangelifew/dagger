package atm

import atm.commands.Command.Result
import atm.commands.Command.Status
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
internal class CommandProcessor @Inject constructor(firstCommandRouter: CommandRouter) {
    private val commandRouterStack: Deque<CommandRouter> = ArrayDeque<CommandRouter>()

    init {
        commandRouterStack.push(firstCommandRouter)
    }

    fun process(input: String): Status {
        val result: Result = commandRouterStack.peek().route(input)
        if (result.status().equals(Status.INPUT_COMPLETED)) {
            commandRouterStack.pop()
            return if (commandRouterStack.isEmpty()) Status.INPUT_COMPLETED else Status.HANDLED
        }
        result.nestedCommandRouter().ifPresent(commandRouterStack::push)
        return result.status()
    }
}