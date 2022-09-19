package top.beeftongue551.xivrestapi.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import top.beeftongue551.xivrestapi.entity.Pagination
import top.beeftongue551.xivrestapi.entity.item.XivItem
import top.beeftongue551.xivrestapi.entity.item.XivItemFinder
import top.beeftongue551.xivrestapi.entity.item.XivItemResponse
import top.beeftongue551.xivrestapi.repository.XivItemRepository
import top.beeftongue551.xivrestapi.service.XivItemService

@Service
class XivItemServiceImpl : XivItemService {
    @Autowired
    private lateinit var xivItemRepository: XivItemRepository

    /**
     * マーケット取引可能アイテムを取得する
     *
     * @param itemName アイテム名
     * @param job ジョブ
     * @param level レベル
     * @param category アイテムカテゴリ
     * @param page 対象ページ
     * @return マーケット取引可能アイテム情報
     */
    override fun getMarketableItem(
        itemName: String,
        page: Int,
        job: String?,
        level: Int?,
        category: String?
    ): XivItemResponse {
        var name = "%"
        var classJob: String? = null

        if (itemName !== "") {
            name = "%$itemName%"
        }
        if (job !== null) {
            classJob = "%$job%"
        }

        val xivItemFinder = XivItemFinder(name, 50, classJob, level, category, page)
        val xivItems: Collection<XivItem> = xivItemRepository.getXivItems(xivItemFinder)
        val resultTotal = xivItemRepository.getXivItemsCount(xivItemFinder)

        val pagination = Pagination(page, resultTotal).generate()

        return XivItemResponse(xivItems, pagination)
    }
}