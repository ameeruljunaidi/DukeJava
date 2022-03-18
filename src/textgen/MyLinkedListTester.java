/**
 *
 */
package textgen;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

    private static final int LONG_LIST_LENGTH = 10;

    MyLinkedList<String> shortList;
    MyLinkedList<Integer> emptyList;
    MyLinkedList<Integer> longerList;
    MyLinkedList<Integer> list1;

    @Before
    public void setUp() throws Exception {
        // Feel free to use these lists, or add your own

        shortList = new MyLinkedList<String>();
        shortList.add("A");
        shortList.add("B");

        emptyList = new MyLinkedList<Integer>();

        longerList = new MyLinkedList<Integer>();
        for (int i = 0; i < LONG_LIST_LENGTH; i++) {
            longerList.add(i);
        }

        list1 = new MyLinkedList<>();
        list1.add(65);
        list1.add(21);
        list1.add(42);
    }


    /** Test if the get method is working correctly.
     *
     * You should not need to add much to this method.
     * We provide it as an example of a thorough test. */
    @Test
    public void testGet() {
        // test empty list, get should throw an exception
        try {
            emptyList.get(0);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException ignored) {
        }

        // test short list, first contents, then out of bounds
        assertEquals("Check first", "A", shortList.get(0));
        assertEquals("Check second", "B", shortList.get(1));

        try {
            shortList.get(-1);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            shortList.get(2);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {
        }

        // test longer list contents
        for (int i = 0; i < LONG_LIST_LENGTH; i++) {
            assertEquals("Check " + i + " element", (Integer) i, longerList.get(i));
        }

        // test off the end of the longer array
        try {
            longerList.get(-1);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            longerList.get(LONG_LIST_LENGTH);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {
        }
    }


    /** Test removing an element from the list.
     * We've included the example from the concept challenge.
     * You will want to add more tests.  */
    @Test
    public void testRemove() {
        int a = list1.remove(0);
        assertEquals("Remove: check a is correct ", 65, a);
        assertEquals("Remove: check element 0 is correct ", (Integer) 21, list1.get(0));
        assertEquals("Remove: check size is correct ", 2, list1.size());

        // TODO: Add more tests here

        assertEquals("Remove: check can access second element", (Integer) 42, list1.get(1));

        try {
            list1.remove(-1);
            fail("Check lower bounds on remove");
        } catch (IndexOutOfBoundsException ignored) {
        }

        try {
            list1.remove(100);
            fail("Check upper bounds on remove");
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    /** Test adding an element into the end of the list, specifically
     *  public boolean add(E element)
     */
    @Test
    public void testAddEnd() {

        list1.add(69);
        assertEquals("Add: check element 3 is correct", (Integer) 69, list1.get(3));
        assertEquals("Add: check that size is 4", 4, list1.size());

        try {
            list1.add(null);
            fail("Check upper bounds on add");
        } catch (NullPointerException ignored) {
        }
    }


    /** Test the size of the list */
    @Test
    public void testSize() {
        // TODO: implement this test

        assertEquals("Size: check current size if 3", 3, list1.size());
        list1.remove(0);
        assertEquals("Size: check current size if 2", 2, list1.size());
    }


    /** Test adding an element into the list at a specified index,
     * specifically:
     * public void add(int index, E element)
     * */
    @Test
    public void testAddAtIndex() {
        // TODO: implement this test

        list1.add(0, 25);
        assertEquals("Add at index: check that first element is 25", (Integer) 25, list1.get(0));
        assertEquals("Add at index: check that size is 4", 4, list1.size());
        list1.add(3, 122);
        assertEquals("Add at index: check that fourth element is 122", (Integer) 122, list1.get(3));
        assertEquals("Add at index: check that size is 5", 5, list1.size());

        try {
            list1.add(-1, 78);
            fail("Check lower bounds on add");
        } catch (IndexOutOfBoundsException ignored) {
        }

        try {
            list1.add(100, 98);
            fail("Check upper bounds on add");
        } catch (IndexOutOfBoundsException ignored) {
        }

        try {
            list1.add(0, null);
            fail("Check upper bounds on add");
        } catch (NullPointerException ignored) {
        }

    }

    /** Test setting an element in the list */
    @Test
    public void testSet() {
        // TODO: implement this test

        list1.set(0, 62);
        assertEquals("Set: check that first element is 62", (Integer) 62, list1.get(0));
        assertEquals("Set: check that list size is unchanged at 3", 3, list1.size());

        try {
            list1.set(-1, 77);
            fail("Check lower bounds on set");
        } catch (IndexOutOfBoundsException ignored) {
        }

        try {
            list1.set(100, 88);
            fail("Check upper bounds on set");
        } catch (IndexOutOfBoundsException ignored) {
        }

        try {
            list1.set(0, null);
            fail("Check upper bounds on set");
        } catch (NullPointerException ignored) {
        }

    }

    // Optionally add more test methods.
}
