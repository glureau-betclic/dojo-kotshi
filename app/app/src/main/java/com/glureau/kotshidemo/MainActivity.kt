package com.glureau.kotshidemo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.glureau.kotshidemo.dto.BreweryJava
import com.glureau.kotshidemo.dto.BreweryKotlin
import com.glureau.kotshidemo.kotshi.DemoAdapterFactory
import com.glureau.kotshidemo.kotshi.KotshiDemoAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {

    private val moshi: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .add(KotshiDemoAdapterFactory)
        .build()

    private val api = Retrofit.Builder()
        .baseUrl("https://api.openbrewerydb.org")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
        .create(BreweryService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        api.breweriesJava()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ data ->
                tvJava.text = data.toString()
            })
    }
}
