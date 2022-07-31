package com.maxqaq.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: yinxue-admin
 * @description:
 * @author: max-qaq
 * @create: 2022-07-29 19:33
 **/
@Data
public class AdminDTO {
    //@JsonFormat //用来修改转换日期时间格式
    @JsonProperty("name")
    private String username;

    private String avatar;

    public AdminDTO() {
    }

    public AdminDTO(String username, String avatar) {
        this.username = username;
        this.avatar = avatar;
    }
}
