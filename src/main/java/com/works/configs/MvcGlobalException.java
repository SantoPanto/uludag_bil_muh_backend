package com.works.configs;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice(basePackages = "com.works.mvc")
public class MvcGlobalException {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleTypeMismatch(MethodArgumentTypeMismatchException ex,
                                     RedirectAttributes redirectAttributes,
                                     HttpServletRequest request
    ) {
        // full url -> http://localhost:8090/mvc/product/delete/ali
        // path -> /mvc/product/delete/ali
        // çıkarmak istediğim -> /mvc/product
        String path = request.getRequestURI();
        String[] paths = path.split("/");
        String newPath = "/" + paths[1] + "/" + paths[2];

        String paramName = ex.getName();
        Object value = ex.getValue();
        String message = paramName + " sayısal bir değer olmalıdır. Gönderilen değer: " + value;
        redirectAttributes.addFlashAttribute("error", message);
        return "redirect:"+newPath;

    }
}
