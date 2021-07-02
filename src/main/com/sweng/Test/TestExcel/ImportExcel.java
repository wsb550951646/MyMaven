package sweng.Test.TestExcel;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/9/2811:10
 */
public class ImportExcel {

    private final String SHEETNAME = "Sheet1";
    private HashMap<Integer,String> topRowIndex = new HashMap<>();
    private HashMap<String,String> inputMap = new HashMap<>();
    private Integer ROWNUM = 0;


    public void initInputMap(XSSFSheet sheet){
        XSSFRow topRow = sheet.getRow(0);
        ROWNUM = topRow.getPhysicalNumberOfCells();
        for (int i = 0; i < ROWNUM; i++) {
            String key = topRow.getCell(i).getStringCellValue();
            topRowIndex.put(i, key);
            inputMap.put(key, null);
        }
    }

    public HashMap<String, String> createInputMap(XSSFSheet sheet){
        HashMap<String, String> map = new HashMap<>();
        if(inputMap!=null && inputMap.size()>0){
            map.putAll(inputMap);
        }else {
            initInputMap(sheet);
            map.putAll(inputMap);
        }

        return map;
    }


    public List<HashMap<String,String>> importExcel(File filePath){
        List<HashMap<String, String>> mapLists = new ArrayList<>();
        try {
            XSSFWorkbook wookbook = new XSSFWorkbook(new FileInputStream(filePath));
            XSSFSheet sheet = wookbook.getSheet(SHEETNAME);
            initInputMap(sheet);
            int totalRowNum = sheet.getLastRowNum();
            //从第一行开始
            for (int i = 1; i <= totalRowNum; i++) {
                XSSFRow row = sheet.getRow(i);
                HashMap<String, String> map = createInputMap(sheet);
                int j = 0;
                while (j < ROWNUM){
                    String key  = topRowIndex.get(j);
                    //为空的处理？
                    String val  = null;
                    if(row.getCell(j)!=null){
                        val = getCellXlsx(row.getCell(j));
                    }
                    map.put(key, val);
                    j++;
                }
                mapLists.add(map);
            }

        }catch (Exception e){
            System.out.println(e.toString());
        }
        return mapLists;
    }

    @Test
    public void test(){
        File source = new File("C:\\Users\\sweng.ARCVIDEO\\Desktop\\NDI输入.xlsx");
        List<HashMap<String, String>> hashMaps = importExcel(source);

        for (HashMap<String,String> map : hashMaps){
            System.out.println("--------");
            for(Map.Entry<String,String> entry : map.entrySet()){
                System.out.println("key:"+entry.getKey()+" val:"+entry.getValue());
            }
            System.out.println("--------");
        }

    }

    @Test
    public void test1(){

        Double d = 1.0;
        String value = String.valueOf(d);
        System.out.println(value);


    }



    private static String getCellXlsx(XSSFCell cell) {
        //判断是否为null或空串
        if (cell==null || cell.toString().trim().equals("")) {
            return null;
        }
        String cellValue = "";
        int cellType=cell.getCellType();
        if(cellType==XSSFCell.CELL_TYPE_FORMULA){ //表达式类型
            try {
                return String.valueOf((int)cell.getNumericCellValue()).equals("")?null:String.valueOf((int)cell.getNumericCellValue());
            }catch (Exception e){
                return String.valueOf(cell.getBooleanCellValue()).equals("")?null:String.valueOf(cell.getBooleanCellValue());
            }
        }

        switch (cellType) {
            case XSSFCell.CELL_TYPE_NUMERIC: //
                cellValue = String.valueOf((int)cell.getNumericCellValue()).equals("")?null:String.valueOf((int)cell.getNumericCellValue());
                break;
            case XSSFCell.CELL_TYPE_STRING: //字符串类型
                cellValue= cell.getStringCellValue().trim();
                cellValue= StringUtils.isEmpty(cellValue) ? "" : cellValue;
                break;
            case XSSFCell.CELL_TYPE_BOOLEAN:  //布尔类型
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            default: //其它类型，取空串吧
                cellValue = "";
                break;
        }
        return cellValue;
    }



}
