package dev.aerin.comicapybara.ui.main

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.aerin.comicapybara.ui.theme.Dimens

@Composable
fun MainLibraryContent(state: MainScreenState, modifier: Modifier = Modifier) {
    state.toString() // TODO
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(minSize = Dimens.mainScreenMinBookSize),
    ) {
        items(listOf<String>()) {
            // TODO put stuff here?
        }
    }
}
