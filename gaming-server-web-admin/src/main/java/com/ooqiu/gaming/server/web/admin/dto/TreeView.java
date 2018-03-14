package com.ooqiu.gaming.server.web.admin.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Title: ${CLASS_NAME} </p>
 * <p>Description: </p>
 *
 * @author Eve
 * @version 1.0.0
 * @date 上午 9:53 2018/3/2 0002
 */
@Data
public class TreeView implements Serializable{
    private String id;
    private String icon;
    private String text;
    private boolean children;
}
