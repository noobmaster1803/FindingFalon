package android.example.findingfalon2

import android.app.appsearch.SearchResult
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.findingfalon2.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    private val apiService: ApiService = NetworkService.getInstance().create(ApiService::class.java)

    fun getPlanets(): LiveData<List<Planet>> {
        val planetsLiveData = MutableLiveData<List<Planet>>()

        apiService.getPlanets().enqueue(object : Callback<List<Planet>> {
            override fun onResponse(call: Call<List<Planet>>, response: Response<List<Planet>>) {
                if (response.isSuccessful) {
                    planetsLiveData.value = response.body()
                } else {
                    // Handle API error
                }
            }

            override fun onFailure(call: Call<List<Planet>>, t: Throwable) {
                // Handle network failure
            }
        })

        return planetsLiveData
    }

    fun getVehicles(): LiveData<List<Vehicle>> {
        val vehiclesLiveData = MutableLiveData<List<Vehicle>>()

        apiService.getVehicles().enqueue(object : Callback<List<Vehicle>> {
            override fun onResponse(call: Call<List<Vehicle>>, response: Response<List<Vehicle>>) {
                if (response.isSuccessful) {
                    vehiclesLiveData.value = response.body()
                } else {
                    // Handle API error
                }
            }

            override fun onFailure(call: Call<List<Vehicle>>, t: Throwable) {
                // Handle network failure
            }
        })

        return vehiclesLiveData
    }

    fun searchForFalcone(searchRequest: SearchRequest): LiveData<SearchResult> {
        val resultLiveData = MutableLiveData<SearchResult>()

        apiService.findFalcone(searchRequest).enqueue(object : Callback<SearchResult> {
            override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {
                if (response.isSuccessful) {
                    resultLiveData.value = response.body()
                } else {
                    // Handle API error
                }
            }

            override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                // Handle network failure
            }
        })

        return resultLiveData
    }
}
