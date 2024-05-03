package sk.mimi.cookbookspring.DTO.model.page;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BriefRecipeResponse {

    private Long id;

    private String name;

    private String imagePath;

    private int overallTime;

    private int prepTime;

    private int cookTime;

    private int bakeTime;
}
