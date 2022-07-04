package navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.axel.legue.composeplayground.animation.DrawableAnimations

@Composable
fun PlaygroundNavigation() {
    val navHostController = rememberNavController()
    NavHost(navController = navHostController, startDestination = PlaygroundScreen.default.route) {
        composable(PlaygroundScreen.default.route) {
            DrawableAnimations()
        }
    }
}
