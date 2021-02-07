package com.yoong.springfx.book01.service.impl;

import com.yoong.springfx.book01.service.IQuoteService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

public class QuoteServiceImpl implements IQuoteService {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    @Override
    public Object updateAccount() {
        jdbcTemplate.execute("UPDATE `wong_user`.`account` SET account_id = '11111' WHERE id = '1'");
        jdbcTemplate.execute("INSERT INTO `wong_user`.`account` (`account_id`, `password`, `contact_name`, `mobile`, `create_time`, `modify_time`) VALUES ('22222', 'password', 'name', 'mobile', NOW(), NOW())");
        return null;
    }

    @Override
    public Object updateAdmin() {
        return null;
    }
}
