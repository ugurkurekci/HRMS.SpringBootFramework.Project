package hrms.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertsDto {

	private int id;
	private String companyName;
	private String titleName;
	private int numberOfOpenPositions;
	private LocalDate releaseDate;
	private LocalDate applicationDeadline;
	private String description;
	private int minSalary;
	private int maxSalary;
}
