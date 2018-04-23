package com.spark.cassandra.datasource;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.execution.streaming.Offset;
import org.apache.spark.sql.execution.streaming.Source;
import org.apache.spark.sql.types.StructType;
import scala.Option;

public class CassandraSource implements Source {
    @Override
    public StructType schema() {
        return null;
    }

    @Override
    public Option<Offset> getOffset() {
        return null;
    }

    @Override
    public Dataset<Row> getBatch(Option<Offset> option, Offset offset) {
        return null;
    }

    @Override
    public void commit(Offset offset) {

    }

    @Override
    public void stop() {

    }
}
