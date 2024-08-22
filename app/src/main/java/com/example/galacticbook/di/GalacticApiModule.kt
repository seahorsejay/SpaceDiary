package com.example.galacticbook.di

import com.example.galacticbook.model.GalacticApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit


@Module
@InstallIn(ViewModelComponent::class)
class GalacticApiModule {
    @Provides
    fun providesApi(retrofit: Retrofit): GalacticApi {
        return retrofit.create(GalacticApi::class.java)
    }
}