package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Deck;
import BlackJack.model.Player;

class InternationalNewGameStrategy implements INewGameStrategy {

    public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
        AmericanNewGameStrategy american = new AmericanNewGameStrategy();
        american.NewGame(a_deck, a_dealer, a_player);
        return true;
    }

    @Override
    public void gameProcess(Deck a_deck, Player a_player, boolean isVisible) {

    }
}