module net.pijcke.nim.aione {
  requires net.pijcke.nim.rules;
  provides net.pijcke.nim.rules.PlayerFactory with net.pijcke.nim.aione.OneAIFactory;
}
