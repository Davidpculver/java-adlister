import java.util.ArrayList;
import java.util.List;

//ListProducts and Products simulates pulling data from db
public class ListProducts implements Products {
    private List<Product> products = new ArrayList<>();

    public ListProducts(){
        insert(new Product("Hammer", 9.99));
        insert(new Product("Screwdriver", 4.99));
        insert(new Product("Air compressor", 99.99));
    }


    @Override
    public List<Product> all() {
        return this.products;
    }

    @Override
    public void insert(Product product) {
        this.products.add(product);
    }
}
