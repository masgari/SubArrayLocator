import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class SubArrayLocatorTest {
    @Test
    public void testIndexOfWithValidInput() {
        SubArrayLocator subArrayLocator = new SubArrayLocator();
        int[] inputArray = new int[]{2, 3, 4, 5};
        assertThat(subArrayLocator.indexOf(inputArray, new int[]{4, 5}), equalTo(2));
        assertThat(subArrayLocator.indexOf(inputArray, new int[]{2, 3}), equalTo(0));
        assertThat(subArrayLocator.indexOf(inputArray, new int[]{3, 4, 5}), equalTo(1));
        assertThat(subArrayLocator.indexOf(inputArray, new int[]{5}), equalTo(3));
        assertThat(subArrayLocator.indexOf(inputArray, new int[]{7}), equalTo(-1));

        inputArray = new int[]{2, 3, 4, 5, 5, 3, 4, 7, 1};
        assertThat(subArrayLocator.indexOf(inputArray, new int[]{3, 4}), equalTo(1));
        assertThat(subArrayLocator.indexOf(inputArray, new int[]{3, 4, 7}), equalTo(5));
    }


    @Test
    public void testIndexOfWithInvalidInput() {
        SubArrayLocator subArrayLocator = new SubArrayLocator();
        //test null inputs
        checkNullInput(subArrayLocator, null, null);
        checkNullInput(subArrayLocator, new int[]{7}, null);
        checkNullInput(subArrayLocator, null, new int[]{13});

        //test invalid inputs
        assertThat(subArrayLocator.indexOf(new int[]{}, new int[]{}), equalTo(-1));
        assertThat(subArrayLocator.indexOf(new int[]{}, new int[]{1}), equalTo(-1));
        assertThat(subArrayLocator.indexOf(new int[]{1, 2}, new int[]{1, 2, 3}), equalTo(-1));
    }

    private void checkNullInput(SubArrayLocator subArrayLocator, int[] inputArray, int[] lookupArray) {
        try {
            subArrayLocator.indexOf(inputArray, lookupArray);
            Assert.fail("Should not reach this line");
        } catch (IllegalArgumentException e) {
            //its okay
        } catch (Exception e) {
            Assert.fail("Should not throw any other exception type");
        }

    }
}
