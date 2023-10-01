module nim.airandom {
    requires kotlin.stdlib;
    requires nim.rules;
    exports net.pijcke.nim.airandom;
    provides net.pijcke.nim.rules.PlayerFactory
            with net.pijcke.nim.airandom.RandomAiFactory;
}