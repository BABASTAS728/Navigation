package com.example.navigation.di

import com.example.navigation.data.RepositoryImpl
import com.example.navigation.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModel {
    @Binds
    abstract fun getRepository(impl: RepositoryImpl): Repository
}