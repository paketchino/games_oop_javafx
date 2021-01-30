package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void position() {
        Cell cell = Cell.A1;
        BishopBlack bishopBlack = new BishopBlack(cell);
        assertThat(bishopBlack.position(), is(cell));
    }

    @Test
    public void copy() {
        Cell cell = Cell.A2;
        BishopBlack bishopBlack = new BishopBlack(Cell.A2);
        assertThat(bishopBlack.copy(cell).position(), is(cell));
    }

    @Test
    public void way() throws ImpossibleMoveException {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] way = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(way, is(expected));
    }

    @Test
    public void isDiagonal() {
        boolean rsl = false;
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        try {
            bishopBlack.way(Cell.B7);
        } catch (ImpossibleMoveException e) {
            rsl = true;
        }
        assertThat(rsl, is(true));
    }
}