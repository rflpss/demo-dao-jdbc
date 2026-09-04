package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entites.Departament;
import model.entites.Seller;

import java.sql.Connection;
import java.util.Date;

public class Program {

    public static void main(String[] args) {

        Departament obj = new Departament("Books", 1);

        Seller seller = new Seller(obj,3000.0 ,new Date() , "bob@gmail.com", "Bob", 21);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println(seller);

    }
}
