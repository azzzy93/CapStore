package kg.geektech.capstore.di

import kg.geektech.capstore.core.network.networkModules

val koinModules = listOf(
    networkModules,
    repoModules,
    viewModules
)