import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ValidateHooksTest {
    ValidateHooks exp = new ValidateHooks();
    Set<String> one = new HashSet<String>();
    Set<String> two = new HashSet<String>();
    Set<String> three = new HashSet<String>();
    Set<String> four = new HashSet<String>();
    Set<String> five = new HashSet<String>();
    Set<String> six = new HashSet<String>();

    @Before
    public void setUp() {
        one.add("{{}}");
        one.add("{}{}");
        two.add("{x}x");
        two.add("{xx}");
        two.add("{}xx");
        three.add("");
        four.add("x{x{2}b}x");
        four.add("x{x}{2b}x");
        four.add("x{x}{2}bx");
        four.add("x{}x{2b}x");
        four.add("x{}x{2}bx");
        five.add("{}{{}{}{}}{{}}");
        five.add("{{}{}{}{}}{{}}");
        five.add("{{{}{}{}}}{{}}");
        five.add("{}{{}{{}}}{{}}");
        five.add("{{}{{{}}}}{{}}");
        five.add("{{}}{{}{}}{{}}");
        five.add("{}{}{}{}{}{{}}");
        five.add("{}{{{{}}}}{{}}");
        five.add("{}{}{{}{}}{{}}");
        five.add("{}{{{}{}}}{{}}");
        five.add("{}{}{{{}}}{{}}");
        five.add("{{{}{{}}}}{{}}");
        five.add("{{}{{}{}}}{{}}");
        five.add("{{{{}{}}}}{{}}");
        five.add("{{}}{}{{}}{{}}");
        five.add("{{}{}{{}}}{{}}");
        five.add("{{}}{}{}{}{{}}");
        five.add("{}{}{}{{}}{{}}");
        five.add("{{}}{{{}}}{{}}");
        six.add("{{}}");
        six.add("{}{}");
    }

    @Test
    public void validate() {
        assertEquals(true,one.equals(exp.validate("{}}{}}")));
        assertEquals(true,two.equals(exp.validate("{}x}x}")));
        assertEquals(true,three.equals(exp.validate("{{{{{")));
        assertEquals(true,four.equals(exp.validate("x{}x}{2}b}x")));
        assertEquals(true,five.equals(exp.validate("{}}{}}{}{}{}}}}{{{{}}{")));
        assertEquals(true,six.equals(exp.validate("}{}}{}}")));
    }
}
