package com.libmod_mystay.util_mystayapp_lib.utils.dto;

/**
 * Created by Saket on 10/7/17.
 */

public class Tv_Channels_dto {

    public String id="",channel_name="",channel_logo="",channel_type="",is_updated="",is_active="",is_deleted="",channel_color="",	channel_command ="",channel_position="",catgId="",category_name="",catg_position="",catg_is_active="",catg_is_deleted="",catg_creation_date="",catg_created_by="",
    catg_modification_date="",catg_modified_by="";

    private static Tv_Channels_dto instance;

    public static Tv_Channels_dto getInstance() {

        if (instance==null){
            instance= new Tv_Channels_dto();
        }
        return instance;
    }

    public static void setInstance(Tv_Channels_dto instance) {
        Tv_Channels_dto.instance = instance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChannel_name() {
        return channel_name;
    }

    public void setChannel_name(String channel_name) {
        this.channel_name = channel_name;
    }

    public String getChannel_logo() {
        return channel_logo;
    }

    public void setChannel_logo(String channel_logo) {
        this.channel_logo = channel_logo;
    }

    public String getChannel_type() {
        return channel_type;
    }

    public void setChannel_type(String channel_type) {
        this.channel_type = channel_type;
    }

    public String getIs_updated() {
        return is_updated;
    }

    public void setIs_updated(String is_updated) {
        this.is_updated = is_updated;
    }

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public String getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(String is_deleted) {
        this.is_deleted = is_deleted;
    }

    public String getCatgId() {
        return catgId;
    }

    public void setCatgId(String catgId) {
        this.catgId = catgId;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCatg_position() {
        return catg_position;
    }

    public void setCatg_position(String catg_position) {
        this.catg_position = catg_position;
    }

    public String getCatg_is_active() {
        return catg_is_active;
    }

    public void setCatg_is_active(String catg_is_active) {
        this.catg_is_active = catg_is_active;
    }

    public String getCatg_is_deleted() {
        return catg_is_deleted;
    }

    public void setCatg_is_deleted(String catg_is_deleted) {
        this.catg_is_deleted = catg_is_deleted;
    }

    public String getCatg_creation_date() {
        return catg_creation_date;
    }

    public void setCatg_creation_date(String catg_creation_date) {
        this.catg_creation_date = catg_creation_date;
    }

    public String getCatg_created_by() {
        return catg_created_by;
    }

    public void setCatg_created_by(String catg_created_by) {
        this.catg_created_by = catg_created_by;
    }

    public String getCatg_modification_date() {
        return catg_modification_date;
    }

    public void setCatg_modification_date(String catg_modification_date) {
        this.catg_modification_date = catg_modification_date;
    }

    public String getCatg_modified_by() {
        return catg_modified_by;
    }

    public void setCatg_modified_by(String catg_modified_by) {
        this.catg_modified_by = catg_modified_by;
    }

    public String getChannel_color() {
        return channel_color;
    }

    public void setChannel_color(String channel_color) {
        this.channel_color = channel_color;
    }

    public String getChannel_command() {
        return channel_command;
    }

    public void setChannel_command(String channel_command) {
        this.channel_command = channel_command;
    }

    public String getChannel_position() {
        return channel_position;
    }

    public void setChannel_position(String channel_position) {
        this.channel_position = channel_position;
    }
}
