package com.example.galacticbook.di

import com.example.galacticbook.domain.CoreConfigImpl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
class CoreDataModule {
    @Provides
    fun providesCoreConfig(): CoreConfigImpl {
        return CoreConfigImpl()
    }

    @Provides
    fun providesGson():Gson{
        return GsonBuilder().create()
    }

    @Provides
    fun providesGsonFactory(
        gson: Gson
    ): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    fun providesRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        coreConfig: CoreConfigImpl
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(gsonConverterFactory)
            .baseUrl(coreConfig.getBaseUrl())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
}