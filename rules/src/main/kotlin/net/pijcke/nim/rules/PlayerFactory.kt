package net.pijcke.nim.rules

interface PlayerFactory {

    val label : String

    fun build() : Player

}