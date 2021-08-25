package ink.ckx.seata.storage.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ink.ckx.seata.storage.entity.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StorageDAO extends BaseMapper<Storage> {
}
