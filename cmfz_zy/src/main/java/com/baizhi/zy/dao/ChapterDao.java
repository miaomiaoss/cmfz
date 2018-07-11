package com.baizhi.zy.dao;

import com.baizhi.zy.entity.Chapter;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterDao {

    void addChapter(Chapter chapter);
}
