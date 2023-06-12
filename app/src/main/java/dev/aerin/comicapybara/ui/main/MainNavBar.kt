package dev.aerin.comicapybara.ui.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import dev.aerin.comicapybara.R
import dev.aerin.comicapybara.toggle
import dev.aerin.comicapybara.ui.ComiCapyCard
import dev.aerin.comicapybara.ui.ComiCapyContents
import dev.aerin.comicapybara.ui.main.MainScreenEvent.GoToSearch
import dev.aerin.comicapybara.ui.theme.ComiCapyTheme
import kotlinx.coroutines.CoroutineScope

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MainNavBar(
    state: MainScreenState,
    drawerState: DrawerState,
    scope: CoroutineScope,
    onEvent: (MainScreenEvent) -> Unit,
) {
    TopAppBar(
        title = {
            Text(text = stringResource(R.string.app_name_with_user, state.user.name))
        },
        navigationIcon = {
            IconButton(onClick = { drawerState.toggle(scope) }) {
                Icon(
                    imageVector = Icons.Rounded.Menu,
                    contentDescription = stringResource(R.string.cd_menu_drawer)
                )
            }
        },
        actions = {
            IconButton(onClick = { onEvent(GoToSearch) }) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = stringResource(id = R.string.cd_search),
                )
            }
        },
    )
}

@Preview
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun PreviewMainNavBar() {
    ComiCapyCard(Modifier.fillMaxWidth().wrapContentHeight()) {
        MainNavBar(
            state = MainScreenState(),
            drawerState = rememberDrawerState(DrawerValue.Closed),
            scope = rememberCoroutineScope(),
            onEvent = { /* No-Op */ },
        )
    }
}
