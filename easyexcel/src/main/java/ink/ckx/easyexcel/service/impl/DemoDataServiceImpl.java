package ink.ckx.easyexcel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ink.ckx.easyexcel.entity.DemoData;
import ink.ckx.easyexcel.mapper.DemoDataMapper;
import ink.ckx.easyexcel.service.DemoDataService;
import org.springframework.stereotype.Service;

/**
 * @author chenkaixin
 * @since 2021/11/8
 */
@Service
public class DemoDataServiceImpl extends ServiceImpl<DemoDataMapper, DemoData> implements DemoDataService {
}
