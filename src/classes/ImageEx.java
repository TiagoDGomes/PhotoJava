/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.IOException;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/**
 *
 * @author Tiago
 */
public class ImageEx {
       public static String getFormatName(Object o) {
        try {
            // Create an image input stream on the image
            ImageInputStream iis = ImageIO.createImageInputStream(o);

            // Find all image readers that recognize the image format
            Iterator iter = ImageIO.getImageReaders(iis);
            if (!iter.hasNext()) {
                // No readers found
                return null;
            }

            // Use the first reader
            ImageReader reader = (ImageReader)iter.next();

            // Close stream
            iis.close();

            // Return the format name
            return reader.getFormatName();
        } catch (IOException e) {
        }
        // The image could not be read
        return null;
    } 
}
