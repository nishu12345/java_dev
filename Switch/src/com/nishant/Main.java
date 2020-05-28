package com.nishant;

public class Main {

    public static void main(String[] args) {
	int switchValue = 1;
	switch(switchValue){
        case 1:
            System.out.println("Value is 1");
            break;
        case 2:
            System.out.println("Value is 2");
            break;
        case 3:case 4:case 5:
            System.out.println("Value is 3 or a 4 or 5");
            break;
        default:
            System.out.println("Value is not 1, 2 ,3 4 or 5");
            break;
    }
    }
}
