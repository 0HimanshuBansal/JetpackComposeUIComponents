package com.work.uicomponents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.AlertDialog
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
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
        modifier = Modifier,
        onDismissRequest = { onDismissRequest() },
        title = {
            Text(
                modifier = Modifier.fillMaxWidth(),
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
                onClick = optionOne,
                colors = ButtonDefaults.textButtonColors(contentColor = Color.Blue)
            ) {
                Text(text = optionOneText)
            }
            TextButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = optionTwo,
                colors = ButtonDefaults.textButtonColors(contentColor = Color.Blue)
            ) {
                Text(text = optionTwoText)
            }
        }
    )
}
