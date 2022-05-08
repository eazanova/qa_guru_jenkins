package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Title
 *
 * @author eazanova
 * @since 08.05.2022
 */
public class SkippedTests
{
    @Test
    @Disabled
    void test00() {
        assertTrue(false);
    }

    @Test
    @Disabled
    void test01() {
        assertTrue(false);
    }

    @Test
    @Disabled("some reason")
    void test02()
    {
        assertTrue(false);
    }
}
