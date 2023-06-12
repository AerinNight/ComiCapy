package dev.aerin.comicapybara

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import dev.aerin.comicapybara.data.User
import dev.aerin.comicapybara.ui.main.MainScreen
import dev.aerin.comicapybara.ui.comiCapyContent
import dev.aerin.comicapybara.ui.main.MainModel
import dev.aerin.comicapybara.ui.theme.refreshDeviceConstants
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

class MainActivity : ComponentActivity(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = lifecycleScope.coroutineContext

    private val model: MainModel by viewModels()

    private val user: User = User(randomId(), "Aerin")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        refreshDeviceConstants()
        model.onFragmentCreate(user)
        comiCapyContent {
            MainScreen(
                state = model.stateFlow.collectAsStateWithLifecycle().value,
                model::onEvent,
            )
        }
    }
}
