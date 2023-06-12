package dev.aerin.comicapybara.ui.main

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import dev.aerin.comicapybara.R

enum class BottomNavItem(
    @StringRes val nameRes: Int,
    val icon: ImageVector,
) {
    Library(R.string.nav_library, Icons.Rounded.Home),
    AddComic(R.string.nav_add_comic, Icons.Rounded.AddCircle),
    Settings(R.string.nav_settings, Icons.Rounded.Settings);
}


