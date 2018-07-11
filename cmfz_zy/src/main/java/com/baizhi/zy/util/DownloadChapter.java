package com.baizhi.zy.util;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

public class DownloadChapter {
    public static void download(String name, String path, HttpSession session, HttpServletResponse response){
        String realPath = session.getServletContext().getRealPath("/cmfw_img");
        //byte[] bs = FileUtils.readFile
        //response.setHeader("content-type", "application/octet-stream");
        String realName = null;
        try {
            realName = new String(name.getBytes("utf-8"),"ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //response.setContentType("audio/mpeg");
        response.setHeader("Content-Disposition", "attachment;filename=" + realName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File(realPath + "/" + path)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
