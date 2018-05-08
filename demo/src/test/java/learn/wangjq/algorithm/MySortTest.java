package learn.wangjq.algorithm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * MySort Tester.
 *
 * @author wangjq
 * @version 1.0
 * @since <pre>03/26/2018</pre>
 */
public class MySortTest {

    public static void isSort(int[] arrays) {
        boolean condition = true;
        for (int i = 0; i < arrays.length - 1; i++) {
            condition = condition && (arrays[i] < arrays[i + 1]);
        }
        assertTrue(condition);
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: bubbleSort(int[] numbers)
     */
    @Test
    public void testBubbleSort() throws Exception {
        int[] arrays = new int[]{5, 3, 6, 4, 2, 9};
        MySort.bubbleSort(arrays);

        isSort(arrays);
    }

    /**
     * Method: selectionSort(int[] numbers)
     */
    @Test
    public void selectionSort() throws Exception {
        int[] arrays = new int[]{5, 3, 6, 4, 2, 9};
        MySort.selectionSort(arrays);
        isSort(arrays);

    }


} 
