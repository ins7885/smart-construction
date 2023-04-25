package com.zkjd.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zkjd.common.annotation.Excel;
import com.zkjd.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 标准规范对象 tab_standard
 *
 * @author zkjd
 * @date 2022-01-27
 */
public class Standard extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long standardId;

    /** 标准名称 */
    @Excel(name = "标准名称")
    private String name;

    /** 标准类型 */
    @Excel(name = "标准类型")
    private String type;

    /** 标准内容 */
    @Excel(name = "标准内容")
    private String content;

    /** 文件格式 */
    @Excel(name = "文件格式")
    private String fileFormat;

    /** 文件大小（单位：KB） */
    @Excel(name = "文件大小", readConverterExp = "单位：KB")
    private Long fileSize;

    /** 上传人 */
    @Excel(name = "上传人")
    private String uploader;

    /** 上传时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上传时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date uploadTime;

    /** 删除标记 */
    private Integer delFlag;

    /** 文件名 */
    private String fileName;

    private String filePath;

    public void setStandardId(Long standardId)
    {
        this.standardId = standardId;
    }

    public Long getStandardId()
    {
        return standardId;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setFileFormat(String fileFormat)
    {
        this.fileFormat = fileFormat;
    }

    public String getFileFormat()
    {
        return fileFormat;
    }
    public void setFileSize(Long fileSize)
    {
        this.fileSize = fileSize;
    }

    public Long getFileSize()
    {
        return fileSize;
    }
    public void setUploader(String uploader)
    {
        this.uploader = uploader;
    }

    public String getUploader()
    {
        return uploader;
    }
    public void setUploadTime(Date uploadTime)
    {
        this.uploadTime = uploadTime;
    }

    public Date getUploadTime()
    {
        return uploadTime;
    }
    public void setDelFlag(Integer delFlag)
    {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag()
    {
        return delFlag;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("standardId", getStandardId())
                .append("name", getName())
                .append("type", getType())
                .append("content", getContent())
                .append("fileFormat", getFileFormat())
                .append("fileSize", getFileSize())
                .append("uploader", getUploader())
                .append("uploadTime", getUploadTime())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("fileName", getFileName())
                .append("filePath", getFilePath())
                .toString();
    }
}

