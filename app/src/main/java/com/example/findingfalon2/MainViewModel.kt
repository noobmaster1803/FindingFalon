package android.example.findingfalon2

import android.app.appsearch.SearchResult
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val repository = Repository() // Implement your repository

    val planetsLiveData: LiveData<List<Planet>> = repository.getPlanets()
    val vehiclesLiveData: LiveData<List<Vehicle>> = repository.getVehicles()

    fun searchForFalcone(searchRequest: SearchRequest): LiveData<SearchResult> {
        return repository.searchForFalcone(searchRequest)
    }
}
