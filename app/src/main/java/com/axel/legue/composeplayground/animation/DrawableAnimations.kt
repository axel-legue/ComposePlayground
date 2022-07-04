@file:OptIn(ExperimentalAnimationApi::class)

package com.axel.legue.composeplayground.animation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.axel.legue.composeplayground.R
import com.axel.legue.composeplayground.ui.theme.ComposePlaygroundTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun DrawableAnimations() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        FilledTonalButtonCrossFadeStateful()
        FilledTonalButtonAnimatedContentStateful()
    }
}

@Composable
private fun FilledTonalButtonCrossFadeStateful() {
    var tonalButtonIsPressed by remember { mutableStateOf(false) }
    FilledTonalButton(modifier = Modifier.padding(bottom = 20.dp), onClick = { tonalButtonIsPressed = !tonalButtonIsPressed }) {
        Crossfade(
            targetState = tonalButtonIsPressed,
            animationSpec = tween(1000)
        ) {
            Icon(painter = painterResource(id = if (it) R.drawable.ic_arrow_left else R.drawable.ic_arrow_right), contentDescription = null)
        }
    }
}

@Composable
private fun FilledTonalButtonAnimatedContentStateful() {
    var tonalButtonIsPressed by remember { mutableStateOf(false) }
    FilledTonalButton(modifier = Modifier.padding(bottom = 20.dp), onClick = { tonalButtonIsPressed = !tonalButtonIsPressed }) {
        AnimatedContent(
            targetState = tonalButtonIsPressed,
            transitionSpec = {
                fadeIn(animationSpec = tween(durationMillis = 1500)) with fadeOut(animationSpec = tween(500))
            }
        ) {
            Icon(painter = painterResource(id = if (it) R.drawable.ic_arrow_left else R.drawable.ic_arrow_right), contentDescription = null)
        }
    }
}

@Preview
@Composable
fun DrawableAnimationsPreview() {
    ComposePlaygroundTheme {
        DrawableAnimations()
    }
}
