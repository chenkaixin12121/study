package ink.ckx.sharding.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * 标准分片策略，分库或分表
 */
public class MyPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    /**
     * @param collection 所有分片库或者分片表的集合
     * @param preciseShardingValue 分片属性，logicTableName 逻辑表，logicTableName 分片键，value 分片键的值
     * @return
     */
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {

        for (String databaseName : collection) {
            String suffix = String.valueOf(preciseShardingValue.getValue() % collection.size());
            if (databaseName.endsWith(suffix)) {
                return databaseName;
            }
        }
        throw new IllegalArgumentException();
    }
}