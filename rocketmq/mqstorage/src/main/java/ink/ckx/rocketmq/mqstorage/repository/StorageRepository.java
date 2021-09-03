package ink.ckx.rocketmq.mqstorage.repository;

import ink.ckx.rocketmq.mqstorage.domain.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author chenkaixin
 * @description
 * @since 2021/9/1
 */
@Repository
public interface StorageRepository extends JpaRepository<Storage, Integer> {

    Storage findByCommodityCode(String commodityCode);
}
