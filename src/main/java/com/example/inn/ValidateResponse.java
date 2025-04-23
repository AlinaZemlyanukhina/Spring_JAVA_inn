package com.example.inn;

public class ValidateResponse {

        private String isValid;

        public ValidateResponse(String isValid){
            this.isValid = isValid;
        }
        public String isValid() {
            return isValid;
        }

        public void setIsValid(String isValid) {
            this.isValid = isValid;
        }


}
