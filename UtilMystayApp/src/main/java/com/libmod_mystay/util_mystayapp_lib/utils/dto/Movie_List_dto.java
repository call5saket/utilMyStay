package com.libmod_mystay.util_mystayapp_lib.utils.dto;

/**
 * Created by Saket on 31/7/17.
 */

public class Movie_List_dto {

    public String mov_cat_id="",mov_cat_name="",vd_movie_code="",vd_movie_title="",vd_movie_genre="",lang="",keywords="",vd_movie_image ="",no_files="",vd_movie_filename="",director="",
            writer="",cast="",release_date="",rating="",counter="",entry_date="",producer="",music_director="",rates="",synopsis="",movie_distributor="",movie_studio="",hd="",licensed="",duration="",is_deleted="",removal_date="",end_date="",vd_movie_certificate="",
            subtitle="",audio_track="",dimension="",position="";


    private static Movie_List_dto instance;

    public static Movie_List_dto getInstance() {

        if (instance==null){
            instance= new Movie_List_dto();
        }
        return instance;
    }

    public String getMov_cat_id() {
        return mov_cat_id;
    }

    public void setMov_cat_id(String mov_cat_id) {
        this.mov_cat_id = mov_cat_id;
    }

    public String getMov_cat_name() {
        return mov_cat_name;
    }

    public void setMov_cat_name(String mov_cat_name) {
        this.mov_cat_name = mov_cat_name;
    }

    public String getVd_movie_code() {
        return vd_movie_code;
    }

    public void setVd_movie_code(String vd_movie_code) {
        this.vd_movie_code = vd_movie_code;
    }

    public String getVd_movie_title() {
        return vd_movie_title;
    }

    public void setVd_movie_title(String vd_movie_title) {
        this.vd_movie_title = vd_movie_title;
    }

    public String getVd_movie_genre() {
        return vd_movie_genre;
    }

    public void setVd_movie_genre(String vd_movie_genre) {
        this.vd_movie_genre = vd_movie_genre;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getVd_movie_image() {
        return vd_movie_image;
    }

    public void setVd_movie_image(String vd_movie_image) {
        this.vd_movie_image = vd_movie_image;
    }

    public String getNo_files() {
        return no_files;
    }

    public void setNo_files(String no_files) {
        this.no_files = no_files;
    }

    public String getVd_movie_filename() {
        return vd_movie_filename;
    }

    public void setVd_movie_filename(String vd_movie_filename) {
        this.vd_movie_filename = vd_movie_filename;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCounter() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }

    public String getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(String entry_date) {
        this.entry_date = entry_date;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getMusic_director() {
        return music_director;
    }

    public void setMusic_director(String music_director) {
        this.music_director = music_director;
    }

    public String getRates() {
        return rates;
    }

    public void setRates(String rates) {
        this.rates = rates;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getMovie_distributor() {
        return movie_distributor;
    }

    public void setMovie_distributor(String movie_distributor) {
        this.movie_distributor = movie_distributor;
    }

    public String getMovie_studio() {
        return movie_studio;
    }

    public void setMovie_studio(String movie_studio) {
        this.movie_studio = movie_studio;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    public String getLicensed() {
        return licensed;
    }

    public void setLicensed(String licensed) {
        this.licensed = licensed;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(String is_deleted) {
        this.is_deleted = is_deleted;
    }

    public String getRemoval_date() {
        return removal_date;
    }

    public void setRemoval_date(String removal_date) {
        this.removal_date = removal_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getVd_movie_certificate() {
        return vd_movie_certificate;
    }

    public void setVd_movie_certificate(String vd_movie_certificate) {
        this.vd_movie_certificate = vd_movie_certificate;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getAudio_track() {
        return audio_track;
    }

    public void setAudio_track(String audio_track) {
        this.audio_track = audio_track;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public static void setInstance(Movie_List_dto instance) {
        Movie_List_dto.instance = instance;
    }
}
