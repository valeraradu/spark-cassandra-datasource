package com.spark.cassandra.datasource;

import org.apache.spark.sql.Row;
import org.apache.spark.sql.sources.v2.reader.DataReaderFactory;
import org.apache.spark.sql.sources.v2.reader.streaming.ContinuousReader;
import org.apache.spark.sql.sources.v2.reader.streaming.Offset;
import org.apache.spark.sql.sources.v2.reader.streaming.PartitionOffset;
import org.apache.spark.sql.types.StructType;

import java.util.List;
import java.util.Optional;

public class CassandraContinuousReader implements ContinuousReader {
    @Override
    public Offset mergeOffsets(PartitionOffset[] partitionOffsets) {
        return null;
    }

    @Override
    public Offset deserializeOffset(String s) {
        return null;
    }

    @Override
    public void setStartOffset(Optional<Offset> optional) {

    }

    @Override
    public Offset getStartOffset() {
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
