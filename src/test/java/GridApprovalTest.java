import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.List;


class GridApprovalTest {

    @Test
    void anEmptyGrid() {
        var grid = new MyBoundedGrid<String>(2, 3);
        Approvals.verify(grid);
    }

    @Test
    void aGridWithTopLeftCellsSetToA() {
        var grid = new MyBoundedGrid<String>(2, 3);
        grid.put(new Location(0, 0), "A");
        Approvals.verify(grid);
    }

    @Test
    void aGridWithBottomRightCellsSetTo1() {
        var grid = new MyBoundedGrid<Integer>(2, 3);
        grid.put(new Location(1, 2), 1);
        Approvals.verify(grid);
    }

    @Test
    void aGridWithBlueBlockInCenter() {
        var grid = new MyBoundedGrid<Block>(3, 3);
        grid.put(new Location(1, 1), new Block());
        Approvals.verify(grid);
    }

    @Test
    void aGridWithAll7ColorsRepresented() {
        var grid = new MyBoundedGrid<Block>(1, 7);
        var colors = List.of(Color.RED,
                Color.BLUE,
                Color.GREEN,
                Color.YELLOW,
                Color.GRAY,
                Color.MAGENTA,
                Color.CYAN
        );
        int column = 0;
        for (var color :
                colors) {
            Block block = new Block();
            block.setColor(color);
            grid.put(new Location(0, column++), block);
        }
        Approvals.verify(grid);
    }

    @Test
    void removingOneOfTwoCells() {
        var grid = new MyBoundedGrid<String>(1, 2);
        grid.put(new Location(0, 0), "A");
        grid.put(new Location(0, 1), "B");
        grid.remove(new Location(0, 0));
        Approvals.verify(grid);
    }
}
