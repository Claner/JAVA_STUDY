package javaStudy.connectionPoolDemo;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * Created by Clanner on 2018/2/6.
 * 连接池
 */
public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<>();

    /**
     * @param initialSize 连接池大小
     */
    public ConnectionPool(int initialSize) {
        if (initialSize > 0) {
            for (int i = 0; i < initialSize; i++) {
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    //释放连接
    public void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    /**
     *
     * @param mills 等待超时时间
     * @return 从连接池中返回连接实例
     * @throws InterruptedException
     */
    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool) {
            //完全超时
            if (mills <= 0) {
                while (pool.isEmpty()) {//连接池为空则等待
                    pool.wait();
                }
                return pool.removeFirst();//从连接队列中返回
            } else {
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                while (pool.isEmpty() && remaining > 0) {//连接池为空则等待
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection result = null;
                if (!pool.isEmpty()) {
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }
}
