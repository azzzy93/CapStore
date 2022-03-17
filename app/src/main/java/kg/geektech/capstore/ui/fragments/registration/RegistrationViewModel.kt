package kg.geektech.capstore.ui.fragments.registration

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import kg.geektech.capstore.data.models.User

class RegistrationViewModel(private val repository: RegistrationRepository) : ViewModel() {

    private val _user = MutableLiveData<User>()

    val registrationUser = _user.switchMap {
        repository.registrationUser(it)
    }

    fun setUser(user: User) {
        _user.postValue(user)
    }
}