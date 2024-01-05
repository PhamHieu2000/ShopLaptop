package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.CategoryDao;
import dao.GaleryDao;
import dao.ProductDao;
import model.Category;
import model.Product;
@WebServlet(urlPatterns = {"/addproduct"})
@MultipartConfig
public class AddProductController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.getRequestDispatcher("/views/admin/addproduct.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		// Định dạng ngày theo mẫu "dd/MM/yyyy"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy ");
		// TODO Auto-generated method stub
		Product product=new Product();
		Part namePart = req.getPart("name-product");
		InputStream nameInputStream = namePart.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(nameInputStream));
		String name = reader.readLine();
		System.out.println(name);
		String short_description=null;
		Part pricePart = req.getPart("price");
		InputStream priceInputStream = pricePart.getInputStream();
		BufferedReader readerprice = new BufferedReader(new InputStreamReader(priceInputStream));
		long price =Long.parseLong(readerprice.readLine()); 

		System.out.println(price);
		Part discountPart = req.getPart("discount");
		InputStream discountInputStream = discountPart.getInputStream();
		BufferedReader readerdiscount = new BufferedReader(new InputStreamReader(discountInputStream));
		long discount =Long.parseLong(readerdiscount.readLine()); 
		System.out.println(discount);
		Part quantityPart = req.getPart("quantity");
		InputStream quantityInputStream = quantityPart.getInputStream();
		BufferedReader readerquantity = new BufferedReader(new InputStreamReader(quantityInputStream));
		int quantity =Integer.parseInt(readerquantity.readLine()); 
		System.out.println(quantity);
		Part product_description_Part = req.getPart("product_description");
		InputStream product_description_InputStream = product_description_Part.getInputStream();
		BufferedReader reader_product_description = new BufferedReader(new InputStreamReader(product_description_InputStream));
		String product_description = reader_product_description.readLine();
		System.out.println(product_description);
		int is_featured=0;
		int status=1;
		LocalDate  create_at= LocalDate.now();
		LocalDate update_at=LocalDate.now();;
		Part category_id_Part = req.getPart("loaihang-select");
		InputStream category_id_InputStream = category_id_Part.getInputStream();
		BufferedReader reader_category_id = new BufferedReader(new InputStreamReader(category_id_InputStream));
		int category_id =Integer.parseInt(reader_category_id.readLine()); 
        Part filePart = req.getPart("file");
        String thumbail=saveFileIMG(filePart);
		product.setName(name);
		product.setShort_description(short_description);
		product.setPrice(price);
		product.setDiscount(discount);
		product.setQuantity(quantity);
		product.setDescription(product_description);
		product.setIs_featured(is_featured);
		product.setStatus(status);
		product.setCreate_at(create_at);
		product.setUpdate_at(update_at);
		product.setCategory_id(category_id);
		product.setThumbnail(thumbail);
		ProductDao.addProduct(product);
		req.getRequestDispatcher("/views/admin/addproduct.jsp").forward(req, resp);

	}

    public String saveFileIMG (Part file) {
        try {
        	String realPath=getServletContext().getRealPath("/image");
        	String filename=Path.of(file.getSubmittedFileName()).getFileName().getFileName().toString();
            // Tạo thư mục nếu chưa tồn tại
        	if(!Files.exists(Path.of(realPath))) {
        		Files.createDirectories(Path.of(realPath));
        	};
        	
            file.write(realPath+"/"+filename);
            return filename;
            }
            catch (Exception e) {
            	System.out.println("Erro Save Img");
            }
		return null;
    }
    
}
