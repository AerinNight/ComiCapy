package dev.aerin.comicapybara

import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
fun DrawerState.toggle(scope: CoroutineScope) = scope.launch {
    if (isOpen) close() else open()
}

fun randomId(): UUID {
    return UUID.randomUUID()
}
