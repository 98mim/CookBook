package sk.mimi.cookbookspring.DTO.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sk.mimi.cookbookspring.DTO.model.Recipe;
import sk.mimi.cookbookspring.DTO.model.page.BriefRecipeResponse;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfileResponse {
    private Long id;

    private String name;

    private Set<BriefRecipeResponse> recipes;
}
