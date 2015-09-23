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
     * @param listIntoSearch given sorted list.
     *
     * @return index if the value is find, -1 else.
     */
    public int chop(Integer valueToSearch, List<Integer> listIntoSearch) {
        int beginIndex = 0;
        int endIndex = listIntoSearch.size() - 1;

        if (listIntoSearch.size() == 0) {
            return -1;
        }

        if (valueToSearch.equals(listIntoSearch.get(beginIndex))) {
            return beginIndex;
        }
        if (valueToSearch.equals(listIntoSearch.get(endIndex))) {
            return endIndex;
        }

        while (beginIndex + 1 < endIndex) {
            int mediumIndex = (endIndex + beginIndex) / 2;
            if (valueToSearch.equals(listIntoSearch.get(mediumIndex))) {
                return mediumIndex;
            }
            if (valueToSearch.compareTo(listIntoSearch.get(mediumIndex)) > 0) {
                beginIndex = mediumIndex;
            } else {
                endIndex = mediumIndex;
            }
        }
        return -1;
    }
}
