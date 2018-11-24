package io.hoseo.fbsample;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class UserInfo {
	@Min(1)
	private int id;
	
	@NotEmpty
	@Size(max = 12, min = 4)
	private String name;
	
	private String welcomeMessage;	
}
