package com.flightbooking.model;

import java.sql.Date;
import java.sql.Time;

public class Flight {
    private int flightId;
    private String flightNo;
    private String source;
    private String destination;
    private Date flightDate;
    private Time flightTime;
    private String classType;
    private double price;

    // Getters and Setters
    public int getFlightId() { return flightId; }
    public void setFlightId(int flightId) { this.flightId = flightId; }
    public String getFlightNo() { return flightNo; }
    public void setFlightNo(String flightNo) { this.flightNo = flightNo; }
    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
    public Date getFlightDate() { return flightDate; }
    public void setFlightDate(Date flightDate) { this.flightDate = flightDate; }
    public Time getFlightTime() { return flightTime; }
    public void setFlightTime(Time flightTime) { this.flightTime = flightTime; }
    public String getClassType() { return classType; }
    public void setClassType(String classType) { this.classType = classType; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}