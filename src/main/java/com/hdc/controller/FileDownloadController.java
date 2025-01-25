package com.hdc.controller;

import com.hdc.entity.OrderFile;
import com.hdc.entity.TeacherTable;
import com.hdc.entity.TeacherTableExample;
import com.hdc.security.MyUser;
import com.hdc.service.DeclarationTableService;
import com.hdc.service.OrderFileService;
import com.hdc.service.OrderService;
import com.hdc.service.TeacherService;
import com.hdc.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;

@RestController
@RequestMapping("")
public class FileDownloadController {


    @Autowired
    private OrderService orderService;

    @Autowired
    private DeclarationTableService declarationTableService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private OrderFileService orderFileService;

    @RequestMapping("/download/{orderFileId:\\d+}")
    public void downloadFiles(HttpServletRequest request,HttpServletResponse response,
                               @PathVariable Long orderFileId) throws IOException {

        response.setCharacterEncoding("UTF-8");
        FileInputStream fs = null;
        BufferedInputStream buff = null;
        OutputStream myout = null;
        String filePath;
        OrderFile orderFile = null;

        try {
            orderFile = orderFileService.selectByPrimaryKey(orderFileId);
            if(orderFile == null){
                System.out.println("in2");
                response.setHeader("Content-type", "text/html;charset=UTF-8");
                PrintWriter os = response.getWriter();
                os.write("文件不存在");
                os.close();
                return;
            }

            response.setContentType("application/octet-stream");
            filePath=FileUtil.getBasePath(request)+orderFile.getFileUrl();
            System.out.println(filePath);

            File file = new File(filePath.trim());
            if (file.exists()) {
                String fileName = orderFile.getOriginFileName();
                fs = new FileInputStream(file);
                response.addHeader(
                        "Content-Disposition",
                        "attachment;filename="
                                + URLEncoder.encode(fileName, "UTF-8"));
                buff = new BufferedInputStream(fs);
                byte[] b = new byte[1024];
                long k = 0;
                myout = response.getOutputStream();
                while (k < file.length()) {
                    int j = buff.read(b, 0, 1024);
                    k += j;
                    myout.write(b, 0, j);
                }
                buff.close();
            } else {
                PrintWriter os = response.getWriter();
                os.write("文件不存在");
                os.close();
            }
            if (myout != null) {
                myout.flush();
                myout.close();
            }
            if (fs != null) {
                fs.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (myout != null) {
                try {
                    myout.flush();
                    myout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
