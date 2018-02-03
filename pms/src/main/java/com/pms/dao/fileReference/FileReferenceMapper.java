package com.pms.dao.fileReference;

import com.pms.model.file.File;
import com.pms.model.filereference.FileReference;
import com.pms.model.project.Project;
import com.pms.model.team.Team;
import com.pms.model.team.TeamMember;
import com.pms.model.user.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.processing.Filer;
import java.util.List;

/**
 * @author MEI
 */
@Repository
public interface FileReferenceMapper {

    /**
     * 通过项目id得到相关关系
     * @param projectId 项目id
     * @return list
     */
    List<FileReference> getReferencesByProjectId(int projectId);

    /**
     * 添加一组文件与用户、（项目、团队）参照关系
     * @param fileReference 文件参照对象
     * @return boolean
     */
    boolean addFileReference(FileReference fileReference);

    /**
     * 通过文件ID得到相关关系
     * @param fileId 文件ID
     * @return 项目
     */
    FileReference getReferenceByFileId(int fileId);

    /**
     * 通过fileId完全删除文件
     * @param fileId 文件Id
     * @return 是否删除文件与项目之间的关系
     */
    boolean deleteFileReferenceByFileId(int fileId);

    /**
     * 通过团队id得到团队下的所有关系（不包含项目的）
     * @param teamId 团队id
     * @return
     */
    List<FileReference> getReferencesByTeamId(int teamId);

    /**
     * 通过团队id和用户id得到相关关系(用户上传到团队的项目)
     * @param teamId 团队id
     * @param userId 用户id
     * @return
     */
    List<FileReference> getReferencesByTeamIdAndUserId(@Param("teamId") int teamId, @Param("userId") int userId);

    /**
     * 通过项目id和用户id得到相关关系（用户在项目上上传的文件信息）
     * @param projectId 项目id
     * @param userId 用户id
     * @return
     */
    List<FileReference> getReferencesByProjectsAndUserId(@Param("projectId") int projectId, @Param("userId") int userId);
}
