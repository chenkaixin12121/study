package ink.ckx.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.annotation.write.style.*;
import com.alibaba.excel.enums.poi.FillPatternTypeEnum;
import ink.ckx.easyexcel.excel.write.CustomStringStringConverter;
import lombok.Data;

import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDateTime;

/**
 * @author chenkaixin
 * @since 2021/11/6
 */
@Data
@ContentRowHeight(20)
@HeadRowHeight(30)
@ColumnWidth(25)
@HeadStyle(fillPatternType = FillPatternTypeEnum.SOLID_FOREGROUND, fillForegroundColor = 14)
public class DemoData {

    @ContentLoopMerge(eachRow = 2)
    @ExcelProperty(value = {"主标题", "字符串标题"}, converter = CustomStringStringConverter.class, index = 0)
    private String string;

    @ContentStyle(fillPatternType = FillPatternTypeEnum.SOLID_FOREGROUND, fillForegroundColor = 40)
    @DateTimeFormat("yyyy年MM月dd日HH时mm分ss秒")
    @ExcelProperty(value = {"主标题", "日期标题"}, index = 1)
    private LocalDateTime date;

    @NumberFormat("#.##%")
    @ExcelProperty(value = "数字标题", index = 3)
    private BigDecimal bigDecimal;

    /**
     * 忽略这个字段
     */
    @ExcelIgnore
    private URL url;
}
