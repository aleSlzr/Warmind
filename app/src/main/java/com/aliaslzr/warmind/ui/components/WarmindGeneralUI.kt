package com.aliaslzr.warmind.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun WarmindTextDivider(text: String) {
    Column(
        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = text,
            fontSize = 22.sp,
        )
        HorizontalDivider(
            thickness = 3.dp,
            color = Color.White
        )
    }
}

@Composable
fun WarmindCharacterBanner(
    characterClass: String,
    characterRace: String,
    characterLightLevel: String
) {
    Row(
        modifier = Modifier
            .background(Color.Gray)
            .fillMaxWidth()
            .height(100.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 70.dp, top = 10.dp, end = 10.dp)
                .background(Color.White)
        ) {
            val (classText, raceText, levelText) = createRefs()
            Text(
                text = characterClass,
                fontSize = 20.sp,
                modifier = Modifier
                    .constrainAs(classText) {})
            Text(
                text = characterRace,
                modifier = Modifier
                    .constrainAs(raceText) {
                        top.linkTo(classText.bottom)
                        start.linkTo(classText.start)
                    })
            Text(
                text = characterLightLevel,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(levelText) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    })
        }
    }
}