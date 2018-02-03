package com.pms.service.FileReference;

import com.pms.model.file.File;

import java.util.List;

public interface FileReferenceService {

    /**
     * 通过项目id来获取所有文件
     * @param projectId
     * @return
     */
    public List<File> getFilesByProjectId(int projectId);
}
