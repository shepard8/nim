module net.pijcke.nim.airandom {
    requires kotlin.stdlib;
    requires net.pijcke.nim.rules;
    exports net.pijcke.nim.airandom;
    provides net.pijcke.nim.rules.PlayerFactory with net.pijcke.nim.airandom.RandomAiFactory;
}