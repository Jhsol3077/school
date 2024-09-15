package com.common;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Template {

    private static SqlSessionFactory sqlSessionFactory;

    // static 초기화 블록을 통해 SqlSessionFactory를 생성
    static {
        try {
            // MyBatis 설정 파일 경로
            String resource = "mybatis-config.xml";
            InputStream inputStream = Template.class.getClassLoader().getResourceAsStream(resource);

            // SqlSessionFactory 생성
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("SqlSessionFactory 생성 중 오류 발생", e);
        }
    }

    // SqlSession을 반환하는 메소드 (AutoCommit 설정 가능)
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession(false); // AutoCommit을 false로 설정
    }

    // SqlSession을 반환하는 메소드 (AutoCommit 설정을 사용자 정의)
    public static SqlSession getSqlSession(boolean autoCommit) {
        return sqlSessionFactory.openSession(autoCommit);
    }
}
