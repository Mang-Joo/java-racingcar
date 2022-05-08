package racingcar;

import racingcar.domain.RacingGame;
import racingcar.domain.policy.MovePolicy;
import racingcar.domain.policy.ZeroToNineRandomMovePolicy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingMain {
    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryNumber = InputView.getTryNumber();

        MovePolicy movePolicy = new ZeroToNineRandomMovePolicy();
        RacingGame racingGame = new RacingGame(carNames, tryNumber, movePolicy);

        ResultView.printHead();
        while (racingGame.isKeepGoing()) {
            racingGame.race();
            ResultView.printCars(racingGame.getCars());
        }

        ResultView.printWinners(racingGame.getWinners());
    }
}
