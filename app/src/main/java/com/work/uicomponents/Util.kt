package com.work.uicomponents

import androidx.compose.foundation.border
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

fun Modifier.thinBorder(color: Color = Color.Green, shape: Shape = RectangleShape) =
    composed {
        this.then(
            border(width = 1.dp, color = color, shape = shape)
        )
    }

