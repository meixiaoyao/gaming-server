package com.ooqiu.gaming.server.web.admin.utils;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ooqiu.gaming.server.commons.constant.DubboVersionConstant;
import com.ooqiu.gaming.server.service.admin.api.DictService;
import org.springframework.stereotype.Component;

/**dubbo 上下文
 * <p>Title: DubboContextUtils </p>
 * <p>Description: </p>
 *
 * @author: Eve
 * @version: 1.0.0
 * @Date: 8:50 2018/3/9
 */
@Component
public class DubboContextUtils {
    @Reference(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_ADMIN)
    private DictService dictService;

    public DictService getDictService(){
        return dictService;
    }
}
