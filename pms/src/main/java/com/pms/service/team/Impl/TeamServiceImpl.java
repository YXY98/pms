package com.pms.service.team.Impl;

import com.pms.dao.teamdao.TeamMapper;
import com.pms.model.team.Team;
import com.pms.model.team.TeamMember;
import com.pms.service.team.Impl.util.JudgeInfo;
import com.pms.service.team.TeamService;
import org.apache.ibatis.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
@Service
public class TeamServiceImpl implements TeamService{
    @Autowired
    TeamMapper teamMapper;
    //团队中超级管理员的权限
    private final int PRIVILEGE_SUPER_MANAGER = 2;

    @Override
    public boolean isExist(String teamName) {
        if (teamName == null){
            return false;
        }
        Team team = teamMapper.getTeamInfo(teamName);
        return team != null;
    }

    /**
     * 如果团队创建成功，而成员没有添加成功，应该回归到之前的状态，并且直接告诉前台创建失败
     * @param team
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addTeam(Team team) {
        if (!JudgeInfo.baseTeamInfo(team) || isExist(team.getTeamName())){
            return false;
        }
        try {
            if (teamMapper.addTeam(team)){
                System.out.println("团队创建成功");
                //团队创建成功就自动的将创建者添加到团队成员表当中去
                TeamMember creator = new TeamMember.Builder()
                        .teamName(team.getTeamName())
                        .userName(team.getCreateBy())
                        .joinBy(team.getCreateBy())
                        .joinTime(team.getCreateTime())
                        .teamRole("队长")
                        .teamPrivelige(PRIVILEGE_SUPER_MANAGER).build();
                System.out.println("创建成员其那一步");
                return teamMapper.addTeamMember(creator);
            }
        } catch (Exception e) {
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }
        System.out.println("失败的最后一步");
        return false;
    }

    @Override
    public boolean delTeam(Team team) {
        return false;
    }

    @Override
    public boolean updateTeam(Team team) {
        return false;
    }

    @Override
    public List<Team> getAllTeamByUserName(String userName) {
        return null;
    }
}