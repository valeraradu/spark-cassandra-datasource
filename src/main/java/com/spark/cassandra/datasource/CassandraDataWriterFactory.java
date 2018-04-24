package com.spark.cassandra.datasource;

import org.apache.spark.sql.Row;
import org.apache.spark.sql.sources.v2.writer.DataWriter;
import org.apache.spark.sql.sources.v2.writer.DataWriterFactory;

import java.util.Map;

public class CassandraDataWriterFactory implements DataWriterFactory<Row> {
    private final Map<String, String> dataSourceOptions;

    public CassandraDataWriterFactory(Map<String, String> dataSourceOptions) {
        this.dataSourceOptions = dataSourceOptions;
    }

    @Override
    public DataWriter<Row> createDataWriter(int partitionId, int attemptNumber) {
        return new CassandraDataWriter(dataSourceOptions);
    }
}
