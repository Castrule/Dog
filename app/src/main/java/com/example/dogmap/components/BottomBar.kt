package com.example.dogmap.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.dogmap.R

@Composable
fun BottomBar(navController: NavHostController){
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Button(onClick = {navController.navigate("MainPage")},
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            elevation = ButtonDefaults.elevation(0.dp),
            modifier = Modifier.height(44.dp)
                .background(color = Color.Transparent)
                .weight(1f)
                .fillMaxWidth()){
            Icon(painter = painterResource(R.drawable.ic_baseline_home_24),
                contentDescription = "desc")
        }
        Button(onClick = {navController.navigate("MapPage")},
            elevation = ButtonDefaults.elevation(0.dp),
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            modifier = Modifier.height(44.dp)
                .background(color = Color.Transparent)
                .weight(1f)
                .fillMaxWidth()){
            Icon(painter = painterResource(R.drawable.ic_baseline_search_24),
                contentDescription = "desc")
        }
        Button(onClick = {navController.navigate("AccountPage")},
            elevation = ButtonDefaults.elevation(0.dp),
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            modifier = Modifier.height(44.dp)
                .weight(1f)
                .fillMaxWidth()){
            Icon(painter = painterResource(R.drawable.ic_baseline_person_24),
                contentDescription = "desc")
        }
        Button(onClick = {navController.navigate("AccountPage")},
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            elevation = ButtonDefaults.elevation(0.dp),
            modifier = Modifier.height(44.dp)
                .weight(1f)
                .fillMaxWidth()){
            Icon(painter = painterResource(R.drawable.ic_baseline_more_horiz_24),
                contentDescription = "desc")
        }
    }
}