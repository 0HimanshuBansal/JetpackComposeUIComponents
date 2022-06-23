package com.work.uicomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.work.uicomponents.ui.theme.UIComponentsTheme
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UIComponentsTheme {
                BottomSheetView()
//                SmallCardView()
            }
        }
    }
}

@Composable
fun TestFocus() {
    val focusRequester = remember { FocusRequester() }
    val radioFocusRequester = remember { FocusRequester() }
    val localFocusManager = LocalFocusManager.current
    val scrollState = rememberScrollState()
    var scrollToPosition by remember { mutableStateOf(0F) }
    val coroutineScope = rememberCoroutineScope()
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp)
            .verticalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.height(70.dp))
        ButtonRow(
            focusRequester = focusRequester,
            localFocusManager = localFocusManager
        )
        TestTextFieldWithFocus(
            Modifier.focusRequester(focusRequester)
        )
        Spacer(modifier = Modifier.height(70.dp))
        ButtonRow(
            focusRequester = radioFocusRequester,
            localFocusManager = localFocusManager
        )
        val color = remember { mutableStateOf(Color.Blue) }
        TestRadioWithFocus(
            modifier = Modifier
                .border(2.dp, color.value)
                .focusRequester(radioFocusRequester)
                .onFocusChanged {
                    color.value = if (it.isFocused) Color.Red else Color.Green
                }
                .focusable()
        )

        Button(onClick = {
            coroutineScope.launch {
                scrollState.animateScrollTo(scrollToPosition.roundToInt())
            }
        }) {
            Text("Click")
        }
        Spacer(modifier = Modifier.height(2000.dp))
        Spacer(modifier = Modifier.height(2000.dp))
        Spacer(modifier = Modifier.height(2000.dp))
        repeat(2) {
            Box(
                Modifier
                    .onGloballyPositioned { coordinates ->
                        scrollToPosition = coordinates.positionInParent().y
                    }
                    .height((Math.random() * 100).dp)
                    .fillMaxWidth()
                    .border(2.dp, Color.Blue)
            ) {
                Text(text = "NULL")
            }
        }
        Spacer(modifier = Modifier.height(2000.dp))
    }

}

@Composable
fun TestTextFieldWithFocus(
    modifier: Modifier,
) {
    val value = remember {
        mutableStateOf("")
    }
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp),
        value = value.value,
        onValueChange = { value.value = it }
    )
}

@Composable
fun TestRadioWithFocus(
    modifier: Modifier,
) {
    var selectedOption by remember { mutableStateOf("") }
    val options = listOf(
        "One", "Two", "Three", "Four", "Five"
    )
    Box(modifier = modifier.fillMaxWidth()) {
        Column {
            options.forEach { option ->
                Row(verticalAlignment = CenterVertically) {
                    RadioButton(
                        selected = (option == selectedOption),
                        onClick = {
                            selectedOption = option
                        }
                    )
                    Text(text = option)
                }
            }
        }
    }
}

@Composable
fun ButtonRow(
    focusRequester: FocusRequester,
    localFocusManager: FocusManager,
) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Button(onClick = {
            focusRequester.requestFocus()
        }) {
            Text(text = "Request Focus")
        }
        Button(onClick = {
            localFocusManager.clearFocus()
        }) {
            Text(text = "Free Focus")
        }
    }
}