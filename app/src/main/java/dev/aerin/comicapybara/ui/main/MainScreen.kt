package dev.aerin.comicapybara.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.aerin.comicapybara.R
import dev.aerin.comicapybara.data.User
import dev.aerin.comicapybara.ui.ComiCapyContents
import dev.aerin.comicapybara.ui.main.MainScreenEvent.BottomNavSelected
import dev.aerin.comicapybara.ui.theme.Dimens
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MainScreen(state: MainScreenState, onEvent: (MainScreenEvent) -> Unit) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val selectedItem = remember { mutableStateOf(BottomNavItem.values()[0]) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            MainNavDrawer(state, drawerState, scope, selectedItem, onEvent)
        }) {
        Scaffold(
            topBar = {
                MainNavBar(
                    state = state,
                    drawerState = drawerState,
                    scope = scope,
                    onEvent = onEvent,
                )
            },
            content = { paddingValues ->
                MainLibraryContent(
                    state = state,
                    modifier = Modifier.padding(paddingValues),
                )
            }
        )
    }
}

data class MainScreenState(
    val user: User = User.Unknown,
)

sealed class MainScreenEvent {
    object GoToSearch : MainScreenEvent()
    data class BottomNavSelected(val item: BottomNavItem) : MainScreenEvent()
}

@Preview
@Composable
fun MainScreenPreview() {
    ComiCapyContents {
        MainScreen(MainScreenState()) { /* No-Op */ }
    }
}
