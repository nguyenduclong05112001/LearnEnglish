package com.longhrk.app.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.longhrk.app.ui.event.NavEvent
import com.longhrk.app.ui.screen.HomeScreen
import com.longhrk.app.ui.screen.OtherScreen
import com.longhrk.app.ui.screen.SplashScreen

@Composable
fun NavGraph(eventHandler: EventHandler, navController: NavHostController) {
    val startDestination = NavTarget.Splash.route

    NavHost(navController, startDestination) {
        composable(NavTarget.Splash.route) {
            SplashScreen {
                eventHandler.postNavEvent(
                    event = NavEvent.ActionWithPopUp(
                        target = NavTarget.Home,
                        popupTarget = NavTarget.Splash,
                        inclusive = true
                    )
                )
            }
        }

        composable(NavTarget.Home.route) {
            HomeScreen()
        }

        composable(NavTarget.Other.route) {
            OtherScreen(
                onClick = { }
            )
        }
    }
}