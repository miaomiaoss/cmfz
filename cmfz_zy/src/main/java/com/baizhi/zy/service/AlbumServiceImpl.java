package com.baizhi.zy.service;

import com.baizhi.zy.Dto.Dto;
import com.baizhi.zy.dao.AlbumDao;
import com.baizhi.zy.entity.Album;
import com.baizhi.zy.entity.Banner;
import com.baizhi.zy.util.GetFileSize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service("albumService")
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Resource(name = "albumDao")
    private AlbumDao dao;

    //查所有专辑
    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Dto queryAllAlbum(Integer page, Integer rows) {

        List<Album> list = dao.queryAllAlbum((page-1)*rows, rows);
        Integer count = dao.countAllbum();
        return new Dto(count,list);
    }

    //添加专辑
    @Override
    public void insertAlbum(MultipartFile pictureFile, HttpSession session, Album album) {
        String realPath = session.getServletContext().getRealPath("cmfw_img");

        File file = new File(realPath);
        if(!file.exists()){
            file.mkdir();
        }
        String uuid = UUID.randomUUID().toString();
        String fileName = pictureFile.getOriginalFilename();
        String uuName = uuid + fileName;
        File tranFile = new File(realPath+"/"+ uuName);
        try {
            pictureFile.transferTo(tranFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        album.setCoverpicture(uuName);

        String size = GetFileSize.getSize(tranFile);

        String id = UUID.randomUUID().toString();
        album.setId(id);

        dao.insertAlbum(album);
    }
}
