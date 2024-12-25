package io.github.shangxinbuyu.practicaltraining.domin.po;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Vote {
    /**主键ID*/
    private Integer id;
    /**发布时间*/
    private LocalDateTime publishTime;
    /**标题*/
    private String title;
    /**发布人*/
    private String publishBy;
    /**状态*/
    private String state;
}
