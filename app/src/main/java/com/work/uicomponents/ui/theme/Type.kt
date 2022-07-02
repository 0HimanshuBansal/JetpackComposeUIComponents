package com.work.uicomponents.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.work.uicomponents.R

val Archivo = FontFamily(Font(R.font.archivo, FontWeight.W400))
val ArchivoSemiBold = FontFamily(Font(R.font.archivo, FontWeight.W600))
val ArchivoBold = FontFamily(Font(R.font.archivo, FontWeight.W700))

val Typography = Typography(
    defaultFontFamily = Archivo,
    h1 = TextStyle(
        fontSize = 30.sp,
        lineHeight = 38.sp,
        letterSpacing = (-1.5).sp
    ),
    h2 = TextStyle(
        fontSize = 24.sp,
        lineHeight = 38.sp,
        letterSpacing = (-0.5).sp
    ),
    h3 = TextStyle(
        fontSize = 20.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.sp
    ),
    h4 = TextStyle(
        fontSize = 34.sp,
        lineHeight = 38.sp,
        letterSpacing = 0.25.sp
    ),
    h5 = TextStyle(
        fontSize = 24.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    h6 = TextStyle(
        fontSize = 20.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    subtitle1 = TextStyle(
        fontSize = 16.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.15.sp
    ),
    subtitle2 = TextStyle(
        fontSize = 14.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.1.sp
    ),
    body1 = TextStyle(
        fontSize = 16.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.5.sp
    ),
    body2 = TextStyle(
        fontSize = 14.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.25.sp
    ),
    button = TextStyle(
        fontSize = 14.sp,
        lineHeight = 18.sp,
        letterSpacing = 1.25.sp
    ),
    caption = TextStyle(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    ),
    overline = TextStyle(
        fontSize = 10.sp,
        lineHeight = 12.sp,
        letterSpacing = 1.5.sp
    )
)

val ArchivoTypography = Typography(
    defaultFontFamily = Archivo,
    h2 = Typography.h2,
    h3 = Typography.h3,
    subtitle2 = Typography.subtitle2,
    body1 = Typography.body1,
    caption = Typography.caption
)

val ArchivoSemiBoldTypography = Typography(
    defaultFontFamily = ArchivoSemiBold,
    h1 = Typography.h1,
    h3 = Typography.h3,
    subtitle1 = Typography.subtitle1,
    subtitle2 = Typography.subtitle2,
    button = Typography.button,
    caption = Typography.caption
)

val ArchivoBoldTypography = Typography(
    defaultFontFamily = ArchivoBold,
    h2 = Typography.h2,
)
