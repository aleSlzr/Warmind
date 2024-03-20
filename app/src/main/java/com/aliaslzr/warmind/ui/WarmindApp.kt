package com.aliaslzr.warmind.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.aliaslzr.warmind.ui.icon.WarmindIcons
import com.aliaslzr.warmind.ui.navigation.WarmindNavHost
import com.aliaslzr.warmind.ui.navigation.WarmindRoutes

@Preview(showSystemUi = true)
@Composable
fun WarmindMainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { WarmindTopAppBar() },
        bottomBar = { WarmindBottomNavigation(navController) }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            WarmindNavHost(navController = navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WarmindTopAppBar() {
    TopAppBar(
        title = { Text(text = "Warmind") },
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(imageVector = WarmindIcons.Menu, contentDescription = "Close")
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

        NavigationBarItem(
            selected = getTabSelected(
                currentDestination = currentDestination,
                route = WarmindRoutes.Weapons.route
            ),
            onClick = {
                onNavigateToScreen(
                    navController = navController,
                    route = WarmindRoutes.Weapons.route
                )
            },
            icon = {
                Icon(
                    painter = painterResource(id = WarmindIcons.Weapons),
                    contentDescription = "Weapons",
                    modifier = Modifier.size(32.dp),
                )
            },
            label = { Text(text = "Weapons") }
        )
        NavigationBarItem(
            selected = getTabSelected(
                currentDestination = currentDestination,
                route = WarmindRoutes.Armor.route
            ),
            onClick = {
                onNavigateToScreen(
                    navController = navController,
                    route = WarmindRoutes.Armor.route
                )
            },
            icon = {
                Icon(
                    painter = painterResource(id = WarmindIcons.Armor),
                    contentDescription = "Weapons",
                    modifier = Modifier.size(32.dp),
                )
            },
            label = { Text(text = "Armor") }
        )
    }
}

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
