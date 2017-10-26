package Algorithm;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by Clanner on 2017/10/13.
 */
public class Util {


    /**
     * 索引表示种别码
     * ""表示标识符
     * number表示实数
     */

    private List<String> TAG = new ArrayList<String>();

    public static final String[] P = {"char", "double", "enum", "float", "int", "long", "short", "signed", "union", "unsigned",
            "void", "for", "do", "while", "break", "continue", "if", "else", "goto", "switch", "case", "default", "return",
            "auto", "extern", "register", "static", "const", "sizeof", "typedef", "volatile", "!", "&", "|", "&&",
            "||", "+", "-", "*", "/", "<", ">", "<=", ">=", "==", "", "number", "decimal", "=", ";", ",", "'",
            "/*", "*/", ":", "(", ")", "\\.", "{", "}", "\\n"};

    private Util() {
        Collections.addAll(TAG, P);
    }

    private void println(String str) {
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        if (TAG.contains(str)) {//关键字或运算符或界符
            builder.append(TAG.indexOf(str));
        } else if (isNumber(str)) {//实数
            builder.append(TAG.indexOf("number"));
        } else if (str.contains(".")) {//小数
            builder.append(TAG.indexOf("decimal"));
        } else {//标识符
            builder.append(TAG.indexOf(""));
        }
        builder.append(",");
        builder.append("\"");
        builder.append(str);
        builder.append("\"");
        builder.append(")");
        System.out.println(builder.toString());
    }

    private char[] appendChar(char a, char b) {
        char[] chars = new char[2];
        chars[0] = a;
        chars[1] = b;
        return chars;
    }

