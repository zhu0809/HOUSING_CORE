package com.bs.housing.utils.common;

import org.apache.poi.hssf.usermodel.*;
import org.springframework.stereotype.Service;

import java.io.OutputStream;

/**
 * <p> @类描述：	                </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2019/7/3 16:43</p>
 */
@Service
public class POIUtils {
    public OutputStream out() throws Exception {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("01");
        HSSFSheet sheet2 = wb.createSheet("02");
        HSSFSheet sheet3 = wb.createSheet("03");
        HSSFRow row = sheet.createRow(0);
        row.setHeightInPoints(120);

        HSSFCell cell = row.createCell(0);

        cell.setCellValue("nihaoidfodisjiojfoisj");
        sheet.setColumnWidth((short) 0, (short) 250);
        HSSFCellStyle cs = cell.getCellStyle();

        HSSFFont font = wb.createFont();
        font.setFontName("黑体");
        font.setColor((short) 14);
        cs.setFont(font);
        return null;
    }

}
