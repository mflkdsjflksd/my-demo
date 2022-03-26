package bloomFilter;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 * @Author ZhangLe
 * @Date 2020/10/30 15:58
 */
public class Main {
    static String host = "https://wplib.haut.edu.cn/seatbook/api/seatbook/addbooking?channel=1003&openid=o-WiZ5fmmrCbpB83y87Gl_ypMRdU";
    static String seatidStr = "&seatid=";
    static String startTimeHead = "&starttime=";
    static String startTimeTail = "%2007%3A30%3A00";
    static String endTimeHead = "&endtime=";
    static String endTimeTail = "%2022%3A00%3A00";

    public static void main(String[] args) throws InterruptedException, IOException {
        TimeUnit.SECONDS.sleep(40);
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-M-dd");
        int[] arr = {1533, 1555, 1510, 1532, 1543, 1554, 1565, 1511, 1522};
        FileWriter fileWriter = new FileWriter("/root/log.txt", true);
        for (int i = 0; i < arr.length; i++) {
            String url = host + seatidStr + arr[i] + startTimeHead + dateFormat.format(date) + startTimeTail + endTimeHead +
                    dateFormat.format(date) + endTimeTail;
            String res = sendGet1(url);
            if (res.contains("成功") || res.contains("已有其他预约，不可重复预约")) {
                String messageSuccess = "请求成功信息为：" + res + "请求时间为：" + LocalDateTime.now() + "\n";
                fileWriter.write(messageSuccess);
                System.out.println(messageSuccess);
                fileWriter.close();
                return;
            } else {
                String messageError = "请求失败信息为：" + res + "请求时间为：" + LocalDateTime.now() + "\n";
                fileWriter.write(messageError);
                System.out.println(messageError);
                TimeUnit.SECONDS.sleep(5);
            }
        }
        fileWriter.close();

    }

    public static String sendGet1(String url) {
        String result = "";
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            // 建立实际的连接
            connection.setRequestMethod("GET");
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}

