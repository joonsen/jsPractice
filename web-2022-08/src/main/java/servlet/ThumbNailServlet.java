package servlet;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.imageio.ImageIO;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig(
   location = "c:/temp",
   maxFileSize = -1,
   maxRequestSize = -1,
   fileSizeThreshold = 2048
)
@WebServlet(urlPatterns = "/thumbnail.do")
public class ThumbNailServlet extends HttpServlet {
    String uploadPath = "d:/upload/";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                   throws ServletException, IOException {
        StringBuffer info = new StringBuffer();
        
        Collection<Part> parts = req.getParts();
        if(parts == null) {
            System.out.println("parts is null");
            return;
        }
        for (Part p : parts) {
            String uploadFile = p.getSubmittedFileName();
            info.append("<li>tag name : " + p.getName());
           
            if (p.getHeader("Content-Disposition").contains("filename=")) {
                info.append("<li>size : " + p.getSize());
                info.append("<li>file name : " + uploadFile);
                if (p.getSize() > 0) {
                    p.write(uploadPath + uploadFile);
                    p.delete();//임시 파일 삭제
                }
               
                // thumb nail 만들기
                ParameterBlock pb = null;
                RenderedOp op = null;
                BufferedImage bi = null;
                BufferedImage thumb = null;
                Graphics2D g = null;
                File file = null;

                pb = new ParameterBlock();
                pb.add(uploadPath + uploadFile);
                op = JAI.create("fileload",pb);

                bi = op.getAsBufferedImage();
                thumb = new BufferedImage(bi.getWidth()/3,bi.getHeight()/3,
                              BufferedImage.TYPE_4BYTE_ABGR);
                g = thumb.createGraphics();
                g.drawImage(bi, 0,0,bi.getWidth()/3,bi.getHeight()/3,null);
                file = new File(uploadPath + "thumb_" + uploadFile);
                ImageIO.write(thumb, "png", file);
                info.append("<li>thumb nail name : " + file.getName());
                info.append("<hr/>");
            }
        }
        req.setAttribute("info", info.toString());
        System.out.println(info.toString().replace("<li>", "\n"));

        RequestDispatcher rd = req.getRequestDispatcher("thumbnail/thumbnail_result.jsp");
        System.gc();	//garbage collection? 필수요건은 아니다.
        rd.forward(req, resp);
       
    }

}


