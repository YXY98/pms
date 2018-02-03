package com.pms.controller.team;
import com.pms.model.team.Team;
import com.pms.service.team.TeamService;
import com.pms.util.JsonUtil;
import com.pms.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by liudong on 2017/8/22.
 */

@Controller
@RequestMapping("/team")
public class TeamAction{
    private final String SUCCESS = "success";
    private final String FALSE = "false";
    @Resource
    private TeamService teamService;
    @RequestMapping(value = "/teamInfo", method = RequestMethod.POST)
    public void createTeamInfo(Team team){
        Map map = null;
        try {
            System.out.println(team.getCreateBy()+"   "+teamService.addTeam(team));
        } catch (Exception e) {
            map = MapUtil.toMap(0,"false", null);
            JsonUtil.toJSON(map);
            e.printStackTrace();
        }
        map = MapUtil.toMap(0,SUCCESS,null);
        JsonUtil.toJSON(map);
    }

    @RequestMapping(value = "/existence", method = RequestMethod.POST)
    public void teamIsexitence(String teamName){
        System.out.println("判断团队是否存在" + teamName);
    }

    @RequestMapping(value = "/teamInfo/{teamId}", method = RequestMethod.GET)
    public void showTeamInfo(@PathVariable("teamId") Integer teamId){
        System.out.println("展示团队信息");
    }

    @RequestMapping(value = "/permission", method = RequestMethod.POST)
    public void exchangePermission(){
        System.out.println("交换权限");
    }

    @RequestMapping(value = "/teamMember", method = RequestMethod.PATCH)
    public void editManager(){
        System.out.println("管理员的修改");
    }

    @RequestMapping(value = "/notice", method = RequestMethod.POST)
    public void createNotice(){
        System.out.println("创建团队公告");
    }

    @RequestMapping(value = "/notice", method = RequestMethod.DELETE)
    public void delNotice(Integer nociceId){
        System.out.println("删除公告");
    }

    @RequestMapping(value = "/notice", method = RequestMethod.PUT)
    public void reEditNotice(Integer noticeId){
        System.out.println("修改公告");
    }

    @RequestMapping(value = "/notice", method = RequestMethod.GET)
    public void getTeamAllNotice(Integer TeamId){
        System.out.println("得到团队所有的公告");
    }

    @RequestMapping(value = "/notice", method = RequestMethod.GET)
    public void getNoticeById(Integer noticeId){
        System.out.println("得到指定公告的信息");
    }

    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public void uploadFile(){
        System.out.println("上传文件");
    }

    @RequestMapping(value = "/file", method = RequestMethod.DELETE)
    public void delFile(Integer fileId){
        System.out.println("文件删除");
    }

    @RequestMapping(value = "/file", method = RequestMethod.PUT)
    public void updateFile(Integer fileId){
        System.out.println("更新文件");
    }

    @RequestMapping(value = "/project", method = RequestMethod.POST)
    public void createProject(){
        System.out.println("创建团队项目");
    }

    @RequestMapping(value = "/project", method = RequestMethod.DELETE)
    public void delProject(Integer projectId){
        System.out.println("删除团队项目");
    }

    @RequestMapping(value = "/project", method = RequestMethod.POST)
    public void reEditProject(Integer projectId){
        System.out.println("修改项目");
    }
}
