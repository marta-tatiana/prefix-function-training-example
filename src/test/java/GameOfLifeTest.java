import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameOfLifeTest {

    @Test public void
    shouldRemainEmptyIfEmpty() {
        int[][] board = new int[3][3];
        GameOfLife gameOfLife = new GameOfLife(board);
        gameOfLife.next();
        int[][] result = gameOfLife.getBoard();
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                assertThat(result[i][j], equalTo(0));
            }
        }
    }


    @Test public void
    singleCellShouldDie() {
        int[][] board = new int[3][3];
        board[1][1] = 1;
        GameOfLife gameOfLife = new GameOfLife(board);
        gameOfLife.next();
        int[][] result = gameOfLife.getBoard();
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                assertThat(result[i][j], equalTo(0));
            }
        }
    }
}
