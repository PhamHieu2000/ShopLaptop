package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.ProductDao;
import model.Product;
@WebServlet(urlPatterns = {"/update_product"})
@MultipartConfig

public class UpdateProductController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product product=ProductDao.getProductById(Integer.parseInt( req.getParameter("id")));
		req.setAttribute("product", product);
		req.getRequestDispatcher("/views/admin/updateproduct.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	

		
		req.setCharacterEncoding("UTF-8");

		// TODO Auto-generated method stub
				Product product=new Product();
				Part namePart = req.getPart("name-product");
				InputStream nameInputStream = namePart.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(nameInputStream));
				String name = reader.readLine();
				System.out.println(name);
				Part product_idPart = req.getPart("product_id");
				InputStream product_idInputStream = product_idPart.getInputStream();
				BufferedReader readerproduct_id = new BufferedReader(new InputStreamReader(product_idInputStream));
				int product_id =Integer.parseInt(readerproduct_id.readLine()); 
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
		
				Part short_description_Part = req.getPart("shortproduct_description");
				InputStream short_description_InputStream = short_description_Part.getInputStream();
				BufferedReader reader_short_description = new BufferedReader(new InputStreamReader(short_description_InputStream));
				String short_description = reader_short_description.readLine();
				System.out.println(short_description);

				LocalDate update_at=LocalDate.now();;
				Part category_id_Part = req.getPart("category-select");
				InputStream category_id_InputStream = category_id_Part.getInputStream();
				BufferedReader reader_category_id = new BufferedReader(new InputStreamReader(category_id_InputStream));
				int category_id =Integer.parseInt(reader_category_id.readLine()); 
		        Part filePart = req.getPart("file");
		        
		        String thumbnail=saveFileIMG(filePart);
		        if(thumbnail==""||thumbnail==null) {
		        	Part thumbnail_Part = req.getPart("thumbnail-img");
					InputStream thumbnail_InputStream = thumbnail_Part.getInputStream();
					BufferedReader reader_thumbnail = new BufferedReader(new InputStreamReader(thumbnail_InputStream));
					thumbnail = reader_thumbnail.readLine();
		        	
		        }
		        product.setId(product_id);
				product.setName(name);
				product.setShort_description(short_description);
				product.setPrice(price);
				product.setDiscount(discount);
				product.setQuantity(quantity);
				product.setDescription(product_description);
				product.setUpdate_at(update_at);
				product.setCategory_id(category_id);
				product.setThumbnail(thumbnail);
				ProductDao.updateProduct(product);
				resp.sendRedirect(req.getContextPath() + "/list_product?id=" + category_id);


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
