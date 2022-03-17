package kg.geektech.capstore.ui.fragments.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kg.geektech.capstore.core.network.Resource
import kg.geektech.capstore.data.models.User
import kg.geektech.capstore.data.remote.RemoteDataSource
import kotlinx.coroutines.Dispatchers

class RegistrationRepository(private val remoteDataSource: RemoteDataSource) {

    fun registrationUser(user: User): LiveData<Resource<User>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val response = remoteDataSource.registrationUser(user)
        emit(response)
    }
}