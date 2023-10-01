module nim.aibest {
    requires kotlin.stdlib;
    requires nim.rules;
    requires nim.airandom; // requires transitive would load nim.airandom.
    provides net.pijcke.nim.rules.PlayerFactory
            with net.pijcke.nim.aibest.BestAiFactory;
}