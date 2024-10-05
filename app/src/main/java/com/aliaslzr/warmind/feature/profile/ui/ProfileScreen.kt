package com.aliaslzr.warmind.feature.profile.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliaslzr.warmind.ui.components.WarmindCharacterBanner
import com.aliaslzr.warmind.ui.components.WarmindTextDivider
import com.aliaslzr.warmind.ui.icon.WarmindIcons

@Preview(showSystemUi = true)
@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = { ProfileTopBar() }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(color = Color.Cyan),
            horizontalAlignment = Alignment.Start,
        ) {
            WarmindTextDivider("About me")
            Text(
                text = "Some description of the user",
                fontStyle = FontStyle.Italic
            )
            WarmindTextDivider("Destiny Character")
            WarmindCharacterBanner(
                characterClass = "Hunter",
                characterRace = "Human",
                characterLightLevel = "1900"
            )
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun ProfileTopBar() {
    LargeTopAppBar(
        title = { ProfileTopBarTitle() },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.onTertiaryContainer,
            titleContentColor = MaterialTheme.colorScheme.tertiaryContainer
        ),
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    modifier = Modifier.size(28.dp),
                    tint = Color.White,
                    imageVector = WarmindIcons.ArrowBack,
                    contentDescription = "Back to main screen"
                )
            }
        }
    )
}

@Composable
private fun ProfileTopBarTitle() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Profile Name#1234",
                color = Color.White
            )
            Text(
                text = "Some informative text",
                color = Color.White, fontSize = 16.sp
            )
        }
    }
}
