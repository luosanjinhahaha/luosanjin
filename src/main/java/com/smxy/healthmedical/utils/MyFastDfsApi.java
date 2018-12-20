package com.smxy.healthmedical.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created with IDEA
 *
 * @author Luoxin
 * Date 2018/11/14
 * Time 19:37
 */
//@Component
public class MyFastDfsApi {

    private FastDfsClient fastDfsClient;

    public MyFastDfsApi() throws Exception {
        init();
    }
    public void init() throws Exception {
        this.fastDfsClient = new FastDfsClient("C:\\Users\\luoxin\\Desktop\\tracker_server.conf");
    }

    //二进制文件上传
    public String uploadImg(byte[] file,String fileName) throws Exception {
        String path = fastDfsClient.uploadFile(file,fileName.substring(fileName.lastIndexOf(".")+1),null);
        //添加到图片管理
        return path;
    }

    public String uploadImg( MultipartFile file) throws Exception {

        String fileName = file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();
        //文件输入流

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] bs = new byte[1024];
        while ((inputStream.read(bs)) != -1){
            bos.write(bs);
        }
        String path = fastDfsClient.uploadFile(bos.toByteArray(),fileName.substring(fileName.lastIndexOf(".")+1),null);

        //添加到图片管理
        System.out.println(file);
        return path;
    }


//    public String updateImg(MultipartFile file, String oldPath) throws Exception {
//        deleteImg(oldPath);
//        return uploadImg(file);
//    }

    //根据路径从fastDFS删除图片
    public void deleteImg(String oldPath) throws Exception {
        fastDfsClient.deleteFile(oldPath);
    }
}

