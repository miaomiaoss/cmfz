package com.baizhi.zy.service;

import com.baizhi.zy.dao.ChapterDao;
import com.baizhi.zy.entity.Chapter;
import com.baizhi.zy.util.GetFileSize;
import com.baizhi.zy.util.GetTimes;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.UUID;

@Service("chapterService")
public class ChapterServiceImpl implements ChapterService {

    @Resource(name = "chapterDao")
    private ChapterDao dao;

    @Override
    public void addChapter(MultipartFile mpFile, HttpSession session,Chapter chapter) {
        String realPath = session.getServletContext().getRealPath("cmfw_img");

        File file = new File(realPath);
        if(!file.exists()){
            file.mkdir();
        }
        String uuid = UUID.randomUUID().toString();
        String fileName = mpFile.getOriginalFilename();
        String uuName = uuid + fileName;
        File tranFile = new File(realPath+"/"+ uuName);
        try {
            mpFile.transferTo(tranFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        chapter.setPath(uuName);

        String size = GetFileSize.getSize(tranFile);//文件大小
        String length = GetTimes.getTimes(tranFile);//文件时长

        chapter.setName(fileName);
        chapter.setId(uuid);
        chapter.setSize(size);
        chapter.setLength(length);
        dao.addChapter(chapter);
    }

    @Override
    public void downloadChapter(String path, HttpSession session, HttpServletResponse response) {

    }
}
