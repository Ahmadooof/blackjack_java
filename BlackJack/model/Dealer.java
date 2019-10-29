package BlackJack.model;

import BlackJack.model.rules.IHitStrategy;
import BlackJack.model.rules.INewGameStrategy;
import BlackJack.model.rules.RulesFactory;

public class Dealer extends Player {

    private Deck m_deck;
    private INewGameStrategy m_newGameRule;
    //    private IHitStrategy m_hitRule;
    private IHitStrategy m_HitRole;

    public Dealer(RulesFactory a_rulesFactory) {

        m_newGameRule = a_rulesFactory.GetNewGameRule();
        //        m_hitRule = a_rulesFactory.GetHitRule();
        m_HitRole = a_rulesFactory.GetHitRule();
    
    /*for(Card c : m_deck.GetCards()) {
      c.Show(true);
      System.out.println("" + c.GetValue() + " of " + c.GetColor());
    }    */
    }


    public boolean NewGame(Player a_player) {
        if (m_deck == null || IsGameOver()) {
            m_deck = new Deck();
            ClearHand();
            a_player.ClearHand();
            return m_newGameRule.NewGame(m_deck, this, a_player);
        }
        return false;
    }

    public boolean Hit(Player a_player) {
        if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
            Card c;
            c = m_deck.GetCard();
            c.Show(true);
            a_player.DealCard(c);

            return true;
        }
        return false;
    }

    public boolean IsDealerWinner(Player a_player) {
        if (a_player.CalcScore() > g_maxScore) {    // dealer wins <=> Player has over 21
            return true;
        } else if (CalcScore() > g_maxScore) {      // player wins <=> Dealer has over 21
            return false;
        }
        // player == dealer => check their hands, if one of them has more (Knight,Queen,King) then wins else dealer wins
        // interface , strategy pattern, 2 variaters, should be same structure
        if (a_player.CalcScore() == CalcScore()) {
            int countKnightQueenKingPlayer = 0;
            for (Card c : a_player.GetHand()) {
                if (c.GetValue() == c.GetValue().Knight ||
                        c.GetValue() == c.GetValue().Queen ||
                        c.GetValue() == c.GetValue().King) {
                    countKnightQueenKingPlayer++;
                }
            }

            int countKnightQueenKingDealer = 0;
            for (Card c : GetHand()) {
                if (c.GetValue() == c.GetValue().Knight ||
                        c.GetValue() == c.GetValue().Queen ||
                        c.GetValue() == c.GetValue().King) {
                    countKnightQueenKingDealer++;
                }
            }
            if (countKnightQueenKingPlayer > countKnightQueenKingDealer) {
                return false;
            } else {
                return true;
            }
        }
        // dealer has more score than player
        return CalcScore() >= a_player.CalcScore();
    }

    public boolean IsGameOver() {
//        return m_deck != null && m_hitRule.DoHit(this) != true;
        return m_deck != null && !m_HitRole.DoHit(this);
    }

    public boolean stand() {
        if (this.m_deck != null) {
            ShowHand();
            while (m_HitRole.DoHit(this)) {
                Card c = m_deck.GetCard();
                c.Show(true);
                DealCard(c);
            }
            return true;
        } else
            return false;
    }
}