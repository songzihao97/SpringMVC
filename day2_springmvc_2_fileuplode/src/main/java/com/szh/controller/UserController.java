package com.szh.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 传统文件上传
     */
    @RequestMapping("/fileUpLode1")
    public String fileUpLode1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传");

        //使用fileuplode组件完成文件上传
        //上传位置
        String path = request.getSession().getServletContext().getRealPath("/uplodes/");
        //判断路径是否存在
        File file=new File(path);
        if (!file.exists()){
            file.mkdir();
        }
        //解析request,获取上传文件项
        DiskFileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload upload=new ServletFileUpload(factory);
        //解析request
        List<FileItem> fileItems = upload.parseRequest(request);
        for (FileItem fileItem : fileItems) {
            if (fileItem.isFormField()){
                //普通表单项
            }else{
                //上传文件项
                //获取上传文件名称
                String fileName = fileItem.getName();
                //把文件名称设置唯一值，uuid
                String uuid= UUID.randomUUID().toString().replace("-","");
                fileName=uuid+"_"+fileName;
                //完成文件上传
                fileItem.write(new File(path,fileName));
                //删除临时文件
                 fileItem.delete();
            }
        }
        return "success";
    }

    /**
     * springMVC文件上传
     */
    @RequestMapping("/fileUpLode2")
    public String fileUpLode2(HttpServletRequest request, MultipartFile upLode) throws Exception{
        System.out.println("springMVC文件上传");

        //使用fileuplode组件完成文件上传
        //上传位置
        String path = request.getSession().getServletContext().getRealPath("/uplodes/");
        //判断路径是否存在
        File file=new File(path);
        if (!file.exists()){
           //创建该文件夹
            file.mkdir();
        }
        //获取上传文件名称
        String fileName = upLode.getOriginalFilename();
        //把文件名称设置唯一值，uuid
        String uuid= UUID.randomUUID().toString().replace("-","");
        fileName=uuid+"_"+fileName;
        //完成文件上传
        upLode.transferTo(new File(path,fileName));
        return "success";
    }

    /**
     * 跨服务器文件上传
     */
    @RequestMapping("/fileUpLode3")
    public String fileUpLode3(MultipartFile upLode) throws Exception{
        System.out.println("跨服务器文件上传");

        //定义上传服务器路径
        String path="http://localhost:9090/fileuplodeserver_war/uplodes/";

        //获取上传文件名称
        String fileName = upLode.getOriginalFilename();
        //把文件名称设置唯一值，uuid
        String uuid= UUID.randomUUID().toString().replace("-","");
        fileName=uuid+"_"+fileName;
        //创建客户端对象
        Client client = Client.create();
        //连接图片服务器
        WebResource resource = client.resource(path + fileName);
        //完成文件上传
        resource.put(upLode.getBytes());
        return "success";
    }
}
