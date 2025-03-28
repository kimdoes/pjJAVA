package practice;

public class practice1 {
    public static void main (String[] args){
        int bottleNum = 10;
        String words = "Bottles";

        while (bottleNum > 0){
            if (bottleNum == 1){
                words = "Bottle";
            }

            System.out.println(bottleNum + " green " + words + " hanging on th wall");
            System.out.println(bottleNum + " green " + words + " hanging on th wall");
            System.out.println("And if one green bottle should accidentally fall");

            bottleNum = bottleNum - 1;
        }

        System.out.println("There'll be no green bottles hanging on the wall");
    }
}