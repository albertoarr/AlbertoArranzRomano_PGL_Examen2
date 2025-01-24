package com.alberto.albertoarranzromano_pgl_examen2.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.alberto.albertoarranzromano_pgl_examen2.views.DetailView
import com.alberto.albertoarranzromano_pgl_examen2.views.HomeView
import com.alberto.albertoarranzromano_pgl_examen2.views.NumberView

@Composable
fun NavManager(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home"){
            HomeView(navController)
        }
        composable("Numbers"){
            NumberView(navController)
        }
        // Ruta que acepta una lista de argumentos con un id de tipo entero y un parametro opcional de tipo string
        composable("Detail/{id}?{opcional}",
            arguments = listOf(
            //Se declara con NavArgument
            navArgument(name = "id"){
                type = NavType.IntType
            },
            navArgument("opcional"){
                type = NavType.StringType
            }
        )){
            val id = it.arguments?.getInt("id")?: 0
            var opcional = it.arguments?.getString("opcional")?: ""
            DetailView(navController, id, opcional)
        }

    }
}