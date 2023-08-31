module net.pijcke.nim.aibest {
    requires net.pijcke.nim.rules;
    provides net.pijcke.nim.rules.PlayerFactory with net.pijcke.nim.aibest.BestAIFactory;
}