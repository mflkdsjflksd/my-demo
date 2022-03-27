package thread;

import leetcode.数据结构.TreeNode;

/**
 * @Author: xs
 * @Date: 2022/3/19 20:53
 * @describe: ThreadLocal源码测试
 * 结论：当threadLocal这个变量指向空的时候，由于Thread类中的hashmap它的key(下面成TMap)，存放的是弱引用，当一个强引用消失的时候
 * 再次垃圾回收当前区域块(新老年代),它就会被回收掉，但是我们不知道它何时会执行清零TMap中的null key，但value是有值的，所以还是需要手动删除value值；
 */
public class ThreadLocalTest {
    static ThreadLocal<Test> threadLocal = new ThreadLocal<>();
    static ThreadLocal<TreeNode> threadLocal2 = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
        }, "aaa").start();
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            threadLocal.set(new Test("zhangsna"));
            threadLocal2.set(new TreeNode(1));
            threadLocal.remove();
            threadLocal = null;

            System.gc();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadLocal2.set(new TreeNode(1));
            System.out.println();
        }, "bbb");

        thread.start();
    }
}


