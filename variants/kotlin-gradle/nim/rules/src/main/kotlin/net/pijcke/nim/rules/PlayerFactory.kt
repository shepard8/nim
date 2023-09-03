package net.pijcke.nim.rules

interface PlayerFactory {

    fun label() : String

    fun build() : Player

}