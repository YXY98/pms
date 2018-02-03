package com.pms.dao.file;


import com.pms.model.file.File;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/8/1.
 */
@Repository
public interface FileMapper {
    /**
     * 通过文件id来查找文件
     * @param fileId
     * @return
     */
    File selectFileById(int fileId);

    /**
     *通过文件id在数据库中将这条文件记录删除来实现文件彻底删除
     * @param fileId
     * @return
     */
    boolean deleteFileById(int fileId);

    /**
     * 文件上传，传递的是model层的FileImpl对象
     * @param file
     * @return
     */
    boolean insertFileInfo(File file);

    /**
     * 通过文件id查找文件，然后更改文件名称信息
     * @param fileName
     * @return
     */
    boolean updateFileInfo(@Param("fileName") String fileName, @Param("fileId") int fileId);

    /**
     * 通过文件id来实现修改数据库中删除标记，以实现文件暂时删除
     * @param fileId
     * @return
     */
    boolean deleteFlagById(int fileId);

    /**
     * 删除文件的恢复,通过文件id
     * @param fileId
     * @return
     */
    boolean recoverFileById(int fileId);

}
