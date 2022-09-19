package top.beeftongue551.xivrestapi.repository

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.builder.annotation.ProviderMethodResolver
import org.apache.ibatis.jdbc.SQL
import org.springframework.stereotype.Repository
import top.beeftongue551.xivrestapi.entity.item.XivItemFinder
import top.beeftongue551.xivrestapi.entity.recipe.XivRecipe
import top.beeftongue551.xivrestapi.entity.recipe.XivRecipeFinder

/**
 * レシピ取得用のレポジトリ
 *
 * @author beeftongue551
 */
@Mapper
@Repository
interface XivRecipeRepository {

    /**
     * SQLからレシピを取得する
     *
     * @param xivItemFinder レシピ検索用データ
     * @return レシピ情報
     */
    @SelectProvider(XivRecipeProvider::class)
    fun getXivRecipe(xivRecipeFinder: XivRecipeFinder): XivRecipe

    /**
     * SQL文生成用のクラス
     *
     * @author beeftongue551
     */
    class XivRecipeProvider: ProviderMethodResolver {
        companion object {
            /**
             * レシピ取得用のSQL文を生成する
             *
             * @param xivRecipeFinder
             * @return
             */
            fun getXivRecipe(xivRecipeFinder: XivRecipeFinder): String {

                val sql: SQL =
                    SQL()
                        .SELECT("")
                        .FROM("M_XIV_ITEM")
                        .WHERE("ItemResult = #{itemName}")

                println(sql.toString())
                return sql.toString()
            }
        }
    }
}