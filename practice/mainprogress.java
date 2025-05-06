package practice;

class mainprogress{
    public static void main(String[] args){
        ints nums = new ints();
        intadd add = new intadd();
        int rst;

        int n1 = nums.randnum();
        int n2 = nums.randnum();

        rst = add.inadd(n1,n2);
        System.out.println(n1 + " " + n2);
        System.out.println(rst);
    }
}