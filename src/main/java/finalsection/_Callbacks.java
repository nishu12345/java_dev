package finalsection;

import java.util.function.Consumer;

public class _Callbacks {
    public static void main(String[] args) {
        hello("Alex","Montana", value -> System.out.println("No last Name Provided for " + value) );
        hello("Alice",null, value -> System.out.println("No last Name Provided for " + value) );

        hello("Maria",null, () -> System.out.println("No last Name Provided"));
    }

    static void hello(String firstName, String lastName, Consumer<String> callback){
        System.out.println(firstName);
        if(lastName != null){
            System.out.println(lastName);
        }else{
            callback.accept(firstName);
        }
    }

    static void hello(String firstName,String lastName, Runnable callback){
        System.out.println(firstName);
        if(lastName != null){
            System.out.println(lastName);
        }else{
            callback.run();
        }
    }


//    Callback example in javaScript
//    function hello(firstName,lastName, callback){
//        console.log("hello")
//                if(lastName){
//                    console.log(lastName)
//                }else{
//                    callback()
//                }
//    }
}
