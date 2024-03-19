package kthdsa.F5;

import java.util.Collections;

public class NB15 {
    public static int binaryToInt(String binary){
        if(binary.length() == 1) return binary.charAt(0) == '0' ? 0 : 1;
        return (binary.charAt(0) == '0' ? 0 : (int)Math.pow(2, binary.length()-1)) + binaryToInt(binary.substring(1));
    }

    public static String intToBinary(int num){
        if(num == 1) return "1";
        return intToBinary(num/2) + (num % 2);
    }

    public static void main(String[] args) {
        System.out.println(intToBinary(118));
        System.out.println(binaryToInt("1110110"));
    }
}
