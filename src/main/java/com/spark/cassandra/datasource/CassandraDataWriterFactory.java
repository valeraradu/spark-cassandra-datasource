package com.spark.cassandra.datasource;

import org.apache.spark.sql.Row;
import org.apache.spark.sql.sources.v2.writer.DataWriter;
import org.apache.spark.sql.sources.v2.writer.DataWriterFactory;

public class CassandraDataWriterFactory implements DataWriterFactory<Row> {
    @Override
    public DataWriter<Row> createDataWriter(int partitionId, int attemptNumber) {
        return new CassandraDataWriter();
    }
}
