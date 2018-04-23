package com.spark.cassandra.datasource;


import com.datastax.spark.connector.util.Logging;
import org.apache.spark.sql.sources.*;
import org.apache.spark.sql.sources.v2.ContinuousReadSupport;
import org.apache.spark.sql.sources.v2.MicroBatchReadSupport;
import org.apache.spark.sql.sources.v2.StreamWriteSupport;

public interface CassandraDataSource extends
        DataSourceRegister,
        StreamSourceProvider,
        StreamSinkProvider,
        RelationProvider,
        CreatableRelationProvider,
        StreamWriteSupport,
        ContinuousReadSupport,
        MicroBatchReadSupport,
        Logging {

}
