package fuctional.stream_api.grouping_collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Partitioning {
    public static void main(String[] args) {

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(3333, "530012"));
        accounts.add(new Account(15000, "771843"));
        accounts.add(new Account(0, "681891"));

        Map<Boolean, List<Account>> accountsByBalance = accounts.stream()
                .collect(Collectors.partitioningBy(account -> account.getBalance() >= 10000));

        System.out.println("Map with to keys " + accountsByBalance.keySet() + " is generated.");
        accountsByBalance.get(false).stream()
                .map(o-> "Balance = " + o.getBalance() + ", Number = " + o.getNumber())
                .forEach(System.out::println);
    }

}
