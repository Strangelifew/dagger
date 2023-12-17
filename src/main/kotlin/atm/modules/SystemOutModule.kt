package atm.modules

import atm.io.Outputter
import dagger.Module
import dagger.Provides


@Module
object SystemOutModule {
  @Provides
  fun textOutputter(): Outputter = Outputter(::println)
}