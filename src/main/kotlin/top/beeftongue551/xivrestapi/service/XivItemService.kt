package top.beeftongue551.xivrestapi.service

import top.beeftongue551.xivrestapi.entity.item.XivItemResponse

/**
 * アイテム情報返却用サービス
 *
 * @constructor Create empty Xiv item service
 */
interface XivItemService {

    /**
     * マーケット取引可能アイテムを取得する
     *
     * @param itemName アイテム名
     * @param job ジョブ
     * @param level レベル
     * @param category アイテムカテゴリー
     * @param page 対象ページ
     * @return マーケット取引可能アイテム情報
     */
    fun getMarketableItem(itemName: String, page: Int, job: String?, level: Int?, category: String?): XivItemResponse
}