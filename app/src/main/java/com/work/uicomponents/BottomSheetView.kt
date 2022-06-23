package com.work.uicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun BottomSheetView() {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )
    val coroutineScope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            Box(
                modifier = Modifier
                    .padding(20.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxSize()
            ) { WorkerBadge() }
        },
        sheetPeekHeight = 0.dp
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Button(onClick = {
                coroutineScope.launch {
                    if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                        bottomSheetScaffoldState.bottomSheetState.expand()
                    } else {
                        bottomSheetScaffoldState.bottomSheetState.collapse()
                    }
                }
            }) {
                Text(text = "OpenSheet")
            }
        }
    }
}

@Preview
@Composable
fun WorkerBadge() {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (bg, photo, name, company, dot, designation, dOne, dTwo, dThree, dFour, contact, certifications, health) = createRefs()
        Box(
            modifier = Modifier
                .height(140.dp)
                .fillMaxWidth()
                .background(Color.Blue)
                .constrainAs(bg) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                }
        )
        Image(
            modifier = Modifier
                .clip(CircleShape)
                .border(5.dp, Color.White, CircleShape)
                .background(Color.White)
                .constrainAs(photo) {
                    top.linkTo(parent.top, margin = 88.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = ""
        )
        Text(
            modifier = Modifier.constrainAs(name) {
                top.linkTo(photo.bottom, margin = 18.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            text = "Worker Name"
        )
        Text(
            modifier = Modifier.constrainAs(company) {
                top.linkTo(name.bottom, margin = 6.dp)
                start.linkTo(name.start)
                end.linkTo(dot.start, margin = 8.dp)
            },
            text = "Electrical Engineer"
        )
        Box(
            modifier = Modifier
                .size(4.dp)
                .clip(CircleShape)
                .background(Color.Gray)
                .constrainAs(dot) {
                    top.linkTo(company.top)
                    bottom.linkTo(company.bottom)
                    start.linkTo(company.end, margin = 8.dp)
                    end.linkTo(designation.start, margin = 8.dp)
                }
        )
        Text(
            modifier = Modifier.constrainAs(designation) {
                top.linkTo(name.bottom, margin = 6.dp)
                start.linkTo(dot.end, 8.dp)
                end.linkTo(name.end)
            },
            text = "Field Engineer"
        )
        Divider(
            modifier = Modifier
                .padding(horizontal = 25.dp)
                .constrainAs(dOne) {
                    top.linkTo(company.bottom, 48.dp)
                }
        )
        Button(
            modifier = Modifier
                .padding(vertical = 5.dp, horizontal = 25.dp)
                .height(43.dp)
                .constrainAs(contact) {
                    top.linkTo(dOne.bottom)
                },
            onClick = { /*TODO*/ },
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent
            ),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp,
                pressedElevation = 0.dp,
                disabledElevation = 0.dp,
                hoveredElevation = 0.dp,
                focusedElevation = 0.dp
            )
        ) {
            Row(
                Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Click Me")
                Icon(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = ""
                )
            }
        }
    }
}