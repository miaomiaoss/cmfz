package com.baizhi.zy.controller;

import com.baizhi.zy.entity.Chapter;
import com.baizhi.zy.service.ChapterService;
import com.baizhi.zy.util.DownloadChapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

@Controller
public class ChapterController {

    @Resource(name = "chapterService")
    private ChapterService service;

    //添加章节
    @RequestMapping("/addchapter")
    @ResponseBody
    public void insertChapter(MultipartFile mpFile, HttpSession session, Chapter chapter){

        service.addChapter(mpFile,session,chapter);
}

    //下载章节
    @RequestMapping("/downloadChapter")
    public void downloadChapter(String name,String path, HttpSession session, HttpServletResponse response){
        //System.out.println("success");
        //service.downloadChapter(path,session,response);
        DownloadChapter.download(name,path,session,response);
    }
}
