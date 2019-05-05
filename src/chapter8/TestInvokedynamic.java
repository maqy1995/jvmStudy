package chapter8;

class GrandFather {
    void thinking(){
        System.out.println("i am grandfather");
    }
}
class Father extends GrandFather {
    void thinking(){
        System.out.println("i am father");
    }
}

class Son extends Father{
    void thinking(){

    }
}

public class TestInvokedynamic {
}
