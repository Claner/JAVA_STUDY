package Sort;

import Algorithm.TreeNode;

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
     *
     * @param values
     */
    public void insertionSort(int[] values) {
        int temp;
        for (int i = 1; i < values.length; i++) {
            temp = values[i];
            for (int j = i - 1; j >= 0 && temp < values[j]; j--) {//和不断前一个数比较，小于就交换
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

    /**
     * 快速排序
     *
     * @param values
     */
    public void quickSort(int[] values, int i, int j) {
        int k;
        if (i < j) {
            k = partition(values, i, j);
            quickSort(values, i, k - 1);//前划分
            quickSort(values, k + 1, j);//后划分
        }
    }

    /**
     * @param values 返回划分后的坐标
     * @param i      第一个数的坐标
     * @param j      最后一个数的坐标
     * @return
     */
    public int partition(int values[], int i, int j) {
        int temp = values[i];//划分元素
        while (i < j) {
            while (values[j] >= temp && i < j) j--;//从后往前找第一个大于划分元素的下标
            if (i < j) values[i++] = values[j];
            while (values[i] <= temp && i < j) i++;//从前往后找第一个小于划分元素的下标
            if (i < j) values[j--] = values[i];
        }
        values[i] = temp;
        return i;
    }

    /**
     * 堆排序
     *
     * @param values
     */
    public void heapSort(int[] values) {
        int n = values.length;

        //构建堆
        for (int i = n / 2; i >= 0; i--) {
            heapAdjust(values, i, n);
        }

        for (int i = n - 1; i > 0; i--) {
            values[0] = values[0] + values[i];
            values[i] = values[0] - values[i];
            values[0] = values[0] - values[i];
            heapAdjust(values, 0, i);
        }
    }

    /**
     * 调整堆
     *
     * @param values
     * @param index
     * @param length
     */
    private void heapAdjust(int[] values, int index, int length) {
        int childLeft;
        int temp = values[index];
        for (; index * 2 + 1 < length; index = childLeft) {
            childLeft = index * 2 + 1;
            if (childLeft != length - 1 && values[childLeft] < values[childLeft + 1]) {
                childLeft++;
            }
            if (temp > values[childLeft]) {
                break;
            } else {
                values[index] = values[childLeft];
                index = childLeft;
            }
        }
        values[index] = temp;
    }

    /**
     * 希尔排序
     *
     * @param values
     */
    public void shellSort(int[] values) {
        int n = values.length;
        int feet = n / 2;//增量
        int index;

        while (feet > 0) {
            for (int i = feet; i < n; i++) {
                index = i;
                while (index >= feet) {
                    if (values[index - feet] > values[index]) {
                        values[index - feet] = values[index - feet] + values[index];
                        values[index] = values[index - feet] - values[index];
                        values[index - feet] = values[index - feet] - values[index];
                        index = feet;
                    } else {
                        break;
                    }
                }
            }
            feet = feet / 2;
        }
    }

    /**
     * 归并排序
     *
     * @param values
     */
    public void mergeSort(int[] values) {
        merage(0, values.length - 1, values);
    }

    //划分数组
    private void merage(int left, int right, int[] values) {
        if (left < right) {
            int mid = (left + right) / 2;
            merage(left, mid, values);
            merage(mid + 1, right, values);
            mergeArray(left, right, mid, values);
        }
    }

    //合并数组
    private void mergeArray(int left, int right, int mid, int[] values) {
        int j = mid + 1, record = left;
        int k = 0;
        int[] temp = new int[values.length];

        while (left <= mid && j <= right) {
            if (values[left] <= values[j]) {
                temp[k++] = values[left++];
            } else {
                temp[k++] = values[j++];
            }
        }
        while (left <= mid) {
            temp[k++] = values[left++];
        }
        while (j <= right) {
            temp[k++] = values[j++];
        }
        for (int i = 0; i < k; i++) {
            values[record + i] = temp[i];
        }
    }

    /**
     * 计数排序
     *
     * @param values
     */
    public void countingSort(int[] values) {
        int min = values[0];
        int max = values[0];
        for (int i = 1; i < values.length; i++) {
            min = Math.min(values[i], min);
            max = Math.max(values[i], max);
        }
        //创建桶
        int[] bucket = new int[max - min + 1];
        for (int i = 0; i < values.length; i++) {
            bucket[values[i] - min]++;//数在该桶的数量
        }
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i]-- > 0) {
                values[index++] = i + min;
            }
        }
    }
}
