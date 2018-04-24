package com.spark.cassandra.datasource;

import org.apache.spark.sql.Row;
import org.apache.spark.sql.sources.v2.writer.DataWriterFactory;
import org.apache.spark.sql.sources.v2.writer.WriterCommitMessage;
import org.apache.spark.sql.sources.v2.writer.streaming.StreamWriter;

import java.util.Map;

public class CassandraStreamWriter implements StreamWriter {

    private final Map<String, String> dataSourceOptions;

    public CassandraStreamWriter(Map<String, String> dataSourceOptions) {
        this.dataSourceOptions = dataSourceOptions;
    }

    @Override
    public void commit(long l, WriterCommitMessage[] writerCommitMessages) {

    }

    @Override
    public void abort(long l, WriterCommitMessage[] writerCommitMessages) {

    }

    @Override
    public DataWriterFactory<Row> createWriterFactory() {

        return new CassandraDataWriterFactory(dataSourceOptions);
    }
}
