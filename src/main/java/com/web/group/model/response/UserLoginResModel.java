package com.web.group.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("用户登录返回")
public class UserLoginResModel implements Serializable {
    private static final long serialVersionUID = 1486007530957386815L;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("token")
    private String token;

}
