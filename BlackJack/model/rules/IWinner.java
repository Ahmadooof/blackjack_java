package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

public interface IWinner {
    boolean winGame(Player a_player, Dealer dealer, int maxScore);
}
