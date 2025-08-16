package com.orange.carshow.services.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CardDto {

    private String thumbnail;
    private long makeID;
    @JsonAlias("modelId")
    private long modelID;
    @JsonAlias("make")
    private Details makerDetails;
    private Details model;
    private long year;
    private long price;
    private long carStatus;

    public long getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(long carStatus) {
        this.carStatus = carStatus;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public Details getModel() {
        return model;
    }

    public void setModel(Details model) {
        this.model = model;
    }

    public Details getMakerDetails() {
        return makerDetails;
    }

    public void setMakerDetails(Details makerDetails) {
        this.makerDetails = makerDetails;
    }

    public long getModelID() {
        return modelID;
    }

    public void setModelID(long modelID) {
        this.modelID = modelID;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public long getMakeID() {
        return makeID;
    }

    public void setMakeID(long makeID) {
        this.makeID = makeID;
    }


}
