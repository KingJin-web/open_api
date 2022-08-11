package com.king.open_api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jsoup.Jsoup;

/**
 * @author: King
 * @project: open_api
 * @date: 2022年08月05日 21:51
 * @description:
 */
@Data
@ApiModel(value = "历史上的今天信息")
public class TodayInHistory {
    @ApiModelProperty(value = "年份")
    private String year;
    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "节日")
    private String festival;
    @ApiModelProperty(value = "链接")
    private String link;
    @ApiModelProperty(value = "描述")
    private String desc;
}