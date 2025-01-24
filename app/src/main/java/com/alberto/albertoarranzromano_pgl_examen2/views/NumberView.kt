package com.alberto.albertoarranzromano_pgl_examen2.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.alberto.albertoarranzromano_pgl_examen2.components.ActionButton
import com.alberto.albertoarranzromano_pgl_examen2.components.NavigationButton
import com.alberto.albertoarranzromano_pgl_examen2.components.TitleBar
import com.alberto.albertoarranzromano_pgl_examen2.constants.numbers
import com.alberto.albertoarranzromano_pgl_examen2.constants.numbersInt
import com.alberto.albertoarranzromano_pgl_examen2.ui.theme.alumno1
import com.alberto.albertoarranzromano_pgl_examen2.ui.theme.background1


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NumberView(navController: NavController) {
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    TitleBar(
                        name = "Aprende números en inglés",
                        color = alumno1
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = background1
                )
            )
        }

    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)){
            DetailNumberView(navController)
        }
    }
}
// Segunda vista
@Composable
fun DetailNumberView(navController: NavController) {
    var id by remember { mutableStateOf(1) }
    var opcional by remember { mutableStateOf("") }
    
    LazyColumn {
        items(numbersInt) { number ->
            NavigationButton(
                name = number.toString(),
                backColor = Color.Green,
                color = Color.Black,
                onClick = {
                    id = number
                    opcional = numbers[number]
                    navController.navigate("Detail/${id}?${opcional}")
                }
            )
        }
    }
}

