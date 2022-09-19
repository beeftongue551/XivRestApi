package top.beeftongue551.xivrestapi.entity.item

/**
 * アイテム検索用のデータクラス
 *
 * @property itemName アイテム名
 * @property page 現在ページ
 * @property job ジョブ名
 * @property level レベル
 * @property category カテゴリー
 * @constructor Create empty Xiv item finder
 */
data class XivItemFinder (
    val itemName: String,
    val limit: Int,
    val job: String?,
    val level: Int?,
    val category: String?,
    val page: Int,
    val allClass: String = "全クラス"
    )