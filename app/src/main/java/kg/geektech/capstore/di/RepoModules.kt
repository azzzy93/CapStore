package kg.geektech.capstore.di

import kg.geektech.capstore.ui.fragments.registration.RegistrationRepository
import org.koin.dsl.module

val repoModules = module {
    single { RegistrationRepository(get()) }
}