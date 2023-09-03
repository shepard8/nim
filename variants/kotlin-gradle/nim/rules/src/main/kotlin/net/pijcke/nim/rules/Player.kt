package net.pijcke.nim.rules

interface Player {

    fun name()

    fun play(sticks : Int): Int

    fun message(message : String) {
        // Override only if a human needs to read the messages.
    }

}