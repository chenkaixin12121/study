package ink.ckx.sharding.algorithm;

import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class MyComplexKeysShardingAlgorithm implements ComplexKeysShardingAlgorithm<Long> {

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, ComplexKeysShardingValue<Long> shardingValue) {
        // 得到每个分片健对应的值
        Map<String, Collection<Long>> columnNameAndShardingValuesMap = shardingValue.getColumnNameAndShardingValuesMap();
        Collection<Long> orderIdValues = columnNameAndShardingValuesMap.get("order_id");
        Collection<Long> userIdValues = columnNameAndShardingValuesMap.get("user_id");
        // 对两个分片健同时取模的方式分库
        List<String> shardingSuffix = new ArrayList<>();
        for (Long userId : userIdValues) {
            for (Long orderId : orderIdValues) {
                String suffix = userId % 2 + "_" + orderId % 2;
                for (String databaseName : availableTargetNames) {
                    if (databaseName.endsWith(suffix)) {
                        shardingSuffix.add(databaseName);
                    }
                }
            }
        }
        return shardingSuffix;
    }
}
