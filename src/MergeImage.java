import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MergeImage {
    public void mergeImage() throws IOException{
        int rows = 2;
        int cols = 2;
        int chunks = rows * cols;

        int chunkWidth, chunkHeight;
        int type;

        //读入小图
        File[] imgFiles = new File[chunks];
        for (int i = 0; i < chunks; i++) {
            imgFiles[i] = new File("C:\\image\\merge\\img" + i + ".jpg");
        }

        //创建BufferedImage
        BufferedImage[] buffImages = new BufferedImage[chunks];
        for (int i = 0; i < chunks; i++) {
            buffImages[i] = ImageIO.read(imgFiles[i]);
        }
        type = buffImages[0].getType();
        chunkWidth = buffImages[0].getWidth();
        chunkHeight = buffImages[0].getHeight();

        //设置拼接后图的大小和类型
        BufferedImage finalImg = new BufferedImage(chunkWidth * cols, chunkHeight * rows, type);

        //写入图像内容
        int num = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                finalImg.createGraphics().drawImage(buffImages[num], chunkWidth * j, chunkHeight * i, null);
                num++;
            }
        }

        //输出拼接后的图像
        ImageIO.write(finalImg, "jpeg", new File("C:\\image\\merge\\finalImg.jpg"));

        System.out.println("完成拼接！");
    }
}
