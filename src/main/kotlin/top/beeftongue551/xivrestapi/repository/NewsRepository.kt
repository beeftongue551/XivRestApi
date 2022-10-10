package top.beeftongue551.xivrestapi.repository

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.builder.annotation.ProviderMethodResolver
import org.apache.ibatis.jdbc.SQL
import org.springframework.stereotype.Repository
import top.beeftongue551.xivrestapi.entity.News

/**
 * News 取得用のレポジトリ
 *
 * @author beeftongue551
 */
@Mapper
@Repository
interface NewsRepository {

    /**
     * DBからニュースを取得する
     *
     * @param cases 取得個数
     * @return ニュース情報
     */
    @SelectProvider(NewsProvider::class)
    fun getNewsList(cases: Int): List<News>

    /**
     * SQL文生成用のクラス
     *
     * @author beeftongue551
     */
    class NewsProvider: ProviderMethodResolver {
        companion object {

            /**
             * ニュース取得用のSQL文を生成する
             *
             * @param cases 取得個数
             * @return SQL文
             */
            @JvmStatic
            fun getNewsList(cases: Int): String {
                return SQL().SELECT("*")
                    .FROM("T_NEWS")
                    .ORDER_BY("NEWS_DATE DESC")
                    .LIMIT("#{cases}")
                    .toString()
            }
        }
    }
}