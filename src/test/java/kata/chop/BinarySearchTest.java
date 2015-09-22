package kata.chop;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Collection;
import java.util.Collections;

import static java.util.Arrays.asList;

public class BinarySearchTest {
    @DataProvider(name = "test1")
    public static Object[][] exceptedResult() {
        return new Object[][]{
                {-1, 3, Collections.<Integer>emptyList()},
                {-1, 3, asList(1)},
                {0, 1, asList(1)},

                {0, 1, asList(1,3,5)},
                {1, 3, asList(1,3,5)},
                {2, 5, asList(1,3,5)},
                {-1, 0, asList(1,3,5)},
                {-1, 2, asList(1,3,5)},
                {-1, 4, asList(1,3,5)},
                {-1, 6, asList(1,3,5)},

                {0, 1, asList(1,3,5,7)},
                {1, 3, asList(1,3,5,7)},
                {2, 5, asList(1,3,5,7)},
                {3, 7, asList(1,3,5,7)},
                {-1, 0, asList(1,3,5,7)},
                {-1, 2, asList(1,3,5,7)},
                {-1, 4, asList(1,3,5,7)},
                {-1, 6, asList(1,3,5,7)},
                {-1, 8, asList(1,3,5,7)},
        };
    }

    @Test(dataProvider = "test1")
    public void testChop(Integer indexFinded, Integer indexToFind, Collection<Integer> listIntoSearch) {
        assertThat(
                format("%s is into %s in index %s", indexToFind, listIntoSearch, indexFinded),
                new BinarySearch ().chop(indexToFind, listIntoSearch),
                equalTo(indexFinded));
    }
}
