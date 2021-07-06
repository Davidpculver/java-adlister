import java.util.List;

//references all of the products inside of our db
interface Products {
    List<Product> all();
    void insert(Product product);

}
