import org.testng.annotations.Test;

public class TestNgPriority {
    @Test(priority = 1)
    public void login() {
        System.out.println("login");
    }

    @Test(priority=4)
    public void signOut() {
        System.out.println("signout");
    }

    @Test(priority = 3)
    public void productOrder() {
        System.out.println("product order page");
    }
    @Test(priority=2)
    public void searchProdcut() {
        System.out.println("search product");
    }
}
