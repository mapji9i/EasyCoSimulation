package macro;

public interface Logger {
    boolean serviceLogKey=false;

    void print(String message);
    default void sprint(String message){
        if(serviceLogKey){
            print(message);
        }
    }
}
