package atm.modules

import atm.commands.Command
import atm.commands.HelloWorldCommand
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey


@Module
abstract class HelloWorldModule {
  @Binds
  @IntoMap
  @StringKey("hello")
  abstract fun helloWorldCommand(command: HelloWorldCommand): Command
}