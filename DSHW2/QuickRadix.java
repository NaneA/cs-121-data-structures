public class QuickRadix {
    public static void QuickRadix(String[] str, int i, int j) {
        if(i < j) {
            int p = partition(str, i, j, 1);
            QuickRadix(str, i, p-1);
            QuickRadix(str, p, j);
        }
    }


    public static int partition(String[] strSet, int low, int high, int position) {
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

    public static void main(String[] args) {
        String[] stringSet = {
                "dferferiuh",
                "eirojfioer",
                "dewjuifeer",
                "ewferuefwf"
        };
        System.out.println('b' < 'q');
        QuickRadix(stringSet, 0, stringSet.length-1);
        for(int i = 0; i < stringSet.length; i++) {
            System.out.println(stringSet[i]);
        }
    }
}