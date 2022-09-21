package top.beeftongue551.xivrestapi.service

import top.beeftongue551.xivrestapi.entity.recipe.XivRecipeResponse

/**
 * レシピ情報取得用のサービスインターフェイス
 *
 * @author beeftongue551
 */
interface XivRecipeService {

    /**
     * レシピ情報を取得する
     *
     * @param itemId アイテムID
     * @param itemName アイテム名
     * @return 返却用のレシピデータ
     */
    fun getRecipe(itemId: Int ,itemName: String): XivRecipeResponse
}