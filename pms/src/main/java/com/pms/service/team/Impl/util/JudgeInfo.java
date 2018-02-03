package com.pms.service.team.Impl.util;

import com.pms.model.team.Team;

/**
 * CreatedBy: liudong
 * On: 2017/12/3.
 * describle: 判断相应的信息是否完善，信息完善则返回true，否则返回false
 */
public  class JudgeInfo {
    public static boolean baseTeamInfo(Team team){
        return  team != null
                &&team.getTeamName() != null
                && team.getCreateBy() != null
                && team.getCreateTime() != null;
    }


}
