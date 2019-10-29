package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Deck;
import BlackJack.model.Player;

class InternationalNewGameStrategy implements INewGameStrategy {

    public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
        AmericanNewGameStrategy american = new AmericanNewGameStrategy();
        american.gameProcess(a_deck, a_dealer, a_player);
        return true;
    }
}