package com.zkjd.web.controller.afacedevice;

import lombok.Data;

/**
 * @PackageName: com.zkjd.web.controller.afacedevice
 * @ProjectName: intelligent-monitor-server
 * @Description:
 * @version: v1.0.0
 * @author: HuangXiang Email:HuangXiang@youotech.com
 * @date: 2023-04-07  0:02
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2023-04-07     HuangXiang           v1.0.0            创建文件
 */

@Data
public class FaceImgeDeal {
    private Long userId;
    private String deviceSerial;
    private String devicePassword;
}
