package top.beeftongue551.xivrestapi.service

import top.beeftongue551.xivrestapi.entity.News

/**
 * ニュース情報返却用サービス
 *
 * @author beeftongue551
 */
interface NewsService {

    /**
     * ニュース情報を取得する
     *
     * @param cases 取得件数
     * @return ニュース情報
     */
    fun getNewsList(cases: Int): List<News>
}