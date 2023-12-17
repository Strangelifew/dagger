package atm.commands

import atm.CommandRouter
import java.util.*


/** Logic to process some user input.  */
interface Command {

    /** Process the rest of the command's words and do something.  */
    fun handleInput(input: List<String>): Result

    /**
     * This wrapper class is introduced to make a future change easier
     * even though it looks unnecessary right now.
     */
    class Result(
        private val status: Status,
        private val nestedCommandRouter: Optional<CommandRouter>
    ) {
        fun status(): Status = status

        fun nestedCommandRouter(): Optional<CommandRouter> = nestedCommandRouter


        companion object {
            fun invalid(): Result = Result(Status.INVALID, Optional.empty())
            fun handled(): Result = Result(Status.HANDLED, Optional.empty())
            fun enterNestedCommandSet(nestedCommandRouter: CommandRouter): Result =
                Result(Status.HANDLED, Optional.of(nestedCommandRouter))
            fun inputCompleted(): Result = Result(Status.INPUT_COMPLETED, Optional.empty())
        }
    }

    enum class Status {
        INVALID, HANDLED, INPUT_COMPLETED
    }
}

