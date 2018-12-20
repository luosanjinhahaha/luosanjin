package com.smxy.healthmedical.utils;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

/**
 * Created with IDEA
 *
 * @author Luoxin
 * Date 2018/11/14
 * Time 19:21
 */
public class FastDfsClient {
    private TrackerClient trackerClient;
    private TrackerServer trackerServer;
    private StorageClient1 storageClient;
    private StorageServer storageServer;


    public FastDfsClient( String conf) throws Exception {
        String classpath = "classpath";
        if (conf.startsWith(classpath)) {
            conf=conf.replace("classpath:", getClass().getResource("/").getPath());
        }
        ClientGlobal.init(conf);
        trackerClient=new TrackerClient();
        trackerServer=trackerClient.getConnection();
        storageClient=new StorageClient1(trackerServer, storageServer);
    }

    public String uploadFile( String fileName, String extName, NameValuePair[]
            pairs) throws Exception {
        return storageClient.upload_file1(fileName, extName, pairs);
    }

    public String uploadFile(String fileName) throws Exception{
        return uploadFile(fileName, null, null);
    }

    public String uploadFile(String fileName,String extName) throws Exception{
        return uploadFile(fileName, extName, null);
    }

    public String uploadFile(String fileName,NameValuePair[] pairs) throws
            Exception{
        return uploadFile(fileName, null, pairs);
    }

    public String uploadFile(byte[] source,String extName,NameValuePair[] pairs)
            throws Exception{
        return storageClient.upload_file1(source, extName, pairs);
    }

    public int deleteFile(String fileName) throws Exception {
        return storageClient.delete_file1(fileName);
    }
}
