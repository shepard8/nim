module net.pijcke.nim.aimax {
    requires kotlin.stdlib;
    requires net.pijcke.nim.rules;
    provides net.pijcke.nim.rules.PlayerFactory with net.pijcke.nim.aimax.MaxAiFactory;
}