package kg.geektech.capstore.di

import kg.geektech.capstore.ui.fragments.registration.RegistrationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModules = module {
    viewModel { RegistrationViewModel(get()) }
}