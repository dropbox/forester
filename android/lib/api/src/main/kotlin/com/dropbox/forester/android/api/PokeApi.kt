package com.dropbox.forester.android.api

import com.dropbox.forester.android.api.entity.*
import com.dropbox.pokedex.common.entity.*


interface PokeApi {

    suspend fun getBerryList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getBerryFirmnessList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getBerryFlavorList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getContestTypeList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getContestEffectList(offset: Int, limit: Int): ApiResourceList

    suspend fun getSuperContestEffectList(offset: Int, limit: Int): ApiResourceList

    suspend fun getEncounterMethodList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getEncounterConditionList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getEncounterConditionValueList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getEvolutionChainList(offset: Int, limit: Int): ApiResourceList

    suspend fun getEvolutionTriggerList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getGenerationList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getPokedexList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getVersionList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getVersionGroupList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getItemList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getItemAttributeList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getItemCategoryList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getItemFlingEffectList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getItemPocketList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getMoveList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getMoveAilmentList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getMoveBattleStyleList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getMoveCategoryList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getMoveDamageClassList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getMoveLearnMethodList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getMoveTargetList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getLocationList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getLocationAreaList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getPalParkAreaList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getRegionList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getMachineList(offset: Int, limit: Int): ApiResourceList

    suspend fun getAbilityList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getCharacteristicList(offset: Int, limit: Int): ApiResourceList

    suspend fun getEggGroupList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getGenderList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getGrowthRateList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getNatureList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getPokeathlonStatList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getPokemonList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getPokemonColorList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getPokemonFormList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getPokemonHabitatList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getPokemonShapeList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getPokemonSpeciesList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getStatList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getTypeList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getLanguageList(offset: Int, limit: Int): NamedApiResourceList

    suspend fun getBerry(id: Int): Berry

    suspend fun getBerryFirmness(id: Int): BerryFirmness

    suspend fun getBerryFlavor(id: Int): BerryFlavor

    suspend fun getContestType(id: Int): ContestType

    suspend fun getContestEffect(id: Int): ContestEffect

    suspend fun getSuperContestEffect(id: Int): SuperContestEffect

    suspend fun getEncounterMethod(id: Int): EncounterMethod

    suspend fun getEncounterCondition(id: Int): EncounterCondition

    suspend fun getEncounterConditionValue(id: Int): EncounterConditionValue

    suspend fun getEvolutionChain(id: Int): EvolutionChain

    suspend fun getEvolutionTrigger(id: Int): EvolutionTrigger

    suspend fun getGeneration(id: Int): Generation

    suspend fun getPokedex(id: Int): Pokedex

    suspend fun getVersion(id: Int): Version

    suspend fun getVersionGroup(id: Int): VersionGroup

    suspend fun getItem(id: Int): Item

    suspend fun getItemAttribute(id: Int): ItemAttribute

    suspend fun getItemCategory(id: Int): ItemCategory

    suspend fun getItemFlingEffect(id: Int): ItemFlingEffect

    suspend fun getItemPocket(id: Int): ItemPocket

    suspend fun getMove(id: Int): Move

    suspend fun getMoveAilment(id: Int): MoveAilment

    suspend fun getMoveBattleStyle(id: Int): MoveBattleStyle

    suspend fun getMoveCategory(id: Int): MoveCategory

    suspend fun getMoveDamageClass(id: Int): MoveDamageClass

    suspend fun getMoveLearnMethod(id: Int): MoveLearnMethod

    suspend fun getMoveTarget(id: Int): MoveTarget

    suspend fun getLocation(id: Int): Location

    suspend fun getLocationArea(id: Int): LocationArea

    suspend fun getPalParkArea(id: Int): PalParkArea

    suspend fun getRegion(id: Int): Region

    suspend fun getMachine(id: Int): Machine

    suspend fun getAbility(id: Int): Ability

    suspend fun getCharacteristic(id: Int): Characteristic

    suspend fun getEggGroup(id: Int): EggGroup

    suspend fun getGender(id: Int): Gender

    suspend fun getGrowthRate(id: Int): GrowthRate

    suspend fun getNature(id: Int): Nature

    suspend fun getPokeathlonStat(id: Int): PokeathlonStat

    suspend fun getPokemon(id: Int): Pokemon

    suspend fun getPokemonEncounterList(id: Int): List<LocationAreaEncounter>

    suspend fun getPokemonColor(id: Int): PokemonColor

    suspend fun getPokemonForm(id: Int): PokemonForm

    suspend fun getPokemonHabitat(id: Int): PokemonHabitat

    suspend fun getPokemonShape(id: Int): PokemonShape

    suspend fun getPokemonSpecies(id: Int): PokemonSpecies

    suspend fun getStat(id: Int): Stat

    suspend fun getType(id: Int): Type

    suspend fun getLanguage(id: Int): Language
}