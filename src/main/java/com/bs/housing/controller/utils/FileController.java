package com.bs.housing.controller.utils;

import com.bs.housing.constant.FIleConfigEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * <p> @类描述：	                </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/12/7 10:02</p>
 */
@Controller
@RequestMapping("file")
public class FileController {
    @Value("${file-home}")
    private String path;

    @RequestMapping("fileUpload2")
    public String fileUpload2(@RequestParam("file") CommonsMultipartFile file, FIleConfigEnum fIleConfigEnum) throws IOException {
        long startTime = System.currentTimeMillis();
        System.out.println("fileName：" + file.getOriginalFilename());


        File newFile = new File(path);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(newFile);
        long endTime = System.currentTimeMillis();
        System.out.println("方法二的运行时间：" + String.valueOf(endTime - startTime) + "ms");
        return "/success";
    }

}
