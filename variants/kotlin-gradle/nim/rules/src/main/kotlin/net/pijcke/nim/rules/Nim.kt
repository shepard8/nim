package net.pijcke.nim.rules

class Nim(private var currentPlayer : Player, private var otherPlayer : Player, private var sticks : Int) {

    companion object {
        val MAX_STICKS_PER_TURN = 3
    }

    fun start() {
        while (true) {
            val sticksToRemove = currentPlayer.play(sticks)

            if (sticksToRemove < 1 || sticksToRemove > MAX_STICKS_PER_TURN || sticksToRemove > sticks) {
                broadcast("Player $currentPlayer has been eliminated for not following the rules.")
                break
            }

            if (sticksToRemove == sticks) {
                broadcast("Player $currentPlayer has been eliminated for removing the last stick.")
                break
            }

            sticks -= sticksToRemove
            broadcast("$currentPlayer removed $sticksToRemove sticks. There are $sticks sticks remaining.")
            swapPlayers()
        }
    }

    private fun broadcast(message: String) {
        currentPlayer.message(message)
        otherPlayer.message(message)
    }

    private fun swapPlayers() {
        currentPlayer = otherPlayer.also { otherPlayer = currentPlayer }
    }

}
