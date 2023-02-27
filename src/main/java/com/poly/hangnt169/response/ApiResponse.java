package com.poly.hangnt169.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author hangnt169
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private Object data;
    private Long totalElement;

}
