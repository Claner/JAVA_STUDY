package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
            "/*", "*/", ":", "(", ")", "\\.", "{", "}","\\n"};

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

    private char[] appendChar(char a,char b){
        char[] chars = new char[2];
        chars[0] = a;
        chars[1] = b;
        return chars;
    }

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
                            println(String.valueOf(appendChar(ch,string.charAt(++i))));
                        } else {
                            println(String.valueOf(ch));
                        }
                        break;
                    case '>':
                        if (string.charAt(i + 1) == '=') {
                            println(String.valueOf(appendChar(ch,string.charAt(++i))));
                        } else {
                            println(String.valueOf(ch));
                        }
                        break;
                    case ':':
                        println(String.valueOf(ch));
                        break;
                    case '*':
                        if (string.charAt(i + 1) == '=') {
                            println(String.valueOf(appendChar(ch,string.charAt(++i))));
                        } else {
                            println(String.valueOf(ch));
                        }
                        break;
                    case '/':
                        if (string.charAt(i + 1) == '=') {
                            println(String.valueOf(appendChar(ch,string.charAt(++i))));
                        } else {
                            println(String.valueOf(ch));
                        }
                        break;
                    case '+':
                        if (string.charAt(i + 1) == '=') {
                            println(String.valueOf(appendChar(ch,string.charAt(++i))));
                        } else {
                            println(String.valueOf(ch));
                        }
                        break;
                    case '-':
                        if (string.charAt(i + 1) == '=') {
                            println(String.valueOf(appendChar(ch,string.charAt(++i))));
                        } else {
                            println(String.valueOf(ch));
                        }
                        break;
                    case '=':
                        if (string.charAt(i + 1) == '=') {
                            println(String.valueOf(appendChar(ch,string.charAt(++i))));
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
                            println(String.valueOf(appendChar(ch,string.charAt(++i))));
                        } else {
                            println(String.valueOf(ch));
                        }
                        break;
                    case '&':
                        if (string.charAt(i + 1) == '&') {
                            println(String.valueOf(appendChar(ch,string.charAt(++i))));
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

    public static boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    public final int getBagMaxValue(Good[] goods, int MAX_WEIGHT) {
        int bags[][] = calMaxValue(goods, MAX_WEIGHT);
        return bags[goods.length][MAX_WEIGHT];
    }

    /**
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

    public static final Util getInstance() {
        return Holder.instance;
    }

    static final class Holder {
        private static final Util instance = new Util();
    }
}
