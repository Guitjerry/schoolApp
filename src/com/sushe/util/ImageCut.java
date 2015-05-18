package com.sushe.util;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by Administrator on 2015/5/4.
 */
public class ImageCut {
    /**
     * 裁剪图片
     * @param x
     * @param y
     * @param width
     * @param height
     * @param srcpath
     * @param subpath
     * @throws java.io.IOException
     */
    public static void cut(int x, int y, int width, int height,String srcpath,String subpath)throws IOException {
        FileInputStream is =   null ;
        ImageInputStream iis = null ;
        Iterator< ImageReader > it=null;
        String imgType="";
        try {
            is =new FileInputStream(srcpath);

            if(".png".equals(srcpath.substring(srcpath.lastIndexOf(".")))){
                it= ImageIO.getImageReadersByFormatName("png");
                imgType="png";

            }else if(".gif".equals(srcpath.substring(srcpath.lastIndexOf(".")))){
                it= ImageIO.getImageReadersByFormatName("gif");
                imgType="gif";
            }else{
                it= ImageIO.getImageReadersByFormatName("jpg");
                imgType="jpg";
            }

            ImageReader reader = it.next();
            iis = ImageIO.createImageInputStream(is);
            reader.setInput(iis, true ) ;
            ImageReadParam param = reader.getDefaultReadParam();
            Rectangle rect =   new Rectangle(x, y, width, height);
            param.setSourceRegion(rect);
            BufferedImage bi=reader.read(0,param);


            ImageIO.write(bi,imgType,new File(subpath));


        } finally {
            if (is != null )
                is.close() ;
            if (iis != null )
                iis.close();
        }



    }
}
