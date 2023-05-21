module net.pijcke.nim.ai.random {
    requires net.pijcke.nim.rules;
    requires kotlin.stdlib;
    provides net.pijcke.nim.rules.Player with net.pijcke.nim.ai.random.RandomAI;
}