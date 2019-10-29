package BlackJack.model;

import BlackJack.model.rules.IHitStrategy;
import BlackJack.model.rules.INewGameStrategy;
import BlackJack.model.rules.IWinner;
import BlackJack.model.rules.RulesFactory;

public class Dealer extends Player {

    private Deck m_deck;
    private INewGameStrategy m_newGameRule;
    //    private IHitStrategy m_hitRule;
    private IHitStrategy m_HitRole;
    private IWinner winGame;

    public Dealer(RulesFactory a_rulesFactory) {

        m_newGameRule = a_rulesFactory.GetNewGameRule();    //American
        //        m_hitRule = a_rulesFactory.GetHitRule();
        m_HitRole = a_rulesFactory.GetHitRule();
        winGame = a_rulesFactory.GetWinner();
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
//            Card c;
//            c = m_deck.GetCard();
//            c.Show(true);
//            a_player.DealCard(c);
            m_newGameRule.gameProcess(m_deck,a_player,true);

            return true;
        }
        return false;
    }

    public boolean IsDealerWinner(Player a_player) {
        return winGame.winGame(a_player, this, g_maxScore);
    }

    public boolean IsGameOver() {
//        return m_deck != null && m_hitRule.DoHit(this) != true;
        return m_deck != null && !m_HitRole.DoHit(this);
    }

    public boolean stand() {
        if (this.m_deck != null) {
            ShowHand();
            while (m_HitRole.DoHit(this)) {
//                Card c = m_deck.GetCard();
//                c.Show(true);
//                DealCard(c);
                m_newGameRule.gameProcess(m_deck, this, true);
            }
            return true;
        } else
            return false;
    }
}