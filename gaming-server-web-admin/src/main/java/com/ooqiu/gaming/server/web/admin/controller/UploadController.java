package com.ooqiu.gaming.server.web.admin.controller;

import com.google.common.collect.Maps;
import com.ooqiu.gaming.server.commons.utils.MapperUtils;
import com.ooqiu.gaming.server.web.admin.config.fastdfs.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件上传控制器
 * <p>Title: UploadController </p>
 * <p>Description: </p>
 *
 * @author: Eve
 * @version: 1.0.0
 * @Date: 10:36 2018/3/8
 */
@Controller
public class UploadController {
    @Value("${fastdfs.base.url}")
    private String FASTDFS_UPLOAD_URL;

    @Autowired
    private StorageService storageService;

    @ResponseBody
    @RequestMapping(value = "upload")
    private String uploda(MultipartFile uploadFile, MultipartFile wangEditorH5File){
        if (uploadFile != null){
            String oName = uploadFile.getOriginalFilename();
            String etxName = oName.substring(oName.indexOf(".")+1);

            HashMap<String, Object> map = new HashMap<>();

            try{
                String uploadUrl = storageService.upload(uploadFile.getBytes(), etxName);
                map.put("success", "上传成功");
                map.put("url", FASTDFS_UPLOAD_URL+uploadUrl);
            }catch (IOException e){
                map.put("error", 1);
                map.put("message", "上传失败");
            }
        }else if(wangEditorH5File != null){
            String oName = wangEditorH5File.getOriginalFilename();
            String etxName = oName.substring(oName.indexOf(".") + 1);

            Map<String, Object> map = Maps.newHashMap();

            try{
                String uploadUrl = storageService.upload(uploadFile.getBytes(), etxName);
                String url = FASTDFS_UPLOAD_URL + uploadUrl;
                // 上传成功
                map.put("error", 0);
                map.put("data", new String[]{url});
            }catch (IOException e){
                map.put("error", 1);
                map.put("message", "服务端错误");
            }
            return MapperUtils.mapToJson(map);
        }
        return " ";
    }
}
