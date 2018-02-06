package Algorithm;

/**
 * 输出数组的全排列
 */
public class Sort {

    public static int total = 0;

    public static void main(String[] args) {
        int[] strings =  {1,2,3};
        arrange(strings,0,strings.length);
    }

    public static void swap(int[] str, int i, int j) {
        int temp;
        temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void arrange(int[] values, int st, int len) {
        if (st   == len - 1) {
            for (int i = 0; i < len; i++) {
                System.out.print(values[i] + "  ");
            }
            System.out.println();
            total++;
        } else {
            for (int i = st; i < len; i++) {
                swap(values, st, i);//交换
                arrange(values, st + 1, len);
                swap(values, st, i);
            }
        }
    }
}
