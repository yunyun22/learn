//package demo.wangjq.base.excel;
//
//
//import org.apache.commons.collections.map.HashedMap;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.ss.util.CellRangeAddress;
//import org.junit.Test;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//
///**
// * @author:wangjq
// * @Date: 2019/4/18 09:17
// */
//public class GenerateSqlTest {
//
//
//    public static String sql = "INSERT INTO tax_base.dbo.SYS_USER(" +
//            "USER_ID, USERNAME, PASSWORD_,salt, PHONE," +//1
//            "LOCK_FLAG, DEL_FLAG, TENANT_ID, STAFF_LEVEL, STAFF_NO," +//2
//            " SERVICE_GROUP, SERVICE_GROUP_DESC, CNAME_, ENAME_, AREA, DEPARTMENT, EMAIL)\n" +//3
//            "VALUES(NEWID(), '%s', '$2a$10$71xj0yqwrayf/hFwu1SlY.OrUS/7iIkZLND7ZZtUMrZ33C1CP/W6G', '','19944466600'," +//1
//            " 0, 0, 'FA', 'Senior Senior SII', '%s', " +//2
//            "'%s', '', '%s', '%s', '%s', '%s', '%s');";//3
//
//    @Test
//    public void testReadExcel() {
//        List<Map<Integer, Object>> excel = readExcelToObj("C:\\Users\\jinqwang\\Desktop\\UAT2.xlsx");
//        System.out.println(excel);
//
//
//        String[] s = excel.stream()
//                .filter(integerObjectMap -> Objects.equals(integerObjectMap.get(0), "MIC") || Objects.equals(integerObjectMap.get(0), "PIC"))
//                .map(integerObjectMap -> integerObjectMap.get(2))
//                .toArray(String[]::new);
//
//        //System.out.println(s.length);
//
////        String path="C:\\Users\\jinqwang\\Desktop\\Sql for user and project.sql";
////        File file = new File(path);
////        String sql = FileTest.textToString(file);
////        System.out.println(String.format(sql, s));
//
//        //登录名
//        //工号
//        //serviceLine
//        //中文名
//        //英文名
//        //region
//        //office
//        //email
//
////        int i = 0;
////        for (Map<Integer, Object> map : excel) {
////            String finalSQL = String.format(sql, map.get(1), map.get(2), map.get(9), map.get(3)
////                    , map.get(4), map.get(8), map.get(7), map.get(6));
////
////            System.out.println(finalSQL);
////            System.out.println();
////            i++;
////        }
//
//
////        String updateSQL = "UPDATE SYS_USER SET ENAME_='%s' WHERE STAFF_NO='%s';";
////        int i = 0;
////        for (Map<Integer, Object> map : excel) {
////            String finalSQL = String.format(updateSQL, map.get(4), map.get(2));
////
////            System.out.println(finalSQL);
////            System.out.println();
////            i++;
////        }
//
//    }
//
//    /**
//     * 读取excel数据
//     */
//    public static List<Map<Integer, Object>> readExcelToObj(String path) {
//
//        Workbook wb = null;
//        try {
//            wb = WorkbookFactory.create(new File(path));
//            return readExcel(wb, 0, 0, 0);
//        } catch (InvalidFormatException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    /**
//     * 读取excel文件
//     *
//     * @param sheetIndex    sheet页下标：从0开始
//     * @param startReadLine 开始读取的行:从0开始
//     * @param tailLine      去除最后读取的行
//     */
//    private static List<Map<Integer, Object>> readExcel(Workbook wb, int sheetIndex, int startReadLine, int tailLine) {
//
//        Sheet sheet = wb.getSheetAt(sheetIndex);
//
//        List<Map<Integer, Object>> excel = new ArrayList<>();
//
//        for (int i = startReadLine; i < sheet.getLastRowNum() - tailLine + 1; i++) {
//
//            Map<Integer, Object> map = new HashedMap();
//            Row row = sheet.getRow(i);
//            Integer integer = 0;
//            for (Cell c : row) {
//                c.setCellType(Cell.CELL_TYPE_STRING);
//                boolean isMerge = isMergedRegion(sheet, i, c.getColumnIndex());
//                //判断是否具有合并单元格
//                String rs = null;
//                if (isMerge) {
//                    rs = getMergedRegionValue(sheet, row.getRowNum(), c.getColumnIndex());
//                    //System.out.print(rs + "  ");
//                } else {
//                    rs = c.getRichStringCellValue().toString();
//                    //System.out.print(rs + "  ");
//                }
//                map.put(integer, rs);
//                integer++;
//            }
//            excel.add(map);
//            //System.out.println();
//
//        }
//        return excel;
//
//    }
//
//    /**
//     * 获取合并单元格的值
//     */
//    public static String getMergedRegionValue(Sheet sheet, int row, int column) {
//
//        int sheetMergeCount = sheet.getNumMergedRegions();
//
//        for (int i = 0; i < sheetMergeCount; i++) {
//            CellRangeAddress ca = sheet.getMergedRegion(i);
//            int firstColumn = ca.getFirstColumn();
//            int lastColumn = ca.getLastColumn();
//            int firstRow = ca.getFirstRow();
//            int lastRow = ca.getLastRow();
//
//            if (row >= firstRow && row <= lastRow) {
//
//                if (column >= firstColumn && column <= lastColumn) {
//                    Row fRow = sheet.getRow(firstRow);
//                    Cell fCell = fRow.getCell(firstColumn);
//                    return getCellValue(fCell);
//                }
//            }
//        }
//
//        return null;
//    }
//
//    /**
//     * 判断合并了行
//     */
//    private boolean isMergedRow(Sheet sheet, int row, int column) {
//
//        int sheetMergeCount = sheet.getNumMergedRegions();
//        for (int i = 0; i < sheetMergeCount; i++) {
//            CellRangeAddress range = sheet.getMergedRegion(i);
//            int firstColumn = range.getFirstColumn();
//            int lastColumn = range.getLastColumn();
//            int firstRow = range.getFirstRow();
//            int lastRow = range.getLastRow();
//            if (row == firstRow && row == lastRow) {
//                if (column >= firstColumn && column <= lastColumn) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    /**
//     * 判断指定的单元格是否是合并单元格
//     *
//     * @param row    行下标
//     * @param column 列下标
//     */
//    private static boolean isMergedRegion(Sheet sheet, int row, int column) {
//
//        int sheetMergeCount = sheet.getNumMergedRegions();
//        for (int i = 0; i < sheetMergeCount; i++) {
//
//            CellRangeAddress range = sheet.getMergedRegion(i);
//            int firstColumn = range.getFirstColumn();
//            int lastColumn = range.getLastColumn();
//            int firstRow = range.getFirstRow();
//            int lastRow = range.getLastRow();
//            if (row >= firstRow && row <= lastRow) {
//                if (column >= firstColumn && column <= lastColumn) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    /**
//     * 判断sheet页中是否含有合并单元格
//     */
//    private boolean hasMerged(Sheet sheet) {
//        return sheet.getNumMergedRegions() > 0 ? true : false;
//    }
//
//    /**
//     * 合并单元格
//     *
//     * @param firstRow 开始行
//     * @param lastRow  结束行
//     * @param firstCol 开始列
//     * @param lastCol  结束列
//     */
//    private void mergeRegion(Sheet sheet, int firstRow, int lastRow, int firstCol, int lastCol) {
//        sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol));
//    }
//
//    /**
//     * 获取单元格的值
//     */
//    public static String getCellValue(Cell cell) {
//
//        if (cell == null) return "";
//
//        if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
//
//            return cell.getStringCellValue();
//
//        } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
//
//            return String.valueOf(cell.getBooleanCellValue());
//
//        } else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
//
//            return cell.getCellFormula();
//
//        } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
//
//            return String.valueOf(cell.getNumericCellValue());
//
//        }
//        return "";
//    }
//}
