package kata.chop;

import java.util.List;

/**
 * Class into implement the chop search.
 */
public class BinarySearch {

    /**
     * Give the index of the value to search into the given list.
     *
     * @param valueToSearch  value to search.
     * @param listIntoSearch given list.
     *
     * @return index if the value is find, -1 else.
     */
    public int chop(Integer valueToSearch, List<Integer> listIntoSearch) {
        if (listIntoSearch.size() < 1) {
            // Empty list
            return -1;
        }
        if (valueToSearch.equals(listIntoSearch.get(0))) {
            // First element match
            return 0;
        }
        if (valueToSearch.equals(
                listIntoSearch.get(listIntoSearch.size() - 1))) {
            // Last element match
            return listIntoSearch.size() - 1;
        }
        return recurciveChop(valueToSearch, listIntoSearch, 0,
                listIntoSearch.size() - 1);
    }

    private int recurciveChop(Integer valueToSearch, List<Integer> listIntoSearch, int begin, int end) {
        int middle = (begin + end) / 2;
        if (middle == begin || middle == end) {
            // begin == end + 1
            return -1;
        }
        if (valueToSearch.equals(listIntoSearch.get(middle))) {
            // Middle element match
            return middle;
        }
        if (valueToSearch.compareTo(listIntoSearch.get(middle)) > 0) {
            return recurciveChop(valueToSearch, listIntoSearch, middle, end);
        } else {
            return recurciveChop(valueToSearch, listIntoSearch, begin, middle);
        }
    }
}
