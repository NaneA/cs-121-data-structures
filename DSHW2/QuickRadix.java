public class QuickRadix {
    private static void QuickRadixHelper(String[] str, int i, int j, int position) {
        if(i < j) {
            int p = partition(str, i, j, position);
            QuickRadixHelper(str, i, p-1, position);
            QuickRadixHelper(str, p, j, position);
        }
    }


    private static int partition(String[] strSet, int low, int high, int position) {
        char pivot = strSet[high].charAt(position);
        int i = (low-1); // index of smaller element
        for (int j = low; j < high; j++) {
            if (strSet[j].charAt(position) <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                String temp = strSet[i];
                strSet[i] = strSet[j];
                strSet[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        String temp = strSet[i+1];
        strSet[i+1] = strSet[high];
        strSet[high] = temp;

        return i+1;
    }

    private static void doOneByOne(String[] strSet, int ind) {
        if(ind+1 >= strSet[0].length()) {
            return;
        }
        String c = strSet[0].substring(0, ind);
        int low = 0;
        int high = 0;

        for(int i = 1; i < strSet.length; i++) {
            if(strSet[i].substring(0, ind).equals(c)) {
                high++;
            } else {
                c = strSet[i].substring(0, ind);
                if(high - low > 0) {

                    System.out.println(high);
                    System.out.println(low);
                    QuickRadixHelper(strSet, low, high, ind+1);
                }
                low = i;
                high = i;
            }
        }
        doOneByOne(strSet, ind+1);
    }

    public static void QuickRadix(String[] strSet) {
        QuickRadixHelper(strSet, 0, strSet.length-1, 0);
        doOneByOne(strSet, 0);
    }
    public static void main(String[] args) {
        String[] stringSet = {
                "aewrerfefe",
                "aarojfioer",
                "qbrojfioer",
                "acrojfioer",
                "dewjuifeer",
                "qwferuefwf"
        };
        QuickRadix(stringSet);

        for(int i = 0; i < stringSet.length; i++) {
            System.out.println(stringSet[i]);
        }
    }
}