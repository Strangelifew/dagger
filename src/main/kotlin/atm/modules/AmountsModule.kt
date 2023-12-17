package atm.modules

import dagger.Module
import dagger.Provides
import java.math.BigDecimal


@Module
internal interface AmountsModule {
    companion object {
        @Provides
        @MinimumBalance
        fun minimumBalance(): BigDecimal = BigDecimal.ZERO

        @Provides
        @MaximumWithdrawal
        fun maximumWithdrawal(): BigDecimal = 1000.toBigDecimal()
    }
}

