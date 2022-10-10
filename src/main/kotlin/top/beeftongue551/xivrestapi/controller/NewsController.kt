package top.beeftongue551.xivrestapi.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import top.beeftongue551.xivrestapi.entity.News
import top.beeftongue551.xivrestapi.service.NewsService

@RestController
class NewsController {
    @Autowired
    lateinit var newsService: NewsService

    @GetMapping("/news")
    fun getNewsList(
        @RequestParam("cases", required = false) cases: Int = 5
    ): List<News> {
        return newsService.getNewsList(cases)
    }
}