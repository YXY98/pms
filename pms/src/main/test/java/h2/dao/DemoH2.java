package h2.dao;

import com.pms.dao.teamdao.TeamMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * CreatedBy: liudong
 * On: 2017/11/20.
 * describle:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-h2-applicationContext.xml")
public class DemoH2 {
    @Resource
    TeamMapper teamMapper;
    @Test
    public void demoTest(){
        //得到的大小为1是因为我在data-prepare-team.sql中只添加了一条数据
        Assert.assertEquals(5,teamMapper.getAllTeam().size());
    }

    @Test
    public void demo2Test(){
        Assert.assertEquals("难受",teamMapper.getTeamById(1).getTeamName());
    }
}
