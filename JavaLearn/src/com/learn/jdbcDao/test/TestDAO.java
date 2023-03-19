package com.learn.jdbcDao.test;

import com.learn.jdbcDao.dao.ActorDao;
import com.learn.jdbcDao.domain.Actor01;

import java.util.List;

/**
 * @author: shuxy
 * @date: 2023/3/13
 * @description:
 */
public class TestDAO {
    public static void main(String[] args) {
        testActorDAO();
    }
    public static void testActorDAO() {
        ActorDao actorDao = new ActorDao();

        List<Actor01> actors = actorDao.queryMulti("select * from test01 where id >= ?",
                Actor01.class, 1);

        for (Actor01 actor : actors) {
            System.out.println(actor);
        }
    }
}
