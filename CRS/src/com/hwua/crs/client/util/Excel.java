package com.hwua.crs.client.util;

import com.hwua.crs.client.entity.Car;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Excel {
    public static void outCar (String path,List<Car> carList) throws IOException {
        //创建一个excel文档对象
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建新的sheet对象（excel表单）
        HSSFSheet sheet = wb.createSheet("汽车信息");
        //创建第一行的内容，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1 = sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个）
        HSSFCell cell = row1.createCell(0);
        //设置单元格内容
        cell.setCellValue("汽车信息数据表");
        //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,10));

        //在sheet里创建第二行
        HSSFRow row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("汽车编号");
        row2.createCell(1).setCellValue("车牌号");
        row2.createCell(2).setCellValue("品牌编号");
        row2.createCell(3).setCellValue("汽车名称");
        row2.createCell(4).setCellValue("颜色");
        row2.createCell(5).setCellValue("类型编号");
        row2.createCell(6).setCellValue("备注");
        row2.createCell(7).setCellValue("总价");
        row2.createCell(8).setCellValue("租金(天)");
        row2.createCell(9).setCellValue("是否可租");
        row2.createCell(10).setCellValue("是否上架");
        int i = 1;
        for (Car car :carList) {
            i++;
            HSSFRow row=sheet.createRow(i);
            row.createCell(0).setCellValue(car.getId());
            row.createCell(1).setCellValue(car.getCarNumber());
            row.createCell(2).setCellValue(car.getBrandId());
            row.createCell(3).setCellValue(car.getModel());
            row.createCell(4).setCellValue(car.getColor());
            row.createCell(5).setCellValue(car.getCategoryId());
            row.createCell(6).setCellValue(car.getComments());
            row.createCell(7).setCellValue(car.getPrice());
            row.createCell(8).setCellValue(car.getRent());
            row.createCell(9).setCellValue(car.getStatus()==0?"可租":"不可租");
            row.createCell(10).setCellValue(car.getUseable()==0?"上架":"下架");
        }

        //输出Excel文件
        try {
            wb.write(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                wb.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static List<Car> getWork (String path) throws IOException {
        List<Car> carList = new ArrayList<>();
        FileInputStream fileIn = new FileInputStream(path);
        Workbook wb = new HSSFWorkbook(fileIn);
        Sheet sheet = wb.getSheet("汽车信息");

        for (Row r: sheet) {
            if(r.getRowNum()<=1){
                continue;
            }
            Car car = new Car();
            car.setId(Math.round(r.getCell(0).getNumericCellValue()));
            car.setCarNumber(r.getCell(1).getStringCellValue());
            car.setBrandId(Math.round(r.getCell(2).getNumericCellValue()));
            car.setModel(r.getCell(3).getStringCellValue());
            car.setColor(r.getCell(4).getStringCellValue());
            car.setCategoryId(Math.round(r.getCell(5).getNumericCellValue()));
            car.setComments(r.getCell(6).getStringCellValue());
            car.setPrice(r.getCell(7).getNumericCellValue());
            car.setRent(r.getCell(8).getNumericCellValue());
            car.setStatus("可租".equals(r.getCell(9).getStringCellValue())?0:1);
            car.setUseable("上架".equals(r.getCell(10).getStringCellValue())?0:1);
            carList.add(car);
        }
        fileIn.close();
        wb.close();
        return carList;
    }
}
