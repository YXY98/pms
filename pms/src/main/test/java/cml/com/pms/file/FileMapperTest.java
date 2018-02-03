package cml.com.pms.file;

import com.pms.dao.file.FileMapper;
import com.pms.model.file.File;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Chenmeiling on 2017/8/19.
 */
@ContextConfiguration("classpath:test-h2-applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class FileMapperTest {
    @Resource
    FileMapper fileMapper;

    @Test
    //@Transactional
    //@Rollback
    public void insertFileInfo() throws Exception {
        File file = new File.Builder()
                .fileName("fileName")
                .url("www.360.com")
                .size(10)
                .createBy("createBy")
                .fileClass("音频").build();
        boolean bool = fileMapper.insertFileInfo(file);
        Assert.assertEquals(true,bool);
    }

    @Test
    public void updateFileInfo() throws Exception {
        fileMapper.updateFileInfo("fileName4",4);
    }

    @Test
    public void selectByFileId() throws Exception{
        File result = fileMapper.selectFileById(1);
        Assert.assertTrue("作业".equals(result.getFileName()));
    }

    @Test
    public void deleteFileTest() throws Exception {
        File file = new File();
        file.setFileId(3);
        fileMapper.deleteFileById(3);

    }

    @Test
    public void deleteByDelFlag() throws Exception{
        boolean bool = fileMapper.deleteFlagById(1);
        Assert.assertEquals(true,bool);
    }

    @Test
    public void recoverFile() throws Exception{
        fileMapper.recoverFileById(1);
    }

}