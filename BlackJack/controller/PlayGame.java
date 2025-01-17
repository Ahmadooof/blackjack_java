package BlackJack.controller;

import BlackJack.model.Game;
import BlackJack.model.ICardObserver;
import BlackJack.view.IView;

public class PlayGame implements ICardObserver {

    public boolean Play(Game a_game, IView a_view) {


//        a_game.addSubscriber(this);
//        thread
        a_view.DisplayWelcomeMessage();
        a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
        a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());

        if (a_game.IsGameOver()) {
            a_view.DisplayGameOver(a_game.IsDealerWinner());
        }

        switch (a_view.GetInput()) {
            case Play:
                a_game.NewGame();
                break;
            case Hit:
                a_game.Hit();
                break;
            case Stand:
                a_game.Stand();
                break;
            case Quite:
                return false;
        }
        return true;
    }

//    @Override
//    public void cardShow(Iterable<Card> a_hand, int a_score) {
//        // thread
//        a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
//        a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());
//    }
}
