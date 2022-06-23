package com.work.uicomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun SmallCardView() {
    ConstraintLayout(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .height(400.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.Gray.copy(alpha = 0.3F))
    ) {
        // Create references for the composables to constrain
        val (onSite, date, time, dividerV, duration, dividerH, checkOutBtn) = createRefs()

        Text(
            text = "On-Site",
            modifier = Modifier.constrainAs(onSite) {
                top.linkTo(parent.top, margin = 10.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }.wrapContentSize()
        )
        Text(
            text = "March 11, 2022, Friday",
            modifier = Modifier.constrainAs(date) {
                top.linkTo(onSite.bottom, margin = 10.dp)
                start.linkTo(onSite.start)
                end.linkTo(onSite.end)
            }.wrapContentSize()
        )

    }
}