package BlackJack.model.rules;

import BlackJack.model.Card;
import BlackJack.model.Dealer;
import BlackJack.model.Player;

public class Winner implements IWinner {

    @Override
    public boolean winGame(Player a_player, Dealer dealer, int maxScore) {
        if (a_player.CalcScore() > maxScore) {    // dealer wins <=> Player has over 21
            return true;
        } else if (dealer.CalcScore() > maxScore) {      // player wins <=> Dealer has over 21
            return false;
        }
        // player == dealer => check their hands, if one of them has more (Knight,Queen,King) then wins else dealer wins
        //  interface, strategy pattern, 2 variaters, should be same structure
        if (a_player.CalcScore() == dealer.CalcScore()) {
            int countKnightQueenKingPlayer = 0;
            for (Card c : a_player.GetHand()) {
                if (c.GetValue() == c.GetValue().Knight ||
                        c.GetValue() == c.GetValue().Queen ||
                        c.GetValue() == c.GetValue().King) {
                    countKnightQueenKingPlayer++;
                }
            }

            int countKnightQueenKingDealer = 0;
            for (Card c : dealer.GetHand()) {
                if (c.GetValue() == c.GetValue().Knight ||
                        c.GetValue() == c.GetValue().Queen ||
                        c.GetValue() == c.GetValue().King) {
                    countKnightQueenKingDealer++;
                }
            }
            return countKnightQueenKingPlayer <= countKnightQueenKingDealer;
        }
        // dealer has more score than player
        return dealer.CalcScore() >= a_player.CalcScore();
    }
}

