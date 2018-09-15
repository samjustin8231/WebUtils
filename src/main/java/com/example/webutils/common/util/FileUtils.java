package com.example.webutils.common.util;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 类的实现描述：FileUtils
 *
 * @author sunyajun 2018/9/15 20:36
 */
public class FileUtils {


    private static final String DEFAULT_CHARSET = "UTF-8";

    public static List<String> readFile2List(String filename) throws IOException {
        return readFile2List(filename, DEFAULT_CHARSET);
    }

    public static List<String> readFile2List(String filename, String charset)
            throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filename);
        return readFile2List(fileInputStream, charset);
    }

    public static List<String> readFile2List(File file) throws IOException {
        return readFile2List(file, DEFAULT_CHARSET);
    }

    public static List<String> readFile2List(File file, String charset)
            throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        return readFile2List(fileInputStream, charset);
    }

    public static List<String> readFile2List(InputStream fileInputStream)
            throws IOException {
        return readFile2List(fileInputStream, DEFAULT_CHARSET);
    }

    public static List<String> readFile2List(InputStream inputStream, String charset)
            throws IOException {
        List<String> list = new ArrayList<String>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(inputStream, charset));

            String s = null;
            while ((s = br.readLine()) != null) {
                list.add(s);
            }
        } finally {
            inputStream.close();
        }

        return list;
    }
}
