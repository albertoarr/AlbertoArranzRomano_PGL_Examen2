package com.alberto.albertoarranzromano_pgl_examen2.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.alberto.albertoarranzromano_pgl_examen2.components.NavigationButton
import com.alberto.albertoarranzromano_pgl_examen2.components.TitleBar
import com.alberto.albertoarranzromano_pgl_examen2.components.TitleView
import com.alberto.albertoarranzromano_pgl_examen2.ui.theme.alumno1
import com.alberto.albertoarranzromano_pgl_examen2.ui.theme.background1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController) {
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

        Column(
            modifier = Modifier
                .padding(innerPadding)
        ){
            ContentHomeView(navController)
        }
    }
}
// Contenido de la vista
@Composable
fun ContentHomeView(navController: NavController) {
    // Declaración de parámetros para preparar la navegación
    val id = 1
    var opcional by remember { mutableStateOf("") }

    TitleView(name = "Números en inglés")

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ){

        //Botón para navegar al que pasaremos los parámetros declarados
        NavigationButton(
            name = "Crear Lista",
            backColor = background1,
            color = alumno1
        ) {
            navController.navigate("Numbers")
        }
    }
}