package Sort;

/**
 * Created by Clanner on 2017/10/24.
 * 排序工具类
 */
public final class SortUtil {

    public static final int ASC = 1;//升序
    public static final int DESC = 2;//降序

    private SortUtil() {
    }

    public static final SortUtil getInstance() {
        return Holder.instance;
    }

    private static final class Holder {
        private static final SortUtil instance = new SortUtil();
    }

    /**
     * 插入排序
     * @param values
     */
    public void insertionSort(int[] values) {
        int temp;
        for (int i = 1; i < values.length; i++) {
            temp = values[i];
            for (int j = i - 1; j >= 0 && temp < values[j]; j--) {
                values[j + 1] = values[j];
                values[j] = temp;
            }
        }
    }

    /**
     * 冒泡排序
     *
     * @param values
     */
    public void bubbleSort(int[] values) {
        for (int i = 0; i < values.length; i++) {
            for (int j = i; j < values.length; j++) {
                if (values[j] < values[i]) {
                    values[i] = values[i] + values[j];
                    values[j] = values[i] - values[j];
                    values[i] = values[i] - values[j];
                }
            }
        }
    }

    /**
     * 选择排序
     *
     * @param values
     */
    public void selectSort(int[] values) {
        for (int i = 0; i < values.length; i++) {
            int min = values[i];
            for (int j = i + 1; j < values.length; j++) {
                if (values[j] < min) {
                    min = values[j];
                    values[i] = values[i] + values[j];
                    values[j] = values[i] - values[j];
                    values[i] = values[i] - values[j];
                }
            }
        }
    }
}
