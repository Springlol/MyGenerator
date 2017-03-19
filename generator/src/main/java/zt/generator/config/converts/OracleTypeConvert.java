package zt.generator.config.converts;


import zt.generator.config.ITypeConvert;
import zt.generator.config.rules.DbColumnType;

/**
 * <p>
 * ORACLE 字段类型转换
 * </p>
 */
public class OracleTypeConvert implements ITypeConvert {

    public DbColumnType processTypeConvert(String fieldType) {
        String t = fieldType.toUpperCase();
        if (t.contains("CHAR")) {
            return DbColumnType.STRING;
        } else if (t.contains("DATE") || t.contains("TIMESTAMP")) {
            return DbColumnType.DATE;
        } else if (t.contains("NUMBER")) {
            if (t.matches("NUMBER\\(+\\d{1}+\\)")) {
                return DbColumnType.INTEGER;
            } else if (t.matches("NUMBER\\(+\\d{2}+\\)")) {
                return DbColumnType.LONG;
            }
            return DbColumnType.DOUBLE;
        } else if (t.contains("FLOAT")) {
            return DbColumnType.FLOAT;
        } else if (t.contains("BLOB")) {
            return DbColumnType.OBJECT;
        } else if (t.contains("RAW")) {
            return DbColumnType.BYTE_ARRAY;
        }
        return DbColumnType.STRING;
    }

}
