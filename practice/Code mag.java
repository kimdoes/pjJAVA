package practice;

class people{
    int count = 0;

    public int reset(){
        return count = 0;
    }

    public int increment(int num){
        return num = num + 1;
    }

    public void get(int number){
        System.out.println(number);
    }
}