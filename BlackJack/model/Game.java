package BlackJack.model;

import java.util.ArrayList;

public class Game {

    private Dealer m_dealer;
    private Player m_player;
    private ArrayList<ICardObserver> cardSubscribers;

    public Game() {
        m_dealer = new Dealer(new BlackJack.model.rules.RulesFactory());
        m_player = new Player();
        cardSubscribers = new ArrayList<ICardObserver>();
    }

    public void addSubscriber(ICardObserver sub) {
        cardSubscribers.add(sub); // forward to player and dealer
    }


    public boolean IsGameOver() {
        return m_dealer.IsGameOver();
    }

    public boolean IsDealerWinner() {
        return m_dealer.IsDealerWinner(m_player);
    }

    public boolean NewGame() {
//        for(ICardObserver obs : cardSubscribers){
//            obs.cardShow(m_dealer.GetHand(),m_dealer.CalcScore());
//        }
        return m_dealer.NewGame(m_player);
    }

    public boolean Hit() {
        return m_dealer.Hit(m_player);
    }

    public boolean Stand() {
        // TODO: Implement this according to Game_Stand.sequencediagram
        return this.m_dealer.stand();
    }

    public Iterable<Card> GetDealerHand() {
        return m_dealer.GetHand();
    }

    public Iterable<Card> GetPlayerHand() {
        return m_player.GetHand();
    }

    public int GetDealerScore() {
        return m_dealer.CalcScore();
    }

    public int GetPlayerScore() {
        return m_player.CalcScore();
    }


}