package BlackJack.model.rules;

import BlackJack.model.Card;
import BlackJack.model.Dealer;
import BlackJack.model.Deck;
import BlackJack.model.Player;

class AmericanNewGameStrategy implements INewGameStrategy {

    public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
        for (int i = 0; i < 2; i++) {
            gameProcess(a_deck, a_player, true);
            if (i == 1) {
                gameProcess(a_deck, a_dealer, false);
                continue;
            }
            gameProcess(a_deck, a_dealer, true);
        }
        return true;
    }

    public void gameProcess(Deck a_deck, Player anyPlayer, boolean isVisible) {
        Card c = a_deck.GetCard();
        c.Show(isVisible);
        anyPlayer.DealCard(c);
    }

//    public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
//        Card c;
//
//        c = a_deck.GetCard();
//        c.Show(true);
//        a_player.DealCard(c);
//
//        c = a_deck.GetCard();
//        c.Show(true);
//        a_dealer.DealCard(c);
//
//        c = a_deck.GetCard();
//        c.Show(true);
//        a_player.DealCard(c);
//
//        c = a_deck.GetCard();
//        c.Show(false);
//        a_dealer.DealCard(c);
//
//        return true;
//    }
}