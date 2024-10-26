
package com.example.data

import retrofit2.http.GET

interface DogApiService {
    @GET("breeds/image/random/10")
    suspend fun getRandomDogBreeds(): DogBreed
}
    