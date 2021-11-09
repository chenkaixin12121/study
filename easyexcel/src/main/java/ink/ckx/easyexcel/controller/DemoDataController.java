package ink.ckx.easyexcel.controller;

import cn.hutool.json.JSONUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import ink.ckx.easyexcel.entity.DemoData;
import ink.ckx.easyexcel.excel.read.UploadDataListener;
import ink.ckx.easyexcel.service.DemoDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenkaixin
 * @since 2021/11/6
 */
@RequiredArgsConstructor
@Slf4j
@RestController
public class DemoDataController {

    private final DemoDataService demoDataService;

    @PostMapping("/upload")
    public void upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), DemoData.class, new UploadDataListener(demoDataService)).sheet().doRead();
    }

    @GetMapping("/download")
    public void download(HttpServletResponse response) throws IOException {
        try {
//            // 头的策略
//            WriteCellStyle headWriteCellStyle = new WriteCellStyle();
//            // 背景设置为红色
////            headWriteCellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
//            // 内容的策略
//            WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
//            // 这里需要指定 FillPatternType 为FillPatternType.SOLID_FOREGROUND 不然无法显示背景颜色.头默认了 FillPatternType所以可以不指定
//            contentWriteCellStyle.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
//            // 背景绿色
//            contentWriteCellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
//            // 这个策略是 头是头的样式 内容是内容的样式 其他的策略可以自己实现
//            HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);

            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");
            // 防止中文乱码
            String fileName = URLEncoder.encode("测试文件", "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            // 设置不导出某个字段
//            Set<String> excludeColumnFiledNames = new HashSet<>();
//            excludeColumnFiledNames.add("date");
            // 设置只导出某个字段
//            Set<String> includeColumnFiledNames = new HashSet<>();
//            includeColumnFiledNames.add("date");
            // 导出
            EasyExcel.write(response.getOutputStream(), DemoData.class)
//                    .excludeColumnFiledNames(excludeColumnFiledNames)
//                    .includeColumnFiledNames(includeColumnFiledNames)
//                    .registerWriteHandler(horizontalCellStyleStrategy) // 自定义样式
                    .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()) // 自动列宽
                    .autoCloseStream(Boolean.FALSE) // 不关闭流
                    .sheet("模板1") // sheet 名称
                    .doWrite(demoDataService.list());
        } catch (IOException e) {
            // 重置 response
            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            Map<String, String> map = new HashMap<>();
            map.put("status", "failure");
            map.put("message", "下载文件失败：" + e.getMessage());
            response.getWriter().println(JSONUtil.toJsonStr(map));
        }
    }
}
