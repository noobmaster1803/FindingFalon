package android.example.findingfalon2

data class SearchRequest(
    val token: String, // Your authentication token, if required
    val planet_names: List<String>, // List of planet names you want to search
    val vehicle_names: List<String> // List of vehicle names you want to use for the search
)
