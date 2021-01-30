package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class LogicTest {

    @Test(expected = FigureNotFoundException.class)
    public void WhenFigureNotFound()
        throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.E1));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void WhenImpossibleMoveException()
        throws ImpossibleMoveException, FigureNotFoundException, OccupiedCellException {
            Logic logic = new Logic();
            logic.add(new BishopBlack(Cell.C1));
            logic.move(Cell.C1, Cell.H4);
        }

    @Test(expected = OccupiedCellException.class)
        public void whenOccupiedCellException()
        throws OccupiedCellException, ImpossibleMoveException, FigureNotFoundException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.F4));
        logic.move(Cell.C1, Cell.F4);
        logic.add(new BishopBlack(Cell.F4));
    }
    }