package Test;

public class upp_5 {

    public static String findLeastMoves(String str, String currentWord)
    {
        if (str.equals("ABCDE")) {
            return currentWord;
        }
        if (currentWord.length() >= 15) {
            return null;
        }

        String str1 = bMove(str);
        String str2 = sMove(str);
        String bSolution = findLeastMoves(str1, currentWord + "b");
        String sSolution = findLeastMoves(str2, currentWord + "s");

        if(bSolution == null){
            return sSolution;
        }

        else if (sSolution == null){
            return bSolution;
        }

        else if(sSolution.length() > bSolution.length()){
            return bSolution;
        }

        else{
            return sSolution;
        }
    }
    private static String bMove(String str)
    {
        String newStr = str.substring(1,2) + str.substring(0,1) + str.substring(2);
        return newStr;
    }
    private static String sMove(String str)
    {
        int s= str.length() - 1;
        String newStr = str.substring(s) + str.substring(0,s);
        return newStr;
    }

    public static String findLeastMoves(String str)
    {
        String returnWord = findLeastMoves(str,"");
        return "The word '" + str + "' takes at least " + returnWord.length()+ " steps, solution: " + returnWord;
    }

    public static void main(String[] args){

        String str1 = "BAECD";
        System.out.println("BECAD" + "\n" + findLeastMoves(str1));

        String str2 = "EDCBA";
        System.out.println("EDCBA" + "\n" + findLeastMoves(str2));
    }
}

