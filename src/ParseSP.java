import javax.mail.*;
import java.util.*;

public class ParseSP{

  public static void main(String []args) throws MessagingException {
    List <String> massive = parsingSP("1,2,3,5-8,10, 155-158, 400...600");
    System.out.println(massive);

  }

  private static List<String> parsingSP(String s) {
    s = s.replaceAll(" ", "");
    s = s.replaceAll("\\.\\.\\.", "-");
    List<String> list = new ArrayList<>();
    String [] massive = s.split(",");
    for(String str : massive){
      if(str.contains("-")){
        String in = splitString(str);
        String [] massiveIn = in.split(",");
        list.addAll(Arrays.asList(massiveIn));
      } else {
        list.add(str);
      }
    }
    return list;
  }


  private static String splitString(String str) {
    String range = str;
    String[] numbers = range.split("-");
    int start = Integer.parseInt(numbers[0]);
    int end = Integer.parseInt(numbers[1]);

    StringBuilder result = new StringBuilder();

    for (int i = start; i <= end; i++) {
      if (i != start) {
        result.append(",");
      }
      result.append(i);
    }
    return result.toString();
  }
}
