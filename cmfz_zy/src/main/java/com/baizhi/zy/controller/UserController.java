package com.baizhi.zy.controller;

import com.baizhi.zy.Dto.Dto;
import com.baizhi.zy.Dto.UserDto;
import com.baizhi.zy.entity.User;
import com.baizhi.zy.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Resource(name = "userService")
    private UserService service;

    //查所有user
    @RequestMapping("/queryAllUser")
    public Dto queryAllUser(Integer page, Integer rows){
        return service.queryAllUser(page,rows);
    }

    //自定义导入user
    @RequestMapping("importUser")
    public void importUser(MultipartFile file, HttpSession session){


    }

    //自定义导出user
    @RequestMapping("/exportUser")
    public void exportSomeUser(String text, String values){
        String[] id = text.split(",");//标题
        String[] value = values.split(",");//字段名
        //创建Excel工作簿对象
        Workbook workbook = new HSSFWorkbook();
        //创建工作表
        Sheet sheet = workbook.createSheet("用户信息");
        //创建标题行
        Row row = sheet.createRow(0);
        //创建单元格对象
        Cell cell = null;
        for (int i = 0; i<id.length; i++){
            cell = row.createCell(i);
            cell.setCellValue(id[i]);
        }

        Dto dto = service.queryAllUser(1,0);
        List users = dto.getRows();
        for (int i = 0; i < users.size(); i++) {
            Class<?> aClass = users.get(i).getClass();
            Row row1 = sheet.createRow(i + 1);
            for (int j = 0; j < value.length; j++) {
                String methodName = "get" + value[j].substring(0, 1).toUpperCase() + value[j].substring(1);
                Object invoke = null;
                try {
                    invoke = aClass.getDeclaredMethod(methodName, null).invoke(users.get(i));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(invoke instanceof Date){
                    DataFormat dataFormat = workbook.createDataFormat();
                    short format = dataFormat.getFormat("yyyy年mm月dd天");
                    CellStyle cellStyle = workbook.createCellStyle();
                    cellStyle.setDataFormat(format);
                    Cell row1Cell = row1.createCell(j);
                    row1Cell.setCellStyle(cellStyle);
                    row1Cell.setCellValue((Date)invoke);
                }else{
                    row1.createCell(j).setCellValue(String.valueOf(invoke));
                }

            }

        }
        try {
            workbook.write(new FileOutputStream(new File("d:/test.xls")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //查询用户创建信息
    @RequestMapping("/countUser")
    public UserDto countUser(){
        return service.countUser();
    }
}
