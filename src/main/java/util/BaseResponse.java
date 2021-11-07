package util;


import java.io.Serializable;

 

import lombok.Data;

 

@Data

public class BaseResponse implements Serializable{

 

              /**

              *

               */

              private static final long serialVersionUID = 1L;

              private String responseCode;

              private String responseMessage;

             

              public BaseResponse(String responseCode, String responseMessage) {

                             this.responseCode = responseCode;

                             this.responseMessage = responseMessage;

              }

 

              public BaseResponse() {

                             super();

                             // TODO Auto-generated constructor stub

              }

             

             

             

             

}