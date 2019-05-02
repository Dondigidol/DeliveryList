package dbServices.dataSets;

import javax.persistence.*;

@Entity
@Table(name = "cities")
public class City {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cityId;
    @Column(name = "name", unique = true)
    private String cityName;

    public City(){

    }

    public City(String cityName){
        this.setCityName(cityName);
    }

    public City(long cityId, String cityName){
        this.setCityId(cityId);
        this.setCityName(cityName);
    }

    public void setCityName(String cityName){
        this.cityName = cityName;
    }

    public void setCityId(long cityId){
        this.cityId = cityId;
    }

    public long getCityId(){
        return cityId;
    }

    public String getCityName(){
        return cityName;
    }



}
