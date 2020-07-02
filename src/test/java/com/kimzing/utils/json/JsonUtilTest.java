package com.kimzing.utils.json;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/2 14:48
 */
public class JsonUtilTest {

    Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    @Test
    public void testBeanToJson() {
        User user = getUser();
        String json = JsonUtil.beanToJson(user, "yyyy-MM-dd");
        logger.info("序列化所有属性+时间格式: {}", json);
        user.setAge(null);
        json = JsonUtil.beanToJson(user, "yyyy-MM-dd");
        logger.info("序列化null属性: {}", json);
        Map<String, User> map = getMap();
        logger.info("序列化map: {}", JsonUtil.beanToJson(map, "yyyy-MM-dd"));
        List<User> list = getList();
        logger.info("序列化list: {}", JsonUtil.beanToJson(list, "yyyy-MM-dd"));
    }

    @Test
    public void testJsonToBean() {
        String json = "{\"name\":\"KimZing\",\"age\":18,\"birth\":\"2020-07-02\"}";
        User user = JsonUtil.jsonToBean(json, User.class, "yyyy-MM-dd");
        logger.info("反序列化user对象: {}", user);

        json = "{\"KimZing\":{\"name\":\"KimZing\",\"age\":18,\"birth\":\"2020-07-02\"}}";
        Map<String, User> map = JsonUtil.jsonToMap(json, String.class, User.class, "yyyy-MM-dd");
        logger.info("反序列化mapr对象: {}", map);

        json = "[{\"name\":\"KimZing\",\"age\":18}]";
        List<User> list = JsonUtil.jsonToList(json, User.class, "yyyy-MM-dd");
        logger.info("反序列化list对象: {}", list);
    }


    private User getUser() {
        User user = new User();
        user.setName("KimZing");
        user.setAge(18);
        user.setBirth(LocalDateTime.now());
        return user;
    }

    private List<User> getList() {
        ArrayList<User> list = new ArrayList<>();
        list.add(getUser());
        return list;
    }

    private Map<String, User> getMap() {
        HashMap<String, User> map = new HashMap<>();
        map.put(getUser().getName(), getUser());
        return map;
    }

}
