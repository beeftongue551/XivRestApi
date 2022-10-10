package top.beeftongue551.xivrestapi.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import top.beeftongue551.xivrestapi.entity.News
import top.beeftongue551.xivrestapi.repository.NewsRepository
import top.beeftongue551.xivrestapi.service.NewsService

/**
 * ニュース情報返却用サービスの実装クラス
 *
 * @author beeftongue551
 */
@Service
class NewsServiceImpl : NewsService {

    @Autowired
    private lateinit var newsRepository: NewsRepository

    /**
     * ニュース情報を取得する
     *
     * @param cases 取得件数
     * @return ニュース情報
     */
    override fun getNewsList(cases: Int): List<News> {

        return newsRepository.getNewsList(cases)
    }
}