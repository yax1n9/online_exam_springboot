package com.yaxing.controller;

import com.yaxing.controller.utils.Result;
import com.yaxing.controller.utils.ResultCode;
import com.yaxing.controller.utils.ResultMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author yx
 * @date 2022/12/12
 */
@CrossOrigin
@RestController
@RequestMapping("/files")
public class FileController {

    @Value("${file.path}")
    private String BasePath;

    @PostMapping
    public Result uploadFile(MultipartFile file) {
        // 原始文件名
        String originalFilename = file.getOriginalFilename();
        // 后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        // 生成新的文件名
        String fileName = UUID.randomUUID() + suffix;

        // 创建目录
        File dir = new File(BasePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        try {
            // 存储文件
            file.transferTo(new File(BasePath + fileName));
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(ResultCode.FILE_UPLOAD_FAILED_CODE, true, ResultMessage.FILE_UPLOAD_FAILED_MSG);
        }

        // 返回文件名
        return new Result(ResultCode.REQUEST_SUCCESS_CODE, true, ResultMessage.FILE_UPLOAD_SUCCESS_MSG, fileName);
    }


    @GetMapping("/{fileName}")
    public Result downloadFile(@PathVariable String fileName, HttpServletResponse response) {
        try {
            // 通过输入流读取文件
            FileInputStream fileInputStream = new FileInputStream(new File(BasePath + fileName));
            // 通过输出流将文件写回浏览器
            ServletOutputStream outputStream = response.getOutputStream();
            int len;
            byte[] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
                outputStream.flush();
            }
            // 关闭流
            fileInputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(ResultCode.FILE_DOWNLOAD_FAILED_CODE, false, ResultMessage.FILE_DOWNLOAD_FAILED_MSG);
        }
        return new Result(ResultCode.REQUEST_SUCCESS_CODE, true, ResultMessage.FILE_DOWNLOAD_SUCCESS_MSG);
    }
}
