package FarExecuter;

import java.lang.reflect.Method;

/**
 * Created by Clanner on 2017/10/15.
 * JavaClass执行工具
 */
public class JavaClassExecuter {
    public static String execute(byte[] classByte) {
        HackSystem.clearBuffer();
        ClassModifier cm = new ClassModifier(classByte);
        byte[] modifyBytes = cm.modifyUTF8Constant("java/lang/System", "FarExecuter/HackSystem");
        HotSwapClassLoader loader = new HotSwapClassLoader();
        Class clazz = loader.loadByte(modifyBytes);
        try {
            Method method = clazz.getMethod("main", new Class[]{String[].class});
            method.invoke(null, new String[]{null});
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return HackSystem.getBufferString();
    }
}
