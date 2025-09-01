package eu.tutorials.jsonbasicelogic

data class  Portion(
    val  name : String,
    val effect  : String,
    val potency : Int
)

fun main(){
    val healingPortion = Portion("Healing Potion", "Heals 50 HP", 50)
    val invisibililityPortion = Portion("Invisibility Potion", "Makes you invisible", 70)
    val strengthPortion = Portion("Strength Potion", "Increases attack power", 40)


    val potions = listOf(healingPortion, invisibililityPortion, strengthPortion)

    println(potions)
}