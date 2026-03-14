import java.util.Calendar;
import java.util.ArrayList;

public class MyCalendar {
    //创建英文星期名称和对应数字的映射
    static String[] WeekHash={"","Sunday","Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    //判断拆分结果是否能转换为int型
    public static boolean IsValidInput(String[] input,ArrayList data){
        if(input.length<2||input.length>3) return false;
        for(String s:input){
            try{
                int d=Integer.parseInt(s);
                data.add(d);
                continue;
            }catch(Exception e){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        //只接受一个参数
        if(args.length>1) {
            System.out.println("Too many arguments");
            return;
        }else if(args.length==0){
            System.out.println("No input given");
            return;
        }
        Calendar cal=Calendar.getInstance();
        //将输入按照/拆分
        String[] input=args[0].split("/");
        ArrayList<Integer> data=new ArrayList<>();
        if(!IsValidInput(input,data)){
            System.out.println("Not a valid input");
            return;
        }
        //设置cal为non_lenient模式
        cal.setLenient(false);
        //为cal按照输入赋值
        cal.set(Calendar.YEAR,data.get(0));
        //注意Calendar中月份为0基，0对应1月
        cal.set(Calendar.MONTH,data.get(1)-1);
        if(data.size()==3) cal.set(Calendar.DAY_OF_MONTH,data.get(2));
        //在non_lenient模式下，非法日期调用get方法后报错
        try{
            cal.getTime();
        }catch(Exception e){
            System.out.println("Not a valid input");
            return;
        }
        //将cal调回lenient模式
        cal.setLenient(true);
        //注释掉的是输入确切日期，返回当天是星期几
//        if(data.size()==3){
//            int week=cal.get(Calendar.DAY_OF_WEEK);
//            System.out.println(WeekHash[week]);
//        }
        //复制输入的月份，并将cal设置为月初，即1号
            int month=cal.get(Calendar.MONTH);
            cal.set(Calendar.DAY_OF_MONTH,1);
            //输出表头
            System.out.println("\t\t "+cal.get(Calendar.YEAR)+"/"+(cal.get(Calendar.MONTH)+1));
            System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
            //月份不变（对cal的参数DAY_OF_MONTH加1，模拟日历翻页，在lenient模式下，超出本月日期，将自动换算到下个月）
            while(cal.get(Calendar.MONTH)==month){
                //list的一组值为输出的一行
                int[] list=new int[7];
                for(int i=0;i<list.length&&cal.get(Calendar.MONTH)==month;i++){
                    //对应1号的星期数
                    if(cal.get(Calendar.DAY_OF_WEEK)==i+1){
                        list[i]=cal.get(Calendar.DAY_OF_MONTH);
                        cal.set(Calendar.DAY_OF_MONTH,cal.get(Calendar.DAY_OF_MONTH)+1);
                    }else list[i]=0;
                }
                for(int j:list){
                    if(j==0) System.out.print("\t");
                    else System.out.print(j+"\t");
                }
                System.out.println();
            }
    }
}