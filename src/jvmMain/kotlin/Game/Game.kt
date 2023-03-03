package Game

class Game(var player1: Player, var player2: Player) {

    fun start() {
        var turn: Int = 1
        println("${player1.name} et l'${player2.name} allez vous affronter")
        println(
            "Regle du jeu : Vous jouer contre l'ordinateur(IA).\n" +
                    "Chaque joueur commence avec une santé de 500 points et une force d'attaque de 150 points.\n" +
                    "Vous êtes le premier a commencer. Chaque tour, le joueur peut choisir parmi trois actions :\n" +
                    "1. Attaquer : inflige des dégâts à l'adversaire, les degats infligés sont egale à la force d'attaque.\n" +
                    "2. Défendre : réduit de moitié la force d'attaque de l'adversaire.\n" +
                    "3. Soigner : augmente sa santé de 5 points.\n-----------------------"
        )
        while (player1.health > 0 && player2.health > 0) {

            // TURN PLAYER 1

            println("\uD83D\uDC4A TOUR NUMERO $turn \uD83D\uDC4A")
            println("Ecrit :\n'1' pour ATTAQUER\n'2' pour DEFENDRE\n'3' pour vous SOIGNER  ")
            var choicePlayer1 = readLine()

            if (choicePlayer1 == "1") {
                choicePlayer1 = "ATTAQUER"
                player1.attack(player2)
                println("${player1.name} PDV -> ${player1.health}, FORCE -> ${player1.attackStrength} : vous avez choisi d' $choicePlayer1 ")
                println("PDV ${player2.name} : ${player2.health}\nForce ${player2.name} : ${player2.attackStrength}")
            } else if (choicePlayer1 == "2") {
                choicePlayer1 = "DEFENDRE"
                player1.defend(player2)
                println("${player1.name} PDV -> ${player1.health}, FORCE -> ${player1.attackStrength} : Vous avez choisi de $choicePlayer1 ")
                println("PDV ${player2.name} : ${player2.health}\nForce ${player2.name} : ${player2.attackStrength}")
            } else {
                choicePlayer1 = "SOIGNER"
                println("${player1.name} PDV -> ${player1.health}, FORCE -> ${player1.attackStrength} : Vous avez choisi de vous $choicePlayer1 ")
                player1.heal()
                println("${player1.name} PDV -> ${player1.health}")

            }

            println("-  -  -  -  -")

            // TURN PLAYER 2

            val random = (1..3).random()
            if (random == 1) {
                player2.attack(player1)
                println("${player2.name} PDV -> ${player2.health}, FORCE -> ${player2.attackStrength} : L'IA a choisi D'ATTAQUER ")
                println("PDV ${player1.name} : ${player1.health}")
                println("Force ${player1.name} : ${player1.attackStrength}")
            } else if (random == 2) {
                player2.defend(player1)
                println("${player2.name} PDV -> ${player2.health}, FORCE -> ${player2.attackStrength} : L'IA a choisi de DEFENDRE ")
                println("PDV ${player1.name} : ${player1.health}")
                println("Force ${player1.name} : ${player1.attackStrength}")
            } else {
                println("${player2.name} PDV -> ${player2.health}, FORCE -> ${player2.attackStrength} : L'IA a choisi de se SOIGNER ")
                player2.heal()
                println("${player2.name} PDV -> ${player2.health}")
            }

            println("__________________")
            turn++
        }

        if (player1.health <= 0) {
            println("${player2.name} a gagné la partie")
        } else {
            println("${player1.name} a gagné la partie")
        }
    }
}