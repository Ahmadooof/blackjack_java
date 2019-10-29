package BlackJack.model;

public interface ICardObserver {

    void cardShow(Iterable<BlackJack.model.Card> a_hand, int a_score);
}
