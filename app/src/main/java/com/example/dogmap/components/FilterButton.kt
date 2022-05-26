package com.example.dogmap.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun FilterButton(image: Int, text: String){
    Row(modifier = Modifier
        .clip(RoundedCornerShape(40))
        .background(color = Color(0xFF1D4ED8))
        .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically){
        Image(painter = painterResource(id = image), contentDescription = "desc")
        Spacer(modifier = Modifier.size(5.dp))
        Text(text, color = Color.White, fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(PaddingValues(horizontal = 10.dp)))
    }
}