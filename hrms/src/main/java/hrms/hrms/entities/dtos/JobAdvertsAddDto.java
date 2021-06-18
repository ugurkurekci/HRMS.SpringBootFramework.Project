package hrms.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertsAddDto {

	private int id;
	private int employerId;
	private int positionId;
	private int cityId;
	private int maxSalary;
	private int minSalary;
	private String description;
	private LocalDate releaseDate;
	private LocalDate applicationDeadline;
}
