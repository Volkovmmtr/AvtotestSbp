package ru.resful.booker.DB.nosql.hbase.dataHelpers;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


/***
 * tableName имя таблицы в БД
 * rowKeyName первичный ключ таблицы
 * columnFamilyName имя семейства столбцов (Column Family)
 * columnName имя семейства столбцов (Column Family)
 */

@Getter
@Setter
@Accessors(chain = true)
public class ColumnLinkBuilder {
    String tableName;
    String rowKeyName;
    String columnFamilyName;
    String columnName;

    public ColumnLink build() {

        assert tableName != null;
        assert rowKeyName != null;
        assert columnFamilyName != null;
        assert columnName != null;

        return new ColumnLink(tableName, rowKeyName, columnFamilyName, columnName);
    }
}
