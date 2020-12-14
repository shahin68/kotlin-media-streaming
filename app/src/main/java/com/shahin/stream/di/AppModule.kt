package com.shahin.stream.di

import com.shahin.stream.ui.MainViewModel
import com.shahin.stream.ui.fragments.home.HomeViewModel
import com.shahin.stream.ui.fragments.profile.ProfileViewModel
import com.shahin.stream.ui.fragments.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { SearchViewModel() }
    viewModel { ProfileViewModel() }
}
