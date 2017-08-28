package com.libmod_mystay.util_mystayapp_lib.utils.dto;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Saket on 6/7/17.
 */

public class Folio_xml_dto {

    @SerializedName("root")
    @Expose
    private Root root;

    public Root getRoot() {
        return root;
    }

    public void setRoot(Root root) {
        this.root = root;
    }


    public class Key {

        @SerializedName("content")
        @Expose
        private Object content;
        @SerializedName("tag")
        @Expose
        private String tag;

        public Object getContent() {
            return content;
        }

        public void setContent(Object content) {
            this.content = content;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

    }


    public class Root {

        @SerializedName("window")
        @Expose
        private List<Window> window = null;
        @SerializedName("row")
        @Expose
        private List<Row_> row = null;

        public List<Window> getWindow() {
            return window;
        }

        public void setWindow(List<Window> window) {
            this.window = window;
        }

        public List<Row_> getRow() {
            return row;
        }

        public void setRow(List<Row_> row) {
            this.row = row;
        }

    }


    public class Row {

        @SerializedName("value")
        @Expose
        private Value value;
        @SerializedName("key")
        @Expose
        private String key;

        public Value getValue() {
            return value;
        }

        public void setValue(Value value) {
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

    }

    public class Row_ {

        @SerializedName("value")
        @Expose
        private Value__ value;
        @SerializedName("key")
        @Expose
        private Key key;

        public Value__ getValue() {
            return value;
        }

        public void setValue(Value__ value) {
            this.value = value;
        }

        public Key getKey() {
            return key;
        }

        public void setKey(Key key) {
            this.key = key;
        }

    }


    public class Subwindowtotal {

        @SerializedName("value")
        @Expose
        private Value_ value;
        @SerializedName("key")
        @Expose
        private String key;

        public Value_ getValue() {
            return value;
        }

        public void setValue(Value_ value) {
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

    }


    public class Value<T> {

        @SerializedName("content")
        @Expose
        private T content;
        @SerializedName("conversion")
        @Expose
        private Boolean conversion;

        public T getContent() {
            return content;
        }

        public void setContent(T content) {
            this.content = content;
        }

        public Boolean getConversion() {
            return conversion;
        }

        public void setConversion(Boolean conversion) {
            this.conversion = conversion;
        }

    }


    public class Value_<T> {

        @SerializedName("content")
        @Expose
        private Object content;
        @SerializedName("conversion")
        @Expose
        private Boolean conversion;

        public Object getContent() {
            return content;
        }

        public void setContent(Object content) {
            this.content = content;
        }

        public Boolean getConversion() {
            return conversion;
        }

        public void setConversion(Boolean conversion) {
            this.conversion = conversion;
        }

    }


    public class Value__ {

        @SerializedName("content")
        @Expose
        private Object content;
        @SerializedName("conversion")
        @Expose
        private Boolean conversion;

        public Object getContent() {
            return content;
        }

        public void setContent(Object content) {
            this.content = content;
        }

        public Boolean getConversion() {
            return conversion;
        }

        public void setConversion(Boolean conversion) {
            this.conversion = conversion;
        }

    }


    public class Window {

        @SerializedName("row")
        @Expose
        private List<Row> row = null;
        @SerializedName("subwindowtotal")
        @Expose
        private Subwindowtotal subwindowtotal;
        @SerializedName("name")
        @Expose
        private String name;

        public List<Row> getRow() {
            return row;
        }

        public void setRow(List<Row> row) {
            this.row = row;
        }

        public Subwindowtotal getSubwindowtotal() {
            return subwindowtotal;
        }

        public void setSubwindowtotal(Subwindowtotal subwindowtotal) {
            this.subwindowtotal = subwindowtotal;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}

