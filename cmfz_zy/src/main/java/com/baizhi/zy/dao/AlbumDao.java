package com.baizhi.zy.dao;

import com.baizhi.zy.entity.Album;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumDao {

    //查所有专辑及其章节
    List<Album> queryAllAlbum(@Param("page") Integer page, @Param("rows") Integer rows);
    //查数据总数
    Integer countAllbum();

    //添加专辑
    void insertAlbum(Album album);
}
