package com.cqupt.pojo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class PageMesDTO {
    private int page;
    private int pageSize;
}
