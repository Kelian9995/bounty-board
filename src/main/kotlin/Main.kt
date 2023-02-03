const val HERO_NAME = "Madrigal"
var playerLevel = 0

fun main() {
    println("$HERO_NAME  announces her presence to the world")
    println("What level id $HERO_NAME ?")
   playerLevel = readLine()?.toIntOrNull() ?: 0

println("$HERO_NAME' s level is $playerLevel")
    readBountyBoard()
                println ("Time passes...")
                println ("$HERO_NAME returns from her quest")
                playerLevel += 1
            println(playerLevel)
readBountyBoard()}
private fun readBountyBoard() {

        val quest: String? = obtainQuest(playerLevel)
        val message: String = try {
            quest?.replace("Nogartse", "xxxxxxxx")
            ?.let { censoredQuest ->

                """
        |$HERO_NAME apporoaches the bounty board.It reads: 
        |"$censoredQuest"
        |""".trimMargin()

            } ?: "$HERO_NAME apporoaches the bounty board, but it is blank"

    } catch (e: Exception) {
        "$HERO_NAME can't read what's on the bounty board."
    }
    println(message)
}

private fun obtainQuest(
    playerLevel: Int,
    playerClass: String = "paladin",
    hasBefriendedBarbarians: Boolean = true,
    hasAngeredBarbarians: Boolean = false
): String? {
   if (playerLevel <= 0 ) {
       throw InvalidPlayerLevelException()
   }
    return when (playerLevel) {
        1 -> "Meet Mr.Bubbles in the land of soft things"
        in 2..5 -> {
            val cantalkTobarbarians = !hasAngeredBarbarians && (hasBefriendedBarbarians || playerClass == "barbarian")
            if (cantalkTobarbarians) {
                "Convince the barbarian to call off their invasion"
            } else {
                "Save the town the barbarian invasion"

            }
        }
        6 -> "Locate the enchanted sword."

        7 -> "Recober the long-lost artifact of creation"

        8 -> "Defeat Nogartse, bringer of death and eater of worlds"
        else -> null
    }
}
class InvalidPlayerLevelException() :
        java.lang.IllegalArgumentException("Invalid player level (must be at least 1).")




