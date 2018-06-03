package com.zhangyaobin.news.config;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Properties;

/**
 * 功能详细描述
 *
 * @author Chenlm
 * @version 2016-04-17-20:12
 */
@Slf4j
@Configuration
@EntityScan(value = "com.zhangyaobin.news.entity")
@EnableJpaRepositories("com.zhangyaobin.news.repository")
@MapperScan(value = "com.zhangyaobin.news.mapper")
public class MapperConfiguration {

}
