package com.spark.cassandra.datasource;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.execution.streaming.Sink;

public class CassandraSink implements Sink {
    @Override
    public void addBatch(long l, Dataset<Row> dataset) {

    }
}
