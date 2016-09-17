import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by 94839 on 2016/9/17.
 */
public class ThirdThread {
    public static void main(String[] args) {
//      创建Callable对象
        ThirdThread rt=new ThirdThread();
//      先使用Lambda表达式创建Callable<Integer>对象
//      使用FutureTask来包装Callable对象
        FutureTask<Integer> task=new FutureTask<Integer>((Callable<Integer>)()->{
            int i=0;
            for (; i < 100; i++) {
                System.out.println(Thread.currentThread().getName()
                    +" 的循环变量i的值："+i);
            }
//          call()方法可以有返回值，声明抛出异常
            return i;
        });
        for (int i=0;i< 100;i++)
        {
            System.out.println(Thread.currentThread().getName()
                    +" 的循环变量i的值："+i);
//          i=20创建子线程，和main线程交替执行
            if (i==20)
            {
//              实质还是以Callable对象来创建并启动线程的
                new Thread(task,"有返回值的线程").start();
            }
        }
        try {
//            使用FutureTask对象的get()方法来获得子线程执结束后的返回值
            System.out.println("子线程的返回值："+ task.get());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
