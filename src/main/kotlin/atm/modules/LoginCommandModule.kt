package atm.modules

import atm.commands.Command
import atm.commands.LoginCommand
import atm.data.Database.Account
import dagger.Binds
import dagger.BindsOptionalOf
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey


@Module
interface LoginCommandModule {
    @Binds
    @IntoMap
    @StringKey("login")
    fun loginCommand(command: LoginCommand): Command

    @BindsOptionalOf
    fun optionalAccount(): Account?
}