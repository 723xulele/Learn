package com.xll.utils;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * @Date: 2021/09/20/15:46
 * @Description: 验证码生成器
 */
public class VcodePictureUtil {

    //图片的宽度
    private int width = 120;
    //图片的高度
    private int height = 40;
    //验证码字符个数
    private int codeCount = 4;
    //干扰线条数
    private int lineCount = 0;
    //验证码
    private String code = null;
    //验证码图片
    private BufferedImage bufferedImage = null;

    private char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'M', 'N', 'P', 'Q', 'R', 'S',
            'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9'};
    //生成随机数
    private Random random = new Random();

    public VcodePictureUtil() {
        this.createCode();
    }

    /**
     * @param width  图片宽
     * @param height 图片高
     */
    public VcodePictureUtil(int width, int height) {
        this.width = width;
        this.height = height;
        this.createCode();
    }

    /**
     * @param width     图片宽
     * @param height    图片高
     * @param codeCount 验证码字符个数
     * @param lineCount 干扰线条个数
     */
    public VcodePictureUtil(int width, int height, int codeCount, int lineCount) {
        this.width = width;
        this.height = height;
        this.codeCount = codeCount;
        this.lineCount = lineCount;
        this.createCode();
    }

    public void createCode() {
        int codeX = 0;
        int fontHeight = 0;
        fontHeight = height - 15;//字体的高度
        codeX = width / (codeCount + 2);//每个字符的宽度

        //图像Buffer
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();

        //将图像填充为白色
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, width, height);

        //创建字体
        ImgFontByte imgFontByte = new ImgFontByte();
        Font font = imgFontByte.getFont(fontHeight);
        graphics2D.setFont(font);

        StringBuffer randomCode = new StringBuffer();
        //随机产生验证啊字符
        for (int i = 0; i < codeCount; i++) {

            String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
            //设置字体颜色
            graphics2D.setColor(getRandomColor());
            //设置字体位置
            graphics2D.drawString(strRand, (i + 1) * codeX, getRandomNumber(height / 2) + 25);
            randomCode.append(strRand);

        }
        code = randomCode.toString();
    }

    /**
     * 获取随机颜色
     *
     * @return
     */
    private Color getRandomColor() {
        int r = getRandomNumber(255);
        int g = getRandomNumber(255);
        int b = getRandomNumber(255);
        return new Color(r, g, b);
    }

    /**
     * 获取随机数
     *
     * @param number
     * @return
     */
    private int getRandomNumber(int number) {
        return random.nextInt(number);
    }

    class ImgFontByte {
        private Font getFont(int fontHeight) {
            return new Font("Arial", Font.PLAIN, fontHeight);
        }
    }

    public void write(String path) throws IOException {
        OutputStream outputStream = new FileOutputStream(path);
        this.write(outputStream);
    }

    public void write(OutputStream outputStream) throws IOException {
        ImageIO.write(bufferedImage, "png", outputStream);
        outputStream.close();
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
