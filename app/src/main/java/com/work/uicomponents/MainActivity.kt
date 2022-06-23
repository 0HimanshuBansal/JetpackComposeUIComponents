package com.work.uicomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.work.uicomponents.ui.theme.UIComponentsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UIComponentsTheme {
                ScanCodeBackground()
            }
        }
    }
}
