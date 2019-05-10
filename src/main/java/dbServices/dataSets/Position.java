package dbServices.dataSets;

import javax.persistence.*;

@Entity
@Table(name = "positions")

public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private long positionId;
    @Column(name = "name")
    private String positionName;

    public Position(){

    }

    public Position(String positionName){
        this.setPositionName(positionName);
    }

    public Position(long positionId, String positionName){
        this.setPositionId(positionId);
        this.setPositionName(positionName);
    }

    public void setPositionId(long positionId){
        this.positionId = positionId;
    }

    public void setPositionName(String positionName){
        this.positionName= positionName;
    }

    public long getPositionId(){
        return positionId;
    }

    public String getPositionName(){
        return positionName;
    }

    @Override
    public String toString(){
        return "Position{" +
                "id = " + positionId +
                ", name = " + positionName +
                "}";
    }

}
