package rpc.v1.server.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    String userId;
    String name;
}
