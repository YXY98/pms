
package com.pms.service.team;
import com.pms.model.file.File;
import com.pms.model.project.Project;
import com.pms.model.project.ProjectMember;
import com.pms.model.team.*;
import com.sdicons.json.validator.impl.predicates.Str;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Created by liudong on 2017/8/15.
 * @author liudong
 *
 */
public interface TeamService {

    //团队
    /**
     * 根据团队名称判断团队是否存在
     * @param teamName
     * @return 存在返回true，不存在返回false
     */
    boolean isExist(String teamName);

    /**
     * 创建团队
     * @param team
     * @return
     */
    boolean addTeam(Team team);

    /**
     * 为团队打上删除的标记
     * @param team
     * @return
     */
    boolean delTeam(Team team);

    /**
     * 更新团队信息
     * @param team
     * @return
     */
    boolean updateTeam(Team team);

    /**
     * 得到用户加入的团队信息
     * @param userName
     * @return
     */
    List<Team> getAllTeamByUserName(String userName);
}