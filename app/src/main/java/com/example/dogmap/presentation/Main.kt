package com.example.dogmap.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.dogmap.components.BottomBar
import com.example.dogmap.components.EventWidget1
import com.example.dogmap.components.TopBar
import com.example.dogmap.database.DogService
import com.example.dogmap.modules.Dog
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Composable
@Preview(showBackground = true)
fun MainPage(navController: NavHostController = rememberNavController()) {
    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomBar(navController)
        }
    ) {
        Body(navController)
    }
}

@Composable
fun Body(navController: NavHostController) {
    val dogs = remember {
        mutableStateOf(listOf<Dog>())
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(onClick = {
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
        }) {
            Text(text = "Получить собак")
        }
        for (dog in dogs.value) {
            EventWidget1(dog = dog)
        }
    }
}