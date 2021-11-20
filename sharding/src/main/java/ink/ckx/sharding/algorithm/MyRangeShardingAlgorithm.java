package ink.ckx.sharding.algorithm;

import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 范围分片算法
 */
public class MyRangeShardingAlgorithm implements RangeShardingAlgorithm<Integer> {

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Integer> shardingValue) {
        Range<Integer> valueRange = shardingValue.getValueRange();
        Set<String> result = new LinkedHashSet<>();
        for (int i = valueRange.lowerEndpoint(); i <= valueRange.upperEndpoint(); i++) {
            for (String databaseName : availableTargetNames) {
                String suffix = String.valueOf(i % availableTargetNames.size());
                if (databaseName.endsWith(suffix)) {
                    result.add(databaseName);
                }
            }
        }
        return result;
    }
}