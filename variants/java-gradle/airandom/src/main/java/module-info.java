module net.pijcke.nim.airandom {
    requires net.pijcke.nim.rules;
    exports net.pijcke.nim.airandom; // For aibest
    provides net.pijcke.nim.rules.PlayerFactory with net.pijcke.nim.airandom.RandomAIFactory;
}