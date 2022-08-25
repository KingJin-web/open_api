package com.king.open_api.util;


import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.reader.SheetReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author: King
 * @project: open_api
 * @date: 2022年08月23日 15:02
 * @description:
 */
public class ExcelUtils {

    public static String getString(InputStream inputStream, int sheetIndex, int rowIndex, int colIndex) {
        return "";
    }

    /**
     * 读取 Excel 某一列的数据
     *
     * @param inputStream Excel 文件输入流
     * @param colIndex    列索引
     * @return
     */
    public static List<Object> getOneColData(InputStream inputStream, int colIndex) {
        List<Object> s = ExcelUtil.getReader(inputStream).readColumn(colIndex, 1);
        System.out.println(s);
        return s;
    }

    public static List<String> getOneColData(InputStream inputStream, String sheetNames) {
      ExcelUtil.getReader(inputStream).readAll().forEach(System.out::println);
      return null;
    }

    //获取行数列数
//    public static int getRowCol(InputStream inputStream) {
//      SheetReader reader = ExcelUtil.getReader(inputStream).readAll().size();
//      return reader.getRowCount();
//    }

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Files.newInputStream(Paths.get("C:\\Users\\12613\\Downloads\\非小酋抽卡记录176068685_2022-08-14.xlsx"));

        List<String> s = getOneColData(inputStream, "");


        System.out.println(s);
    }
}