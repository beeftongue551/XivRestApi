package top.beeftongue551.xivrestapi.entity.item

/**
 * DB取得用 XIVアイテムデータクラス
 *
 * @property itemId アイテムID
 * @property itemName アイテム名
 * @property description 説明
 * @property itemIcon アイコン
 * @property itemLevel アイテムレベル
 * @property itemUICategory アイテムUIカテゴリ
 * @property itemSearchCategory アイテムサーチカテゴリ
 * @property equipSlotCategory 装備スロットカテゴリ
 * @property itemSortCategory アイテムソートカテゴリ
 * @property equipLevel 装備レベル
 * @property equipRestriction 装備制限
 * @property classJobCategory クラスジョブカテゴリ
 * @property marketable マーケット可
 * @property recipeId レシピID
 * @constructor Create empty XIV item
 */
data class XivItem (
    val itemId: Int,
    val itemName: String = "",
    val description: String?,
    val itemIcon: String = "",
    val itemLevel: Int,
    val itemUICategory: String = "",
    val itemSearchCategory: String = "",
    val equipSlotCategory: String,
    val itemSortCategory: Int,
    val equipLevel: Int,
    val equipRestriction: Boolean,
    val classJobCategory: String?,
    val marketable: Boolean,
    val recipeId: Int? = null
)