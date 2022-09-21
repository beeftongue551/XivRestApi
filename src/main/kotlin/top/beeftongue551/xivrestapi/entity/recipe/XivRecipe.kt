package top.beeftongue551.xivrestapi.entity.recipe

/**
 * レシピ取得用のデータクラス
 *
 * @property id アイテムID
 * @property craftType クラフト種別 例:木工
 * @property recipeLevel レシピレベル
 * @property secretRecipeBook 対応秘伝書
 * @property itemResult 作成アイテム
 * @property amountResult 作成個数
 * @property itemIngredient0 素材アイテム
 * @property amountIngredient0 素材個数
 * @property itemIngredient1
 * @property amountIngredient1
 * @property itemIngredient2
 * @property amountIngredient2
 * @property itemIngredient3
 * @property amountIngredient3
 * @property itemIngredient4
 * @property amountIngredient4
 * @property itemIngredient5
 * @property amountIngredient5
 * @property itemIngredient6
 * @property amountIngredient6
 * @property itemIngredient7
 * @property amountIngredient7
 * @property itemIngredient8
 * @property amountIngredient8
 * @property itemIngredient9
 * @property amountIngredient9
 * @constructor Create empty Xiv recipe
 *
 * @author beeftongue551
 */
data class XivRecipe (
    val id: Int,
    val craftNumber: Int,
    val craftType: String,
    val recipeLevel: Int,
    val itemResult: String,
    val amountResult: Int,
    val itemIngredient0: String?,
    val amountIngredient0: Int?,
    val itemIngredient1: String?,
    val amountIngredient1: Int?,
    val itemIngredient2: String?,
    val amountIngredient2: Int?,
    val itemIngredient3: String?,
    val amountIngredient3: Int?,
    val itemIngredient4: String?,
    val amountIngredient4: Int?,
    val itemIngredient5: String?,
    val amountIngredient5: Int?,
    val itemIngredient6: String?,
    val amountIngredient6: Int?,
    val itemIngredient7: String?,
    val amountIngredient7: Int?,
    val itemIngredient8: String?,
    val amountIngredient8: Int?,
    val itemIngredient9: String?,
    val amountIngredient9: Int?,
    val secretRecipeBook: String?
)