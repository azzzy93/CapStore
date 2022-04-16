package kg.geektech.capstore.di.product

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kg.geektech.capstore.data.product.ProductRepositoryImpl
import kg.geektech.capstore.data.product.remote.ProductApi
import kg.geektech.capstore.di.NetworkModule
import kg.geektech.capstore.domain.product.repository.ProductRepository
import kg.geektech.capstore.domain.product.usecase.GetProductUseCase
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
object ProductModule {

    @Provides
    @Singleton
    fun provideProductApi(retrofit: Retrofit): ProductApi {
        return retrofit.create(ProductApi::class.java)
    }

    @Provides
    @Singleton
    fun provideProductRepository(productApi: ProductApi): ProductRepository {
        return ProductRepositoryImpl(productApi)
    }

    @Provides
    @Singleton
    fun provideGetProductUseCase(productRepository: ProductRepository): GetProductUseCase {
        return GetProductUseCase(productRepository)
    }

}