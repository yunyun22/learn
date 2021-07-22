package demo.wangjq.http;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wang, jinqiao
 * @title: HttpClientTest
 * @date 29/06/2021
 */
public class HttpClientTest {


    private static final CloseableHttpClient HTTP_CLIENT;

    static {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(200);
        cm.setDefaultMaxPerRoute(20);
        cm.setDefaultMaxPerRoute(50);
        HTTP_CLIENT = HttpClients.custom().setConnectionManager(cm).build();
    }

    public static String get(String url) {
        CloseableHttpResponse response = null;
        BufferedReader in;
        String result = "";
        try {
            HttpGet httpGet = new HttpGet(url);
            response = HTTP_CLIENT.execute(httpGet);

            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer sb = new StringBuffer("");
            String line = "";
            String NL = System.getProperty("line.separator");
            while ((line = in.readLine()) != null) {
                sb.append(line + NL);
            }
            in.close();
            result = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != response) response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(1000);
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(100,100,1, TimeUnit.SECONDS,blockingQueue);
        for (int i = 0; i < 1000; i++) {
            threadPoolExecutor.submit(()->{
                String s = get("http://localhost:8881/admin/");
                System.out.println(s);
            });
        }
        System.out.println("加载任务完成");
    }
}
