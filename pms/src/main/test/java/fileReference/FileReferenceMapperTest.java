package fileReference;

import com.pms.dao.fileReference.FileReferenceMapper;
import com.pms.model.filereference.FileReference;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-h2-applicationContext.xml")
public class FileReferenceMapperTest {

    @Resource
    FileReferenceMapper fileReferenceMapper;
    @Test
    public void getReferenceByFileIdTest(){
        int fileId = 1;
        FileReference fileReference = fileReferenceMapper.getReferenceByFileId(fileId);
        Assert.assertEquals(1, fileReference.getUserId());
    }

    @Test
    public void getReferencesByTeamIdTest(){
        int teamId = 1;
        List<FileReference> list = fileReferenceMapper.getReferencesByTeamId(teamId);
        Assert.assertEquals(1,list.get(0).getUserId());
    }

    @Test
    public void addFileReferenceTest(){
        FileReference fileReference = new FileReference.Builder()
                .fileId(7).projectId(3).teamId(7).userId(7).build();
        boolean isOk = fileReferenceMapper.addFileReference(fileReference);
        Assert.assertTrue(isOk);
    }

    @Test
    public void getReferencesByProjectIdTest(){
        int projectId = 1;
        List<FileReference> list = fileReferenceMapper.getReferencesByProjectId(projectId);
        Assert.assertEquals(2, list.size());
    }

    @Test
    public void deleteFileReferenceByFileIdTest(){
        int fileId = 1;
        boolean isOk = fileReferenceMapper.deleteFileReferenceByFileId(fileId);
        Assert.assertTrue(isOk);
    }

    @Test
    public void getReferencesByTeamIdAndUserIdTest(){
        int teamId = 2;
        int userId = 1;
        List<FileReference> list = fileReferenceMapper.getReferencesByTeamIdAndUserId(teamId, userId);
        Assert.assertEquals(2, list.size());
    }

    @Test
    public void getReferencesByProjectsAndUserIdTest(){
        int projectId = 1;
        int userId = 1;
        List<FileReference> list = fileReferenceMapper.getReferencesByProjectsAndUserId(projectId, userId);
        Assert.assertEquals(2, list.size());
    }
}
