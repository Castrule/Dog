package com.example.dogmap.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.dogmap.R

@Composable
@Preview(showBackground = true)
fun WidgetPage(navHostController: NavHostController = rememberNavController()) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(painter = painterResource(R.drawable.sobaka_png), contentDescription = "desc")
        Text("Немецкая овчарка", fontWeight = FontWeight.Bold,
            fontSize = 25.sp, modifier = Modifier.padding(10.dp))
        Column(
            modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState()).padding(10.dp),

            ){
            Text("Характеристики:\n" +
                    "\n" +
                    "Возраст: 3 года\n" +
                    "Вес: ~2 кг\n" +
                    "Характер: Покладистая\n" +
                    "Дрессировка: Знает команды\n" +
                    "Размер: Средний\n" +
                    "Адрес: ул. Узкая 22/3\n" +
                    "\n" +
                    "Паспорт:\n" +
                    "Кличка: Ракета\n" +
                    "Пол: Мужской\n" +
                    "Дата рождения: 1.06.2019\n" +
                    "Вид животного: Собака\n" +
                    "Порода: Смешаная\n" +
                    "Окрас: Чёрно - белый, короткошёрстная",
                color = Color.DarkGray)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
        }
    }
}
}