package com.aliaslzr.warmind.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aliaslzr.warmind.feature.armor.ArmorScreen
import com.aliaslzr.warmind.feature.profile.ui.ProfileScreen
import com.aliaslzr.warmind.feature.weapons.WeaponsScreen

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
        composable(WarmindRoutes.Profile.route) {
            ProfileScreen()
        }
    }
}
