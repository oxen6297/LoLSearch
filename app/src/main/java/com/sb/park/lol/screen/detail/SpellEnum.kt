package com.sb.park.lol.screen.detail

enum class SpellEnum(private val order: Int) {
    Q(0), W(1), E(2), R(3);

    companion object {
        fun getSpell(index: Int): String? = entries.find { spell ->
            spell.order == index
        }?.name
    }
}