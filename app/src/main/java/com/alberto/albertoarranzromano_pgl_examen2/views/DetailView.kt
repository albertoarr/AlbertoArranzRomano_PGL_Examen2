package com.alberto.albertoarranzromano_pgl_examen2.views

import android.widget.TextView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.alberto.albertoarranzromano_pgl_examen2.components.MainIconButton
import com.alberto.albertoarranzromano_pgl_examen2.components.NavigationButton
import com.alberto.albertoarranzromano_pgl_examen2.components.TitleBar
import com.alberto.albertoarranzromano_pgl_examen2.components.TitleView
import com.alberto.albertoarranzromano_pgl_examen2.ui.theme.alumno1
import com.alberto.albertoarranzromano_pgl_examen2.ui.theme.background1


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailView(navController: NavController, id:Int, opcional: String) {
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
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        // PopStackBack revisa el stack del móvil y vuelve a la página anterior
                        navController.popBackStack()
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)){
            DetailHomeView(navController, id, opcional)
        }
    }
}
// Segunda vista
@Composable
fun DetailHomeView(navController: NavController, id: Int, opcional: String) {
    //id
    TitleView(name = id.toString())
    // Traduccion
    TitleView(name = opcional)
    Column{
        // Botón para volver a Home sin revisar el Stack
        NavigationButton("Ir a Home",
            color = Color.Black,
            backColor = alumno1,
            onClick = {
            navController.navigate("Home")
        })

    }
}
