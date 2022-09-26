public class Main extends Base{
    public Main(){
        super("http://automationpractice.com");
    }

    public static void main(String[] args) throws InterruptedException {
        Main test = new Main();
        previewElement("//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]/img");
        addToCart();
        proceedBtn();

        previewElement("//*[@id=\"homefeatured\"]/li[2]/div/div[1]/div/a[1]/img");
        addToCart();
        proceedBtn();

        previewElement("//*[@id=\"homefeatured\"]/li[3]/div/div[1]/div/a[1]/img");
        addToCart();
        proceedBtn();

        previewElement("//*[@id=\"homefeatured\"]/li[6]/div/div[1]/div/a[1]/img");
        addToCart();
        proceedBtn();

        goToCart();
        removeFirstItemFromCart();

        incrementQuantity();
        Thread.sleep(15000);
        closeDriver();







    }



}
