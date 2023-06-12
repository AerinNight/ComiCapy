@file:Suppress("Unused", "MemberVisibilityCanBePrivate")

package dev.aerin.comicapybara.ui.theme

import android.app.Activity
import androidx.compose.ui.unit.dp
import dev.aerin.comicapybara.R

var isTablet = false
var landscape = false

object Dimens {
    val grid1 = 4.dp
    val grid2 = 8.dp
    val grid3 = 12.dp
    val grid4 = 16.dp
    val grid5 = 20.dp
    val grid6 = 24.dp
    val grid7 = 28.dp
    val grid8 = 32.dp
    val grid9 = 36.dp
    val grid10 = 40.dp
    val grid11 = 44.dp
    val grid12 = 48.dp

    val mainScreenMinBookSize get() = if (isTablet) grid8 else grid6
}

object Alpha {
    const val opaque = 1f
    const val pct50 = 0.5f
    const val invisible = 0f
}

fun Activity.refreshDeviceConstants() {
    isTablet = resources.getBoolean(R.bool.is_tablet)
    landscape = resources.getBoolean(R.bool.landscape)
}
