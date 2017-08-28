package com.libmod_mystay.util_mystayapp_lib.utils.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Saket on 12/7/17.
 */

public class Login_dto {

    @SerializedName("checkindata")
    @Expose
    private Checkindata checkindata;
    @SerializedName("redirectto")
    @Expose
    private String redirectto;

    public Checkindata getCheckindata() {
        return checkindata;
    }

    public void setCheckindata(Checkindata checkindata) {
        this.checkindata = checkindata;
    }

    public String getRedirectto() {
        return redirectto;
    }

    public void setRedirectto(String redirectto) {
        this.redirectto = redirectto;
    }

    public class Checkindata {

        @SerializedName("pc_ip")
        @Expose
        private String pcIp;
        @SerializedName("pmsi_guest_id")
        @Expose
        private Integer pmsiGuestId;
        @SerializedName("room_no")
        @Expose
        private String roomNo;
        @SerializedName("guestlg")
        @Expose
        private String guestlg;
        @SerializedName("roomno")
        @Expose
        private String roomno;
        @SerializedName("guestname")
        @Expose
        private String guestname;
        @SerializedName("sharestatus")
        @Expose
        private String sharestatus;
        @SerializedName("MAC")
        @Expose
        private String mAC;

        public String getPcIp() {
            return pcIp;
        }

        public void setPcIp(String pcIp) {
            this.pcIp = pcIp;
        }

        public Integer getPmsiGuestId() {
            return pmsiGuestId;
        }

        public void setPmsiGuestId(Integer pmsiGuestId) {
            this.pmsiGuestId = pmsiGuestId;
        }

        public String getRoomNo() {
            return roomNo;
        }

        public void setRoomNo(String roomNo) {
            this.roomNo = roomNo;
        }

        public String getGuestlg() {
            return guestlg;
        }

        public void setGuestlg(String guestlg) {
            this.guestlg = guestlg;
        }

        public String getRoomno() {
            return roomno;
        }

        public void setRoomno(String roomno) {
            this.roomno = roomno;
        }

        public String getGuestname() {
            return guestname;
        }

        public void setGuestname(String guestname) {
            this.guestname = guestname;
        }

        public String getSharestatus() {
            return sharestatus;
        }

        public void setSharestatus(String sharestatus) {
            this.sharestatus = sharestatus;
        }

        public String getMAC() {
            return mAC;
        }

        public void setMAC(String mAC) {
            this.mAC = mAC;
        }

    }
}
