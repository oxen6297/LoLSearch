package com.sb.park.lol.screen.detail

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

enum class SpellEnum {
    Q, W, E, R
}

enum class StatEnum(
    val statName: String,
    val progressColor: @Composable () -> Color,
    val maxValue: Int
) {
    Hp("체력", { MaterialTheme.colorScheme.onSecondary },800),
    Mp("마나", { MaterialTheme.colorScheme.surfaceVariant },800),
    Armor("방어력", { MaterialTheme.colorScheme.surfaceDim },100),
    AttackDamage("공격력", { MaterialTheme.colorScheme.surfaceTint },100),
    AttackRange("사거리", { MaterialTheme.colorScheme.inversePrimary },800)
}