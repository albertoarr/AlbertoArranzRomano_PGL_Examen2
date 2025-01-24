package com.alberto.albertoarranzromano_pgl_examen2.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.alberto.albertoarranzromano_pgl_examen2.components.ActionButton
import com.alberto.albertoarranzromano_pgl_examen2.components.NavigationButton
import com.alberto.albertoarranzromano_pgl_examen2.components.TitleBar
import com.alberto.albertoarranzromano_pgl_examen2.components.TitleView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController) {
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar(name = "Aprende números en inglés" )},
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.LightGray
                )
            )
        },
        floatingActionButton = {
            ActionButton()
        }

    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)){
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

    TitleView(name = "HomeView")

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextField(
            value = opcional,
            onValueChange = {opcional = it}, // Se recoge en el textField
            label = { Text(text= "Opcional: ") }
        )

        //Botón para navegar al que pasaremos los parámetros declarados
        NavigationButton("Ir a la siguiente pantalla", Color.Gray, Color.White){
            // Los parámetros se envían a la ruta para que se muestre el DetailView
            navController.navigate("Detail/${id}?${opcional}")
        }
        NavigationButton("Ir a la MoroPantalla", Color.Gray, Color.White){
            // Los parámetros se envían a la ruta para que se muestre el DetailView
            navController.navigate("Moro")
        }
        NavigationButton("Ir a examen pasado", Color.Blue, Color.White) {
            navController.navigate("Examen1")
        }
    }
}