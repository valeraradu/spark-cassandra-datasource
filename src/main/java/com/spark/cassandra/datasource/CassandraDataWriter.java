package com.spark.cassandra.datasource;

import com.datastax.driver.core.Session;
import com.datastax.spark.connector.cql.CassandraConnector;
import com.datastax.spark.connector.writer.BoundStatementBuilder;
import com.datastax.spark.connector.writer.SqlRowWriter;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.cassandra.CassandraSQLRow;
import org.apache.spark.sql.sources.v2.writer.DataWriter;
import org.apache.spark.sql.sources.v2.writer.WriterCommitMessage;
import scala.runtime.AbstractFunction1;

public class CassandraDataWriter implements DataWriter<Row> {

    private final CassandraConnector cassandraConnector;

    public CassandraDataWriter() {
        cassandraConnector = CassandraConnector.apply(
                SparkSession.builder().getOrCreate().sparkContext().getConf());
    }

    @Override
    public void write(Row record) {


        new BoundStatementBuilder().bind(record);

       new  SqlRowWriter().

        saveToCassandra() SqlRowWriter.Factory

        cassandraConnector.withSessionDo(new AbstractFunction1<Session, Void>() {
            @Override
            public Void apply(Session session) {
                /*session.execute(String.format("CREATE KEYSPACE IF NOT EXISTS %s WITH " +
                        "replication = {'class': 'SimpleStrategy', 'replication_factor': 1}",
                        keyspace));*/
                session.execute(String.format("CREATE TABLE %s.%s " +
                        "(id INT PRIMARY KEY, name TEXT, parents LIST<INT>)",
                        keyspace, tablename));
                session.execute("INSERT INTO ${quote(keyspaceName)}.${quote(tableName)}" +
                        " ($columnSpec) VALUES ($valueSpec))");
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
