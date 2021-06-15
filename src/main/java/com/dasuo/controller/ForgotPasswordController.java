package com.dasuo.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dasuo.config.Utility;
import com.dasuo.entity.TaiKhoan;
import com.dasuo.service.impl.TaiKhoanNotFoundException;
import com.dasuo.service.impl.TaiKhoanService;


import net.bytebuddy.utility.RandomString;

@Controller
public class ForgotPasswordController {
	@Autowired
	TaiKhoanService taiKhoanService;
	@Autowired
    private JavaMailSender mailSender;
	@GetMapping("/forgot_password")
    public String showForgotPasswordForm() {
		return "web/quenmatkhau";
 
    }
 
    @PostMapping("/forgot_password")
    public String processForgotPassword(HttpServletRequest request, Model model) {
    	String email = request.getParameter("email");
        String token = RandomString.make(30);
        try {
        	taiKhoanService.updateResetPasswordToken(token, email);
            model.addAttribute("message", "We have sent a reset password link to your email. Please check.");
            String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
            sendEmail(email, resetPasswordLink);
            model.addAttribute("message", "We have sent a reset password link to your email. Please check.");
             
        } catch (TaiKhoanNotFoundException ex) {
            model.addAttribute("error", ex.getMessage());
        }catch (UnsupportedEncodingException | MessagingException e) {
            model.addAttribute("error", "Error while sending email");
        }
             
        return "web/quenmatkhau";
    }
     
    private void sendEmail(String email, String resetPasswordLink) throws MessagingException, UnsupportedEncodingException{
    	MimeMessage message = mailSender.createMimeMessage();              
        MimeMessageHelper helper = new MimeMessageHelper(message);
         
        helper.setFrom("contact@shopme.com", "Shopme Support");
        helper.setTo(email);
         
        String subject = "Here's the link to reset your password";
         
        String content = "<p>Hello,</p>"
                + "<p>You have requested to reset your password.</p>"
                + "<p>Click the link below to change your password:</p>"
                + "<p><a href=\"" + resetPasswordLink + "\">Change my password</a></p>"
                + "<br>"
                + "<p>Ignore this email if you do remember your password, "
                + "or you have not made the request.</p>";
         
        helper.setSubject(subject);
         
        helper.setText(content, true);
         
        mailSender.send(message);
		
	}

    @GetMapping("/reset_password")
    public String showResetPasswordForm(@Param(value = "token") String token, Model model) {
        TaiKhoan customer = taiKhoanService.getByResetPasswordToken(token);
        model.addAttribute("token", token);
         
        if (customer == null) {
            model.addAttribute("message", "Invalid Token");
            return "message";
        }
         
        return "web/taolaimatkhau";
    }
    
    @PostMapping("/reset_password")
    public String processResetPassword(HttpServletRequest request, Model model,@RequestParam("token") String token) {
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
         
        TaiKhoan customer = taiKhoanService.getByResetPasswordToken(token);
        model.addAttribute("title", "Reset your password");
        if(password.length()!=0 && password.equals(repassword)== true)
        {
        	if (customer == null) {
                model.addAttribute("message", "Invalid Token");
            } else {           
            	taiKhoanService.updatePassword(password, customer);
                 
                model.addAttribute("message", "Đổi mật khẩu thành công.");
            }
        }
        else {
        	model.addAttribute("message", "Đổi mật khẩu thất bại");
		}
         
        
         
        return "web/taolaimatkhau";
    }
     
     
    
}
