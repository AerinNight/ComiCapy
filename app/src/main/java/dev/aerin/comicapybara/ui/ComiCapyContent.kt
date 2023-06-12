package dev.aerin.comicapybara.ui

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults.elevatedCardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.aerin.comicapybara.ui.theme.Alpha
import dev.aerin.comicapybara.ui.theme.ComiCapyTheme

fun ComponentActivity.comiCapyContent(contents: @Composable () -> Unit) = setContent {
    ComiCapyContents(contents)
}

@Composable
fun ComiCapyContents(contents: @Composable () -> Unit) {
    ComiCapyTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.contentColorFor(
                MaterialTheme.colorScheme.background,
            ),
        ) {
            contents()
        }
    }
}

@Composable
fun ComiCapyCard(modifier: Modifier = Modifier, contents: @Composable () -> Unit) {
    ComiCapyTheme {
        // A surface container using the 'background' color from the theme
        Card(
            modifier = modifier,
            colors = elevatedCardColors(
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = MaterialTheme.colorScheme.contentColorFor(
                    MaterialTheme.colorScheme.background,
                ),
                disabledContainerColor = MaterialTheme.colorScheme.background
                    .copy(alpha = Alpha.pct50),
                disabledContentColor = MaterialTheme.colorScheme.contentColorFor(
                    MaterialTheme.colorScheme.background,
                ).copy(alpha = Alpha.pct50),
            ),
        ) {
            contents()
        }
    }
}
