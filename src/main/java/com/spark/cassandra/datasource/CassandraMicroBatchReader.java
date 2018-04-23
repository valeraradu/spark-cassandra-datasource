package com.spark.cassandra.datasource;

import org.apache.spark.sql.Row;
import org.apache.spark.sql.sources.v2.reader.DataReaderFactory;
import org.apache.spark.sql.sources.v2.reader.streaming.MicroBatchReader;
import org.apache.spark.sql.sources.v2.reader.streaming.Offset;
import org.apache.spark.sql.types.StructType;

import java.util.List;
import java.util.Optional;

public class CassandraMicroBatchReader implements MicroBatchReader {
    @Override
    public void setOffsetRange(Optional<Offset> optional, Optional<Offset> optional1) {

    }

    @Override
    public Offset getStartOffset() {
        return null;
    }

    @Override
    public Offset getEndOffset() {
        //todo implement this
        return null;
    }

    @Override
    public Offset deserializeOffset(String s) {
        return null;
    }

    @Override
    public void commit(Offset offset) {

    }

    @Override
    public void stop() {

    }

    @Override
    public StructType readSchema() {
        return null;
    }

    @Override
    public List<DataReaderFactory<Row>> createDataReaderFactories() {
        return null;
    }
}
