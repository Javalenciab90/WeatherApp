# Weather App with Clean Architecture & Jetpack Compose

**Porpuse of this project is implement modularity clean architecture.**

This is a small project built with Clean Architecture and Jetpack Compose. 
The project utilizes the WeatherMaps API to search for weather information 
by typing a city name into the search bar. It demonstrates the navigation 
between screens, with one screen showing the weather details and another
screen showing a map (though the map is not fully implemented in this version).
The app also includes a bottom sheet displaying brief weather information.

| Empty | Weather | WeatherMap |
| ------------- | ------------- | ------------- |
| ![EmptyWeather](https://github.com/user-attachments/assets/406009d2-b4f1-4ef4-abdd-e0556e2f2057)|![Weather](https://github.com/user-attachments/assets/ff4e568a-6392-498a-9417-f2c3c532f2b7)|![WeatherMap](https://github.com/user-attachments/assets/144268d5-296b-4faa-ab55-674e48d66706)

- Search for Weather: Users can type a city name in the search bar to get weather details.
- Navigation: Can search on second screen that displays a map (used for navigation demonstration purposes, not implemented).
- Bottom Sheet: Displays minimal weather details on the map screen.
- Clean Architecture: The app follows Clean Architecture principles, ensuring separation of concerns and scalability.

## Architecture

This app is structured around Clean Architecture and includes the following modules:

**- app:** Holds the main activity and NavigationHost to manage screen navigation.

**- common-ui:** Manages common UI components like error handling views and icons used throughout the app.

**- design-system:** Contains abstract components and the app's theme, defining UI consistency.

**- platform:** Manages base classes for ViewModel, CoroutineContext, and handles UI effects. Also defines the routes used in navigation.

**- domain:** Manages domain models, the DataMapper interface, and API exceptions. It ensures business logic is separated from other layers.

**- features:** Contains the core functionality of the app, such as the weather module and weatherMap module.

**- weather module:** Implements view, viewModel, useCase, and repository to handle weather data, including fetching and presenting weather information.

**- data module:** Handles the data sources. Fetches data from the service API and maps it to the database (using Room), providing a single source of truth for the app.

**- network models module:** Manages the DTOs (Data Transfer Objects) used by the data and service modules, ensuring no cyclic dependencies between them.

**- service module:** Manages the connection to the external service API (WeatherMaps API) to fetch weather data.

# Modular scheme

![image](https://github.com/user-attachments/assets/58b03838-e889-427c-9126-0988a2cd237f)

# Pattern Presentation
**MVI**
![image](https://github.com/user-attachments/assets/b2910eab-b8cf-4bed-bed2-9e66bd60f6b4)


# Principal Libraries

- [API](https://api.openweathermap.org/data/2.5/weather)
- [Coroutines](https://developer.android.com/topic/libraries/architecture/coroutines?hl=es-419)
- [Retrofit2](https://github.com/square/retrofit)
- [Gson](https://github.com/google/gson)
- [HILT](https://developer.android.com/training/dependency-injection/hilt-android?hl=es-419)
- [Compose](https://developer.android.com/develop/ui/compose/bom?hl=es-419)
- [Room](https://developer.android.com/jetpack/androidx/releases/room?hl=es-419)
