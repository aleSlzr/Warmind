package com.aliaslzr.warmind.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.aliaslzr.warmind.feature.profile.ui.viewModel.ProfileViewModel
import com.aliaslzr.warmind.ui.components.WarmindBottomNavigation
import com.aliaslzr.warmind.ui.components.WarmindDrawerSheet
import com.aliaslzr.warmind.ui.components.WarmindTopAppBar
import com.aliaslzr.warmind.ui.navigation.WarmindNavHost

@Preview(showSystemUi = true)
@Composable
fun WarmindMainScreen(profileViewModel: ProfileViewModel) {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { WarmindDrawerSheet(profileViewModel) },
        gesturesEnabled = true
    ) {
        Scaffold(
            topBar = { WarmindTopAppBar(drawerState) },
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
}
