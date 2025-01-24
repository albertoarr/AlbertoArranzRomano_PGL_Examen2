package com.alberto.albertoarranzromano_pgl_examen2.components


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.sp

@Composable
fun TitleBar(name: String) {
    Text(
        text= name,
        fontSize = 40.sp,
        fontWeight = Bold,
        color = Color.White
    )
}

@Composable
fun TitleView(name: String) {
    Text(text= name, fontSize = 40.sp, fontWeight = Bold)
}

