package eu.tutorials.jsonbasicelogic

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController: NavHostController) {
    val recipeViewModel :MainViewModel = viewModel()
    val viewState by recipeViewModel.categorisState

    NavHost(navController= navController, startDestination = Screen.RecipeScreen.route) {
        composable (route = Screen.RecipeScreen.route){

            RecipeScreen(viewState = viewState, navgiateToDetails = {
                navController.currentBackStackEntry?.savedStateHandle?.set("cat", it)
                navController.navigate(Screen.DetailScreen.route)

            }
            )
        }
        composable (route = Screen.DetailScreen.route){
            val category = navController.previousBackStackEntry?.savedStateHandle?.
            get<Category>("cat")?:Category(idcategory = "", strCategory = "", strCategoryThumb = "", strCategoryDescription = "")
            CategoryDetailScreen(category = category)

        }

    }
}