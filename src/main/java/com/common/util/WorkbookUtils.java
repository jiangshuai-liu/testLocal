package com.common.util;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.word.WordExportUtil;
import com.common.constants.ContentTypeMapping;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @author 赵旭
 * <p>
 * 导出模版
 */
public class WorkbookUtils {

    public static void exportTemplate(TemplateExportParams params, Map<String, Object> map, String fileName) throws IOException {
        flush(ExcelExportUtil.exportExcel(params, map), fileName);
    }

    public static void flush(Workbook workbook, String fileName) throws IOException {
        try {
            if (workbook == null) return;
            String fileType = "." + FileTypeUtils.getFileType(fileName);
            HttpServletResponse response = ServletUtils.getResponse();
            response.setContentType(ContentTypeMapping.getContentType(fileType));
            response.setCharacterEncoding("utf-8");
            String encodeFileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=" + encodeFileName);
            workbook.write(response.getOutputStream());
        } finally {
            IOUtils.closeQuietly(workbook);
        }
    }

    /**
     * 描述：  <b color=yellow>导出Word模版</b>
     *
     * @param templateUrl 模版路径
     * @param fileName    文件名
     * @param map         参数
     * @return void
     * @author Asahi
     * @time 2023/4/6 18:44
     */
    public static void exportWordTemplate(String templateUrl, String fileName, Map<String, Object> map) {
        try {
            XWPFDocument doc = WordExportUtil.exportWord07(templateUrl, map);
            HttpServletResponse response = ServletUtils.getResponse();
            fileName = URLEncoder.encode(fileName + ".docx", "utf-8");
            response.setContentType(ContentTypeMapping.getContentType(".docx"));
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            doc.write(response.getOutputStream());
            IOUtils.closeQuietly(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
