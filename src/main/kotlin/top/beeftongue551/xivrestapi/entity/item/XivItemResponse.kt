package top.beeftongue551.xivrestapi.entity.item

import top.beeftongue551.xivrestapi.entity.Pagination

/**
 * 返却用のアイテムデータ
 *
 * @property xivItems
 * @property pagination
 * @constructor Create empty Xiv item response
 */
data class XivItemResponse(
    val xivItems: Collection<XivItem>,
    val pagination: Pagination
)