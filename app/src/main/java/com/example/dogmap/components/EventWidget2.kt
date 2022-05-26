package com.example.dogmap.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.dogmap.R


@Composable
fun EventWidget2(navController: NavHostController){
    Button(onClick = {navController.navigate("WidgetPage")},
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        elevation = ButtonDefaults.elevation(0.dp)
    ){
        Card(
            elevation = 0.dp,
            modifier = Modifier
                .clip(RoundedCornerShape(10))
                .height(200.dp)
                .width(300.dp)
                .padding(0.dp),

            ){
            Image(painter = painterResource(id = R.drawable.sobaka2_png), contentDescription = "desc",
                modifier = Modifier
                    .fillMaxSize())
            Text("Дворовая", textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(40.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Black,
                                Color.Transparent,
                                Color.Transparent
                            )
                        )
                    ), color = Color.White,
                fontWeight = FontWeight.Bold)
        }
    }
}