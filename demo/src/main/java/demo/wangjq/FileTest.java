package demo.wangjq;

import java.io.*;

/**
 * @author:wangjq
 * @Date: 2019/9/6 09:42
 */
public class FileTest {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println(System.getProperty("user.dir"));
        //URL base = FileTest.class.getResource("");

        //ClassLoader.getSystemClassLoader();

//        System.out.println(base);
//
//        File file = new File(base.getFile(), "/demo/wangjq/myTest.txt");
//
//        System.out.println(ClassLoader.getSystemResource(""));
//
//        InputStream inputStream = new FileInputStream(file);
//        System.out.println(ClassLoader.getSystemResource("/"));
//
//        System.out.println(file.getPath());

        String path="C:\\Users\\jinqwang\\Desktop\\Sql for user and project.sql";
        File file = new File(path);
        System.out.println(textToString(file));

    }


    public static String textToString(File file) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gb2312"));// 构造一个BufferedReader类来读取文件
            String str = null;
            while ((str = br.readLine()) != null) {// 使用readLine方法，一次读一行
                result.append(System.lineSeparator() + str);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    /**
     * 解析普通文本文件  流式文件 如txt
     *
     * @param path
     * @return
     */
    @SuppressWarnings("unused")
    public static String readTxt(String path) {
        StringBuilder content = new StringBuilder("");
        try {
            String code = "gb2312";
            File file = new File(path);
            InputStream is = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(is, code);
            BufferedReader br = new BufferedReader(isr);
            String str = "";
            while (null != (str = br.readLine())) {
                content.append(str);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("读取文件:" + path + "失败!");
        }
        return content.toString();
    }

}
