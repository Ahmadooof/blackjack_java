package BlackJack.model.rules;

import BlackJack.model.Card;
import BlackJack.model.Dealer;
import BlackJack.model.Deck;
import BlackJack.model.Player;

class AmericanNewGameStrategy implements INewGameStrategy {

    public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
        gameProcess(a_deck, a_dealer, a_player);

        Card c = a_deck.GetCard();
        c.Show(false);
        a_dealer.DealCard(c);

        return true;
    }

    void gameProcess(Deck a_deck, Dealer a_dealer, Player a_player) {

        Card c = a_deck.GetCard();
        c.Show(true);
        a_player.DealCard(c);

        c = a_deck.GetCard();
        c.Show(true);
        a_dealer.DealCard(c);

        c = a_deck.GetCard();
        c.Show(true);
        a_player.DealCard(c);
    }
}