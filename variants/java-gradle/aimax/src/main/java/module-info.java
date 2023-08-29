module net.pijcke.nim.aimax {
    requires net.pijcke.nim.rules;
    provides net.pijcke.nim.rules.PlayerFactory with net.pijcke.nim.aimax.MaxAIFactory;
}