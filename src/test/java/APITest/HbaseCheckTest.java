package APITest;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.hadoop.hbase.client.ColumnFamilyDescriptor;
import org.apache.hadoop.hbase.client.ColumnFamilyDescriptorBuilder;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.jupiter.api.Test;
import ru.resful.booker.DB.nosql.hbase.connection.ConnectionFactory;
import ru.resful.booker.DB.nosql.hbase.dataHelpers.ColumnLinkBuilder;
import ru.resful.booker.DB.nosql.hbase.interfaces.EntryOperations;
import ru.resful.booker.DB.nosql.hbase.interfaces.TableOperations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HbaseCheckTest {

    //todo parametrized tests?
    Connection c = ConnectionFactory.getConnection();
    TableOperations tableOperations = new TableOperations(c);


    @Test
    public void addTableTest() {
        List<ColumnFamilyDescriptor> columnFamilyDescriptors = new ArrayList<>();
        columnFamilyDescriptors.add(ColumnFamilyDescriptorBuilder.newBuilder(Bytes.toBytes("familyThreeVersions")).setMaxVersions(3).build());
        columnFamilyDescriptors.add(ColumnFamilyDescriptorBuilder.newBuilder(Bytes.toBytes("familyTwoVersions")).setMaxVersions(2).build());


        String tbn = RandomStringUtils.random(4, true, false);
        tableOperations.createTable(
                tbn,
                columnFamilyDescriptors);

        new EntryOperations(c).addDataToTable(
                new ColumnLinkBuilder()
                        .setTableName(tbn)
                        .setColumnFamilyName("familyThreeVersions")
                        .setRowKeyName("familyThreeVersions")
                        .setColumnName("asd")

                        .build(), Collections.singletonList(Bytes.toBytes("fawfawf")));

        System.out.println();
        //todo checks
    }

    @Test
    public void deleteTableTest() {
        List<ColumnFamilyDescriptor> columnFamilyDescriptors = new ArrayList<>();
        columnFamilyDescriptors.add(ColumnFamilyDescriptorBuilder.newBuilder(Bytes.toBytes("familyThreeVersions")).setMaxVersions(3).build());
        columnFamilyDescriptors.add(ColumnFamilyDescriptorBuilder.newBuilder(Bytes.toBytes("familyTwoVersions")).setMaxVersions(2).build());

        String tableName = RandomStringUtils.random(4, true, false);

        tableOperations.createTable(
                tableName,
                columnFamilyDescriptors);

        //todo checks
    }

}
