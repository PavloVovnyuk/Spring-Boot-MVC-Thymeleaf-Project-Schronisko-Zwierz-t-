package zadaniedomowe20.schronisko.model;

public class Animal {
    private int id;
    private String name;
    private String description;
    private String category;
    private String imgUrl;

    public Animal(int id, String name, String description, String category, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.imgUrl = imgUrl;
    }

    public Animal(String name, String description, String category, String imgUrl) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.imgUrl = imgUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        if (description.length()>=100) {
            return (description.substring(0, 100));
        } else {
            return description;
        }
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}

