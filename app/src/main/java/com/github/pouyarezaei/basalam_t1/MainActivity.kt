package com.github.pouyarezaei.basalam_t1

import DaggerNetworkComponent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import com.github.pouyarezaei.basalam_t1.data.domain.InformationMapper
import com.github.pouyarezaei.basalam_t1.data.remote.BasalamNetworkService
import com.github.pouyarezaei.basalam_t1.repository.BasalamRepository
import com.github.pouyarezaei.basalam_t1.util.TAG
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var basalamNetworkService: BasalamNetworkService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerNetworkComponent.factory().create().inject(this)
        setContentView(R.layout.main_activity)
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
        Log.d(TAG, "onCreate: $basalamNetworkService")
        val repo = BasalamRepository(basalamNetworkService, InformationMapper())
        runBlocking {
            repo.getAnimalPairFlower()
        }
    }
}