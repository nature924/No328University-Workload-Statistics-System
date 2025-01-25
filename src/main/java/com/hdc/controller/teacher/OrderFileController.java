package com.hdc.controller.teacher;

import com.hdc.entity.OrderFile;
import com.hdc.entity.TeacherExample;
import com.hdc.entity.TeacherTable;
import com.hdc.entity.TeacherTableExample;
import com.hdc.security.MyUser;
import com.hdc.service.*;
import com.hdc.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;

@RestController
@RequestMapping("/teacher")
public class OrderFileController {


    @Autowired
    private OrderService orderService;

    @Autowired
    private DeclarationTableService declarationTableService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private OrderFileService orderFileService;

    @RequestMapping("/upload")
    @ResponseBody
    public Map<String, Object> springUpload(HttpServletRequest request) {

        //获取登录的用户ID
        MyUser userDetails = (MyUser) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        TeacherTableExample teacherTableExample = new TeacherTableExample();
        teacherTableExample.createCriteria().andUserIdEqualTo(userDetails.getMyUserId());

        TeacherTable teacherTable=teacherService.selectAllByExample(teacherTableExample).get(0);
        Integer collegeId = teacherTable.getCollegeId();
        Integer teacherId = teacherTable.getTeacherId();
        Map<String, Object> map = new HashMap<>();
        String originFileName = "";// 文件名称;
        String saveFileName = "";// 文件名称;
        List<Long> orderFileIdList = new ArrayList<>();

        // 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        // 检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            // 将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // 获取multiRequest 中所有的文件名
            Iterator iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                // 一次遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next().toString());

                if (file != null) {
                    System.out.println("文件大小为："+file.getSize());
                    originFileName = file.getOriginalFilename();
                    String [] tempStr = originFileName.split("\\.");
                    saveFileName = FileUtil.getRandomFileName()+"."+tempStr[tempStr.length-1];
                    String rootPath = FileUtil.getBasePath(request,collegeId,teacherId);
                    String path = rootPath+saveFileName;

                    // 文件文件夹
                    File rootFile = new File(rootPath);
                    if (!rootFile.exists()) {
                        rootFile.mkdirs();
                    }

                    // 上传

                    try {
                        file.transferTo(new File(path));
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                        map.put("code", 500);
                        map.put("msg", "上传失败");
                        return map;
                    } catch (IOException e) {
                        e.printStackTrace();
                        map.put("code", 500);
                        map.put("msg", "上传失败");
                        return map;
                    }

                    //将记录插入数据库
                    OrderFile orderFile = new OrderFile();
                    orderFile.setCreateTime(new Date());
                    orderFile.setFileUrl(FileUtil.getBaseURl(collegeId, teacherId)+saveFileName);
                    orderFile.setOrderId((long) 0);
                    orderFile.setSize(file.getSize());
                    orderFile.setOriginFileName(originFileName);
                    orderFile.setSaveFileName(saveFileName);
                    orderFile.setTeacherId(teacherId);
                    orderFileService.insert(orderFile);
                    orderFileIdList.add(orderFile.getOrderFileId());
                }

            }
            map.put("code", 0);
            map.put("msg", "上传成功");
            map.put("data", orderFileIdList);

        }
        return map;
    }

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
