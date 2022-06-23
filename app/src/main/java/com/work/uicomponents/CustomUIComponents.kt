package com.work.uicomponents

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties

@Composable
fun AlertDialogWithTwoOption(
    onDismissRequest: () -> Unit,
    title: String,
    optionOne: () -> Unit,
    optionOneText: String,
    optionTwo: () -> Unit,
    optionTwoText: String,
) {
    AlertDialog(
        modifier = Modifier
            .thinBorder(Color.Green),
        onDismissRequest = { onDismissRequest() },
        title = {
            Text(
                modifier = Modifier
//                    .thinBorder(Color.Red)
                    .fillMaxWidth(),
                text = title,
                textAlign = TextAlign.Center
            )
        },
        properties = DialogProperties(
            dismissOnClickOutside = false,
            dismissOnBackPress = true
        ),
        buttons = {
            Box(modifier = Modifier.height(60.dp))
            TextButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { optionOne() },
                colors = ButtonDefaults.textButtonColors(contentColor = Color.Blue)
            ) {
                Text(text = optionOneText)
            }
            TextButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { optionTwo() },
                colors = ButtonDefaults.textButtonColors(contentColor = Color.Blue)
            ) {
                Text(text = optionTwoText)
            }
        }
    )
}


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
        val width = canvasWidth
        val height = canvasHeight
        val path = Path().apply {
            moveTo(width.times(.76f), height.times(.72f))
            cubicTo(
                width.times(.93f),
                height.times(.72f),
                width.times(.98f),
                height.times(.41f),
                width.times(.76f),
                height.times(.40f)
            )
        }
//        drawLine()
        drawPath(
            path = path,
            color = Color.Blue
        )
    }
}