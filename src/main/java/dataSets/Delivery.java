package dataSets;

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

    public void setDeliveryPrice(Integer deliveryPrice){
        this.deliveryPrice = deliveryPrice.doubleValue();
    }

    public void setDeliveryClientPrice(Integer deliveryClientPrice){
        this.deliveryClientPrice = deliveryClientPrice.doubleValue();
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

    @Override
    public String toString(){
        return "Delivery{" +
                "id = " + deliveryId +
                ", date = " + deliveryDate +
                ", orderId = " + deliveryOrderId +
                ", client = " + deliveryClient +
                ", clientPrice = " + deliveryClientPrice +
                ", price = " + deliveryPrice +
                ", city = " + deliveryCity +
                ", comment = " + deliveryComment +
                ", author = " + deliveryAuthor +
                "}";
    }

    public void prepareSearch(){
        if(getDeliveryId()==null) setDeliveryId(-1);
        if(getDeliveryDate()==null) setDeliveryDate("%"); else setDeliveryDate("%" + getDeliveryDate() + "%");
        if(getDeliveryClient()==null) setDeliveryClient("%"); else setDeliveryClient("%" + getDeliveryClient() + "%");
        if(getDeliveryOrderId()==null) setDeliveryOrderId("%"); else setDeliveryOrderId("%" + getDeliveryOrderId() + "%");
        if(getDeliveryCity()==null) setDeliveryCity("%"); else setDeliveryCity("%" + getDeliveryCity() + "%");
        if(getDeliveryComment()==null) setDeliveryComment("%"); else setDeliveryComment("%" + getDeliveryComment() + "%");
        if(getDeliveryAuthor()==null) setDeliveryAuthor("%"); else setDeliveryAuthor("%" + getDeliveryAuthor() + "%");
        if(getDeliveryClientPrice()==null) setDeliveryClientPrice(0);
        if(getDeliveryPrice()==null) setDeliveryPrice(0);
    }







}
