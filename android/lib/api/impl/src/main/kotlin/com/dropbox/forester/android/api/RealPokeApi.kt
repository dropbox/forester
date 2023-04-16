package com.dropbox.forester.android.api


import com.dropbox.forester.android.api.entity.Pokemon
import com.dropbox.forester.android.scoping.AppScope
import com.squareup.anvil.annotations.ContributesBinding
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json
import javax.inject.Inject

@ContributesBinding(AppScope::class)
class RealPokeApi @Inject constructor(
    private val client: HttpClient
) : PokeApi {
    override suspend fun getBerryList(offset: Int, limit: Int) = TODO()
    override suspend fun getBerryFirmnessList(offset: Int, limit: Int) = TODO()
    override suspend fun getBerryFlavorList(offset: Int, limit: Int) = TODO()
    override suspend fun getContestTypeList(offset: Int, limit: Int) = TODO()
    override suspend fun getContestEffectList(offset: Int, limit: Int) = TODO()
    override suspend fun getSuperContestEffectList(offset: Int, limit: Int) = TODO()
    override suspend fun getEncounterMethodList(offset: Int, limit: Int) = TODO()
    override suspend fun getEncounterConditionList(offset: Int, limit: Int) = TODO()
    override suspend fun getEncounterConditionValueList(offset: Int, limit: Int) = TODO()
    override suspend fun getEvolutionChainList(offset: Int, limit: Int) = TODO()
    override suspend fun getEvolutionTriggerList(offset: Int, limit: Int) = TODO()
    override suspend fun getGenerationList(offset: Int, limit: Int) = TODO()
    override suspend fun getPokedexList(offset: Int, limit: Int) = TODO()
    override suspend fun getVersionList(offset: Int, limit: Int) = TODO()
    override suspend fun getVersionGroupList(offset: Int, limit: Int) = TODO()
    override suspend fun getItemList(offset: Int, limit: Int) = TODO()
    override suspend fun getItemAttributeList(offset: Int, limit: Int) = TODO()
    override suspend fun getItemCategoryList(offset: Int, limit: Int) = TODO()
    override suspend fun getItemFlingEffectList(offset: Int, limit: Int) = TODO()
    override suspend fun getItemPocketList(offset: Int, limit: Int) = TODO()
    override suspend fun getMoveList(offset: Int, limit: Int) = TODO()
    override suspend fun getMoveAilmentList(offset: Int, limit: Int) = TODO()
    override suspend fun getMoveBattleStyleList(offset: Int, limit: Int) = TODO()
    override suspend fun getMoveCategoryList(offset: Int, limit: Int) = TODO()
    override suspend fun getMoveDamageClassList(offset: Int, limit: Int) = TODO()
    override suspend fun getMoveLearnMethodList(offset: Int, limit: Int) = TODO()
    override suspend fun getMoveTargetList(offset: Int, limit: Int) = TODO()
    override suspend fun getLocationList(offset: Int, limit: Int) = TODO()
    override suspend fun getLocationAreaList(offset: Int, limit: Int) = TODO()
    override suspend fun getPalParkAreaList(offset: Int, limit: Int) = TODO()
    override suspend fun getRegionList(offset: Int, limit: Int) = TODO()
    override suspend fun getMachineList(offset: Int, limit: Int) = TODO()
    override suspend fun getAbilityList(offset: Int, limit: Int) = TODO()
    override suspend fun getCharacteristicList(offset: Int, limit: Int) = TODO()
    override suspend fun getEggGroupList(offset: Int, limit: Int) = TODO()
    override suspend fun getGenderList(offset: Int, limit: Int) = TODO()
    override suspend fun getGrowthRateList(offset: Int, limit: Int) = TODO()
    override suspend fun getNatureList(offset: Int, limit: Int) = TODO()
    override suspend fun getPokeathlonStatList(offset: Int, limit: Int) = TODO()
    override suspend fun getPokemonList(offset: Int, limit: Int) = TODO()
    override suspend fun getPokemonColorList(offset: Int, limit: Int) = TODO()
    override suspend fun getPokemonFormList(offset: Int, limit: Int) = TODO()
    override suspend fun getPokemonHabitatList(offset: Int, limit: Int) = TODO()
    override suspend fun getPokemonShapeList(offset: Int, limit: Int) = TODO()
    override suspend fun getPokemonSpeciesList(offset: Int, limit: Int) = TODO()
    override suspend fun getStatList(offset: Int, limit: Int) = TODO()
    override suspend fun getTypeList(offset: Int, limit: Int) = TODO()
    override suspend fun getLanguageList(offset: Int, limit: Int) = TODO()
    override suspend fun getBerry(id: Int) = TODO()
    override suspend fun getBerryFirmness(id: Int) = TODO()
    override suspend fun getBerryFlavor(id: Int) = TODO()
    override suspend fun getContestType(id: Int) = TODO()
    override suspend fun getContestEffect(id: Int) = TODO()
    override suspend fun getSuperContestEffect(id: Int) = TODO()
    override suspend fun getEncounterMethod(id: Int) = TODO()
    override suspend fun getEncounterCondition(id: Int) = TODO()
    override suspend fun getEncounterConditionValue(id: Int) = TODO()
    override suspend fun getEvolutionChain(id: Int) = TODO()
    override suspend fun getEvolutionTrigger(id: Int) = TODO()
    override suspend fun getGeneration(id: Int) = TODO()
    override suspend fun getPokedex(id: Int) = TODO()
    override suspend fun getVersion(id: Int) = TODO()
    override suspend fun getVersionGroup(id: Int) = TODO()
    override suspend fun getItem(id: Int) = TODO()
    override suspend fun getItemAttribute(id: Int) = TODO()
    override suspend fun getItemCategory(id: Int) = TODO()
    override suspend fun getItemFlingEffect(id: Int) = TODO()
    override suspend fun getItemPocket(id: Int) = TODO()
    override suspend fun getMove(id: Int) = TODO()
    override suspend fun getMoveAilment(id: Int) = TODO()
    override suspend fun getMoveBattleStyle(id: Int) = TODO()
    override suspend fun getMoveCategory(id: Int) = TODO()
    override suspend fun getMoveDamageClass(id: Int) = TODO()
    override suspend fun getMoveLearnMethod(id: Int) = TODO()
    override suspend fun getMoveTarget(id: Int) = TODO()
    override suspend fun getLocation(id: Int) = TODO()
    override suspend fun getLocationArea(id: Int) = TODO()
    override suspend fun getPalParkArea(id: Int) = TODO()
    override suspend fun getRegion(id: Int) = TODO()
    override suspend fun getMachine(id: Int) = TODO()
    override suspend fun getAbility(id: Int) = TODO()
    override suspend fun getCharacteristic(id: Int) = TODO()
    override suspend fun getEggGroup(id: Int) = TODO()
    override suspend fun getGender(id: Int) = TODO()
    override suspend fun getGrowthRate(id: Int) = TODO()
    override suspend fun getNature(id: Int) = TODO()
    override suspend fun getPokeathlonStat(id: Int) = TODO()
    override suspend fun getPokemon(id: Int): Pokemon {
        val result = client.get("https://pokeapi.co/api/v2/pokemon/$id")
        println(result.bodyAsText())

        val body = try {
            result.body<Pokemon>()
        } catch (error: Throwable) {
            println(error.cause)
            throw error
        }
        return body
    }

    override suspend fun getPokemonEncounterList(id: Int) = TODO()
    override suspend fun getPokemonColor(id: Int) = TODO()
    override suspend fun getPokemonForm(id: Int) = TODO()
    override suspend fun getPokemonHabitat(id: Int) = TODO()
    override suspend fun getPokemonShape(id: Int) = TODO()
    override suspend fun getPokemonSpecies(id: Int) = TODO()
    override suspend fun getStat(id: Int) = TODO()
    override suspend fun getType(id: Int) = TODO()
    override suspend fun getLanguage(id: Int) = TODO()
}