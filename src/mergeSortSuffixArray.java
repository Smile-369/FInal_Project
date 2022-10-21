import java.util.Arrays;

/*
* mergeSortSuffixArray serves as a suffix array creation using mergesort
* */
public class mergeSortSuffixArray {

    public static void main(String[] args) {
      printSuffixArray();
    }
    /*
    * This method works as a way to print out a suffix array, and applies the following methods
    *  createRandomString, suffixArrayCreation,and mergeSort
    * */
    static void printSuffixArray(){
        int n= 128*(int) Math.pow(2,8);
            /*
            sets n to 128 *2^n
            * */
        String Input=createRandomString(n);
        String[] Sorted=suffixArrayCreation(Input);
        String[] temp = Sorted.clone();
        mergeSort(Sorted,0, Sorted.length-1);
        System.out.printf("Output: ");
        int[] Index2=Index(Sorted,temp);
        System.out.println(Arrays.toString(Index2));
    }
    /*
    * This Method creates an unsorted suffix array using a for loop and the .substring() method
    * */
    static String[] suffixArrayCreation(String Input){
        String[] Final = new String[Input.length()];
        String temp = Input;
        for(int i= 0;i<Input.length();i++){
            temp = Input.substring(i);
            Final[i]=temp;
        }
        return Final;
    }
    /*
    *This method uses the StringBuilder Class and takes an input of n to allocate the length of the string, and uses
    * Math.random multiplied by the length of the input string, and appends the random char to the string.
    * */
    public static String createRandomString(int n){
        String Input ="acgt";
        StringBuilder s = new StringBuilder(n);
        for ( int i=0; i<n; i++) {
            int random = (int)(Input.length() * Math.random());
            s.append(Input.charAt(random));
        }
        return s.toString();
    }
    /*
    * This method uses a nested for loop to compare the index of the unsorted suffix array to the sorted suffix array
    * */
    public static int[] Index(String[] Sorted, String[] Original){
        int[] Indexes=new int[Sorted.length];
        for(int i=0;i<Sorted.length;i++){
            for(int j = 0; j< Original.length;j++){
                if(Sorted[i].equals(Original[j])){
                    Indexes[i]=j;
                }
            }
        }
        return Indexes;
    }
    /*
    * these two methods are merge sort but , uses the .compareTo method for strings
    * */
    public static void mergeSort(String[] a, int from, int to) {
        if (from == to) {
            return;
        }
        int mid = (from + to) / 2;

        mergeSort(a, from, mid);
        mergeSort(a, mid + 1, to);
        merge(a, from, mid, to);
    }

    public static void merge(String[] a, int from, int mid, int to) {
        int n = to - from + 1;
        String[] b = new String[n];
        int i1 = from;
        int i2 = mid + 1;
        int j = 0;

        while (i1 <= mid && i2 <= to) {
            if (a[i1].compareTo(a[i2]) < 0) {
                b[j] = a[i1];
                i1++;
            } else {
                b[j] = a[i2];
                i2++;
            }
            j++;
        }
        while (i1 <= mid) {
            b[j] = a[i1];
            i1++;
            j++;
        }
        while (i2 <= to) {
            b[j] = a[i2];
            i2++;
            j++;
        }
        for (j = 0; j < n; j++) {
            a[from + j] = b[j];
        }
    }
}
