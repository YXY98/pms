package ld.com.pms.model.team;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.pms.dao.project.ProjectMapper;
import com.pms.dao.teamdao.TeamMapper;
import com.pms.model.project.Project;
import com.pms.model.project.ProjectMember;
import com.pms.model.team.*;
import com.pms.service.project.ProjectService;
import com.pms.service.team.Impl.TeamServiceImpl;
import com.pms.service.team.TeamService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;

/**
 * Created by liudong on 2017/8/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springconfig.xml")
public class TeamServiceTest {
    //只有一个接口，接口的方法并没有实现，这个时候就用一个mock模仿方法的实现
   @Mock
    ProjectMapper projectMapper;
   @Mock
   TeamMapper teamMapper;

   //待测试的组件，即调用使用了mock注解的对象方法
   @InjectMocks
    TeamService teamService = new TeamServiceImpl();

   private Team team;

    @Before
    public void setUp() throws Exception {
        //用于初始化@Mock注解修饰的组件
        MockitoAnnotations.initMocks(this);
        team = new Team.Builder()
                .teamName("测测")
                .createBy("今天")
                .createTime("11")
                .build();
    }

    @Test
    public void addTeamTest(){

    }



}
