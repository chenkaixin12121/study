package ink.ckx.sharding.algorithm;

import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.ArrayList;
import java.util.Collection;

public class MyHintShardingAlgorithm implements HintShardingAlgorithm<Integer> {

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, HintShardingValue<Integer> shardingValues) {
        Collection<String> result = new ArrayList<>();
        for (String tableName : availableTargetNames) {
            for (Integer shardingValue : shardingValues.getValues()) {
                String suffix = String.valueOf(shardingValue % availableTargetNames.size());
                if (tableName.endsWith(suffix)) {
                    result.add(tableName);
                }
            }
        }
        return result;
    }
}
