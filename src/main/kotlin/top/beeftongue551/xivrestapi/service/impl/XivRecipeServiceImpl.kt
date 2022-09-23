package top.beeftongue551.xivrestapi.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import top.beeftongue551.xivrestapi.entity.recipe.XivRecipe
import top.beeftongue551.xivrestapi.entity.recipe.XivRecipeFinder
import top.beeftongue551.xivrestapi.entity.recipe.XivRecipeResponse
import top.beeftongue551.xivrestapi.repository.XivItemRepository
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

    @Autowired
    private  lateinit var xivItemRepository: XivItemRepository

    /**
     * レシピ情報を取得する
     *
     * @param itemId アイテムID
     * @param recipeId レシピID
     * @return 返却用のレシピデータ
     */
    override fun getRecipe(itemId: Int, recipeId: Int): XivRecipeResponse {
        val xivRecipeFinder = XivRecipeFinder(recipeId)
        val xivRecipe: XivRecipe = xivRecipeRepository.getXivRecipe(xivRecipeFinder)
        val itemIngredient: List<String?> = makeItemIngredientList(xivRecipe)
        val amountIngredient: List<Int?> = makeAmountIngredient(xivRecipe)
        val ingredientId: List<Int?> = makeIngredientId(itemIngredient)

        return XivRecipeResponse(
            xivRecipe.id,
            xivRecipe.craftType,
            xivRecipe.recipeLevel,
            xivRecipe.secretRecipeBook,
            itemId,
            xivRecipe.itemResult,
            xivRecipe.amountResult,
            ingredientId,
            itemIngredient,
            amountIngredient
        )
    }

    private fun makeAmountIngredient(xivRecipe: XivRecipe): List<Int?> {
        val amountIngredient: MutableList<Int?> = mutableListOf()
        amountIngredient.add(xivRecipe.amountIngredient0)
        amountIngredient.add(xivRecipe.amountIngredient1)
        amountIngredient.add(xivRecipe.amountIngredient2)
        amountIngredient.add(xivRecipe.amountIngredient3)
        amountIngredient.add(xivRecipe.amountIngredient4)
        amountIngredient.add(xivRecipe.amountIngredient5)
        amountIngredient.add(xivRecipe.amountIngredient6)
        amountIngredient.add(xivRecipe.amountIngredient7)
        amountIngredient.add(xivRecipe.amountIngredient8)
        amountIngredient.add(xivRecipe.amountIngredient9)
        return amountIngredient
    }

    private fun makeItemIngredientList(xivRecipe: XivRecipe): List<String?> {
        val itemIngredient: MutableList<String?> = mutableListOf()
        itemIngredient.add(xivRecipe.itemIngredient0)
        itemIngredient.add(xivRecipe.itemIngredient1)
        itemIngredient.add(xivRecipe.itemIngredient2)
        itemIngredient.add(xivRecipe.itemIngredient3)
        itemIngredient.add(xivRecipe.itemIngredient4)
        itemIngredient.add(xivRecipe.itemIngredient5)
        itemIngredient.add(xivRecipe.itemIngredient6)
        itemIngredient.add(xivRecipe.itemIngredient7)
        itemIngredient.add(xivRecipe.itemIngredient8)
        itemIngredient.add(xivRecipe.itemIngredient9)
        return itemIngredient
    }

    private fun makeIngredientId(itemIngredient: List<String?>): List<Int?> {
        val ingredientIds: MutableList<Int?> = emptyList<Int?>().toMutableList()
        val itemsList = xivItemRepository.getXivItemsByNames(itemIngredient.toList())

        for(itemName in itemIngredient) {
            var searchFlag = false
            for(item in itemsList) {
                if(itemName == item.itemName) {
                    searchFlag = true
                    ingredientIds.add(item.itemId)
                }
            }
            if(!searchFlag) {
                ingredientIds.add(null)
            }
        }

        return ingredientIds
    }
}