package dev.aerin.comicapybara.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import dev.aerin.comicapybara.ui.ComiCapyContents
import dev.aerin.comicapybara.ui.main.MainScreenEvent.BottomNavSelected
import dev.aerin.comicapybara.ui.theme.Dimens.grid12
import dev.aerin.comicapybara.ui.theme.Dimens.grid2
import dev.aerin.comicapybara.ui.theme.Dimens.grid4
import dev.aerin.comicapybara.ui.theme.Dimens.grid6
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MainNavDrawer(
    state: MainScreenState,
    drawerState: DrawerState,
    scope: CoroutineScope,
    selectedItem: MutableState<BottomNavItem>,
    onEvent: (MainScreenEvent) -> Unit,
) {
    ModalDrawerSheet {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = grid2, top = grid2, end = grid2),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                AppIcon(Modifier.size(grid12))
                Spacer(modifier = Modifier.width(grid4))
                Text(state.user.name)
            }

            Spacer(modifier = Modifier.height(grid6))

            BottomNavItem.values().forEach { item ->
                NavigationDrawerItem(
                    icon = { Icon(item.icon, contentDescription = null) },
                    label = { Text(stringResource(item.nameRes)) },
                    selected = item == selectedItem.value,
                    onClick = {
                        scope.launch { drawerState.close() }
                        selectedItem.value = item
                        onEvent(BottomNavSelected(item))
                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )
            }
        }
    }
}

@Preview
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun PreviewMainNavDrawer() {
    ComiCapyContents {
        MainNavDrawer(
            state = MainScreenState(),
            drawerState = rememberDrawerState(DrawerValue.Open),
            scope = rememberCoroutineScope(),
            selectedItem = remember { mutableStateOf(BottomNavItem.Library) },
            onEvent = { /* No-Op */ },
        )
    }
}
