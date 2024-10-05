package com.aliaslzr.warmind.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.aliaslzr.warmind.ui.components.WarmindBottomNavigation
import com.aliaslzr.warmind.ui.components.WarmindDrawerSheet
import com.aliaslzr.warmind.ui.components.WarmindTopAppBar
import com.aliaslzr.warmind.ui.navigation.WarmindNavHost
import com.aliaslzr.warmind.ui.navigation.WarmindRoutes

@Composable
fun WarmindMainScreen() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val navStateStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navStateStackEntry?.destination?.route

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { WarmindDrawerSheet(navController, drawerState) },
        gesturesEnabled = true
    ) {
        Scaffold(
            topBar = {
                if (currentRoute != WarmindRoutes.Profile.route) {
                    WarmindTopAppBar(drawerState)
                }
            },
            bottomBar = {
                if (currentRoute != WarmindRoutes.Profile.route) {
                    WarmindBottomNavigation(navController)
                }
            }
        ) {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
            ) {
                WarmindNavHost(navController = navController)
            }
        }
    }
}
