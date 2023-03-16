package views;

import dao.UserDAO;
import modal.User;
import service.GenerateOTP;
import service.SendOTPService;
import service.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

public class welcome {
    public void welcomeScreen(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to the app");
        System.out.println("Press 1 to login");
        System.out.println("Press 2 to SignUp");
        System.out.println("Press 0 to exit");

        int choice = 0;
        try{
            choice =Integer.parseInt(br.readLine());
        }catch (IOException ex){
            ex.printStackTrace();
        }
        switch (choice){
            case 1 -> login();
            case 2 -> SignUp();
            case 0 -> System.exit(0);
        }
    }
    private void login(){
        Scanner sc = new Scanner(System.in);
        String email = sc.nextLine();
        try{
            if (UserDAO.isExists(email)){
                String genOTP = GenerateOTP.getOTP();
                SendOTPService.sendOTP(email,genOTP);
                System.out.println("Enter the OTP");
                String otp = sc.nextLine();
                if (otp.equals(genOTP)){
                    new Userview(email).home();

                    System.out.println("Welcome");
                }else {
                    System.out.println("Wrong otp");
                }
            }else {
                System.out.println("User not found");
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    private void SignUp(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        String name = sc.nextLine();
        System.out.println("Enter email");
        String email = sc.nextLine();
        String genOTP = GenerateOTP.getOTP();
        SendOTPService.sendOTP(email,genOTP);
        System.out.println("Enter the OTP");
        String otp = sc.nextLine();
        if (otp.equals(genOTP)){
            User user = new User(name, email);
            int response = UserService.saveUser(user);
            switch (response){
                case  0 -> System.out.println("User registered");
                case  1 -> System.out.println("User already exists");
            }
        }else {
            System.out.println("Wrong otp");
        }
    }
}
