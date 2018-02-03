package com.pms.controller.file;

import com.pms.model.file.File;
import com.pms.service.file.FileService;
import com.pms.util.JsonUtil;
import com.pms.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Chenmeiling
 * @date 2017/8/30
 */
@Controller
@RequestMapping("/file")
public class FileAction {

    @RequestMapping(value = "files",method = RequestMethod.GET)
    public void getFiles(HttpServletRequest httpServletRequest){
        System.out.println("通过用户id得到用户所有的文件" + httpServletRequest.getSession());
    }

    @RequestMapping(value = "/files", method = RequestMethod.GET)
    public void downloadFile(Integer fileId){
        System.out.println("通过文件下载id");
    }

    @RequestMapping(value = "/files", method = RequestMethod.POST)
    public void uploadFile(){
        System.out.println("上传文件");
    }

    @RequestMapping(value = "/files", method = RequestMethod.DELETE)
    public void delFile(Integer fileId){
        System.out.println("删除文件");
    }

    @RequestMapping(value = "/files", method = RequestMethod.PATCH)
    public void reEditFile(Integer fileId){
        System.out.println("修改文件信息");
    }

    //以下是要参考的一些东西
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH-mm-ss");
    String message;

    @Autowired
    FileService fileService;


    /**
     * 文件上传功能，通过spring MVC的MultipartFile来实现的
     * 成功上传返回1，并返回文件对象，未上传返回0和message信息，
     * 应该是个坑，你们要改。
     * @param file
     * @param request
     * @throws IOException
     */
    @RequestMapping("insertFileInfo")
    public void insertFileInfo(MultipartFile file, HttpServletRequest request) throws IOException {
        Map map;
        File fileImpl = new File();
        if (file.isEmpty()) {
            message = "文件未上传!";
//            Map map = new HashMap();
            map = MapUtil.toMap(0,message,null);
            JsonUtil.toJSON(map);
        } else {
            //得到上传的文件名
            String fileName = file.getOriginalFilename();
            //得到服务器项目发布运行所在地址
            String path1 = request.getSession().getServletContext().getRealPath("upload") + java.io.File.separator;
            //此处用日期做为标识
            String path = path1 + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + fileName;
            fileImpl.setUrl(path);
            //把文件上传至path的路径
            java.io.File localFile = new java.io.File(path);
            file.transferTo(localFile);
            message = "文件上传成功！";
            //Map map = new HashMap();
            map = MapUtil.toMap(1,message,file);
            JsonUtil.toJSON(map);
        }
    }

    /**
     * 文件下载功能，需要的参数为fileId
     * 这儿也是个坑
     * @param fileId
     * @param response
     */
    @RequestMapping("downloadFile")
    public void downloadFile(int fileId, HttpServletResponse response) {
        String message;
        String filePath = null;
        try {
            File file = fileService.selectByFileId(fileId);
            if (fileId == file.getFileId()) {
                filePath = file.getUrl();
            }
            InputStream inputStream = new FileInputStream(new java.io.File(filePath));
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
            // 这里主要关闭
            os.close();
            inputStream.close();
            message = "文件下载成功！";
            Map map = new HashMap();
            map.put("sucMessage",message);
            JsonUtil.toJSON(map);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            message = "没有该文件!";
            Map map = new HashMap();
            map.put("errMessage",message);
            JsonUtil.toJSON(map);
        } catch (IOException e) {
            e.printStackTrace();
            message = "文件下载失败!";
            Map map = new HashMap();
            map.put("errMessage",message);
            JsonUtil.toJSON(map);
        }
    }


    /**
     * 文件名称信息更改，需要传递的参数为fileName和fileId
     * 成功返回1，未成功返回0
     * @param fileName
     * @param fileId
     * @param response
     */
    @RequestMapping("updateFileInfo")
    public void updateFileInfo(String fileName,int fileId,HttpServletResponse response){
        Map map;
        if (fileService.updateFileInfo(fileName,fileId)){
            message = "操作成功";
            map = MapUtil.toMap(1,message,null);
        }else {
            message = "操作失败";
            map = MapUtil.toMap(0,message,null);
        }
        JsonUtil.toJSON(map,response);
    }

    /**
     * 文件暂时删除功能，传递的参数为fileId
     * 成功删除返回1，否则返回0
     * @param fileId
     * @param response
     */
    @RequestMapping("deleteByDelFlag")
    public void deleteByDelFlag(int fileId,HttpServletResponse response){
        File file = new File();
        Map map;
        String date = simpleDateFormat.format(new Date());
        file.setDelTime(date);
        file.setDelFlag(0);
        System.out.println("时间格式："+date);
        if (fileService.deleteByDelFlag(fileId)){
            message = "操作成功";
            map = MapUtil.toMap(1,message,null);
        }else {
            message = "操作失败";
            map = MapUtil.toMap(0,message,null);
        }
        JsonUtil.toJSON(map,response);
    }

    /**
     * 删除文件恢复功能，传递的参数为fileId
     * 成功返回1和该恢复的文件对象fileImple，否则返回0
     * @param fileId
     * @param response
     */
    @RequestMapping("recoverFile")
    public void recoverFile(int fileId,HttpServletResponse response){
        File file = new File();
        Map map;
        file.setDelFlag(0);
        if (fileService.recoverFile(fileId)){
            message = "操作成功";
            map = MapUtil.toMap(1,message, file);
        }else {
            message = "操作失败";
            map = MapUtil.toMap(0,message,null);
        }
        JsonUtil.toJSON(map,response);
    }

    /**
     * 文件彻底删除功能，通过文件id来进行操作
     * 成功返回1，失败返回0
     * @param fileId
     * @param response
     */
    @RequestMapping("deleteFile")
    public void deleteFile(int fileId,HttpServletResponse response){
        File file = new File();
        Map map;
        String date = simpleDateFormat.format(new Date());
        file.setDelTime(date);
        file.setDelFlag(1);
        System.out.println("时间格式："+date);
        if (fileService.deleteFile(fileId)){
            message = "操作成功";
            map = MapUtil.toMap(1,message,null);
        }else {
            message = "操作失败";
            map = MapUtil.toMap(0,message,null);
        }
        JsonUtil.toJSON(map,response);
    }
}