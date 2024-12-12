package hello.pay;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    // 상황에 따라서 `LocalPayClient` 또는 `ProdPayClient` 를 주입받는다.
    private final PayClient payClient;

    public void order(int money) {
        payClient.pay(money);
    }
}