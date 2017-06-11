package serifenuruysal.com.mylistapp;

/**
 * Created by serifenuruysal on 11/06/17.
 */

public class Movie {
    private String name;
    private String detail;
    private String imageUrl;


    public Movie(String name, String detail,String imageUrl) {
        this.name = name;
        this.detail = detail;
        this.imageUrl=imageUrl;
    }

    public Movie(String name, String detail) {
        this.name = name;
        this.detail = detail;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
