package com.sb.park.data.mapper

import com.sb.park.data.model.datadragon.ImageResponse
import com.sb.park.data.model.datadragon.ItemResponse
import com.sb.park.model.ImageModel
import com.sb.park.model.ItemModel

private object ItemMapper : ModelMapper<ItemResponse, ItemModel> {

    override fun asModel(response: ItemResponse): ItemModel = ItemModel(
        name = response.name.deleteHtmlTag(),
        plaintext = response.plaintext.deleteHtmlTag(),
        into = response.into,
        from = response.from,
        image = response.image.toModel(),
        gold = response.gold.toModel(),
        tags = response.tags
    )

    private fun ImageResponse.toModel(): ImageModel = ImageModel(fileName = this.full)

    private fun ItemResponse.GoldResponse.toModel(): ItemModel.GoldModel =
        ItemModel.GoldModel(
            purchasable = this.purchasable,
            total = "${this.total} 원",
            sell = "${this.sell} 원"
        )
}

internal fun ItemResponse.toModel(): ItemModel = ItemMapper.asModel(this)