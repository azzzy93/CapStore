package kg.geektech.capstore.data.remote

import kg.geektech.capstore.data.models.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("auth/jwt/create/")
    suspend fun registrationUser(@Body user: User): Response<User>
}