package dbServices.dataSets;

import javax.persistence.*;

@Entity
@Table(name = "deliveries")

public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long deliveryId;
    @Column(name = "date")
    private String deliveryDate;
    @Column(name = "orderId")
    private String deliveryOrderId;
    @Column(name = "client")
    private String deliveryClient;
    @Column(name = "clientPrice")
    private Double deliveryClientPrice;
    @Column(name = "price")
    private Double deliveryPrice;
    @Column(name = "city")
    private String deliveryCity;
    @Column(name = "comment")
    private String deliveryComment;
    @Column(name = "author")
    private String deliveryAuthor;

    public Delivery(){

    }

    public Delivery(String deliveryDate, String deliveryOrderId, String deliveryClient, Double deliveryClientPrice, Double deliveryPrice, String deliveryCity, String deliveryComment, String deliveryAuthor){
        this.setDeliveryDate(deliveryDate);
        this.setDeliveryOrderId(deliveryOrderId);
        this.setDeliveryClient(deliveryClient);
        this.setDeliveryClientPrice(deliveryClientPrice);
        this.setDeliveryPrice(deliveryPrice);
        this.setDeliveryCity(deliveryCity);
        this.setDeliveryComment(deliveryComment);
        this.setDeliveryAuthor(deliveryAuthor);
    }

    public Delivery(long deliveryId, String deliveryDate, String deliveryOrderId, String deliveryClient, Double deliveryClientPrice, Double deliveryPrice, String deliveryCity, String deliveryComment, String deliveryAuthor){
        this.setDeliveryId(deliveryId);
        this.setDeliveryDate(deliveryDate);
        this.setDeliveryOrderId(deliveryOrderId);
        this.setDeliveryClient(deliveryClient);
        this.setDeliveryClientPrice(deliveryClientPrice);
        this.setDeliveryPrice(deliveryPrice);
        this.setDeliveryCity(deliveryCity);
        this.setDeliveryComment(deliveryComment);
        this.setDeliveryAuthor(deliveryAuthor);
    }

    public void setDeliveryId(long deliveryId){
        this.deliveryId = deliveryId;
    }

    public void setDeliveryDate(String deliveryDate){
        this.deliveryDate = deliveryDate;
    }

    public void setDeliveryOrderId(String deliveryOrderId){
        this.deliveryOrderId = deliveryOrderId;
    }

    public void setDeliveryClient(String deliveryClient){
        this.deliveryClient = deliveryClient;
    }

    public void setDeliveryClientPrice(Double deliveryClientPrice){
        this.deliveryClientPrice = deliveryClientPrice;
    }

    public void setDeliveryPrice(Double deliveryPrice){
        this.deliveryPrice = deliveryPrice;
    }

    public void setDeliveryCity(String deliveryCity){
        this.deliveryCity = deliveryCity;
    }

    public void setDeliveryComment(String deliveryComment){
        this.deliveryComment =deliveryComment;
    }

    public void setDeliveryAuthor(String deliveryAuthor){
        this.deliveryAuthor = deliveryAuthor;
    }

    public Long getDeliveryId(){
        return deliveryId;
    }

    public String getDeliveryDate(){
        return deliveryDate;
    }

    public String getDeliveryOrderId(){
        return deliveryOrderId;
    }

    public String getDeliveryClient(){
        return deliveryClient;
    }

    public Double getDeliveryClientPrice(){
        return deliveryClientPrice;
    }

    public Double getDeliveryPrice(){
        return deliveryPrice;
    }

    public String getDeliveryCity(){
        return deliveryCity;
    }

    public String getDeliveryComment(){
        return deliveryComment;
    }

    public String getDeliveryAuthor(){
        return deliveryAuthor;
    }





}
