package atm.modules

import atm.commands.Command
import atm.commands.DepositCommand
import atm.commands.LogoutCommand
import atm.commands.WithdrawCommand
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey


@Module
abstract class UserCommandsModule {
    @Binds
    @IntoMap
    @StringKey("deposit")
    abstract fun depositCommand(command: DepositCommand): Command

    @Binds
    @IntoMap
    @StringKey("withdraw")
    abstract fun withdrawCommand(command: WithdrawCommand): Command

    @Binds
    @IntoMap
    @StringKey("logout")
    abstract fun logoutCommand(command: LogoutCommand): Command
}