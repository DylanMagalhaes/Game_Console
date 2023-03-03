import Game.Game
import Game.Player

fun main() {
    val payer1 = Player("Joueur 1")
    val player2 = Player("IA")
    var game = Game(payer1, player2)
    game.start()

}