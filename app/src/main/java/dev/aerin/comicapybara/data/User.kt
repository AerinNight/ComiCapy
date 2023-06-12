package dev.aerin.comicapybara.data

import dev.aerin.comicapybara.randomId
import java.util.UUID

data class User(
    override val id: UUID,
    val name: String
) : Identifiable {
    companion object {
        val Unknown = User(randomId(), "Not Logged In")
    }
}
