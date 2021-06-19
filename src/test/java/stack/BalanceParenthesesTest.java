package stack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BalanceParenthesesTest {

    private final String str;
    private final boolean result;

    @Parameterized.Parameters
    public static Collection<Object[]> input() {
        List<Object[]> args = new ArrayList<>();
        args.add(new Object[]{"[({})(())]", true});
        args.add(new Object[]{"(({()})))[[", false});
        args.add(new Object[]{"({(){}()})()({(){}()})(){()}{}((()))", true});
        args.add(new Object[]{"{}()))(()()({}}{}", false});
        args.add(new Object[]{"}}}}", false});
        args.add(new Object[]{"))))", false});
        args.add(new Object[]{"{{{", false});
        args.add(new Object[]{"(((", false});
        args.add(new Object[]{"{}(){()}((())){{{}}}{()()}{{}{}}", true});
        args.add(new Object[]{"{{{{{{{)))))))))))))))))))", false});
        args.add(new Object[]{"{}{}(", false});
        args.add(new Object[]{"{}}}{}", false});
        args.add(new Object[]{"()()()())))", false});
        args.add(new Object[]{"(((((()()()", false});
        args.add(new Object[]{"(){}{{}}()(()){{()()}}", true});
        args.add(new Object[]{"{}{{{}}}{{{((()))}}}", true});
        args.add(new Object[]{"((()))[]", true});
        args.add(new Object[]{"{{}}(()[])", true});
        return args;
    }

    public BalanceParenthesesTest(String str, boolean result) {
        this.str = str;
        this.result = result;
    }

    @Test
    public void Tests() {
        assertEquals(this.result, new BalanceParentheses().isBalance(this.str));
    }

}