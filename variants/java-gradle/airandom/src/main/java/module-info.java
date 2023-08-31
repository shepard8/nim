module net.pijcke.nim.airandom {
    requires net.pijcke.nim.rules;
    provides net.pijcke.nim.rules.PlayerFactory with net.pijcke.nim.airandom.RandomAIFactory;
}