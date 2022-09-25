public class Main extends Base{
    public Main(){
        super("http://automationpractice.com");
    }

    public static void main(String[] args) throws InterruptedException {
        Main test = new Main();
        test.previewElement("//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]/img");
        test.addToCart();

    }



}
