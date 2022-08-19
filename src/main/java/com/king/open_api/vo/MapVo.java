package com.king.open_api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: King
 * @project: open_api
 * @date: 2022年08月17日 22:49
 * @description:
 */
@ApiModel(value = "地址信息")
@NoArgsConstructor
@Data
public class MapVo {
//    @ApiModelProperty(value = "省份")
//    private String province;
//    @ApiModelProperty(value = "城市")
//    private String city;
//    @ApiModelProperty(value = "区县")
//    private String district;
    @ApiModelProperty(value = "详细地址")
    private String detail;
    @ApiModelProperty(value = "经度")
    private String longitude;
    @ApiModelProperty(value = "纬度")
    private String latitude;

    public MapVo(String longitude, String latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public MapVo(String detail, String longitude, String latitude) {
        this.detail = detail;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}