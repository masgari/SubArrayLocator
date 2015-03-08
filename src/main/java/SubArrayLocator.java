
public class SubArrayLocator {
    /**
     * Returns the first index of lookupArray in the inputArray
     *
     * @param inputArray  can not be null.
     * @param lookupArray can not be null.
     * @return index of array or -1 if the lookup array was not found.
     */
    public int indexOf(int[] inputArray, int[] lookupArray) {
        if (inputArray == null) {
            throw new IllegalArgumentException("Input array can not be null");
        }
        if (lookupArray == null) {
            throw new IllegalArgumentException("Lookup array can not be null");
        }

        //check lengths
        if (inputArray.length < 1 || lookupArray.length < 1 || inputArray.length < lookupArray.length) {
            return -1;
        }

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == lookupArray[0]) {
                boolean match = true;
                for (int j = 0; j < lookupArray.length; j++) {
                    if (inputArray[i + j] != lookupArray[j]) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return i;
                }
            }
        }
        return -1;
    }
}
