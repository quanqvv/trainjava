
package train.Ex8.query;

import train.Ex8.City;
import train.Ex8.Country;
import train.Ex8.ObjectLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Query {

    List<Country> getAllCountry(){
        List<Country> countryList = ObjectLoader.loadCountryList();
        Map<String, List<City>> codeToCityList = new HashMap<>();
        List<City> cityList = ObjectLoader.loadCityList();
        cityList.forEach(city -> {
            if(!codeToCityList.containsKey(city.getCodeCountry())){
                codeToCityList.put(city.getCodeCountry(), new ArrayList<City>());
            }
            codeToCityList.get(city.getCodeCountry()).add(city);
        });
        countryList.forEach(country -> {
            if(codeToCityList.get(country.getCode())!=null)
                country.setCityList(codeToCityList.get(country.getCode()));
        });
        return countryList;
    }

    List<City> getAllCity(){
        return ObjectLoader.loadCityList();
    }


    public void theMostCrowdedCityOfEachCountry() {
        List<City> cityList = new ArrayList<>();
        getAllCountry().forEach(country -> {
            if(country.getCityList().size()>=1){
                City city = country.getCityList().stream().max(
                        (city1, city2) -> Long.compare(city1.getPopulation(), city2.getPopulation())
                ).get();
                if (city != null)
                    cityList.add(city);
            }

        });
        System.out.println(cityList.size());
    }

    public void theMostCrowdedCityOfEachContinent() {
        Map<String, List<City>> continentToCityList = new HashMap<>();

        getAllCountry().forEach((country -> {
            String continent = country.getContinent();
            if (!continentToCityList.containsKey(continent)) {
                continentToCityList.put(continent, new ArrayList<>());
            }
            country.getCityList().forEach(city -> {
                continentToCityList.get(continent).add(city);
            });
        }));
        System.out.println(continentToCityList);

        continentToCityList.forEach((continentKey, listCity) -> {
            if(listCity.size()>0) {
                City city = listCity
                        .stream()
                        .max((city1, city2) -> Long.compare(city1.getPopulation(), city2.getPopulation()))
                        .get();
                System.out.printf("Continent: %s, City: %s \n", continentKey, city.getName());
            }
        });
    }

    public void theMostCrowdedCapital() {
        List<City> capitalList = new ArrayList<>();
        getAllCountry().forEach(country -> {
            if(country.getCapitalObject() != null)
            capitalList.add(country.getCapitalObject());
        });

        System.out.println(capitalList
                .stream()
                .max((city1, city2) -> Long.compare(city1.getPopulation(), city2.getPopulation()))
                .get());
    }

    public void theMostCrowdedCityIsCapitalOfContinent() {
        Map<String, List<City>> continentToCapitalList = new HashMap<>();

        getAllCountry().forEach((country -> {
            String continent = country.getContinent();
            int capital = country.getCapital();
            if (!continentToCapitalList.containsKey(continent)) {
                continentToCapitalList.put(continent, new ArrayList<>());
            }
            continentToCapitalList.get(continent).add(country.getCapitalObject());
        }));

        continentToCapitalList.forEach((continentKey, listCapital) -> {
            City city = listCapital
                    .stream()
                    .max((city1, city2) -> Long.compare(city1.getPopulation(), city2.getPopulation()))
                    .get();
            System.out.printf("Continent: %s, City: %s \n", continentKey, city.getName());
        });
    }

    public void arrangeCountryByCityNumber() {
        List<Country> countryList = getAllCountry();
        countryList.sort((country1, country2) -> {
            return country2.getCityList().size() - country1.getCityList().size();
        });
        countryList.forEach(country -> System.out.println(country.getName() + " " + country.getCityList().size()));
    }

    public void arrangeCountryByPopulationDensity() {
        List<Country> countryList = getAllCountry();
        countryList.sort((country1, country2) -> {
            double density1 = country1.getPopulation() / country1.getSurfaceArea();
            double density2 = country2.getPopulation() / country2.getSurfaceArea();
            return (int) (density2 - density1);
        });
        countryList.forEach(country -> {
            int density = (int)(country.getPopulation() / country.getSurfaceArea());
            System.out.printf("%s: %d people/km2\n",country.getName(), density);
        });
    }

    public static void main(String[] args) {
//        new Query().theMostCrowdedCityOfEachCountry();
//        new Query().theMostCrowdedCityOfEachContinent();
//        new Query().theMostCrowdedCapital();
//        new Query().theMostCrowdedCityIsCapitalOfContinent();
//        new Query().arrangeCountryByCityNumber();
//        new Query().arrangeCountryByPopulationDensity();
    }
}
