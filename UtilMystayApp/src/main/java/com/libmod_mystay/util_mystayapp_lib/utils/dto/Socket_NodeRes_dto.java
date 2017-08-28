package com.libmod_mystay.util_mystayapp_lib.utils.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Saket on 1/7/17.
 */

public class Socket_NodeRes_dto {



    @SerializedName("event_type")
    @Expose
    private String eventType;
    @SerializedName("event_name")
    @Expose
    private String eventName;
    @SerializedName("event_status")
    @Expose
    private String eventStatus;
    @SerializedName("source_of_change")
    @Expose
    private String sourceOfChange;
    @SerializedName("event_value")
    @Expose
    private String eventValue;
    @SerializedName("room_number")
    @Expose
    private String roomNumber;
    @SerializedName("room_ip")
    @Expose
    private String roomIp;
    @SerializedName("guest_id")
    @Expose
    private String guestId;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    public String getSourceOfChange() {
        return sourceOfChange;
    }

    public void setSourceOfChange(String sourceOfChange) {
        this.sourceOfChange = sourceOfChange;
    }

    public String getEventValue() {
        return eventValue;
    }

    public void setEventValue(String eventValue) {
        this.eventValue = eventValue;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomIp() {
        return roomIp;
    }

    public void setRoomIp(String roomIp) {
        this.roomIp = roomIp;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

}
