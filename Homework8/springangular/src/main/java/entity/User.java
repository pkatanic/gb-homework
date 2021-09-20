package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
public class User implements Serializable {
	 private static final long serialVersionUID = 4887904943282174032L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    @NaturalId
	    @NotEmpty
	    private String email;
	    @NotEmpty
	    @Size(min = 3, message = "длина пароля должна быть не менее  3")
	    private String password;
	    @NotEmpty
	    private String name;
	    @NotEmpty
	    private String phone;
	    @NotEmpty
	    private String address;
	    @NotNull
	    private boolean active;
	    @NotEmpty
	    private String role = "ROLE_CUSTOMER";

	    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    @JsonIgnore  
	    private ShoppingCart cart;


        

	    public static long getSerialversionuid() {
			return serialVersionUID;
		}




		public Long getId() {
			return id;
		}




		public String getEmail() {
			return email;
		}


        

		public void setPassword(String password) {
			this.password = password;
		}




		public String getPassword() {
			return password;
		}




		public String getName() {
			return name;
		}




		public String getPhone() {
			return phone;
		}




		public String getAddress() {
			return address;
		}




		public boolean isActive() {
			return active;
		}




		public String getRole() {
			return role;
		}




		public ShoppingCart getCart() {
			return cart;
		}

        


		public void setCart(ShoppingCart cart) {
			this.cart = cart;
		}

        


		public void setName(String name) {
			this.name = name;
		}




		public void setPhone(String phone) {
			this.phone = phone;
		}




		public void setAddress(String address) {
			this.address = address;
		}




		@Override
	    public String toString() {
	        return "Пользователь {" +
	                "id=" + id +
	                ", почта='" + email + '\'' +
	                ", пароль='" + password + '\'' +
	                ", имя='" + name + '\'' +
	                ", телефон='" + phone + '\'' +
	                ", адрес='" + address + '\'' +
	                ", активность =" + active +
	                ", роль ='" + role + '\'' +
	                '}';
	    }




		

}
