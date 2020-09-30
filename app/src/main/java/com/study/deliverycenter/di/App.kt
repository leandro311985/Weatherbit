package com.study.deliverycenter.di

import android.app.Application
import android.content.Context
import com.study.deliverycenter.api.ApiHelper
import com.study.deliverycenter.api.ApiHelperImpl
import com.study.deliverycenter.api.ICityForecastService
import com.study.deliverycenter.repository.Repository
import com.study.deliverycenter.ui.MainViewModel
import com.study.deliverycenter.utils.BASE_URL_
import com.study.deliverycenter.utils.NetworkHelper
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    appModule,
                    repoModule,
                    viewModelModule
                )
            )
        }
    }

}

val appModule = module {
    single { provideOkHttpClient() }
    single {
        provideRetrofit(
            get(),
            BASE_URL_
        )
    }
    single { provideApiService(get()) }
    single { provideNetworkHelper(androidContext()) }
    single<ApiHelper> {
        return@single ApiHelperImpl(get())
    }
}

val viewModelModule = module {
    viewModel {
        MainViewModel(get(), get())
    }
}

val repoModule = module {
    single {
        Repository(get())
    }
}


private fun provideNetworkHelper(context: Context) =
    NetworkHelper(context)


private fun provideOkHttpClient() = OkHttpClient.Builder()
    .connectTimeout(1, TimeUnit.MINUTES)
    .readTimeout(1, TimeUnit.MINUTES)
    .writeTimeout(1, TimeUnit.MINUTES)
    .callTimeout(1, TimeUnit.MINUTES)
    .build()

private fun provideRetrofit(
    okHttpClient: OkHttpClient,
    BASE_URL_: String
): Retrofit =
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL_)
        .client(okHttpClient)
        .build()

private fun provideApiService(retrofit: Retrofit): ICityForecastService =
    retrofit.create(ICityForecastService::class.java)