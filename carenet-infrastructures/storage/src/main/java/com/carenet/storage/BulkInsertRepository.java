package com.carenet.storage;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BulkInsertRepository {

    private final JdbcTemplate jdbcTemplate;

    public <T> void  bulkInsert(String query, List<T> list, ParameterizedPreparedStatementSetter<T> pss) {
        jdbcTemplate.batchUpdate(query, list, list.size(), pss);
    }

}
