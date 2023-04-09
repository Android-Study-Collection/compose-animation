package com.example.compose_animation.cases.animation_visibility

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_animation.ui.theme.Theme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SeekAndHide() {
    val defaultFont = 16.sp
    val defaultEnter = fadeIn() + expandVertically()
    val defaultExit = fadeOut() + shrinkVertically()

    var isShowText by remember { mutableStateOf(true) }
    var enter by remember { mutableStateOf(defaultEnter) }
    var exit by remember { mutableStateOf(defaultExit) }

    Column(
        verticalArrangement = Arrangement.spacedBy(7.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
    ) {
        Row(
            modifier = Modifier.height(80.dp)
        ){
            AnimatedVisibility(
                visible = isShowText,
                enter = enter,
                exit = exit
            ) {
                Text(
                    text = "Hello Word!",
                    fontSize = 50.sp
                )
            }
        }
        Button(
            onClick = {
                enter = defaultEnter
                exit = defaultExit
                isShowText = !isShowText
            }
        ) {
            Text(
                text = "Default Exit and Enter",
                fontSize = defaultFont
            )
        }
        Button(
            onClick = {
                enter = fadeIn()
                exit = fadeOut()
                isShowText = !isShowText
            }
        ) {
            Text(
                text = "fadeIn(), fadeOut()",
                fontSize = defaultFont
            )
        }
        Button(
            onClick = {
                enter = expandVertically()
                exit = shrinkVertically()
                isShowText = !isShowText
            }
        ) {
            Text(
                text = "expandVertically(), shrinkVertically()",
                fontSize = defaultFont
            )
        }
        Button(
            onClick = {
                enter = expandIn()
                exit = shrinkOut()
                isShowText = !isShowText
            }
        ) {
            Text(
                text = "expandIn(), shrinkOut()",
                fontSize = defaultFont
            )
        }
        Button(
            onClick = {
                enter = expandHorizontally()
                exit = shrinkHorizontally()
                isShowText = !isShowText
            }
        ) {
            Text(
                text = "expandHorizontally(), shrinkHorizontally()",
                fontSize = defaultFont
            )
        }
        Button(
            onClick = {
                enter = slideIn(spring(stiffness = Spring.StiffnessMediumLow), initialOffset = { IntOffset(0, 0) })
                exit = slideOut(spring(stiffness = Spring.StiffnessMediumLow), targetOffset = { IntOffset(100, 100) })
                isShowText = !isShowText
            }
        ) {
            Text(
                text = "slideIn(0,0), slideOut(100,100)",
                fontSize = defaultFont
            )
        }
        Button(
            onClick = {
                enter = scaleIn()
                exit = scaleOut()
                isShowText = !isShowText
            }
        ) {
            Text(
                text = "scaleIn(0), scaleOut(0)",
                fontSize = defaultFont
            )
        }
    }
}

@Preview
@Composable
fun SeekAndHidePreview() {
    Theme {
        SeekAndHide()
    }
}