package com.aliaslzr.warmind.ui.navigation

sealed class WarmindRoutes(val route: String) {
    data object Weapons: WarmindRoutes("Weapons")
    data object Armor: WarmindRoutes("Armor")
    data object Profile: WarmindRoutes("Profile")
}
