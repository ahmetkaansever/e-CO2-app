package com.aksdev.projectsecondaryusage;

public class Upload {
    private String imageName;
    private String imageUrl;

    public Upload(String imageName, String imageUrl) {
        if(imageName.isEmpty() == true){
            imageName = "No_Name_Found";
        }
        this.imageName = imageName;
        this.imageUrl = imageUrl;
    }

    public Upload(){
        new Upload("No_Name_Found", "1");
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
