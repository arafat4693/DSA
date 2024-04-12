package BitManipulation;

public class AddBinary {
    public String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        int carry = 0;

        StringBuilder res = new StringBuilder();

        for(int i = 0; i < Math.max(a.length(), b.length()); i++){
            int digitA = i >= a.length() ? 0 : a.charAt(i) - '0';
            int digitB = i >= b.length() ? 0 : b.charAt(i) - '0';

            int total = digitA + digitB + carry;
            res.insert(0, total % 2);
            carry = total/2;
        }

        return carry != 0 ? res.insert(0, carry).toString() : res.toString();
    }
}
