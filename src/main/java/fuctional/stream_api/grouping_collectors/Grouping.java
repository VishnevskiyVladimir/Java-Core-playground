package fuctional.stream_api.grouping_collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grouping {

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(3333L, "530012", Status.REMOVED));
        accounts.add(new Account(15000L, "771843", Status.ACTIVE));
        accounts.add(new Account(0L, "681891", Status.BLOCKED));
        accounts.add(new Account(33L, "5012", Status.REMOVED));
        accounts.add(new Account(150L, "7743", Status.ACTIVE));
        accounts.add(new Account(110L, "6891", Status.BLOCKED));


        Map<Status, List<Account>> accountsByStatus = accounts.stream()
                .collect(Collectors.groupingBy(Account::getStatus));

        System.out.println(accountsByStatus);


    }
}
