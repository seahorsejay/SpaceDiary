package com.example.galacticbook.di

import android.view.View
import com.example.galacticbook.domain.GalacticProvider
import com.example.galacticbook.domain.GalacticProviderImpl
import com.example.galacticbook.domain.GalacticRepository
import com.example.galacticbook.domain.GalacticRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface GalacticProviderModule {
    @Binds
    fun GalacticProvider(impl: GalacticProviderImpl):GalacticProvider

    @Binds
    fun GalacticRepository(impl:GalacticRepositoryImpl):GalacticRepository
}