package com.baizhi.zy.service;

import com.baizhi.zy.entity.Chapter;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface ChapterService {

    void addChapter(MultipartFile pictureFile, HttpSession session, Chapter chapter);

    void downloadChapter(String name, HttpSession session, HttpServletResponse response);
}
