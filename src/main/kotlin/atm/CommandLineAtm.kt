package atm

import atm.commands.Command
import java.util.*

internal object CommandLineAtm {
    @JvmStatic
    fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        val commandProcessorFactory: CommandProcessorFactory = DaggerCommandProcessorFactory.create()
        val commandProcessor: CommandProcessor = commandProcessorFactory.commandProcessor()
        while (scanner.hasNextLine()) {
            val unused: Command.Status = commandProcessor.process(scanner.nextLine())
        }
    }
}