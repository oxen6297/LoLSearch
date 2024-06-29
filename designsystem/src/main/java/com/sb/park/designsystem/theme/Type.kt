package com.sb.park.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val SansSerifStyle = TextStyle(
    fontFamily = FontFamily.SansSerif,
    fontWeight = FontWeight.Normal,
)

val Typography = LoLTypography(
    titleLarge = SansSerifStyle.copy(
        fontSize = 23.sp
    ),
    titleMedium = SansSerifStyle.copy(
        fontSize = 18.sp
    ),
    titleSmall = SansSerifStyle.copy(
        fontSize = 15.sp
    ),

    titleLargeSB = SansSerifStyle.copy(
        fontSize = 23.sp,
        fontWeight = FontWeight.SemiBold
    ),
    titleMediumSB = SansSerifStyle.copy(
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold
    ),
    titleSmallSB = SansSerifStyle.copy(
        fontSize = 15.sp,
        fontWeight = FontWeight.SemiBold
    ),

    titleLargeB = SansSerifStyle.copy(
        fontSize = 23.sp,
        fontWeight = FontWeight.Bold
    ),
    titleMediumB = SansSerifStyle.copy(
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    ),
    titleSmallB = SansSerifStyle.copy(
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold
    ),

    contentLarge = SansSerifStyle.copy(
        fontSize = 20.sp
    ),
    contentMedium = SansSerifStyle.copy(
        fontSize = 17.sp
    ),
    contentSmall = SansSerifStyle.copy(
        fontSize = 14.sp
    ),

    contentLargeB = SansSerifStyle.copy(
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    ),
    contentMediumB = SansSerifStyle.copy(
        fontSize = 17.sp,
        fontWeight = FontWeight.Bold
    ),
    contentSmallB = SansSerifStyle.copy(
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold
    ),
)

@Immutable
data class LoLTypography(
    val titleLarge: TextStyle,
    val titleMedium: TextStyle,
    val titleSmall: TextStyle,

    val titleLargeSB: TextStyle,
    val titleMediumSB: TextStyle,
    val titleSmallSB: TextStyle,

    val titleLargeB: TextStyle,
    val titleMediumB: TextStyle,
    val titleSmallB: TextStyle,

    val contentLarge: TextStyle,
    val contentMedium: TextStyle,
    val contentSmall: TextStyle,

    val contentLargeB: TextStyle,
    val contentMediumB: TextStyle,
    val contentSmallB: TextStyle,
)

val LocalTypography = staticCompositionLocalOf {
    LoLTypography(
        titleLarge = SansSerifStyle,
        titleMedium = SansSerifStyle,
        titleSmall = SansSerifStyle,

        titleLargeSB = SansSerifStyle,
        titleMediumSB = SansSerifStyle,
        titleSmallSB = SansSerifStyle,

        titleLargeB = SansSerifStyle,
        titleMediumB = SansSerifStyle,
        titleSmallB = SansSerifStyle,

        contentLarge = SansSerifStyle,
        contentMedium = SansSerifStyle,
        contentSmall = SansSerifStyle,

        contentLargeB = SansSerifStyle,
        contentMediumB = SansSerifStyle,
        contentSmallB = SansSerifStyle
    )
}

