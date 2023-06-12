package dev.aerin.comicapybara.ui.main

import androidx.lifecycle.ViewModel
import dev.aerin.comicapybara.data.User
import dev.aerin.comicapybara.ui.main.BottomNavItem.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainModel: ViewModel() {

    private val _stateFlow = MutableStateFlow(MainScreenState())
    val stateFlow = _stateFlow.asStateFlow()

    fun onFragmentCreate(user: User) {
        _stateFlow.value = _stateFlow.value.copy(user = user)
    }

    fun onEvent(event: MainScreenEvent) {
        _stateFlow.value = _stateFlow.value.let { state ->
            when (event) {
                MainScreenEvent.GoToSearch -> TODO("Actually Go To Search")
                is MainScreenEvent.BottomNavSelected ->  {
                    navigate(event.item)
                    state
                }
            }
        }
    }

    private fun navigate(item: BottomNavItem) {
        when (item) {
            Library -> TODO()
            AddComic -> TODO()
            Settings -> TODO()
        }
    }
}
