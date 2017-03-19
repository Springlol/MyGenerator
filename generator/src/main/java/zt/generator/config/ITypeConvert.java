package zt.generator.config;


import zt.generator.config.rules.DbColumnType;

/**
 * <p>
 * 数据库字段类型转换
 * </p>
 */
public interface ITypeConvert {

    /**
     * <p>
     * 执行类型转换
     * </p>
     *
     * @param fieldType 字段类型
     * @return
     */
    DbColumnType processTypeConvert(String fieldType);

}
