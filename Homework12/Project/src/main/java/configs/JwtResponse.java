package configs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String token;

	public JwtResponse(String token) {
		super();
		this.token = token;
	}
    
    
}
