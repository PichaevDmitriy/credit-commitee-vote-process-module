package uz.keysoft.processmodules.committeevote.camundaprocessadapter.dto;

import static lombok.AccessLevel.PRIVATE;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.lang.annotation.Retention;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE)
public class CommitteeMemberProcess  implements Serializable {
  String id;
  String firstName;
  String lastName;
}
