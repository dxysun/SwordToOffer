package designpatterns.singleton.lazy;

public enum  SingletonEnum {
    INSTANCE;
    public void whateverMethod() {
    }
    private String name;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
