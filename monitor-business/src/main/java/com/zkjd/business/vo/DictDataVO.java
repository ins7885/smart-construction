package com.zkjd.business.vo;

import com.zkjd.common.core.domain.entity.SysDictData;

import java.util.List;

/**
 * @author: Xu Xiang  @createTime: 2021/11/16 9:56
 * Description: 封装app中检查类别列表数据
 */
public class DictDataVO {
    /** 字典标签 */
    private String dictLabel;

    /** 字典标签数据列表 */
    private List<SysDictData> dictDataList;

    public DictDataVO(String dictLabel, List<SysDictData> dictDataList) {
        this.dictLabel = dictLabel;
        this.dictDataList = dictDataList;
    }

    public DictDataVO() {
    }

    public String getDictLabel() {
        return dictLabel;
    }

    public void setDictLabel(String dictLabel) {
        this.dictLabel = dictLabel;
    }

    public List<SysDictData> getDictDataList() {
        return dictDataList;
    }

    public void setDictDataList(List<SysDictData> dictDataList) {
        this.dictDataList = dictDataList;
    }

    @Override
    public String toString() {
        return "DictDataVO{" +
                "dictLabel='" + dictLabel + '\'' +
                ", dictDataList=" + dictDataList +
                '}';
    }
}
