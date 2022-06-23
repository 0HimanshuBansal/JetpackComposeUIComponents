package com.work.uicomponents

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun ScanCodeBackground() {
    val innerRadius = 20.dp
    val outerRadius = 30.dp
    val scanArea = 260.dp
    val scanAreaBorder = 300.dp
    val scanAreaBorderWidth = 4.dp
    Canvas(modifier = Modifier.fillMaxSize()) {
        val canvasSize = size
        val canvasWidth = size.width
        val canvasHeight = size.height
        val scanAreaSize = scanArea.toPx()
        val scanAreaBorderSize = scanAreaBorder.toPx()
        val scanAreaBorderWidthSize = scanAreaBorderWidth.toPx()

        drawRect(Color.Gray.copy(alpha = 0.5f))
        drawRoundRect(
            color = Color.Transparent,
            size = Size(scanAreaSize, scanAreaSize),
            blendMode = BlendMode.Clear,
            topLeft = Offset(
                x = (canvasWidth - scanAreaSize) / 2,
                y = canvasHeight / 3F - scanAreaSize / 2
            ),
            cornerRadius = CornerRadius(innerRadius.toPx())
        )
        val style = Stroke(
            width = scanAreaBorderWidthSize,
//            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 2f, 10f, 20f), 0f)
        )
        drawRoundRect(
            color = Color.Blue,
            size = Size(scanAreaBorderSize, scanAreaBorderSize),
            style = style,
            topLeft = Offset(
                x = (canvasWidth - scanAreaBorderSize) / 2,
                y = canvasHeight / 3F - scanAreaBorderSize / 2
            ),
            cornerRadius = CornerRadius(outerRadius.toPx())
        )
    }
}