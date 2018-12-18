package com.luchao.test;

import java.io.FileWriter;
import java.io.IOException;

public class demo01 {

    public static void main(String[] args) {
        String resultinfo="{\"name\":\"测试三、测试22、测试\",\"icon\":\"sgjt/thirdpart/group/1f66e63e0abe42b39716895b58c48159.png\",\"isManage\":true,\"_id\":\"0b05c57f9fe84d5b8b97979513fa8db3\",\"_class\":\"com.whenling.fingersoft.api.support.rongcloud.model.Group\",\"isRefreshName\":true,\"imids\":[\"156200\",\"156196\",\"106163\",\"156202\"],\"cid\":\"156200\"}";
        try {
            FileWriter writer = new FileWriter("D:/group.json");
            writer.write(resultinfo);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
