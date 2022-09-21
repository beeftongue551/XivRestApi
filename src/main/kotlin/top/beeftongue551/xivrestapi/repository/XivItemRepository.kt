package top.beeftongue551.xivrestapi.repository

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.builder.annotation.ProviderMethodResolver
import org.apache.ibatis.jdbc.SQL
import org.springframework.stereotype.Repository
import top.beeftongue551.xivrestapi.entity.item.XivItem
import top.beeftongue551.xivrestapi.entity.item.XivItemFinder

@Mapper
@Repository
interface XivItemRepository {

    @SelectProvider(XivItemProvider::class)
    fun getXivItemsByNames(nameList: List<String?>): Collection<XivItem>

    @SelectProvider(XivItemProvider::class)
    fun getXivItems(xivItemFinder: XivItemFinder): Collection<XivItem>

    @SelectProvider(XivItemProvider::class)
    fun getXivItemsCount(xivItemFinder: XivItemFinder): Int


    class XivItemProvider: ProviderMethodResolver {
        companion object {

            @JvmStatic
            fun getXivItemsByNames(nameList: List<String?>): String {
                var sql: SQL = SQL()
                    .SELECT("*")
                    .FROM("M_XIV_ITEM")
                val sqlString = StringBuffer()
                for (index in nameList.indices) {
                    sqlString.append("Name = #{nameList[$index]} OR ")
                }
                sqlString.setLength(sqlString.length - 3)
                sql = sql.WHERE(sqlString.toString())
                println(sql.toString())
                return sql.toString()
            }


            @JvmStatic
            fun getXivItems(xivItemFinder: XivItemFinder): String {

                var sql: SQL =
                    SQL().SELECT("*").FROM("M_XIV_ITEM").WHERE("Marketable = TRUE").WHERE("Name LIKE BINARY #{itemName}")

                sql = whereSql(xivItemFinder, sql)

                println(sql.toString())
                return sql.toString()
            }

            @JvmStatic
            fun getXivItemsCount(xivItemFinder: XivItemFinder): String {
                var sql: SQL =
                    SQL().SELECT("COUNT(*)").FROM("M_XIV_ITEM").WHERE("Marketable = TRUE").WHERE("Name LIKE BINARY #{itemName}")

                sql = whereSql(xivItemFinder, sql)

                println(sql.toString())
                return sql.toString()
            }

            private fun whereSql(xivItemFinder: XivItemFinder, sql: SQL): SQL {
                var tempSQL:SQL = sql
                if (xivItemFinder.job !== null) {
                    tempSQL = tempSQL.WHERE("(ClassJobCategory = #{allClass} OR ClassJobCategory LIKE BINARY #{job})")
                }
                if (xivItemFinder.level !== null) {
                    tempSQL = tempSQL.WHERE("EquipLevel <= #{level}")
                }
                if (xivItemFinder.category !== null) {
                    tempSQL = tempSQL.WHERE("ItemSearchCategory = #{category}")
                }
                return tempSQL
            }
        }
    }
}