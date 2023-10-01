module nim.aione {
    requires kotlin.stdlib;
    requires nim.rules;
    provides net.pijcke.nim.rules.PlayerFactory
            with net.pijcke.nim.aione.OneAiFactory;
}