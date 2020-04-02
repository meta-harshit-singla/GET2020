//package Counseling;
//
//public class demo {
//
//    package Counseling;
//
//    import java.io.File;
//    import java.io.FileInputStream;
//    import java.io.IOException;
//    import java.util.ArrayList;
//    import java.util.HashMap;
//    import java.util.Iterator;
//    import java.util.LinkedList;
//    import java.util.List;
//    import java.util.Queue;
//
//    import org.apache.poi.hssf.usermodel.HSSFSheet;
//    import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//    import org.apache.poi.ss.usermodel.Cell;
//    import org.apache.poi.ss.usermodel.FormulaEvaluator;
//    import org.apache.poi.ss.usermodel.Row;
//
//    public class ExcelFiles {
//
//        public Queue<student> readFileStudent() {
//            Queue<student> q = new LinkedList<student>();
//            try {
//                // obtaining input bytes from a file
//                FileInputStream fis = new FileInputStream(new File(
//                        "./Data/students.xls"));
//
//                // creating workbook instance that refers to .xls file
//                HSSFWorkbook wb = new HSSFWorkbook(fis);
//
//                // creating a Sheet object to retrieve the object
//                HSSFSheet sheet = wb.getSheetAt(0);
//
//                // evaluating cell type
//                FormulaEvaluator formulaEvaluator = wb.getCreationHelper()
//                        .createFormulaEvaluator();
//
//                // get row no
//                int rowNo = sheet.getLastRowNum();
//                int cellNo = sheet.getRow(0).getLastCellNum();
//                Iterator<Row> rowIterator = sheet.iterator();
//
//                for (int row = 1; row <= rowNo; row++) {
//
//                    student stu = new student(sheet.getRow(row).getCell(0)
//                            .toString());
//
//                    List<String> br = new ArrayList<String>();
//                    for (int cell = 1; cell < cellNo; cell++) {
//                        br.add(sheet.getRow(row).getCell(cell).toString());
//
//                    }
//                    // for(int i=1;i<br.size();i++){
//                    // System.out.println(br.get(i));
//                    // }
//                    // System.out.print("\n");
//                    stu.setBranch(br);
//                    q.add(stu);
//                    // System.out.print(stu.getName());
//                    // System.out.print(stu.getBranch());
//
//                }
//
////                 for(student s:q){
////                 System.out.println(s.getName());
////                 System.out.println(s.getBranch());
////                 }
////                
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return q;
//
//        }
//
//        public HashMap<String, Integer> readPrograms(){
//            HashMap<String, Integer> map= new HashMap<>();
//            try {
//                // obtaining input bytes from a file
//                FileInputStream fis = new FileInputStream(new File(
//                        "./Data/programs.xls"));
//
//                // creating workbook instance that refers to .xls file
//                HSSFWorkbook wb = new HSSFWorkbook(fis);
//
//                // creating a Sheet object to retrieve the object
//                HSSFSheet sheet = wb.getSheetAt(0);
//
//                // evaluating cell type
//                FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
//                
//             // get row no
//                int rowNo = sheet.getLastRowNum();
//                int cellNo = sheet.getRow(0).getLastCellNum();
//                Iterator<Row> rowIterator = sheet.iterator();
//                
//                for(int row=1;row<=rowNo;row++){
//                   
//                        String cap  = (sheet.getRow(row).getCell(1)).toString();
//                        int capasity = (int)Float.parseFloat(cap);
//                       
//                        //System.out.println(sheet.getRow(row).getCell(0));
//                        map.put(sheet.getRow(row).getCell(0).toString(),capasity);
//                    
//                }
//                //System.out.println(map); 
//            }
//            catch(Exception e){
//                e.printStackTrace();
//            }
//            return map;
//                
//        }
//        
//        public void compare(HashMap<String, Integer> map,Queue<student> stu){
//            HashMap<String,String> allocate = new HashMap<>();
//            
//            for(student s:stu){
//                
//              String selectedStudent = s.getName();
//              String preferredBranch;
//              int branchCapasity;
//              
//              for(int index=0;index<s.getBranch().size();index++){
//               preferredBranch = s.getBranch().get(index);
//              //System.out.println(selectedStudent+"-->"+preferredBranch);
//              
//              
//              
//              if(map.containsKey(preferredBranch)){
//                  
//                  branchCapasity = map.get(preferredBranch);
//                  if(branchCapasity!=0){
//                      allocate.put(selectedStudent,preferredBranch);
//                      System.out.println("before"+branchCapasity);
//                      System.out.println(preferredBranch);
//                      System.out.println(selectedStudent+":"+preferredBranch);
//                      
//                      map.put(preferredBranch, --branchCapasity);
//                     // System.out.println("after"+branchCapasity);
//                      System.out.println("\n");
//                      index--;
//                      break;
//
//                  }
////                  else{
////                     
////                      
////                  }
////              
//              }
//              }}
//            System.out.print(allocate);
//        }
//        
//        public static void main(String[] args) {
//            // queue for student
//            
//            ExcelFiles e = new ExcelFiles();
//            HashMap<String, Integer> map = new HashMap<String, Integer>();
//            map = e.readPrograms();
//            
//            Queue<student> stv = e.readFileStudent();
////            for(student s:stv){
////              System.out.println(s.getName());
////              System.out.println(s.getBranch());
////              }
//            
//            e.compare(map, stv);
//            
//        }
//    }
//
//}
