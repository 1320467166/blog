package com.example.blog.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author yjs
 */
public class FileUtil {
    @Value("${spring.port}")
    private String serverPort;

    public static String uploadFile(MultipartFile file) throws IOException {
        //将上传的文件重命名 避免文件重复产生冲突
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        String newFileName = sdf.format(new Date()) + file.getOriginalFilename();
        //设置文件上传路径
        String filePath = "E:\\blogFile";
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        //设置最终文件存储位置
        String lastFilePath = filePath +"/"+ newFileName;
        FileOutputStream out = null;
        String fileUrl = null;
        try{
            out = new FileOutputStream(lastFilePath);
            out.write(file.getBytes());
            fileUrl = "http://127.0.0.1:9091" + File.separator + newFileName;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (out != null){
                try {
                    out.flush();
                }catch (Exception e){
                    e.printStackTrace();
                }
                try {
                    out.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return fileUrl;
    }
}
