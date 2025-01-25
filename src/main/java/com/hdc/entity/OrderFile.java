package com.hdc.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class OrderFile implements Serializable {
    /**
     * 申请单文件ID
     */
    private Long orderFileId;

    /**
     * 申请单ID
     */
    private Long orderId;

    /**
     * 上传的教师ID
     */
    private Integer teacherId;

    /**
     * 服务器保存的文件名称
     */
    private String saveFileName;

    /**
     * 上传时原始的文件名称
     */
    private String originFileName;

    /**
     * 文件大小，单位为B
     */
    private Long size;

    /**
     * 服务器中文件的URl
     */
    private String fileUrl;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getOrderFileId() {
        return orderFileId;
    }

    public void setOrderFileId(Long orderFileId) {
        this.orderFileId = orderFileId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getSaveFileName() {
        return saveFileName;
    }

    public void setSaveFileName(String saveFileName) {
        this.saveFileName = saveFileName;
    }

    public String getOriginFileName() {
        return originFileName;
    }

    public void setOriginFileName(String originFileName) {
        this.originFileName = originFileName;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OrderFile other = (OrderFile) that;
        return (this.getOrderFileId() == null ? other.getOrderFileId() == null : this.getOrderFileId().equals(other.getOrderFileId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getTeacherId() == null ? other.getTeacherId() == null : this.getTeacherId().equals(other.getTeacherId()))
            && (this.getSaveFileName() == null ? other.getSaveFileName() == null : this.getSaveFileName().equals(other.getSaveFileName()))
            && (this.getOriginFileName() == null ? other.getOriginFileName() == null : this.getOriginFileName().equals(other.getOriginFileName()))
            && (this.getSize() == null ? other.getSize() == null : this.getSize().equals(other.getSize()))
            && (this.getFileUrl() == null ? other.getFileUrl() == null : this.getFileUrl().equals(other.getFileUrl()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderFileId() == null) ? 0 : getOrderFileId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getTeacherId() == null) ? 0 : getTeacherId().hashCode());
        result = prime * result + ((getSaveFileName() == null) ? 0 : getSaveFileName().hashCode());
        result = prime * result + ((getOriginFileName() == null) ? 0 : getOriginFileName().hashCode());
        result = prime * result + ((getSize() == null) ? 0 : getSize().hashCode());
        result = prime * result + ((getFileUrl() == null) ? 0 : getFileUrl().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderFileId=").append(orderFileId);
        sb.append(", orderId=").append(orderId);
        sb.append(", teacherId=").append(teacherId);
        sb.append(", saveFileName=").append(saveFileName);
        sb.append(", originFileName=").append(originFileName);
        sb.append(", size=").append(size);
        sb.append(", fileUrl=").append(fileUrl);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}