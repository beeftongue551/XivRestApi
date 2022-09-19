package top.beeftongue551.xivrestapi.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import top.beeftongue551.xivrestapi.entity.recipe.XivRecipe
import top.beeftongue551.xivrestapi.entity.recipe.XivRecipeFinder
import top.beeftongue551.xivrestapi.entity.recipe.XivRecipeResponse
import top.beeftongue551.xivrestapi.repository.XivRecipeRepository
import top.beeftongue551.xivrestapi.service.XivRecipeService

/**
 * XivRecipeServiceの実装クラス
 *
 * @author beeftongue551
 */
@Service
class XivRecipeServiceImpl : XivRecipeService {
    @Autowired
    private lateinit var xivRecipeRepository: XivRecipeRepository

    /**
     * レシピ情報を取得する
     *
     * @param itemName アイテム名
     * @return 返却用のレシピデータ
     */
    override fun getRecipe(itemName: String): XivRecipeResponse {
        val xivRecipeFinder = XivRecipeFinder(itemName)
        val xivRecipe: XivRecipe = xivRecipeRepository.getXivRecipe(xivRecipeFinder)
        val itemIngredient: Array<String?> = makeItemIngredientList(xivRecipe)
        val amountIngredient: Array<Int?> = makeAmountIngredient(xivRecipe)


        TODO("Not yet implemented")
    }

    private fun makeAmountIngredient(xivRecipe: XivRecipe): Array<Int?> {
        val amountIngredient: Array<Int?> = arrayOfNulls(10)
        TODO("Not yet implemented")
    }

    private fun makeItemIngredientList(xivRecipe: XivRecipe): Array<String?> {
        val itemIngredient: Array<String?> = arrayOfNulls(10)
        for (i in 0..9) {
            when (i) {
                0 -> {
                    itemIngredient[0] = xivRecipe.itemIngredient0
                }

                1 -> {
                    itemIngredient[1] = xivRecipe.itemIngredient1
                }

                2 -> {
                    itemIngredient[2] = xivRecipe.itemIngredient2
                }

                3 -> {
                    itemIngredient[3] = xivRecipe.itemIngredient3
                }

                4 -> {
                    itemIngredient[4] = xivRecipe.itemIngredient4
                }

                5 -> {
                    itemIngredient[5] = xivRecipe.itemIngredient5
                }

                6 -> {
                    itemIngredient[6] = xivRecipe.itemIngredient6
                }

                7 -> {
                    itemIngredient[7] = xivRecipe.itemIngredient7
                }

                8 -> {
                    itemIngredient[8] = xivRecipe.itemIngredient8
                }

                9 -> {
                    itemIngredient[9] = xivRecipe.itemIngredient9
                }
            }
        }
        return itemIngredient
    }
}