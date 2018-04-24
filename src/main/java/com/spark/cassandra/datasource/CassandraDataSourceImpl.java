package com.spark.cassandra.datasource;

import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.cassandra.DefaultSource;
import org.apache.spark.sql.execution.streaming.Sink;
import org.apache.spark.sql.execution.streaming.Source;
import org.apache.spark.sql.sources.v2.DataSourceOptions;
import org.apache.spark.sql.sources.v2.reader.streaming.ContinuousReader;
import org.apache.spark.sql.sources.v2.reader.streaming.MicroBatchReader;
import org.apache.spark.sql.sources.v2.writer.streaming.StreamWriter;
import org.apache.spark.sql.streaming.OutputMode;
import org.apache.spark.sql.types.StructType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.Option;
import scala.Tuple2;
import scala.collection.Seq;
import scala.collection.immutable.Map;

import java.util.Optional;

public class CassandraDataSourceImpl
        extends DefaultSource implements CassandraDataSource {

    private static transient Logger log = LoggerFactory
            .getLogger(CassandraDataSourceImpl.class);


    @Override
    public String shortName() {
        return "cassandra";
    }

    @Override
    public StreamWriter createStreamWriter(String s,
                                           StructType structType,
                                           OutputMode outputMode,
                                           DataSourceOptions dataSourceOptions) {

        return new CassandraStreamWriter(dataSourceOptions.asMap());
    }

    @Override
    public Sink createSink(SQLContext sqlContext,
                           Map<String, String> map,
                           Seq<String> seq,
                           OutputMode outputMode) {
        return new CassandraSink();
    }

    @Override
    public Tuple2<String, StructType> sourceSchema(SQLContext sqlContext,
                                                   Option<StructType> option,
                                                   String s,
                                                   Map<String, String> map) {
        return null;
    }

    @Override
    public Source createSource(SQLContext sqlContext,
                               String s,
                               Option<StructType> option,
                               String s1,
                               Map<String, String> map) {

        return new CassandraSource();
    }

    @Override
    public ContinuousReader createContinuousReader(Optional<StructType> optional,
                                                   String s,
                                                   DataSourceOptions dataSourceOptions) {
        return new CassandraContinuousReader();
    }

    @Override
    public MicroBatchReader createMicroBatchReader(Optional<StructType> optional,
                                                   String s,
                                                   DataSourceOptions dataSourceOptions) {
        return new CassandraMicroBatchReader();
    }
}
