package kg.geektech.capstore.data.remote

import kg.geektech.capstore.core.network.BaseDataSource
import kg.geektech.capstore.core.network.Resource
import kg.geektech.capstore.data.models.User

class RemoteDataSource(private val apiService: ApiService) : BaseDataSource() {

    suspend fun registrationUser(user: User): Resource<User> {
        return getResult {
            apiService.registrationUser(user)
        }
    }
}