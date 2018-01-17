package com.lux.netcracker.homework.homework.service.util.XLSParser;

import com.lux.netcracker.homework.homework.model.Author;
import com.lux.netcracker.homework.homework.model.Publisher;
import com.lux.netcracker.homework.homework.service.authorService.AuthorService;
import com.lux.netcracker.homework.homework.service.publisherService.PublisherService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class XLSParser {

    @Autowired
    PublisherService publisherService;

    @Autowired
    AuthorService authorService;

    private int publisherCell;
    private int authorCell;
    private int bookCell;

    private ArrayList<Publisher> publishers = new ArrayList<>();
    private ArrayList<Author> authors = new ArrayList<>();
    private ArrayList<String> books = new ArrayList<>();

    public void readFromExcel(String file) throws IOException {
        if (file.length() > 4) {
            String ext = file.substring(file.length() - 4);
            switch (ext) {
                case "xlsx":
                    readXLSX(file);
                    break;
                case ".xls":
                    readXLS(file);
                    break;
                default:
                    throw new IllegalArgumentException("Wrong type of file!");
            }
        }
    }

    private void readXLS(String file) throws IOException {
        HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(file));
        HSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);

        for (int i = myExcelSheet.getFirstRowNum(); i <= myExcelSheet.getLastRowNum(); i++) {
            HSSFRow row = myExcelSheet.getRow(i);

            for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
                if (row.getCell(j).getCellType() == HSSFCell.CELL_TYPE_STRING) {
                    checkCellValue(row, j);
                }
            }
        }

        for (int i = myExcelSheet.getFirstRowNum() + 1; i <= myExcelSheet.getLastRowNum(); i++) {
            HSSFRow row = myExcelSheet.getRow(i);
            fillArrays(row);
        }

        myExcelBook.close();
    }

    private void readXLSX(String file) throws IOException {
        XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(file));
        XSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);

        for (int i = myExcelSheet.getFirstRowNum(); i <= myExcelSheet.getLastRowNum(); i++) {
            XSSFRow row = myExcelSheet.getRow(i);

            for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
                if (row.getCell(j).getCellType() == XSSFCell.CELL_TYPE_STRING) {
                    checkCellValue(row, j);
                }
            }
        }

        for (int i = myExcelSheet.getFirstRowNum() + 1; i <= myExcelSheet.getLastRowNum(); i++) {
            XSSFRow row = myExcelSheet.getRow(i);
            fillArrays(row);
        }

        myExcelBook.close();
    }

    public ArrayList<Publisher> getPublishers() {
        return publishers;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public ArrayList<String> getBooks() {
        return books;
    }

    private void fillArrays(Row row) {
        if (row.getPhysicalNumberOfCells() == 3) {
            String bookName = row.getCell(bookCell).getStringCellValue().toLowerCase();
            String bookAuthor = row.getCell(authorCell).getStringCellValue().toLowerCase();
            String bookPublisher = row.getCell(publisherCell).getStringCellValue().toLowerCase();
            publishers.add(publisherService.createPublisher(bookPublisher));
            authors.add(authorService.createAuthor(bookAuthor));
            books.add(bookName);
        }
    }

    private void checkCellValue(Row row, int position) {
        if (row.getCell(position).getStringCellValue().equals("Издательство")) {
            publisherCell = position;
        } else if (row.getCell(position).getStringCellValue().equals("Автор")) {
            authorCell = position;
        } else if (row.getCell(position).getStringCellValue().equals("Книга")) {
            bookCell = position;
        }
        String name = row.getCell(position).getStringCellValue();
        System.out.println("name: " + name);
    }
}
