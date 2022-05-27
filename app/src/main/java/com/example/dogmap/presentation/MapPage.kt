package com.example.dogmap

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.dogmap.components.BottomBar
import com.example.dogmap.components.TopBar
import com.example.dogmap.database.DogService
import com.example.dogmap.modules.Dog
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun MapPage(navController: NavHostController = rememberNavController()) {
    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomBar(navController)
        }
    ) {
        MapPageBody(navController)
    }
}

@Composable
fun MapPageBody(navController: NavHostController) {
    val yakutsk = LatLng(62.031043, 129.727878)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(yakutsk, 15f)
    }
    var position: MutableState<LatLng?> = remember {
        mutableStateOf(null)
    }
    val dogs = remember {
        mutableStateOf(listOf<Dog>())
    }
    var popUpShow = remember {
        mutableStateOf(false)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        onMapLongClick = { address ->
            popUpShow.value = true
            position.value = address
        },
        onMapLoaded = {
            CoroutineScope(Dispatchers.IO).launch {
                val retrofit = Retrofit
                    .Builder()
                    .baseUrl("https://itcube.goykt.ru/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                val result = retrofit.create(DogService::class.java).getDogs().execute()
                val newDogs: List<Dog> = result.body() as List<Dog>
                dogs.value = newDogs
            }
        }
    ) {
        for (dog in dogs.value){
            Marker(
                position = LatLng(dog.latitude, dog.longitude),
                title = dog.name,
                snippet = dog.description
            )
        }
        Marker(
            position = yakutsk,
            title = "Yakutsk",
            snippet = "Marker in Yakutsk"
        )
    }
    if (popUpShow.value) {
        var dogName = remember {
            mutableStateOf("")
        }
        var dogDescription = remember {
            mutableStateOf("")
        }
        AlertDialog(
            onDismissRequest = { popUpShow.value = false },
            title = { Text("Добавление собаки") },
            text = {
                Column() {
                    TextField(value = dogName.value, onValueChange = {
                        dogName.value = it
                    })
                    TextField(value = dogDescription.value, onValueChange = {
                        dogDescription.value = it
                    })
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        // Change the state to close the dialog
                        popUpShow.value = false
                        val newDog = Dog(
                            dogName.value,
                            dogDescription.value,
                            position.value?.latitude ?: 1.2,
                            position.value?.longitude ?: 1.2
                        )

                        CoroutineScope(Dispatchers.IO).launch {
                            val retrofit = Retrofit
                                .Builder()
                                .baseUrl("https://itcube.goykt.ru/")
                                .addConverterFactory(GsonConverterFactory.create())
                                .build()
                            retrofit.create(DogService::class.java).createDog(newDog).execute()
                        }

                    },
                ) {
                    Text("Сохранить")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        // Change the state to close the dialog
                        popUpShow.value = false
                    },
                ) {
                    Text("Отменить")
                }
            },
        )
    }
}
