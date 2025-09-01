package eu.tutorials.jsonbasicelogic

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue

class MainViewModel : ViewModel() {

    private val _categoriesState = mutableStateOf(recipeState())
    val categorisState : State<recipeState> = _categoriesState

    init {
        fatchCategories()
    }

    private fun fatchCategories(){
        viewModelScope.launch {
            try{
                val response = recipeService.getCategories()
                _categoriesState.value = _categoriesState.value.copy(
                    loading = false,
                    recipe = response.categories,
                    error = null
                )

            }catch (e : Exception){
                _categoriesState.value = categorisState.value.copy(
                    loading = false,
                    error = "errors fatching categories ${e.message}"
                )
            }
        }
    }



    data class recipeState(
        val loading: Boolean = true,
        val recipe: List<Category> = emptyList(),
        val error: String? = null

    )


}