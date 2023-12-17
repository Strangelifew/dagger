package atm

import atm.data.Database.Account
import atm.modules.PerSession
import atm.modules.UserCommandsModule
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent

@PerSession
@Subcomponent(modules = [UserCommandsModule::class])
interface UserCommandsRouter {
    fun router(): CommandRouter

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance account: Account): UserCommandsRouter
    }

    @Module(subcomponents = [UserCommandsRouter::class])
    interface InstallationModule
}