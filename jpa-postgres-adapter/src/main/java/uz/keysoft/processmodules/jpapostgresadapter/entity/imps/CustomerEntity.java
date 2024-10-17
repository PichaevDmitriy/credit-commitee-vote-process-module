package uz.keysoft.processmodules.jpapostgresadapter.entity.imps;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import uz.keysoft.processmodules.jpapostgresadapter.entity.AbstractEntity;

import java.util.Objects;

@Data
@Entity
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CUSTOMER")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerEntity extends AbstractEntity {

  @Column(name = "FIRST_NAME")
  String firstName;
  @Column(name = "LAST_NAME")
  String lastName;

  @Override
  public final boolean equals(final Object o) {
    if (this == o) return true;
    if (!(o instanceof CustomerEntity that)) return false;

    return Objects.equals(getId(), that.getId()) && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName());
  }

  @Override
  public int hashCode() {
    int result = Objects.hashCode(getId());
    result = 31 * result + Objects.hashCode(getFirstName());
    result = 31 * result + Objects.hashCode(getLastName());
    return result;
  }
}
