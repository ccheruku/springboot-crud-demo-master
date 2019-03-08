package com.ensat;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductErrorController implements ErrorController {

	
	@RequestMapping("/error")
    public String handleError() {
        //do something like logging
        return "error";
    }
 
    @Override
    public String getErrorPath() {
        return "/error";
    }
    
	/*private static final String PATH = "/error";

    @Autowired
    private ErrorAttributes errorAttributes;

    @Autowired
    public ProductErrorController(ErrorAttributes errorAttributes) {
      Assert.notNull(errorAttributes, "ErrorAttributes must not be null");
      this.errorAttributes = errorAttributes;
    }
    
    @RequestMapping
    public Map<String, Object> error(HttpServletRequest aRequest){
       Map<String, Object> body = getErrorAttributes(aRequest,getTraceParameter(aRequest));
       String trace = (String) body.get("trace");
       if(trace != null){
         String[] lines = trace.split("\n\t");
         body.put("trace", lines);
       }
       return body;
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
    
    private boolean getTraceParameter(HttpServletRequest request) {
        String parameter = request.getParameter("trace");
        if (parameter == null) {
            return false;
        }
        return !"false".equals(parameter.toLowerCase());
      }

    private Map<String, Object> getErrorAttributes(HttpServletRequest aRequest, boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(aRequest);
        return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
      }*/
}