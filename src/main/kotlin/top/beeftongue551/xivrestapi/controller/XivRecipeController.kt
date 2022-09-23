package top.beeftongue551.xivrestapi.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import top.beeftongue551.xivrestapi.entity.recipe.XivRecipeResponse
import top.beeftongue551.xivrestapi.service.XivRecipeService

@RestController
class XivRecipeController {
    @Autowired
    lateinit var xivRecipeService: XivRecipeService

    @GetMapping("/recipe")
    fun getXivRecipe(
        @RequestParam("itemId", required = true) itemId: Int,
        @RequestParam("recipeId", required = true) recipeId: Int
    ): XivRecipeResponse {
        return xivRecipeService.getRecipe(itemId, recipeId)
    }
}