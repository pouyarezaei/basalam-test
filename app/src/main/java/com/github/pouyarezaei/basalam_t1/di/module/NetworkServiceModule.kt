import com.github.pouyarezaei.basalam_t1.data.remote.BasalamNetworkService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
class NetworkServiceModule {
    @Provides
    fun provideBasalamNetworkService(retrofit: Retrofit): BasalamNetworkService {
        return retrofit.create(BasalamNetworkService::class.java)
    }
}