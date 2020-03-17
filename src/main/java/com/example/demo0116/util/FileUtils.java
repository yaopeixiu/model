package com.example.demo0116.util;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUtils {
    public static Map<String, String> chatMap = new HashMap<>();
    public static String root_path = "/opt/chat_record";

    public static boolean writeContent(String c, String filename) {
        File f = new File(root_path);
        if (!f.exists()) {
            f.mkdirs();
        }
        try {
            FileOutputStream fos = new FileOutputStream(root_path + File.separator + filename, true);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(c + "\n");

            bw.close();
            osw.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 从文件读取内容
     *
     * @param filename
     * @return
     */
    public static List<String> readText(String filename) {
        List<String> resultList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(root_path + File.separator + filename);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                resultList.add(line);
            }
            br.close();
            isr.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public long getTextLines(String filename) {
        List<String> resultList = new ArrayList<>();
        RandomAccessFile rf = null;
        long len = 0;
        try {
            rf = new RandomAccessFile(root_path + File.separator + filename, "r");
            len = rf.length();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                rf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return len;
        }
    }

    public static List<String> readFromEnd(String filename) {
        List<String> resultList = new ArrayList<>();
        RandomAccessFile rf = null;
        try {
            rf = new RandomAccessFile(root_path + File.separator + filename, "r");
            long len = rf.length();
            long start = rf.getFilePointer();
            long nextend = start + len - 1;
            String line;
            rf.seek(nextend);
            int c = -1;
            while (nextend > start) {
                c = rf.read();
                if (c == '\n' || c == '\r') {
                    line = rf.readLine();
                    if (line == null) {//处理文件末尾是空行这种情况
                        nextend--;
                        rf.seek(nextend);
                        continue;
                    }
                    resultList.add(new String(line.getBytes("ISO-8859-1"), "UTF-8"));
                    nextend--;
                }
                nextend--;
                rf.seek(nextend);
                if (nextend == 0) {//当文件指针退至文件开始处，输出第一行
                    resultList.add(new String(rf.readLine().getBytes("ISO-8859-1"), "UTF-8"));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                rf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return resultList;
        }
    }

    public static String readEndLine(String filename) {
        String result = "";
        RandomAccessFile raf = null;
        File file = new File(root_path + File.separator + filename);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        try {
            raf = new RandomAccessFile(root_path + File.separator + filename, "r");
            long len = raf.length();
            if (len != 0L) {
                long pos = len - 1;
                while (pos > 0) {
                    pos--;
                    raf.seek(pos);
                    if (raf.readByte() == '\n') {
                        result = new String(raf.readLine().getBytes("ISO-8859-1"), "UTF-8");
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }
    }

    public static boolean deleteFile(String fileName) {
        File file = new File(root_path + File.separator + fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
