package net.pijcke.nim.rules

interface Player {

    val name : String

    fun play(sticks : Int) : Int

    fun message(message : String) {
        // Override only if a human needs to read the message at some point.
    }

}