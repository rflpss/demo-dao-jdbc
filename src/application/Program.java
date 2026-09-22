package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entites.Department;
import model.entites.Seller;

import db.DB;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("=== TEST 2: seller findByDepartment ===");
        Department department = new Department(null, 2);

        List<Seller> list = sellerDao.findByDepartment(department);

        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("=== TEST 3: seller findAll ===");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("=== TEST 4: seller insert ===");
        Seller newSeller = new Seller(department, 4000.00, new Date(), "greg@gmail.com", "Greg", null);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("=== TEST 5: seller insert ===");
        seller = sellerDao.findById(1);
        seller.setName("Mich");
        seller.setEmail("mich@gmail.com");
        sellerDao.update(seller);
        System.out.println("Update complete");

        System.out.println("=== TEST 6: seller delete ===");
        System.out.println("Enter id for delete test");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete complete");


        sc.close();
    }
}




