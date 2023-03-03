package Game

class Player(val name: String, var health: Int = 500, var attackStrength: Int = 150 ) {

    fun attack(player: Player){
        player.health -= this.attackStrength
       var coupCritique = (1..4).random()
        if(coupCritique == 2){
            player.health -= 10
            println("\uD83D\uDCA5 COUP CRITIQUE \uD83D\uDCA5")
        }
    }

    fun defend(player: Player){
        player.attackStrength -= player.attackStrength / 2
    }

    fun heal(){
        this.health += 5
    }
}