package dev.aerin.comicapybara.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.aerin.comicapybara.R

@Composable
fun AppIcon(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(CircleShape),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            modifier = Modifier
                .matchParentSize(),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "",
        )
        Image(
            modifier = Modifier
                .scale(1.4f),
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = stringResource(id = R.string.cd_app_icon),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAppIcon() {
    AppIcon(modifier = Modifier.size(126.dp))
}
