package train.Ex8;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Country implements Serializable {
    private String code;
    private String name;
    private String continent; //ma luc dia
    private double surfaceArea; //dien tich be mat
    private long population;
    private double gnp; //Gross national product
    private int capital;
    private List<City> cityList = new ArrayList<>();

    public Country(String code, String name, String continent,
                   double surfaceArea, long population, double gnp, int capital) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.surfaceArea = surfaceArea;
        this.population = population;
        this.gnp = gnp;
        this.capital = capital;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public double getGnp() {
        return gnp;
    }

    public void setGnp(double gnp) {
        this.gnp = gnp;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void addCity(City city) {
        cityList.add(city);
    }

    public void setCityList(List<City> cityList){
        this.cityList = cityList;
    }

    public City getCapitalObject(){
        for(City c: getCityList()){
            if(c.getId() == getCapital()){
                return c;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", surfaceArea=" + surfaceArea +
                ", population=" + population +
                ", gnp=" + gnp +
                ", capital=" + capital +
                ", cityList=" + cityList +
                '}';
    }
}

