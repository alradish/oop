package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.nsu.alexandr.lab2.CalcException;
import ru.nsu.alexandr.lab2.Context;
import ru.nsu.alexandr.lab2.command.Sub;
import ru.nsu.alexandr.lab2.command.Sum;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class SubTest {

    private Context context;
    private Sub sub = new Sub();

    @BeforeEach
    void init() {
        context = new Context();
    }

    @Test
    void work() throws CalcException.WrongParameters {
        context.push(1.1);
        context.push(2.2);
        assertTrue(sub.work(context, new String[0]) == 2.2 - 1.1);
        assertThrows(EmptyStackException.class, () -> sub.work(context, new String[0]));
        assertTrue(context.peek().equals(2.2 - 1.1));
    }
}