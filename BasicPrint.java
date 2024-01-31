class  Year{
    public int year;
    public Year(int v)
    {
        this.year=v;
    }
    public void print()
    {
        System.out.println("Happy New Year "+this.year+"\n");
    }

}
public class BasicPrint{
    public static void main(String[] args)
    {
        Year y=new Year(2024);
        y.print();
    }
}
