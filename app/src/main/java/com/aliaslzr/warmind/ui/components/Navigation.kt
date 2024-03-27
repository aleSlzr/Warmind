package com.aliaslzr.warmind.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.aliaslzr.warmind.ui.icon.WarmindIcons
import com.aliaslzr.warmind.ui.navigation.WarmindRoutes


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WarmindTopAppBar() {
    TopAppBar(
        title = { Text(text = "Warmind") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(imageVector = WarmindIcons.Menu, contentDescription = "Menu")
            }
        }
    )
}

@Composable
fun WarmindBottomNavigation(navController: NavHostController) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
        tonalElevation = 0.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        BOTTOM_BAR_DESTINATIONS.forEach { item ->
            NavigationBarItem(
                selected = getTabSelected(
                    currentDestination = currentDestination,
                    route = item.route
                ),
                onClick = {
                    onNavigateToScreen(
                        navController = navController,
                        route = item.route
                    )
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.route,
                        modifier = Modifier.size(32.dp),
                    )
                },
                label = { Text(text = item.route) }
            )
        }
    }
}

data class WarmindBottomBarItems(
    val icon: Int,
    val route: String
)

val BOTTOM_BAR_DESTINATIONS = listOf(
    WarmindBottomBarItems(
        icon = WarmindIcons.Weapons,
        route = WarmindRoutes.Weapons.route
    ),
    WarmindBottomBarItems(
        icon = WarmindIcons.Armor,
        route = WarmindRoutes.Armor.route
    )
)

private fun onNavigateToScreen(navController: NavHostController, route: String) {
    navController.navigate(route) {
        popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

private fun getTabSelected(currentDestination: NavDestination?, route: String): Boolean {
    return currentDestination?.hierarchy?.any {
        it.route == route
    } == true
}
