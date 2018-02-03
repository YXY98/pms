package ld.com.pms.model.team;

import com.pms.dao.teamdao.TeamMapper;
import com.pms.model.project.ProjectMember;
import com.pms.model.team.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liudong on 2017/8/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-h2-applicationContext.xml")
public class TeamMapperTest {
    @Resource
    private TeamMapper teamMapper;
        @Test
        public void testRunWith() throws Exception {
            System.out.println("hello spring Junit");
}
        //团队方面的测试
        @Test
        public void addTeamTest(){
            Team team = new Team.Builder()
                    .teamName("队1")
                    .createBy("诸葛")
                    .createTime("0000")
                    .build();
            boolean re = teamMapper.addTeam(team);
            Assert.assertEquals(true,re);
        }

        @Test
        public void getTeamInfoTest() {
                String teamName = "猪猪侠";
                Assert.assertEquals("pig" , teamMapper.getTeamInfo(teamName).getCreateBy());
        }

        @Test
        public void delTeamTest(){
                Team team = new Team.Builder()
                        .teamName("猪猪侠")
                        .delFlag(true)
                        .delRemarks("测试使用")
                        .delTime("4444")
                        .build();
                boolean re = teamMapper.delTeam(team);
                Assert.assertEquals(true,re);
        }

        @Test
        public void getAllTeamTest(){
                //data-prepare-demo里面插入了一条关于team的数据再加上data-prepare-teaminfo上的数据就是五条了。
                int number = 5;
                Assert.assertEquals(number , teamMapper.getAllTeam().size());
              }

        //团队成员方面的测试
        @Test
        public void addTeamMemberTest(){
                TeamMember teamMember = new TeamMember.Builder()
                        .teamName("猪猪侠")
                        .teamPrivelige(1)
                        .joinBy("pig")
                        .userName("fish")
                        .teamRole("成员")
                        .joinTime("111")
                        .build();
                Assert.assertEquals(true , teamMapper.addTeamMember(teamMember));
        }

        @Test
        public void delTeamMemberTest(){
                TeamMember teamMember = new TeamMember.Builder()
                        .teamName("猪猪侠")
                        .teamPrivelige(1)
                        .joinBy("pig")
                        .userName("大灰狼")
                        .delTime("2222")
                        .delFlag(true)
                        .delBy("pig")
                        .build();
                Assert.assertEquals(true , teamMapper.delTeamMember(teamMember));
        }

        @Test
        public void getTeamMembersByTeamNameTest(){
                String teamName = "猪猪侠";
                //当前团队的成员数量
                int number = 3;
                Assert.assertEquals(number,teamMapper.getTeamMembersByTeamName(teamName).size());
        }

        @Test
        public void getTeamMemberByTeamNameAndUserNameTest() throws Exception {
                String teamName = "猪猪侠", userName = "pig";
                Assert.assertEquals("pig",teamMapper.getTeamMemberByTeamNameAndUserName(teamName,userName).getUserName());
        }

        @Test
        public void getTeamMemberInfoByNameTest(){
                int number = 2;//表示当前用户加入了多少个团队
                Assert.assertEquals(number,teamMapper.getTeamInfoByUserName("pig").size());
        }

        @Test
        public void getDelTeamMemberTest(){
                String teamName = "猪猪侠", userName = "被删除的成员";
                String delTime = "00";
                Assert.assertEquals(delTime, teamMapper.getDelTeamMember(teamName,userName).getDelTime());
        }

        @Test
        public void reAddTeamMemberTest(){
                TeamMember teamMember =
                        new TeamMember.Builder().teamName("猪猪侠").userName("被删除的成员").build();
                Assert.assertEquals(true,teamMapper.reAddTeamMember(teamMember));
        }

        //团队公告的测试
        @Test
        public void  addNoticeTest(){
                TeamNotice teamNotice = new TeamNotice.Builder()
                        .teamName("猪猪侠")
                        .context("不知道什么内容")
                        .createBy("pig")
                        .createTime("5555")
                        .title("公告四")
                        .build();
                Assert.assertEquals(true,teamMapper.addNotice(teamNotice));
        }

        @Test
        public void getNoticeByIdTest(){
                String title = "公告一";
                Assert.assertEquals(title,teamMapper.getNoticeById(1).getTitle());
        }

        @Test
        public void  delNoticeTest(){
                TeamNotice teamNotice = new TeamNotice.Builder()
                        .id(1)
                        .delFlag(true)
                        .delTime("666")
                        .build();
                Assert.assertEquals(true,teamMapper.delNotice(teamNotice));
        }

        @Test
        public void  updateNoticeTest(){
                TeamNotice teamNotice = new TeamNotice.Builder()
                        .id(1)
                        .teamName("猪猪侠")
                        .context("不知道什么内容2")
                        .createBy("pig")
                        .createTime("5555")
                        .title("没有标题哈")
                        .build();
                Assert.assertEquals(true,teamMapper.updateNotice(teamNotice));
        }

        @Test
        public void  getNoticeByteamNameTest(){
                String teamName = "猪猪侠";
                int number = 3;//公告的数量
                Assert.assertEquals(number,teamMapper.getNoticeByteamName(teamName).size());
        }

        @Test
        public void setPriviligeTest(){
                TeamMember teamMember = new TeamMember.Builder()
                        .teamName("猪猪侠")
                        .userName("大灰狼")
                        .teamPrivelige(2)
                        .build();
                Assert.assertEquals(true,teamMapper.setPrivilege(teamMember));
        }

        @Test
        public void insertTeamMasterHistoryTest(){
                TeamMasterHistory teamMasterHistory = new TeamMasterHistory.Builder()
                        .teamName("猪猪侠")
                        .fromRole("成员")
                        .ModifyAt("111")
                        .toRole("负责人")
                        .modifyBy("pig")
                        .userName("大灰狼")
                        .build();
                Assert.assertEquals(true,teamMapper.insertTeamMasterHistory(teamMasterHistory));
        }

        @Test
        public void getTeamByIdTest(){
                int id = 2;
                String teamName = "猪猪侠";
                Assert.assertEquals(teamName,teamMapper.getTeamById(id).getTeamName());
        }

        @Test
        public void addTeamFileTest(){
                int teamId = 11, fileId = 11, userId = 11;
                Assert.assertEquals(true, teamMapper.addTeamFile(teamId,fileId,userId));
        }
}
