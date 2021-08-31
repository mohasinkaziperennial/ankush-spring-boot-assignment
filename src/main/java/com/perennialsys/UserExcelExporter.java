package com.perennialsys;

import com.perennialsys.entity.Book;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * This class will track about exportin data to excel file
 *
 * @author ankush katkar
 */
public class UserExcelExporter {
    private final XSSFWorkbook workbook;
    private final List<Book> listUsers;
    private XSSFSheet sheet;

    public UserExcelExporter(List<Book> listUsers) {
        this.listUsers = listUsers;
        workbook = new XSSFWorkbook();
    }


    private void writeHeaderLine() {
        sheet = workbook.createSheet("Users");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Book isbn", style);
        createCell(row, 1, "Book Name", style);
        createCell(row, 2, "Authors", style);
        createCell(row, 3, "HoldRequest", style);
        createCell(row, 3, "HoldRequest", style);

    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (Book book : listUsers) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            //  createCell(row, columnCount++, book.getIsbn(), style);
            createCell(row, columnCount++, book.getName(), style);
            //  createCell(row, columnCount++, book.getAuthors(), style);
            // createCell(row, columnCount++, book.getHoldRequests(), style);
            // createCell(row, columnCount++, book.getHoldRequests(), style);


        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.close();

    }

}
