package com.sb.park.data.mapper

import com.sb.park.data.model.datadragon.RuneResponse
import com.sb.park.model.RuneModel

private object RuneMapper : ModelMapper<RuneResponse, RuneModel> {

    override fun asModel(response: RuneResponse): RuneModel = RuneModel(
        id = response.id,
        key = response.key,
        icon = response.icon,
        name = response.name,
        slots = response.slots.toModel()
    )

    @JvmName("RuneSlotToModel")
    private fun List<RuneResponse.RuneSlot>.toModel(): List<RuneModel.RuneSlot> = map { slot ->
        RuneModel.RuneSlot(
            runes = slot.runes.toModel()
        )
    }

    @JvmName("RuneToModel")
    private fun List<RuneResponse.Rune>.toModel(): List<RuneModel.Rune> = map { rune ->
        RuneModel.Rune(
            id = rune.id,
            key = rune.key,
            icon = rune.icon,
            name = rune.name,
            shortDesc = rune.shortDesc,
            longDesc = rune.longDesc
        )
    }
}

internal fun RuneResponse.toModel(): RuneModel = RuneMapper.asModel(this)