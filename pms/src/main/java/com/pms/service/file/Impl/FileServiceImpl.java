package com.pms.service.file.Impl;

import com.pms.dao.file.FileMapper;
import com.pms.model.file.File;
import com.pms.service.file.FileService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 *
 * @author Chenmeiling
 * @date 2017/8/18
 */
@Service
public class FileServiceImpl implements FileService {

    @Resource
    private FileMapper fileMapper;

    @Override
    public boolean insertFileInfo(File file) {
        try {
            fileMapper.insertFileInfo(file);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("添加失败");
            return false;
        }
        return true;
    }

    @Override
    public File selectByFileId(int fileId){
        return fileMapper.selectFileById(fileId);
    }

    @Override
    public boolean updateFileInfo(String fileName,int fileId) {
        try {
            fileMapper.updateFileInfo(fileName,fileId);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("修改失败");
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteByDelFlag(int fileId){
        try {
            fileMapper.deleteFlagById(fileId);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("删除失败");
            return false;
        }
        return true;
    }

    @Override
    public boolean recoverFile(int fileId) {
        try {
            fileMapper.recoverFileById(fileId);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("恢复失败");
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteFile(int fileId) {
        try {
            fileMapper.deleteFileById(fileId);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("删除失败");
            return false;
        }
        return true;
    }

    @Override
    public boolean downloadFile(int fileId){
        return true;
    }

}
