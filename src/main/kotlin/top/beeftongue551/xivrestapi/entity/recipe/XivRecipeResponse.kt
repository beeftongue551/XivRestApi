package top.beeftongue551.xivrestapi.entity.recipe

/**
 * 返却用のレシピデータクラス
 *
 * @property id レシピID
 * @property craftType クラフト種別
 * @property recipeLevel レシピレベル
 * @property secretRecipeBook 秘伝書
 * @property resultId 作成アイテムID
 * @property itemResult 作成アイテム名
 * @property amountResult 作成アイテム個数
 * @property itemIngredientId 素材アイテムID
 * @property itemIngredient 素材アイテム名
 * @property amountIngredient 素材アイテム個数
 * @constructor Create empty Xiv recipe response
 *
 * @author beeftongue551
 */
data class XivRecipeResponse (
    val id: Int,
    val craftType: String,
    val recipeLevel: Int,
    val secretRecipeBook: String,
    val resultId: Int,
    val itemResult: String,
    val amountResult: Int,
    val itemIngredientId: Collection<Int?>,
    val itemIngredient: Collection<String?>,
    val amountIngredient: Collection<Int?>
)