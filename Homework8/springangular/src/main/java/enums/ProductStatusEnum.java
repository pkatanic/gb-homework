package enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum implements CodeEnum {
	 UP(0, "Available"),
	    DOWN(1, "Unavailable")
	    ;
	    private Integer code;
	    private String message;

	    ProductStatusEnum(Integer code, String message) {
	        this.code = code;
	        this.message = message;
	    }

	    public String getStatus(Integer code) {

	        for(ProductStatusEnum statusEnum : ProductStatusEnum.values()) {
	            if(statusEnum.getCode() == code) return statusEnum.getMessage();
	        }
	        return "";
	    }

	    private String getMessage() {
			// TODO Auto-generated method stub
			return message;
		}

		public Integer getCode() {
	        return code;
	    }
}
