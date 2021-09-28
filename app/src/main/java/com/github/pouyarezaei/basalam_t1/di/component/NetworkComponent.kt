import com.github.pouyarezaei.basalam_t1.MainActivity
import com.github.pouyarezaei.basalam_t1.di.module.CoreNetworkModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreNetworkModule::class, NetworkServiceModule::class])
interface NetworkComponent {
    @Component.Factory
    interface Factory {
        fun create(): NetworkComponent
    }

    fun provideBasalamNetworkService(retrofit: Retrofit)
    fun inject(activity: MainActivity)

}