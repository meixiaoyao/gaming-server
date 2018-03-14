package com.ooqiu.gaming.server.web.admin.config.fastdfs;

/**
 * 文件存储服务接口
 * <p>Title: StorageService </p>
 * <p>Description: </p>
 *
 * @author: Eve
 * @version: 1.0.0
 * @Date: 9:20 2018/3/8
 */

public interface StorageService {
    /**
     * 上传文件
     * @param data 文件的二进制名
     * @param extName 文件扩展名
     * @return 上传成功后返回文件的 id，失败返回 null
     */
    public String upload(byte[] data, String extName);

    /**
     * 删除文件
     * @param fileId 成功返回0 ，失败返回错误代码
     * @return
     */
    public int delete(String fileId);

}
