import java.util.Arrays;

public class bubbleSortSuffixArray {
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
        bubbleSort(Sorted);
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
    * This method is Bubble Sort but instead of using a comparator, it uses the .compareTo mehtod
    * */
    public static void bubbleSort(String[] a){
        int n = a.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (a[j].compareTo(a[j+1]) > 0) {
                    // swap arr[j+1] and arr[j]
                    String temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
    }
}
