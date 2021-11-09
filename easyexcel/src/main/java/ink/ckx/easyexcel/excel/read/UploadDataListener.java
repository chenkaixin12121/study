package ink.ckx.easyexcel.excel.read;

import cn.hutool.json.JSONUtil;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import ink.ckx.easyexcel.entity.DemoData;
import ink.ckx.easyexcel.service.DemoDataService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenkaixin
 * @since 2021/11/6
 */
@Slf4j
public class UploadDataListener extends AnalysisEventListener<DemoData> {

    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */
    private final DemoDataService demoDataService;
    List<DemoData> demoDataList = new ArrayList<>();

    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     *
     * @param demoDataService
     */
    public UploadDataListener(DemoDataService demoDataService) {
        this.demoDataService = demoDataService;
    }

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data    one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context
     */
    @Override
    public void invoke(DemoData data, AnalysisContext context) {
        log.info("解析到一条数据：{}", JSONUtil.toJsonStr(data));
        demoDataList.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (demoDataList.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            demoDataList.clear();
        }
    }

    /**
     * 所有数据解析完成了，都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        log.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        if (demoDataList.size() > 0) {
            log.info("{}条数据，开始存储数据库！", demoDataList.size());
            demoDataService.saveBatch(demoDataList);
            log.info("存储数据库成功！");
        }
    }
}
