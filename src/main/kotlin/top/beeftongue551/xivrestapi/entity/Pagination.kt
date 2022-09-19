package top.beeftongue551.xivrestapi.entity

/**
 * Pagination データクラス
 *
 * @property page 現在ページ
 * @property pageNext 次のページ
 * @property pagePrev 前のページ
 * @property pageTotal トータルページ数
 * @property resultsParPage 1ページごとの項目数 デフォルト50
 * @property resultTotal 合計項目数
 * @constructor Create empty Pagination
 */
class Pagination(
    val page: Int,
    val resultTotal: Int,
    var pageNext: Int?,
    var pagePrev: Int?,
    var pageTotal: Int?,
    val resultsParPage: Int = 50
) {
    constructor(page: Int, resultTotal: Int) : this(page = page, resultTotal = resultTotal, null,null,null)

    /**
     * Generate Pagination
     *
     * @return ページネーション情報
     */
    fun generate(): Pagination {

        this.pageTotal = (this.resultTotal / this.resultsParPage) + 1
        this.pagePrev = this.page - 1
        if(this.pageTotal == this.page) {
            this.pageNext = 0
        } else {
            this.pageNext = this.page + 1
        }

        return this
    }
}
