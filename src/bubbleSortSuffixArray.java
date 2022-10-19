import java.util.Arrays;

public class bubbleSortSuffixArray {
    public static void main(String[] args) {
        printSuffixArray();
    }
    static void printSuffixArray(){
        int n= 128*(int) Math.pow(2,8);
        String Input=createRandomString(n);
        String[] Sorted=suffixArrayCreation(Input);
        String[] temp = Sorted.clone();
        bubbleSort(Sorted);
        System.out.printf("Output: ");
        int[] Index2=Index(Sorted,temp);
        System.out.println(Arrays.toString(Index2));
    }
    static String[] suffixArrayCreation(String Input){
        String[] Final = new String[Input.length()];
        String temp = Input;
        for(int i= 0;i<Input.length();i++){
            temp = Input.substring(i, Input.length());
            Final[i]=temp;
        }
        return Final;
    }
    public static String createRandomString(int n){
        String Input ="acgt";
        StringBuilder s = new StringBuilder(n);
        for ( int i=0; i<n; i++) {
            int random = (int)(Input.length() * Math.random());
            s.append(Input.charAt(random));
        }
        return s.toString();
    }

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
