package com.pms.model.file;

/**
 *
 * @author Chenmeiling
 * @date 2017/8/26
 */
public class File {
    private int fileId;
    private String fileName;
    private String url;//文件位置
    private String fileClass;//文件类型
    private int size;
    private String createBy;
    private String createTime;
    private int delFlag;
    private String delTime;
    private boolean isPrivater;
    public File(){}
    private File(Builder builder) {
        setFileId(builder.fileId);
        setFileName(builder.fileName);
        setUrl(builder.url);
        setFileClass(builder.fileClass);
        setSize(builder.size);
        setCreateBy(builder.createBy);
        setCreateTime(builder.createTime);
        setDelFlag(builder.delFlag);
        setDelTime(builder.delTime);
        isPrivater = builder.isPrivater;
    }

    public Integer getFileId(){ return fileId; }

    public void setFileId(int fileId){ this.fileId = fileId; }

    public String getFileName() { return fileName; }

    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    public String getFileClass() { return fileClass; }

    public void setFileClass(String fileClass) { this.fileClass = fileClass; }

    public int getSize() { return size; }

    public void setSize(int size) { this.size = size; }

    public String getCreateBy() { return createBy; }

    public void setCreateBy(String createBy) { this.createBy = createBy; }

    public String getCreateTime() { return createTime; }

    public void setCreateTime(String createTime) { this.createTime = createTime; }

    public int getDelFlag() { return delFlag; }

    public void setDelFlag(int delFlag) { this.delFlag = delFlag; }

    public String getDelTime() { return delTime; }

    public void setDelTime(String delTime) { this.delTime = delTime; }

    public boolean getIsPrivater() { return isPrivater; }

    public void setIsPrivater(boolean privater) { isPrivater = privater; }


    public static final class Builder {
        private int fileId;
        private String fileName;
        private String url;
        private String fileClass;
        private int size;
        private String createBy;
        private String createTime;
        private int delFlag;
        private String delTime;
        private boolean isPrivater;

        public Builder() {
        }

        public Builder fileId(int val) {
            fileId = val;
            return this;
        }

        public Builder fileName(String val) {
            fileName = val;
            return this;
        }

        public Builder url(String val) {
            url = val;
            return this;
        }

        public Builder fileClass(String val) {
            fileClass = val;
            return this;
        }

        public Builder size(int val) {
            size = val;
            return this;
        }

        public Builder createBy(String val) {
            createBy = val;
            return this;
        }

        public Builder createTime(String val) {
            createTime = val;
            return this;
        }

        public Builder delFlag(int val) {
            delFlag = val;
            return this;
        }

        public Builder delTime(String val) {
            delTime = val;
            return this;
        }

        public Builder isPrivater(boolean val) {
            isPrivater = val;
            return this;
        }

        public File build() {
            return new File(this);
        }
    }
}
