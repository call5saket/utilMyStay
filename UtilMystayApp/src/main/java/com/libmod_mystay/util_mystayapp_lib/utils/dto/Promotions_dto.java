package com.libmod_mystay.util_mystayapp_lib.utils.dto;

/**
 * Created by Saket on 11/7/17.
 */

public class Promotions_dto {

    private static Promotions_dto instance;

    public String title="",descriptions="",image="",image_large="",promotion_type="",promotion_url="",position="",visibility="";

    public static Promotions_dto getInstance() {

        if (instance==null){
            instance = new Promotions_dto();
        }

        return instance;
    }

    public static void setInstance(Promotions_dto instance) {
        Promotions_dto.instance = instance;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage_large() {
        return image_large;
    }

    public void setImage_large(String image_large) {
        this.image_large = image_large;
    }

    public String getPromotion_type() {
        return promotion_type;
    }

    public void setPromotion_type(String promotion_type) {
        this.promotion_type = promotion_type;
    }

    public String getPromotion_url() {
        return promotion_url;
    }

    public void setPromotion_url(String promotion_url) {
        this.promotion_url = promotion_url;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }
}
