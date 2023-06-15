package com.Stars.Stars.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LockAccDto {
    private String email;
   // private boolean isAccLocked;

}