    /**
     * 词法分析
     *
     * @param string
     */
    public final void lexicalAnalysis(String string) {
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {//可能是关键字或标识符
                StringBuilder charBuilder = new StringBuilder();
                while ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                    charBuilder.append(ch);
                    ch = string.charAt(++i);
                }
                println(charBuilder.toString());
                i--;
            } else if (ch >= '0' && ch <= '9') {//数字或小数
                StringBuilder numberBuilder = new StringBuilder();
                while ((ch >= '0' && ch <= '9') || ch == '.') {
                    numberBuilder.append(ch);
                    ch = string.charAt(++i);
                }
                println(numberBuilder.toString());
                i--;
            } else {//其他字符
                switch (ch) {
                    case '<':
                        if (string.charAt(i + 1) == '=') {
                            println(String.valueOf(appendChar(ch, string.charAt(++i))));
                        } else {
                            println(String.valueOf(ch));
                        }
                        break;
                    case '>':
                        if (string.charAt(i + 1) == '=') {
                            println(String.valueOf(appendChar(ch, string.charAt(++i))));
                        } else {
                            println(String.valueOf(ch));
                        }
                        break;
                    case ':':
                        println(String.valueOf(ch));
                        break;
                    case '*':
                        if (string.charAt(i + 1) == '=') {
                            println(String.valueOf(appendChar(ch, string.charAt(++i))));
                        } else {
                            println(String.valueOf(ch));
                        }
                        break;
                    case '/':
                        if (string.charAt(i + 1) == '=') {
                            println(String.valueOf(appendChar(ch, string.charAt(++i))));
                        } else {
                            println(String.valueOf(ch));
                        }
                        break;
                    case '+':
                        if (string.charAt(i + 1) == '=') {
                            println(String.valueOf(appendChar(ch, string.charAt(++i))));
                        } else {
                            println(String.valueOf(ch));
                        }
                        break;
                    case '-':
                        if (string.charAt(i + 1) == '=') {
                            println(String.valueOf(appendChar(ch, string.charAt(++i))));
                        } else {
                            println(String.valueOf(ch));
                        }
                        break;
                    case '=':
                        if (string.charAt(i + 1) == '=') {
                            println(String.valueOf(appendChar(ch, string.charAt(++i))));
                        } else {
                            println(String.valueOf(ch));
                        }
                        break;
                    case ';':
                        println(String.valueOf(ch));
                        break;
                    case '(':
                        println(String.valueOf(ch));
                        break;
                    case ')':
                        println(String.valueOf(ch));
                        break;
                    case '#':
                        println(String.valueOf(ch));
                        break;
                    case '{':
                        println(String.valueOf(ch));
                        break;
                    case '}':
                        println(String.valueOf(ch));
                        break;
                    case '.':
                        println(String.valueOf(ch));
                        break;
                    case '|':
                        if (string.charAt(i + 1) == '|') {
                            println(String.valueOf(appendChar(ch, string.charAt(++i))));
                        } else {
                            println(String.valueOf(ch));
                        }
                        break;
                    case '&':
                        if (string.charAt(i + 1) == '&') {
                            println(String.valueOf(appendChar(ch, string.charAt(++i))));
                        } else {
                            println(String.valueOf(ch));
                        }
                        break;
                    case '\n':
                        println("\\n");
                        break;
                    default:
                }
            }
        }
    }

    /**
     * 判断字符串是否是数字
     *
     * @param str
     * @return
     */
    public boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    /**
     * 获取背包最大价值
     *
     * @param goods
     * @param MAX_WEIGHT
     * @return
     */
    public final int getBagMaxValue(Good[] goods, int MAX_WEIGHT) {
        int bags[][] = calMaxValue(goods, MAX_WEIGHT);
        return bags[goods.length][MAX_WEIGHT];
    }

    /**
     * 计算背包最大价值
     *
     * @param goods      物品列表
     * @param MAX_WEIGHT 背包最大容量
     * @return 返回最大价值
     */
    private final int[][] calMaxValue(Good[] goods, int MAX_WEIGHT) {

        /**
         * bags[i][j]
         * i表示当前背包放入i个物品
         * j表示当前背包容量
         */
        int ROW = goods.length + 1;
        int WEIGHT = MAX_WEIGHT + 1;
        int bags[][] = new int[ROW][WEIGHT];

        //初始化背包,不放任何物品时背包价值为0
        for (int w = 1; w < WEIGHT; w++)
            bags[0][w] = 0;

        for (int i = 1; i < ROW; i++) {
            bags[i][0] = 0;//容量为0是价值为0
            for (int w = 1; w < WEIGHT; w++) {
                if (goods[i - 1].getWeight() <= w) {//如果当前物品容量小于背包容量，则将物品放进背包

                    //如果当前物品价值加上未添加该物品的背包价值大于相同容量但未添加该物品的价值
                    if ((goods[i - 1].getValue() + bags[i - 1][w - goods[i - 1].getWeight()]) > bags[i - 1][w]) {
                        bags[i][w] = goods[i - 1].getValue() + bags[i - 1][w - goods[i - 1].getWeight()];
                    } else {
                        bags[i][w] = bags[i - 1][w];
                    }
                } else {//如果当前物品容量大于背包容量，则当前背包价值等于上一个相同容量的背包价值
                    bags[i][w] = bags[i - 1][w];
                }
            }
        }

        return bags;
    }

    /**
     * 小易准备去魔法王国采购魔法神器,购买魔法神器需要使用魔法币,但是小易现在一枚魔法币都没有,但是小易有两台魔法机器可以通过投入x(x可以为0)个魔法币产生更多的魔法币。
     * 魔法机器1:如果投入x个魔法币,魔法机器会将其变为2x+1个魔法币
     * 魔法机器2:如果投入x个魔法币,魔法机器会将其变为2x+2个魔法币
     * 小易采购魔法神器总共需要n个魔法币,所以小易只能通过两台魔法机器产生恰好n个魔法币,小易需要你帮他设计一个投入方案使他最后恰好拥有n个魔法币。
     *
     * @param n
     */
    public void coin(int n) {
        List<Integer> list = new ArrayList<Integer>();

        int result = n;

        while (result != 0) {

            System.out.println("result:" + result);

            if (result % 2 == 0) {
                result = (result - 2) / 2;
                list.add(2);
            } else {
                result = (result - 1) / 2;
                list.add(1);
            }
        }

        for (int i = list.size(); i > 0; i--) {
            System.out.print(list.get(i - 1));
        }
    }

    /**
     * 计算一个数与它相反数的和
     *
     * @param n
     * @return
     */
    public int calSum(int n) {
        int sum = 0;
        int temp = n;

        while (temp != 0) {
            sum = sum * 10 + (temp % 10);
            temp = temp / 10;
        }
        return n + sum;
    }

    /**
     * 计算字符串平均长度
     *
     * @param string
     */
    public void calStr(String string) {
        char temp = string.charAt(0);
        int j = 1;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == temp) {
                j++;
                if (i + 1 == string.length()) list.add(j);
            } else {
                temp = c;
                list.add(j);
                j = 1;
                if (i + 1 == string.length()) list.add(j);
            }
        }

        float sum = 0;
        for (int i : list) {
            sum += i;
        }
        sum = sum / list.size();
        System.out.println(new DecimalFormat("##0.00").format(sum));
    }

    /**
     * 动态规划问题
     * 两个cpu，一秒处理一个kb的任务
     *
     * @param times 任务的大小
     * @return
     */
    public int cpu(int[] times) {
        int sum = 0;
        for (int time : times)
            sum += time >> 10;

        int[] dp = new int[sum / 2 + 1];
        for (int i = 0; i < times.length; i++) {
            for (int j = sum / 2; j >= times[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - times[i]] + times[i]);
            }
        }
        System.out.println(Math.max(dp[sum / 2], sum - dp[sum / 2]) << 10);
        return Math.max(dp[sum / 2], sum - dp[sum / 2]) << 10;
    }

    /**
     * 字符串反转
     *
     * @param str
     * @return
     */
    public String rotation(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = str.length() - 1; i > -1; i--) builder.append(str.charAt(i));
        return builder.toString();
    }

    /**
     * 判断两个字符串是否是旋转词
     *
     * @return
     */
    public boolean isRotationStr(String A, String B) {
        return (A+A).contains(B);
    }

    /**
     * 反转句子
     *
     * @return
     */
    public String rotationSentence(String sentence) {
        StringBuilder builder = new StringBuilder();
        String[] words = rotation(sentence).split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = rotation(words[i]);
            builder.append(words[i]);
            builder.append(" ");
        }
        return builder.toString().trim();
    }

    /**
     * 交换两个子串
     *
     * @param str
     * @param position
     * @return
     */
    public String rotationPosition(String str, int position) {
        return rotation(rotation(str.substring(0, position + 1)) + rotation(str.substring(position + 1, str.length())));
    }

    public static final Util getInstance() {
        return Holder.instance;
    }

    static final class Holder {
        private static final Util instance = new Util();
    }
}
