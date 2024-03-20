package com.aliaslzr.warmind.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aliaslzr.warmind.ui.navigation.armor.ArmorScreen
import com.aliaslzr.warmind.ui.navigation.weapons.WeaponsScreen

@Composable
fun WarmindNavHost(
    navController: NavHostController,
    startDestination: String = WarmindRoutes.Weapons.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(WarmindRoutes.Weapons.route) {
            WeaponsScreen()
        }
        composable(WarmindRoutes.Armor.route) {
            ArmorScreen()
        }
    }
}
