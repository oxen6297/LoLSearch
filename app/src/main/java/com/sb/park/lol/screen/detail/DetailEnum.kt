package com.sb.park.lol.screen.detail

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

enum class SpellEnum {
    Q, W, E, R
}

enum class StatEnum(val statName: String, val progressColor: @Composable () -> Color) {
    Hp("체력", { MaterialTheme.colorScheme.onSurfaceVariant }),
    Mp("마나", { MaterialTheme.colorScheme.surfaceVariant }),
    Armor("방어력", { MaterialTheme.colorScheme.surfaceDim }),
    AttackDamage("공격력", { MaterialTheme.colorScheme.surfaceTint }),
    AttackRange("사거리", { MaterialTheme.colorScheme.inversePrimary })
}