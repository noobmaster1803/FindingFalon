package com.example.findingfalon2

import android.example.findingfalon2.MainViewModel
import android.example.findingfalon2.SearchRequest
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var planetSpinner: Spinner
    private lateinit var vehicleSpinner: Spinner
    private lateinit var resultTextView: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        planetSpinner = findViewById(R.id.planetSpinner)
        vehicleSpinner = findViewById(R.id.vehicleSpinner)
        resultTextView = findViewById(R.id.resultTextView)

        viewModel.planetsLiveData.observe(this) { planets ->
            val planetNames = planets.map { it.name }
            val planetAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, planetNames)
            planetAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            planetSpinner.adapter = planetAdapter
        }

        viewModel.vehiclesLiveData.observe(this) { vehicles ->
            val vehicleNames = vehicles.map { it.name }
            val vehicleAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, vehicleNames)
            vehicleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            vehicleSpinner.adapter = vehicleAdapter
        }


    }

    fun searchButtonClick(view: View) {
        val selectedPlanet = planetSpinner.selectedItem as String
        val selectedVehicle = vehicleSpinner.selectedItem as String

        // Create a SearchRequest object based on selectedPlanet and selectedVehicle

        val searchRequest = SearchRequest(
            token = "zWSOZUCQJOPUhweUgYklARgNbuNVCyin", // Replace with your authentication token if required
            planet_names = listOf(selectedPlanet),
            vehicle_names = listOf(selectedVehicle)
        )

        viewModel.searchForFalcone(searchRequest).observe(this) { result ->
            resultTextView.text = "Result: $result"
        }
    }
}