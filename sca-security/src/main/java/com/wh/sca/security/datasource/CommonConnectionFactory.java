package com.wh.sca.security.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.apache.ibatis.mapping.Environment;

import javax.sql.DataSource;

public class CommonConnectionFactory extends SpringCloudConnectionFactory {

    public static class CommonConnectionFactoryHolder {
        private static final CommonConnectionFactory connFactory = new CommonConnectionFactory();
    }

    public static CommonConnectionFactory getInstance(){
        return CommonConnectionFactoryHolder.connFactory;
    }


    private CommonConnectionFactory(){
        try{

        }
    }


    private SqlSessionFactory sqlSessionFactory;
    private SqlSessionTemplate sqlSessionTemplate;

    private DataSource dataSource;

    public DataSource getDataSource(){
        return dataSource;
    }

    private DataSource buildDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();

        return druidDataSource;
    }

    private SqlSessionFactory getSqlSessionFactory() throws Exception {
        TransactionFactory transactionFactory = new JdbcTransactionFactory();

        Environment environment = new Environment("development", transactionFactory, getDataSource());

        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setEnvironment(environment);
        configuration.setLazyLoadingEnabled(true);
        configuration.addMappers("org.apache.dolphinscheduler.dao.mapper");
        configuration.addInterceptor(new PaginationInterceptor());

        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfiguration(configuration);
        sqlSessionFactoryBean.setDataSource(getDataSource());

        sqlSessionFactoryBean.setTypeEnumsPackage("org.apache.dolphinscheduler.*.enums");
        sqlSessionFactory = sqlSessionFactoryBean.getObject();

        return sqlSessionFactory;
    }

    private SqlSessionTemplate getSqlSessionTemplate() {
        sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }

    public SqlSession getSqlSession() {
        return sqlSessionTemplate;
    }

    public <T> T getMapper(Class<T> type){
        try{
            return getSqlSession().getMapper(type);
        }catch (Exception e){
            throw new RuntimeException("get mapper failed");
        }
    }



}
