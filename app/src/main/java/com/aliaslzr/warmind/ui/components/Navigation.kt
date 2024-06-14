package com.aliaslzr.warmind.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.aliaslzr.warmind.feature.profile.ui.viewModel.ProfileUiState
import com.aliaslzr.warmind.feature.profile.ui.viewModel.ProfileViewModel
import com.aliaslzr.warmind.ui.icon.WarmindIcons
import com.aliaslzr.warmind.ui.models.WarmindBottomBarItems
import com.aliaslzr.warmind.ui.navigation.WarmindRoutes
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WarmindTopAppBar(drawerState: DrawerState) {
    val scope = rememberCoroutineScope()
    TopAppBar(
        title = { Text(text = "Warmind") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        navigationIcon = {
            IconButton(
                onClick = {
                    scope.launch {
                        drawerState.apply {
                            if (isClosed) open() else close()
                        }
                    }
                }
            ) {
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
        tonalElevation = 5.dp
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

@Composable
fun WarmindDrawerSheet(
    profileViewModel: ProfileViewModel = hiltViewModel()
) {

    val profileUiState by profileViewModel.profileUiState.collectAsStateWithLifecycle()

    ModalDrawerSheet {
        Text(
            text = "Options",
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )
        Divider(modifier = Modifier.padding(start = 12.dp, end = 12.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, top = 4.dp, bottom = 4.dp)
        ) {
            NavigationDrawerItem(
                icon = {
                    Icon(
                        imageVector = WarmindIcons.Person,
                        contentDescription = "My Profile",
                        modifier = Modifier.size(32.dp),
                    )
                },
                label = {
                    when(profileUiState) {
                        ProfileUiState.Loading -> {
                            Text(text = "My Profile")
                        }
                        is ProfileUiState.Success -> {
                            Text(
                                text = (profileUiState as ProfileUiState.Success).profile.bnetMembership?.displayName.orEmpty()
                            )
                        }
                    }
                },
                selected = false,
                onClick = {}
            )
            Spacer(modifier = Modifier.weight(1f))
            NavigationDrawerItem(
                icon = {
                    Icon(
                        imageVector = WarmindIcons.LogOut,
                        contentDescription = "My Profile",
                        modifier = Modifier.size(32.dp),
                    )
                },
                label = { Text(text = "Sign Out") },
                selected = false,
                onClick = {  }
            )
        }
    }
}
