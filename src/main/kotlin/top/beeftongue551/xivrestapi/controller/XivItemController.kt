package top.beeftongue551.xivrestapi.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import top.beeftongue551.xivrestapi.entity.item.XivItemResponse
import top.beeftongue551.xivrestapi.service.XivItemService

@RestController
class XivItemController {
    @Autowired
    lateinit var xivItemService: XivItemService

    @GetMapping("/item")
    fun getXivItems(
        @RequestParam("name", required = true) name: String,
        @RequestParam("page", required = true) page: Int,
        @RequestParam("job", required = false) job: String?,
        @RequestParam("level", required = false) level: Int?,
        @RequestParam("category", required = false) category: String?
    ): XivItemResponse {
        return xivItemService.getMarketableItem(name, page, job, level, category)
    }
}