package net.pijcke.nim.rules

class Nim(private val players : List<Player>, private var sticks : Int) {

    private val playing : MutableList<Player> = players.toMutableList()

    companion object {
        const val MAX_STICKS_PER_TURN = 3;
    }

    fun start() {
        while (sticks > 0 && players.count() > 1) {
            val currentPlayer = playing.removeFirst()

            val sticksToRemove = players.first().play(sticks)

            if (sticksToRemove < 1 || sticksToRemove > MAX_STICKS_PER_TURN || sticksToRemove > sticks) {
                broadcast("Player $currentPlayer has been eliminated for not following the rules.")
                continue
            }

            if (sticksToRemove == sticks) {
                broadcast("Player $currentPlayer has been eliminated for removing the last stick.")
                continue
            }

            sticks -= sticksToRemove
            broadcast("$currentPlayer removed $sticksToRemove sticks. There are $sticks remaining sticks.")

            playing.add(currentPlayer)
        }

        if (playing.count() == 1) {
            broadcast("The winner is ${players.first()}!")
        }
        else {
            broadcast("The winners are $players!")
        }
    }

    private fun broadcast(message : String) {
        println(message)

        players.forEach {
            it.message(message)
        }
    }

}