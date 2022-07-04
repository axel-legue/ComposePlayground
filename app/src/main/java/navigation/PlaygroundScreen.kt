package navigation

sealed class PlaygroundScreen(override val route: String) : Screen {
    object default : PlaygroundScreen(route = "default")
}
