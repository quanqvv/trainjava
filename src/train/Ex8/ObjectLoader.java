package train.Ex8;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class NotFoundAttributeException extends Exception{

}

public class ObjectLoader {
    public static List<Object> loadObject(){
        List<City> cities = new ArrayList<>();
        return null;
    }

    private static String getAttribute(String string, String attr){
        String patternStr = String.format("%s=[^,\\]}]*", attr);
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(string);
        if(matcher.find()){
            return matcher.group().replace(attr+"=", "");
        }
        return null;
    }

    public static List<City> loadCityList(){
        try{
            List<City> cityList = new ArrayList<>();
            File file = new File("E:\\20201\\Intership\\Bai tap phan 1\\input_8\\cities.dat");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null){
                int id = Integer.parseInt(getAttribute(line, "id"));
                String name = getAttribute(line, "name");
                long population  = Long.parseLong(getAttribute(line, "population"));
                String codeCountry = getAttribute(line, "countryCode");
                cityList.add(new City(id, name, population, codeCountry));
            }

            return cityList;

        }
        catch (Exception e){

        }
        return null;
    }

    public static List<Country> loadCountryList(){
        List<Country> countryList = new ArrayList<>();
        try{
            File file = new File("E:\\20201\\Intership\\Bai tap phan 1\\input_8\\countries.dat");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null){

                String code = getAttribute(line, "code");
                String name = getAttribute(line, "name");
                String continent = getAttribute(line, "continent");
                double surfaceArea = Double.parseDouble(getAttribute(line, "surfaceArea"));
                long population = Long.parseLong(getAttribute(line, "population"));
                double gnp = Double.parseDouble(getAttribute(line, "gnp"));
                int capital = Integer.parseInt(getAttribute(line, "capital"));
                countryList.add(new Country(code, name, continent, surfaceArea, population, gnp, capital));
            }

            return countryList;

        }
        catch (Exception e){
            System.out.println(countryList);
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(loadCountryList());
    }
}
