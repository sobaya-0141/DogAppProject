
package com.example.data

class Repository(private val apiService: DogApiService) {
    suspend fun fetchDogBreeds(): DogBreed = apiService.getRandomDogBreeds()
}
    