package atm

import atm.modules.AmountsModule
import atm.modules.HelloWorldModule
import atm.modules.LoginCommandModule
import atm.modules.SystemOutModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        HelloWorldModule::class,
        SystemOutModule::class,
        LoginCommandModule::class,
        UserCommandsRouter.InstallationModule::class,
        AmountsModule::class
    ]
)
internal interface CommandProcessorFactory {
    fun commandProcessor(): CommandProcessor
}