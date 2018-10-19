package ru.job4j.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.TransactionWrapper;
import ru.job4j.car.logic.Logic;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

public class UploadServlet extends HttpServlet {
    private Random random = new Random(System.currentTimeMillis());
    private static final Logger LOGGER = LogManager.getLogger(AddServlet.class);
    private final ObjectMapper CONVERTER = new ObjectMapper();
    private final Logic logic = new Logic();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        if (ServletFileUpload.isMultipartContent(request)) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletContext servletContext = this.getServletConfig().getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            factory.setRepository(repository);
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                List<FileItem> items = upload.parseRequest(request);
                for (FileItem item : items) {
                    if (!item.isFormField()) {
                        writer.append(processUploadedFile(item));
                    }
                }
            } catch (FileUploadException e) {
                LOGGER.error(e.getMessage());
            }
        }
        writer.flush();
    }

    private String processUploadedFile(FileItem item) {
        File uploadedFile;
        String fileName = null;
        do {
            String path = getServletContext().getRealPath("./upload/" + random.nextInt() + item.getName());
            uploadedFile = new File(path);
        } while (uploadedFile.exists());
        try {
            uploadedFile.createNewFile();
            item.write(uploadedFile);
            fileName = "./upload/" + uploadedFile.getName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
