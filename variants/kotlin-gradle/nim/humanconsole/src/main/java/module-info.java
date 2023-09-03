module net.pijcke.nim.humanconsole {
    requires kotlin.stdlib;
    requires net.pijcke.nim.rules;
    provides net.pijcke.nim.rules.PlayerFactory with net.pijcke.nim.humanconsole.ConsoleHumanFactory;
}