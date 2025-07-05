package entity;

import java.time.LocalDate;

public interface IExpirable {
    LocalDate getExpiryDate();
    default boolean isExpired() {
        return LocalDate.now().isAfter(getExpiryDate());
    }
}
