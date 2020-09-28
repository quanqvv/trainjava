package train;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex7 {

    public static void main(String[] args) {
        String line = "http://tiki.vn/dien-thoai-may-tinhbang/c1789?src=mega-menu";
        String pattern_str = "^(http:|https:)\\/\\/(\\w+\\.\\w{2,6}|\\w+.\\w+.\\w{2,6})\\/[^\\s]+$";

        Pattern pattern = Pattern.compile(pattern_str);
        Matcher matcher = pattern.matcher(line);

        if(matcher.find()){
            System.out.println("Url is ok");
        }else{
            System.out.println("Url is not ok");
        }



    }
}
