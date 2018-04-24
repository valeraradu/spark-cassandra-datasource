package com.spark.cassandra.datasource;


import com.datastax.driver.core.Session;
import com.datastax.spark.connector.cql.CassandraConnector;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.sources.v2.writer.DataWriter;
import org.apache.spark.sql.sources.v2.writer.WriterCommitMessage;
import scala.collection.Seq;
import scala.runtime.AbstractFunction1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CassandraDataWriter implements DataWriter<Row> {

    private final CassandraConnector cassandraConnector;
    private final Map<String, String> dataSourceOptions;

    public CassandraDataWriter(Map<String, String> dataSourceOptions) {
        this.dataSourceOptions = dataSourceOptions;
        cassandraConnector = CassandraConnector.apply(
                SparkSession.builder().getOrCreate().sparkContext().getConf());
    }


    @Override
    public void write(Row record) {

        String keySpace = dataSourceOptions.get("keyspace");
        String table = dataSourceOptions.get("table");

        List<String> fieldNames = Arrays.asList(record.schema().fieldNames());

        Seq<String> seq = scala.collection.JavaConverters.asScalaBufferConverter(
                fieldNames)
                .asScala().toSeq();

        String columns = String.join(", ", fieldNames);
        String values = record.getValuesMap(seq).values().mkString(", ");

        cassandraConnector.withSessionDo(new AbstractFunction1<Session, Void>() {
            @Override
            public Void apply(Session session) {

                session.execute(String.format("INSERT INTO %s.%s" +
                        " (%s) VALUES (%s)", keySpace, table, columns, values));
                return null;
            }
        });
    }

    @Override
    public WriterCommitMessage commit() {
        return null;
    }

    @Override
    public void abort() {

    }
}
