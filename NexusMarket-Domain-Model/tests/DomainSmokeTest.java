import com.nexusmarket.domain.model.*;
import com.nexusmarket.domain.valueobject.*;
import com.nexusmarket.domain.services.*;
import com.nexusmarket.domain.ports.out.*;
import java.util.*;
import java.math.BigDecimal;

public class DomainSmokeTest {
    static class FakeUsers implements UserRepositoryPort, UserUniquenessPort {
        Map<String, User> data = new HashMap<>();
        public Optional<User> findById(String id) { return Optional.ofNullable(data.get(id)); }
        public User save(User u) { data.put(u.getIdentifier(), u); return u; }
        public List<User> findAll() { return new ArrayList<>(data.values()); }
        public boolean existsByIdentifier(String id) { return data.containsKey(id); }
        public boolean existsByEmail(Email email) { return data.values().stream().anyMatch(u -> u.getEmail().equals(email)); }
    }
    static void expectFailure(Runnable r) {
        try { r.run(); throw new AssertionError("Expected failure"); }
        catch (IllegalArgumentException | IllegalStateException | SecurityException expected) { }
    }
    public static void main(String[] args) {
        FakeUsers fake = new FakeUsers();
        User admin = new User("admin", "Administrator", new Email("admin@example.com"), UserRole.ADMINISTRATOR, UserStatus.ACTIVE);
        User buyer = new User("buyer", "Buyer", new Email("buyer@example.com"), UserRole.BUYER, UserStatus.ACTIVE);
        UserService service = new UserService(fake, fake);
        service.register(admin, buyer);
        expectFailure(() -> service.register(admin, buyer));
        expectFailure(() -> service.changeStatus(buyer, "buyer", UserStatus.BLOCKED));
        service.changeStatus(admin, "buyer", UserStatus.BLOCKED);
        if (!service.consult(admin, "buyer").getStatus().equals(UserStatus.BLOCKED)) throw new AssertionError("Status");
        User sellerUser = new User("seller", "Seller", new Email("seller@example.com"), UserRole.SELLER, UserStatus.ACTIVE);
        Seller seller = new Seller(sellerUser, SellerStatus.of("ACTIVE","Active","Active seller"));
        Product product = new Product("p", "Item", "Example", new Money(new BigDecimal("10"), "COP"), ProductType.PHYSICAL, ProductStatus.PUBLISHED, seller);
        Warehouse warehouse = new Warehouse("w", "Warehouse", new Address("Street","City","State","000","CO"), WarehouseType.SELLER, seller);
        Inventory stock = new Inventory("i", product, warehouse, 10, 0, InventoryStatus.AVAILABLE);
        stock.reserve(4);
        if (stock.getAvailableQuantity()!=6 || stock.getReservedQuantity()!=4) throw new AssertionError("Reserve");
        expectFailure(() -> stock.reserve(7));
        stock.sellReserved(3);
        if (stock.getReservedQuantity()!=1) throw new AssertionError("Sell");
        Inventory damaged = new Inventory("d", product, warehouse, 3, 0, InventoryStatus.DAMAGED);
        expectFailure(() -> damaged.reserve(1));
        stock.adjust(-2);
        if (stock.getAvailableQuantity()!=4) throw new AssertionError("Adjustment");
        expectFailure(() -> stock.adjust(-5));
        Buyer profile = new Buyer(buyer, new Address("Street","City","State","000","CO"), List.of(), BuyerStatus.of("ACTIVE","Active","Active buyer"));
        Order order = new Order("o", profile, List.of(new OrderItem(product, null, 1, product.getPrice())),
                product.getPrice(), OrderStatus.PENDING_PAYMENT, java.time.LocalDateTime.now());
        expectFailure(() -> order.transitionTo(OrderStatus.COMPLETED));
        order.transitionTo(OrderStatus.PAID);
        order.transitionTo(OrderStatus.SHIPPED);
        order.transitionTo(OrderStatus.DELIVERED);
        order.transitionTo(OrderStatus.COMPLETED);
        expectFailure(() -> order.transitionTo(OrderStatus.PAID));
        System.out.println("PASS: role, uniqueness, status, inventory reservation, oversell and damaged stock");
    }
}
